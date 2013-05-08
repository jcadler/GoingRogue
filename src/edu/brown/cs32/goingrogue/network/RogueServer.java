package edu.brown.cs32.goingrogue.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.jcadler.GameLogic.GameLogic;
/** Basic networking for a host **/
public class RogueServer extends Listener implements RoguePort{
	private Server net;
	private String name = "";
	private HashMap<Integer, Player> players;
	//	No need (or way) to store the actual RogueClient - store mock RCs instead. 
	private HashMap<Integer, LobbyEntry> lobby;
	GameLogic g = null;

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public EndPoint getEndPoint(){
		return net;
	}
	public HashMap<Integer, LobbyEntry> getLobby()
	{
		return lobby;
	}

	public RogueServer(String name) throws Exception
	{
		this.name = name;
	}

	public void start(String dummy, int port) throws Exception
	{
		//	TCP only, default buffer should be ok.
		net = new Server();
		net.start();
		Network.register(net);
		net.bind(port);
		net.addListener(this);

		players = new HashMap<>();
		lobby = new HashMap<>();
		//	Add the host to the lobby
		lobby.put(-1, new LobbyEntry(getName(), null));
		//	TODO: Be able to convert this lobby into an actual game, move entries to players.
	}

	public void updateClients(){
		//	DO NOT use net.sendToAllTCP(arg0)
		//	iterate through players, send each one their snapshot (Entities in range for each player).
		for(Map.Entry<Integer, Player> entry : players.entrySet())
			updateClient(entry.getKey());
	}

	public void updateClient(int id){
		//	TODO: Do it!
	}

	public List<String> getPlayerNames(){
		List<String> rv = new ArrayList<>();
		if(g != null){
			synchronized(players){
				for(Player p : players.values()){
					rv.add(p.getName());
				}
			}
		}
		else{
			synchronized(lobby){
				for(LobbyEntry p : lobby.values()){
					rv.add(p.name);
					//System.out.println("Adding: " + p.name);
				}
			}
		}
		return rv;
	}

	@Override
	public void close(){
		if(net != null){
			net.stop();
			net.close();
		}
	}

	@Override
	public void connected(Connection c){
		//	Set up the player on the server! Instantiate a new player and stuff.
		//	Get ready to receive more Actions.
		if(g != null){
			//	Command should disconnect the client.
			net.sendToTCP(c.getID(), "dc\tGame is already in session!");
		}

		LobbyEntry e = new LobbyEntry("", c);
		lobby.put(c.getID(), e);
		//	(Maybe) notify some log that a player has connected.
		net.sendToTCP(c.getID(), "connected!");
	}

	@Override
	public void disconnected(Connection c){
		//	Delete the player associated with the connection.
		lobby.remove(c.getID());
		players.remove(c.getID());

	}

	@Override
	public void received(Connection c, Object o){
		/*if(!o instanceof Action){
			System.err.println("Received non-Action object!");
			return;
		}*/
		if(o instanceof Action){
			//Action a = (Action) o;
			//	TODO: Not actually a thing yet.
			//	List<Action> acts = players.get(c.getID()).addAction(a);
		}
		//	Players reporting their names, asking for lobby info, etc.
		if(o instanceof String){
			try{
				//System.out.println(o);
				String[] cmd = ((String) o).split("\t");
				if(cmd[0].equals("name")){
					synchronized(lobby){
						if(lobby.containsKey(c.getID())){
							lobby.get(c.getID()).name = cmd[1];
						}
					}
					synchronized(players){
						if(players.containsKey(c.getID())){
							players.get(c.getID()).setName(cmd[1]);
						}
					}
				}
				else if(cmd[0].equals("lobby")){
					String msg = "";
					List<String> rv = getPlayerNames();
					for(String elem : rv)
						msg += "\t" + elem;
					//	Dummy last character
					msg = "lobby" + msg + "0";
					net.sendToTCP(c.getID(), msg);
				}
			}
			catch(Exception e){

			}
		}
	}
}

class LobbyEntry{
	public String name;
	public Connection connection;

	public LobbyEntry(String n, Connection c){
		name = n;
		connection = c;
	}
}
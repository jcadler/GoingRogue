package edu.brown.cs32.goingrogue.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import edu.brown.cs32.goingrogue.game.GamePlayState;
import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.gameobjects.creatures.factories.PlayerFactory;
import edu.brown.cs32.jcadler.GameLogic.GameLogic;
import edu.brown.cs32.jcadler.GameLogic.NetworkedGameLogic;
import edu.brown.cs32.jcadler.GameLogic.RogueMap.LogicMap;
/** Basic networking for a host **/
public class RogueServer extends Listener implements RoguePort{
	private Server net;
	private String name = "";
	private HashMap<Integer, Player> players;
	//	No need (or way) to store the actual RogueClient - store mock RCs instead. 
	private HashMap<Integer, String> lobby;
	private StateBasedGame game;
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
	public void addGame(NetworkedGameLogic g){
		this.g = g;
	}
	public HashMap<Integer, String> getLobby()
	{
		return lobby;
	}

	public RogueServer(String name, StateBasedGame game)
	{
		this.name = name;
		this.game = game;
	}

	public StateBasedGame getGame() {
		return game;
	}
	public void setGame(StateBasedGame game) {
		this.game = game;
	}

	public void beginGame(){
		try{
			LogicMap map = LogicMap.getRandomMap();
			//	Initialize/ build players
			for(Map.Entry<Integer, String> entry : lobby.entrySet()){
				Player p = PlayerFactory.create(null, null);
				p.setName(entry.getValue());
				players.put(entry.getKey(), p);
			}
			g = new NetworkedGameLogic(this, map, players, players.get(-1));
			for(Map.Entry<Integer, Player> entry : players.entrySet()){
				if(entry.getKey() < 0)
					continue;
				try{
					NetworkedGameLogic ngl = new NetworkedGameLogic(null, (NetworkedGameLogic) g, entry.getValue());
					net.sendToTCP(entry.getKey(), ngl);
				}
				catch(Exception e){
					System.err.println(e.getMessage());
				}
			}
			//	Find the game state and give it the game logic, enter game!
			for(int it = 0; it < game.getStateCount(); it++){
				GameState gs = game.getState(it);
				if(gs instanceof GamePlayState){
					//TODO:
					//gs.setGameLogic(g);
					game.enterState(it, new FadeOutTransition(), new FadeInTransition());
					return;
				}
			}
		}
		catch(Exception e){
			
		}
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
		lobby.put(-1, getName());
		//	TODO: Be able to convert this lobby into an actual game, move entries to players.
	}

	public void updateClients(Object o){
		//	DO NOT use net.sendToAllTCP(arg0)
		//	iterate through players, send each one their snapshot (Entities in range for each player).
		List<Creature> msg = g.getCreatures();//g.getCreatures(minX, minY, maxX, maxY)
		for(Map.Entry<Integer, Player> entry : players.entrySet()){
			if(entry.getKey() >= 0)
				net.sendToTCP(entry.getKey(), msg);
		}
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
				for(String p : lobby.values()){
					rv.add(p);
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
		lobby.put(c.getID(), "");
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
		if(o instanceof Action){
			if(g != null){
				players.get(c.getID()).addAction((Action) o);
			}
		}
		//	Players reporting their names, asking for lobby info, etc.
		if(o instanceof String){
			try{
				String[] cmd = ((String) o).split("\t");
				if(cmd[0].equals("name")){
					synchronized(lobby){
						if(lobby.containsKey(c.getID())){
							lobby.put(c.getID(), cmd[1]);
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
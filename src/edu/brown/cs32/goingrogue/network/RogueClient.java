package edu.brown.cs32.goingrogue.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;

import edu.brown.cs32.goingrogue.game.GamePlayState;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.jcadler.GameLogic.GameLogic;
import edu.brown.cs32.jcadler.GameLogic.NetworkedGameLogic;
/** Basic networking for a non-host player **/
public class RogueClient extends Listener implements RoguePort{
	private Client net;
	private String name;
	private List<String> playerNames = new ArrayList<>();
	private StateBasedGame game;
	GameLogic g = null;

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public EndPoint getEndPoint(){
		return net;
	}
	public void addGame(NetworkedGameLogic g){
		this.g = g;
	}

	public RogueClient(String name, StateBasedGame game)
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
	/** Send action objects to the server! **/
	public void send(Object o){
		net.sendTCP(o);
	}

	public List<String> getPlayerNames(){
		//	Update me please - next tick will provide accurate info.
		net.sendTCP("lobby");
		return playerNames;
	}

	@Override
	public void start(String host, int port) throws Exception{
		//	TCP only, default buffer should be ok.
		net = new Client();
		net.start();
		Network.register(net);
		final String h = host;
		final int p = port;
		new Thread(){
			public void run(){
				try{
					net.connect(3000, h, p);
				}
				catch(Exception e){
					System.err.println(e.getMessage());
				}
			}
		}.start();
		net.addListener(this);
	}

	@Override
	public void close() {
		if(net != null){
			net.stop();
			net.close();
		}
	}

	@Override
	public void connected(Connection c){
		net.sendTCP("name\t" + name);
	}

	@Override
	public void disconnected(Connection c){
		playerNames.clear();
		playerNames.add("Disconnected from server!");
	}

	@SuppressWarnings({"unchecked"})
	@Override
	public void received(Connection c, Object o){
		if(o instanceof List){
			/*if(g != null){
				if(((List) o).isEmpty() || ((List)o).get(0) instanceof Action){
					g.setActions((List<Action>) o);
				}
				else{*/
			g.setCreatures((List<Creature>) o);
			//}
			//}
		}
		else if(o instanceof String){
			try{
				String[] cmd = ((String) o).split("\t");
				if(cmd[0].equals("dc")){
					//	Print reason for disconnection
					System.out.println(cmd[1]);
					net.close();
				}
				else if(cmd[0].equals("map")){
					//	TODO: Not actually a thing yet - manage later...
					//	g.setMap(cmd[1]);
				}
				else if(cmd[0].equals("lobby")){
					//System.out.println(o);
					playerNames.clear();
					for(int it = 1; it < cmd.length - 1; it++)
						playerNames.add(cmd[it]);
					playerNames.add(cmd[cmd.length - 1].substring(0, cmd[cmd.length - 1].length() - 1));
				}
			}
			catch(Exception e){

			}
		}
		//	Let the games begin!
		else if(o instanceof NetworkedGameLogic){
			NetworkedGameLogic ngl = (NetworkedGameLogic) o;
			try {
				g = new NetworkedGameLogic(this, ngl, ngl.getPlayer());
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
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

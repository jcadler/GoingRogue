package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import edu.brown.cs32.goingrogue.network.RogueServer;

public class GameLobbyState extends BasicGameState{
	
	private int id; //	Used for StateBasedGame
	private RogueServer server;	//	The core of the lobby!
	
	public GameLobbyState(int id){
		this.id = id;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		try{
			server = new RogueServer("");
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return id;
	}

}

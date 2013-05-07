package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import edu.brown.cs32.goingrogue.network.RogueServer;

public class GameLobbyServer extends GameLobbyState {
	public GameLobbyServer(int id, MenuGame game){
		super(id, game);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		try{
			port = new RogueServer("");
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub

	}

}

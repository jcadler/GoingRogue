package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import edu.brown.cs32.goingrogue.network.RogueServer;

public class GameLobbyServer extends GameLobbyState {
	
	public GameLobbyServer(String bg, String md, int id, MenuGame game){
		super(bg, md, id, game);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame gm)
			throws SlickException {
		super.init(gc, gm);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		super.render(gc, game, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void buttonAction(){
		try{
			game.setUserName(inputFields.get(0).getText());
			//	Default port number
			int pn = 54242;
			try{
				pn = Integer.parseInt(inputFields.get(1).getText());
			}
			catch(Exception e){
				System.err.println("Bad port number!");
			}
			game.setPortNumber(pn);
			port = new RogueServer(game.getUserName());
			port.start("dummy", pn);
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}

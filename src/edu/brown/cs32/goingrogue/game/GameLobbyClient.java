package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import edu.brown.cs32.goingrogue.network.RogueClient;

public class GameLobbyClient extends GameLobbyState {
	private int sumDelta = 0;
	private int updateLimit = 1500;

	public GameLobbyClient(String bg, String md, int id, MenuGame game){
		super(bg, md, id, game);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame gm)
			throws SlickException {
		super.init(gc, gm);
		try{
			//port = new RogueClient(game.getUserName());
			//	TODO: Configure host name
			//port.start("", game.getPortNumber());
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		super.render(gc, game, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		sumDelta += delta;
		if(sumDelta > updateLimit){
			sumDelta = 0;
			if(port != null){
				this.setPlayerNames(port.getPlayerNames());
				String msg = "";
				if(getPlayerNames() != null){
					for(String elem : getPlayerNames()){
						msg += "\n" + elem;
					}
					msg = msg.substring(1);
					textBox.setMsg(msg);
				}
			}
		}
	}

	@Override
	public void buttonAction(){
		try{
			game.setUserName(inputFields.get(0).getText());
			game.setHostName(inputFields.get(1).getText());
			//	Default port number
			int pn = 54242;
			try{
				pn = Integer.parseInt(inputFields.get(2).getText());
			}
			catch(Exception e){
				System.err.println("Bad port number!");
			}
			game.setPortNumber(pn);
			port = new RogueClient(game.getUserName());
			port.start(game.getHostName(), game.getPortNumber());
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}

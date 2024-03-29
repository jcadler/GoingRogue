package edu.brown.cs32.goingrogue.game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import edu.brown.cs32.goingrogue.network.RoguePort;

public abstract class GameLobbyState extends MenuState{
	protected RoguePort port;	//	The core of the lobby!
	protected MenuGame game;
	private boolean enteringGame = false;
	private List<String> playerNames = new ArrayList<>();
	
	public GameLobbyState(String bg, String md, int id, MenuGame game){
		super(bg, md, id);
		this.game = game;
	}

	public List<String> getPlayerNames(){
		return playerNames;
	}

	public void setPlayerNames(List<String> playerNames){
		this.playerNames = playerNames;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		super.render(gc, game, g);
	}
	
	public void setEnteringGame(boolean e){
		enteringGame = e;
	}
	
	@Override
	public void leave(GameContainer gc, StateBasedGame game){
		super.leave(gc, game);
		if(port != null && !enteringGame){
			port.close();
			port = null;
		}
		enteringGame = false;
	}
}

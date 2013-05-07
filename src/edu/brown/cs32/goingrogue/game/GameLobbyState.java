package edu.brown.cs32.goingrogue.game;

import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;

import edu.brown.cs32.goingrogue.network.RoguePort;

public abstract class GameLobbyState extends BasicGameState{
	protected String message = "";
	protected String background = "graphics/menu/mmbg.png";	//	Default is Main Menu!
	protected String menuData = "data/menus/mm.txt";
	protected Image bg;
	protected List<TransitionButton> buttons;
	private int id; //	Used for StateBasedGame
	protected RoguePort port;	//	The core of the lobby!
	protected MenuGame game;
	
	public GameLobbyState(int id, MenuGame game){
		this.id = id;
		this.game = game;
	}

	@Override
	public int getID() {
		return id;
	}

}

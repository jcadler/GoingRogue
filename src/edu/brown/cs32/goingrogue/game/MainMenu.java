package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState{
	private String background = "";
	private Image bg;
	private TransitionButton[] buttons;
	private GameContainer gc;

	private int id; //Used for StateBasedGame
	
	public void setID(int id){
		this.id = id;
	}
	
	public MainMenu(){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		try{
			bg = new Image(background);
		}
		catch(Exception e){
			System.err.println("No background image!");
			System.exit(1);
		}
		this.gc = gc;
		buttons = new TransitionButton[3];
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		//	Draw background
		//	Color c = Color.RED;
		g.drawImage(bg, 0f, 0f);
		for(TransitionButton t : buttons){
			t.render(gc, g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return id;
	}

}

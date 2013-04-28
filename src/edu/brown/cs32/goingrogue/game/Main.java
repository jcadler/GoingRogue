package edu.brown.cs32.goingrogue.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.graphics.TestGame;
import edu.brown.cs32.jcalder.GameLogic.GameLogic;

/**
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public class Main extends BasicGame
{
	int timeCount;
	
	GameLogic game;
	Player player;
	
	public Main()
	{
		super("Going Rogue");
		
		timeCount=0;
		
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		timeCount+=delta;
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
	}
	
	public static void main(String[] args) throws SlickException
	{
		AppGameContainer app = new AppGameContainer(new TestGame());
		app.setDisplayMode(800, 600, false);
		app.start();
	}
	
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
	}
	
	@Override
	public void mousePressed(int button, int x, int y) {
	}
	
	@Override
	public void mouseReleased(int button, int x, int y) {
	}
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
	}
	
	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
	}
	
	@Override
	public void keyPressed(int key, char c) {
		
	}
}
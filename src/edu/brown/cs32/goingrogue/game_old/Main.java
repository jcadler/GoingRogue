package edu.brown.cs32.goingrogue.game_old;

import java.util.concurrent.ConcurrentHashMap;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.util.KeyCodes;

/**
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class Main extends BasicGame
{
	GamePlay g;
	int timeCount;
	
	ConcurrentHashMap<Integer, Boolean> keysPressed;
	
	public Main()
	{
		super("Going Rogue");
		
		g=null; //Set up by init() method
		timeCount=0;
		
		keysPressed=new ConcurrentHashMap<Integer, Boolean>();
		keysPressed.put(KeyCodes.Q, false);
		keysPressed.put(KeyCodes.W, false);
		keysPressed.put(KeyCodes.E, false);
		keysPressed.put(KeyCodes.A, false);
		keysPressed.put(KeyCodes.S, false);
		keysPressed.put(KeyCodes.D, false);
		keysPressed.put(KeyCodes.LEFT, false);
		keysPressed.put(KeyCodes.RIGHT, false);
		keysPressed.put(KeyCodes.UP, false);
		keysPressed.put(KeyCodes.DOWN, false);
		keysPressed.put(KeyCodes.SPACE, false);
		keysPressed.put(KeyCodes.ESC, false);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		g=new GamePlay(gc);
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		timeCount+=delta;
		
		Player p=g.getPlayer();
		
		if(keysPressed.get(KeyCodes.W) || keysPressed.get(KeyCodes.UP)) p.getHandler().moveUp();
		else if(keysPressed.get(KeyCodes.S) || keysPressed.get(KeyCodes.DOWN)) p.getHandler().moveDown();
		if(keysPressed.get(KeyCodes.A) || keysPressed.get(KeyCodes.LEFT)) p.getHandler().moveLeft();
		else if(keysPressed.get(KeyCodes.D) || keysPressed.get(KeyCodes.RIGHT)) p.getHandler().moveRight();
		if(keysPressed.get(KeyCodes.SPACE)) p.getHandler().attack();
		if(keysPressed.get(KeyCodes.E)) p.getHandler().pickUp();
		
		else if(keysPressed.get(KeyCodes.ESC)) System.exit(0);
		
		g.update(delta);
	}
	
	@Override
	public void render(GameContainer gc, Graphics graphics) throws SlickException {
		g.render(graphics);
	} 
	
	public static void main(String[] args) throws SlickException
	{
		AppGameContainer app = new AppGameContainer(new Main());
		app.setDisplayMode(800, 600, false);
		app.setSmoothDeltas(false);
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
		keysPressed.put(key, true);
	}
	
	@Override
	public void keyReleased(int key, char c) {
		keysPressed.put(key, false);
	}
}
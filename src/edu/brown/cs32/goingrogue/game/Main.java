package edu.brown.cs32.goingrogue.game;

import java.awt.geom.Point2D;
import java.util.concurrent.ConcurrentHashMap;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import edu.brown.cs32.goingrogue.gameobjects.creatures.KeyCodes;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;

/**
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class Main extends BasicGame
{
	GamePlay g;
	int timeCount;
	
//	ConcurrentHashMap<> keysPressed;
	
	public Main()
	{
		super("Going Rogue");
		
		g=null; //Set up by init() method
		timeCount=0;
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		g=new GamePlay(gc);
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		timeCount+=delta;
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
		//Test the coord transformation methods
		
		Point2D center=g.player.getPosition();
		
		System.out.println("ORIG: "+x+", "+y);
		
		Point2D gameCoords=g.screenToGame(new int[]{x, y}, center);
		System.out.println("GAME: "+gameCoords.getX()+", "+gameCoords.getY());
		
		int[] newCoords=g.gameToScreen(gameCoords, center);
		System.out.println("NEW:  "+newCoords[0]+", "+newCoords[1]);
	}
	
	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
	}
	
	@Override
	public void keyPressed(int key, char c) {
		Player p=g.getPlayer();
		
		if(key==KeyCodes.W || key==KeyCodes.UP) p.getHandler().moveUp();
		else if(key==KeyCodes.S || key==KeyCodes.DOWN) p.getHandler().moveDown();
		else if(key==KeyCodes.A || key==KeyCodes.LEFT) p.getHandler().moveLeft();
		else if(key==KeyCodes.D || key==KeyCodes.RIGHT) p.getHandler().moveRight();
		else if(key==KeyCodes.SPACE) p.getHandler().attack();
		else if(key==KeyCodes.E) p.getHandler().pickUp();
		
		else if(key==KeyCodes.ESC) System.exit(0);
	}
}
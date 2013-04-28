package edu.brown.cs32.goingrogue.graphics;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/** A class for testing basic graphical methods
 * 
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */

public class TestGame extends BasicGame
{
	Animation anim;
	List<Animation> anims;
	List<Integer> xList;
	List<Integer> yList;
	boolean animDrawn;
	
	int timeCount;
	
	int nextAddMarker;
	int addMarkerDelta;
	
	int nextMoveMarker;
	int moveMarkerDelta;
	int numMoves;
	int moveDelta;
	
	String textToDisplay;
	
	public TestGame()
	{
		super("Hello World");
		
		anim=null;
		xList=new ArrayList<>();
		yList=new ArrayList<>();
		anims=new ArrayList<>();
		
		animDrawn=false;
		
		//Used to track time between successive calls to update()
		timeCount=0;
		nextAddMarker=0;
		addMarkerDelta=300;
		nextMoveMarker=0;
		moveMarkerDelta=20;
		numMoves=0;
		moveDelta=-1;
		
		textToDisplay="_";
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{
		timeCount+=delta;
		
		if(anim!=null && timeCount>=nextAddMarker) {
			nextAddMarker+=addMarkerDelta;
			xList.add((int)(Math.random()*gc.getWidth()));
			yList.add((int)(Math.random()*gc.getHeight()));
			anims.add(anim.copy());
		}
		
		if(anim!=null && timeCount>=nextMoveMarker) {
			nextMoveMarker+=moveMarkerDelta;
			for(int i=0; i<xList.size(); i++) xList.set(i, xList.get(i)+moveDelta);
			numMoves++;
		}
		
		//Add code to remove bats when list gets too big
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.setBackground(Color.black);
		g.setAntiAlias(false);
		
		if(!animDrawn) {
			AnimationLoader.setFilterType(Image.FILTER_NEAREST);
			anim=AnimationLoader.loadMove(GraphicsPaths.SLIME.path);
			animDrawn=true;
		}
		
		for(int i=0; i<xList.size(); i++) anims.get(i).draw(xList.get(i), yList.get(i), 40, 40);
		
		g.drawString(textToDisplay, 100, gc.getHeight()-100);
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
		for(int i=0; i<xList.size(); i++) {
			xList.set(i, xList.get(i)+newx-oldx);
			yList.set(i, yList.get(i)+newy-oldy);
		}
	}
	
	@Override
	public void keyPressed(int key, char c) {
		
		//Escape key to quit
		if(key==1) System.exit(0);
		
		//Other fun stuff
		if(Character.getNumericValue(c)!=-1 ||
			key==57) {
			if(textToDisplay.equals("_")) textToDisplay=c+"_";
			else textToDisplay=textToDisplay.substring(0, Math.max(1, textToDisplay.length()-1))+c+"_";
		}
		else if(key==14) {
			textToDisplay=textToDisplay.substring(0, Math.max(0, textToDisplay.length()-2))+"_";
		}
	}
}
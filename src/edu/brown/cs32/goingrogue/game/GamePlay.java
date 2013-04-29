package edu.brown.cs32.goingrogue.game;

import java.awt.geom.Point2D;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import edu.brown.cs32.goingrogue.constants.Constants;
import edu.brown.cs32.goingrogue.gameobjects.actions.Action;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import edu.brown.cs32.goingrogue.gameobjects.creatures.Player;
import edu.brown.cs32.goingrogue.graphics.GraphicsPaths;
import edu.brown.cs32.goingrogue.map.RogueMap;
import edu.brown.cs32.goingrogue.map.Space;
import edu.brown.cs32.goingrogue.map.Tile;
import edu.brown.cs32.goingrogue.map.Wall;
import edu.brown.cs32.goingrogue.util.Util;
import edu.brown.cs32.jcadler.GameLogic.GameLogic;

/**
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public class GamePlay {
	
	GameContainer gc;
	
	GameLogic game;
	Player player;
	RogueMap map;
	
	int timeCount; //Used for tracking game updates
	
	double gameToScreenFactor=40.; //Conversion from game to screen coordinates
	
	public GamePlay(GameContainer gc) {
		
		this.gc=gc;
		
		//Initializes gameplay
		game = null; /* new GameLogic() */
		player=game.getPlayer();
		map=game.getMap();
	}
	
	//Converts a point on the game map to a point on the screen
	int[] gameToScreen(Point2D point, Point2D center) {
		
		//Offsets from the center of the screen
		double xOffset=(point.getX()-center.getX());
		double yOffset=(point.getY()-center.getY());
		
		//Screen coords
		int x=(int)(gc.getWidth()/2+xOffset*gameToScreenFactor);
		int y=(int)(gc.getHeight()/2+yOffset*gameToScreenFactor);
		
		return new int[]{x, y};
	}
	
	Point2D screenToGame(int[] point, Point2D center) {
		
		//The screen center
		int screenXCenter=gc.getWidth()/2;
		int screenYCenter=gc.getHeight()/2;
		
		//Game coords
		double x=(point[0]-screenXCenter)/gameToScreenFactor + center.getX();
		double y=(point[1]-screenYCenter)/gameToScreenFactor + center.getY();
		
		return new Point2D.Double(x, y);
	}
	
	/** Updates the game one time
	 * 
	 * @param delta The amount of time since the last game update
	 */
	public void update(int delta) {
		timeCount+=delta;
		try {
			game.update(); // TODO Add delta
		} catch(CloneNotSupportedException e) {
			
		}
	}
	
	/** Draws the game
	 * 
	 * @param g The graphics component used to draw the game
	 */
	public void render(Graphics g) {
		Point2D center=player.getPosition();
		
		Point2D upperLeft=screenToGame(new int[]{0,0}, center);
		Point2D lowerRight=screenToGame(new int[]{gc.getWidth(),gc.getHeight()}, center);
		
		//Draws the map
		List<Space> spaces=map.getData((int)(upperLeft.getX()-1), (int)(upperLeft.getY()-1), (int)(lowerRight.getX()+1), (int)(lowerRight.getY()+1));
		for(Space s: spaces) drawSpace(s, g);
		
		//Draws and animates entities
		List<Creature> gameCreaures=game.getCreatures();
		
		for(Creature c: gameCreatures) {
			List<Action> actions=c.getActions();
			ActionAnimation anim=
			for(Action a: actions) {
				if(a)
			}
		}
	}
	
	//Draws a space to the graphics object given
	void drawSpace(Space s, Graphics g) {
		int[] upperLeft=Util.snapPoint(s.upperLeft());
		Tile[][] floor=s.getFloor();
		
		for(int i=0; i<floor.length; i++)
		for(int j=0; j<floor[i].length; j++) {
			Tile t=floor[i][j];
			int x=(int)upperLeft[0]+i;
			int y=(int)upperLeft[1]+j;
			
			Image tileImage=null;
			try {
				tileImage=new Image(t.path, false, Image.FILTER_LINEAR);
				tileImage.draw(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
			} catch(SlickException e) {
				System.out.println("Could not create image for tile "+t+" at location ("+x+", "+y+")...");
				e.printStackTrace();
			}
		}
		
		Wall w=s.getWallType();
		
		//{N, S, E, W, NE, NW, SE, SW}
		String[] wallPaths=new String[8];
		if(w==Wall.NONE) {
			for(int i=0; i<wallPaths.length; i++) {
				wallPaths[i]=GraphicsPaths.EMPTY.path;
			}
		} else if(w==Wall.DEFAULT) {
			wallPaths[0]=GraphicsPaths.WALL_N.path;
			wallPaths[1]=GraphicsPaths.WALL_S.path;
			wallPaths[2]=GraphicsPaths.WALL_E.path;
			wallPaths[3]=GraphicsPaths.WALL_W.path;
			wallPaths[4]=GraphicsPaths.WALL_NE.path;
			wallPaths[5]=GraphicsPaths.WALL_NW.path;
			wallPaths[6]=GraphicsPaths.WALL_SE.path;
			wallPaths[7]=GraphicsPaths.WALL_SW.path;
		}
		//Top edge
		int y1=upperLeft[1]-1;
		
		try {
			Image wallN=new Image(wallPaths[0], false, Image.FILTER_LINEAR);
			for(int i=0; i<s.width(); i++) {
				int x=upperLeft[0]+i;
				wallN.draw(x, y1, Constants.TILE_SIZE, Constants.TILE_SIZE);
			}
		} catch(SlickException e) {
			System.out.println("Could not create image for north wall...");
			e.printStackTrace();
		}
		
		//Bottom edge
		int y2=upperLeft[1]+s.height()+1;
		
		try {
			Image wallS=new Image(wallPaths[1], false, Image.FILTER_LINEAR);
			for(int i=0; i<s.width(); i++) {
				int x=upperLeft[0]+i;
				wallS.draw(x, y2, Constants.TILE_SIZE, Constants.TILE_SIZE);
			}
		} catch(SlickException e) {
			System.out.println("Could not create image for south wall...");
			e.printStackTrace();
		}
		
		//Right edge
		int x2=upperLeft[0]+upperLeft[0]+s.width()+1;
		
		try {
			Image wallE=new Image(wallPaths[2], false, Image.FILTER_LINEAR);
			for(int i=0; i<s.height(); i++) {
				int y=upperLeft[1]+i;
				wallE.draw(x2, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
			}
		} catch(SlickException e) {
			System.out.println("Could not create image for west wall...");
			e.printStackTrace();
		}
		
		//Left edge
		int x1=upperLeft[0]-1;
		
		try {
			Image wallW=new Image(wallPaths[3], false, Image.FILTER_LINEAR);
			for(int i=0; i<s.height(); i++) {
				int y=upperLeft[1]+i;
				wallW.draw(x1, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
			}
		} catch(SlickException e) {
			System.out.println("Could not create image for east wall...");
			e.printStackTrace();
		}
		
		//Upper right tile
		try {
			Image wallNE=new Image(wallPaths[4]);
			wallNE.draw(upperLeft[0]-1, upperLeft[1]-1, Constants.TILE_SIZE, Constants.TILE_SIZE);
		} catch(SlickException e) {
			System.out.println("Could not create image for NE wall...");
			e.printStackTrace();
		}
		
		//Upper left tile
		try {
			Image wallNW=new Image(wallPaths[4]);
			wallNW.draw(upperLeft[0]-1, upperLeft[1]-1, Constants.TILE_SIZE, Constants.TILE_SIZE);
		} catch(SlickException e) {
			System.out.println("Could not create image for NW wall...");
			e.printStackTrace();
		}

		//Lower right tile
		try {
			Image wallSE=new Image(wallPaths[4]);
			wallSE.draw(upperLeft[0]-1, upperLeft[1]-1, Constants.TILE_SIZE, Constants.TILE_SIZE);
		} catch(SlickException e) {
			System.out.println("Could not create image for SE wall...");
			e.printStackTrace();
		}

		//Lower left tile
		try {
			Image wallSW=new Image(wallPaths[4]);
			wallSW.draw(upperLeft[0]-1, upperLeft[1]-1, Constants.TILE_SIZE, Constants.TILE_SIZE);
		} catch(SlickException e) {
			System.out.println("Could not create image for SW wall...");
			e.printStackTrace();
		}
	}
}
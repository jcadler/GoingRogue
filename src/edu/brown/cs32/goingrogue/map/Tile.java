package edu.brown.cs32.goingrogue.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import edu.brown.cs32.goingrogue.graphics.GraphicsPaths;

/** An enum detailing different types of tiles, storing a path to their images
 * 
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public enum Tile {
	EMPTY(GraphicsPaths.EMPTY.path),
	GROUND(GraphicsPaths.GROUND.path),
	WATER(GraphicsPaths.WATER.path),
	WALL_N(GraphicsPaths.WALL_N.path),
	WALL_S(GraphicsPaths.WALL_S.path),
	WALL_E(GraphicsPaths.WALL_E.path),
	WALL_W(GraphicsPaths.WALL_W.path),
	WALL_NE(GraphicsPaths.WALL_NE.path),
	WALL_NW(GraphicsPaths.WALL_NW.path),
	WALL_SE(GraphicsPaths.WALL_SE.path),
	WALL_SW(GraphicsPaths.WALL_SW.path);
		
	public final String path;
	
	Tile(String _path) {
		path=_path;
	}
	
	/** Returns the image for the tile
	 * @throws SlickException Thrown if the image file cannot be loaded
	 */
	public Image getImage() throws SlickException {
		return new Image(path);
	}
}

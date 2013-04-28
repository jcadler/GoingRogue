package edu.brown.cs32.goingrogue.map;

/** An interface detailing the necessary components of a space (corridor, room, etc) in the game
 * 
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public interface Space {
	
	/** Enum detailing the types of allowed spaces
	 */
	public static enum Type {
		ROOM, CORRIDOR;
	}
	
	/** Returns the space type
	 */
	
	/** Returns the width
	 */
	public int width();
	
	/** Returns the height
	 */
	public int height();
	
	/** Returns the (x,y) coordinates of the upper left tile
	 */
	public int[] upperLeft();
	
	/** Returns the (x,y) coordinates of the lower right tile
	 */
	public int[] lowerRight();
	
	/** Returns an array of Tiles detailing the floor's makeup
	 */
	public Tile[][] getFloor();
	
}

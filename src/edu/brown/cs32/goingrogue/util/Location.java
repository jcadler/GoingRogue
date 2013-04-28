package edu.brown.cs32.goingrogue.util;

/** Basic package class to hold on to a 2D location. Can 
 * 
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public class Location {
	
	public final float x, y;
	
	public Location(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/** Returns the Location's coordinates rounded to the nearest integer, essentially snapping it to the grid
	 */
	public int[] snap() {
		return new int[]{(int)(x+.5F), (int)(y+.5F)};
	}
}

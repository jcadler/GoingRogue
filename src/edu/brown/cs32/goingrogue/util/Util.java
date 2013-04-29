package edu.brown.cs32.goingrogue.util;

import java.awt.geom.Point2D;

/** A class with various utility methods
 * 
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public class Util {
	
	/** Safely snaps a Point2D (storing doubles) to its proper integer coordinates, avoiding floating point error
	 * 
	 * @return An array of integer coordinates (x, y)
	 */
	public static int[] snapPoint(Point2D p) {
		return new int[]{(int)(p.getX()+.5), (int)(p.getY()+.5)};
	}
}

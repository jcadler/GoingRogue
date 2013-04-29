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
	
	/** Converts a polar coordinate to a rectangular one
	 * 
	 * @param r The coordinate's radius
	 * @param theta The coordinate's angle
	 * @return The same coordinate in rectangular coordinates (x, y)
	 */
	public static double[] polarToRectangular(double r, double theta) {
		return new double[]{r*Math.cos(theta), r*Math.sin(theta)};
	}
	
	/** Converts a rectangular coordinate to a polar one
	 * 
	 * @param x The x coord
	 * @param y The y coord
	 * @return The same coordinate in polar coordinates (r, theta)
	 */
	public static double[] rectangularToPolar(double x, double y) {
		return new double[]{Math.sqrt(x*x+y*y), Math.atan2(y,x)};
	}
}

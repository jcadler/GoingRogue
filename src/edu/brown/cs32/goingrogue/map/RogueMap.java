package edu.brown.cs32.goingrogue.map;

import java.util.List;

import edu.brown.cs32.goingrogue.gameobjects.items.GridItem;

/** An interface to allow access to map info inside the given bounds
 * Only handles access to things that are snapped to the grid, which means it does not handle
 * moving creatures, dropped items, etc
 * 
 * @author Dominic Adams
 * @author Ben Weedon
 * @author John Adler
 * @author Ken Lin
 * @version 1.0 4/13
 */
public interface RogueMap {
	
	/** Returns all Spaces in the area specified by the given bounds
	 * Note that spaces within one tile of the specified area should be returned to allow for walls
	 */
	public List<Space> getData(int minX, int minY, int maxX, int maxY);
}
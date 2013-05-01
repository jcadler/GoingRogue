package edu.brown.cs32.goingrogue.util;

/** A pair of integer values. Helpful for indexing tasks
 * 
 * @author Dominic Adams
 * @version 1.0 4/13
 */
public class IndexPair {
	
	public final int x;
	public final int y;
	
	public IndexPair(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public IndexPair incX() {
		return new IndexPair(x+1, y);
	}
	
	public IndexPair altX(int amt) {
		return new IndexPair(x+amt, y);
	}
	
	public IndexPair incY() {
		return new IndexPair(x, y+1);
	}
	
	public IndexPair altY(int amt) {
		return new IndexPair(x, y+amt);
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof IndexPair)) return false;
		IndexPair otherIndexPair=(IndexPair)other;
		return otherIndexPair.x==this.x &&
				otherIndexPair.y==this.y;
	}
}

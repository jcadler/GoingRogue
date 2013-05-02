package edu.brown.cs32.bweedon.geometry;

/**
 * a interface containing methods all n-dimensional shapes (Hypershapes) should
 * implement
 *
 * @author Ben Weedon (bweedon)
 */
public interface Hypershape {

    /**
     * determines if the specified OrderedTuple is inside this Hypershape
     *
     * @param tuple an OrderedTuple
     * @return true if the specified OrderedTuple is inside or exactly on the
     * border of this Hypershape, false if not
     */
    public boolean tupleInShape(OrderedTuple tuple);

    /**
     * gets the dimensions of this Hypershape
     *
     * @return the number of dimensions in this Hypershape
     */
    public int getDimensions();
}

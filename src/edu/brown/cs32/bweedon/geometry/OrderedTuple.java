package edu.brown.cs32.bweedon.geometry;

/**
 * a interface containing the methods all ordered-tuples should implement
 *
 * @author Ben Weedon (bweedon)
 */
public interface OrderedTuple {

    /**
     * gets the value of the OrderedTuple at the specified dimension
     *
     * @param dimension the zero-based dimension of the value to be retrieved
     * @return the value at the specified dimension
     */
    public double getValue(int dimension);

    /**
     * gets the number of dimensions of this OrderedTuple
     *
     * @return the number of dimensions of this OrderedTuple
     */
    public int getDimensions();

    /**
     * sets the value of this OrderedTuple to a specified new value at the
     * specified dimension
     *
     * @param dimension the dimension of the OrderedTuple to be set
     * @param newValue the new value to set into the OrderedTuple
     */
    public void setValue(int dimension, double newValue);

    /**
     * determines the distance between two OrderedTuples
     *
     * @param tuple2 the OrderedTuple being compared to this OrderedTuple
     * @return the distance in units between this OrderedTuple and the specified
     * OrderedTuple
     */
    public double distance(OrderedTuple tuple2);
}

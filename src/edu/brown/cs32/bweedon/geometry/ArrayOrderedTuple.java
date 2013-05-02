package edu.brown.cs32.bweedon.geometry;

import static java.lang.Math.*;
import java.util.Arrays;

/**
 * a class that represents an ordered tuple using an array to store the values
 * of the tuple
 *
 * @author Ben Weedon (bweedon)
 */
public class ArrayOrderedTuple implements OrderedTuple {

    private double[] values_;

    /**
     * constructs a new ArrayOrderedTuple using the specified values
     *
     * @param values either an array, or just a list of parameters, that
     * correspond to the ordered values of the ArrayOrderedTuple
     */
    public ArrayOrderedTuple(double... values) {
        values_ = values;
    }

    /**
     * gets the value of the ArrayOrderedTuple at the specified dimension
     *
     * @param dimension the zero-based dimension of the value to be retrieved
     * @return the value at the specified dimension
     */
    @Override
    public double getValue(int dimension) {
        return values_[dimension];
    }

    /**
     * gets the number of dimensions of this ArrayOrderedTuple
     *
     * @return the number of dimensions of this ArrayOrderedTuple
     */
    @Override
    public int getDimensions() {
        return values_.length;
    }

    /**
     * sets the value of this ArrayOrderedTuple to a specified new value at the
     * specified dimension
     *
     * @param dimension the dimension of the ArrayOrderedTuple to be set
     * @param newValue the new value to set into the ArrayOrderedTuple
     */
    @Override
    public void setValue(int dimension, double newValue) {
        values_[dimension] = newValue;
    }

    /**
     * determines the distance between two OrderedTuples
     *
     * @param tuple2 the OrderedTuple being compared to this ArrayOrderedTuple
     * @return the distance in units between this ArrayOrderedTuple and the
     * specified OrderedTuple
     */
    @Override
    public double distance(OrderedTuple tuple2) {
        if (this.getDimensions() != tuple2.getDimensions()) {
            throw new Error("These two OrderedTuples do not have the same number of dimensions!");
        }

        // carry out an n-dimensional Pythagorean formula to determine
        // the distance between the two tuples
        final int dims = this.getDimensions();
        double distance = abs(this.getValue(0) - tuple2.getValue(0));
        for (int i = 1; i < dims; ++i) {
            distance = sqrt(pow(distance, 2) + pow(this.getValue(i) - tuple2.getValue(i), 2));
        }

        return distance;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof OrderedTuple) {
            boolean equal = true;
            if (values_.length != ((OrderedTuple) other).getDimensions()) {
                equal = false;
            }
            for (int i = 0; i < values_.length; ++i) {
                if (values_[i] != ((OrderedTuple) other).getValue(i)) {
                    equal = false;
                }
            }
            return equal;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Arrays.hashCode(this.values_);
        return hash;
    }

    @Override
    public String toString() {
        String returnStr = "(" + values_[0];
        for (int i = 1; i < values_.length; ++i) {
            returnStr += ", " + values_[i];
        }
        returnStr += ")";
        return returnStr;
    }
}

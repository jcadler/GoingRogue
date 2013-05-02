package edu.brown.cs32.bweedon.geometry;

// TODO make equals, hashcode, and toString for every class
import java.util.Objects;

/**
 * a class representing an n-dimensional, axis-aligned Hyperrectangle
 *
 * @author Ben Weedon (bweedon)
 */
public class Hyperrectangle implements Hypershape {

    private OrderedTuple minPoint_, maxPoint_;

    /**
     * constructs a new Hyperrectangle with its min-point set to
     * Double.NEGATIVE_INFINITY, and its max-point set to
     * Double.POSITIVE_INFINITY
     *
     * @param dimensions the number of dimensions this Hyperrectangle should
     * have
     */
    public Hyperrectangle(int dimensions) {
        // produce the infinite hyperrectangle
        minPoint_ = new ArrayOrderedTuple(new double[dimensions]);
        maxPoint_ = new ArrayOrderedTuple(new double[dimensions]);
        for (int i = 0; i < dimensions; ++i) {
            minPoint_.setValue(i, Double.NEGATIVE_INFINITY);
            maxPoint_.setValue(i, Double.POSITIVE_INFINITY);
        }
    }

    /**
     * constructs a new Hyperrectangle out of the specified min- and max-points
     *
     * @param minPoint the OrderedTuple to be the min-point of the
     * Hyperrectangle
     * @param maxPoint the OrderedTuple to be the max-point of the
     * Hyperrectangle
     */
    public Hyperrectangle(OrderedTuple minPoint, OrderedTuple maxPoint) {
        if (minPoint.getDimensions() != maxPoint.getDimensions()) {
            throw new Error("The two given OrderedTuples are not of the same dimensions.");
        }
        for (int i = 0; i < minPoint.getDimensions(); ++i) {
            if (minPoint.getValue(i) > maxPoint.getValue(i)) {
                throw new Error("You gave the minimum and maximum points in the wrong order.");
            }
        }
        minPoint_ = minPoint;
        maxPoint_ = maxPoint;
    }

    /**
     * determines if the specified OrderedTuple is inside this Hyperrectangle
     *
     * @param tuple an OrderedTuple
     * @return true if the specified OrderedTuple is inside or exactly on the
     * border of this Hyperrectangle, false if not
     */
    @Override
    public boolean tupleInShape(OrderedTuple tuple) {
        if (tuple.getDimensions() != minPoint_.getDimensions()) {
            throw new Error("The number of dimensions in this OrderedTuple is not"
                    + " equal to the number of dimensions in the Hyperrectangle.");
        }
        for (int i = 0; i < minPoint_.getDimensions(); ++i) {
            double p = tuple.getValue(i);
            if ((p > maxPoint_.getValue(i)) || (p < minPoint_.getValue(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * produces a new Hyperrectangle split off from this one which is on the
     * lesser-valued end of the specified dimension and value
     *
     * @param dimension the dimension of the Hyperrectangle to be split along
     * @param value the value of the specified dimension to be split less than
     * @return a new Hyperrectangle split off from this one with the specified
     * split dimension and value
     */
    public Hyperrectangle splitLess(int dimension, double value) {
        OrderedTuple newMaxPoint = new ArrayOrderedTuple(new double[minPoint_.getDimensions()]);
        for (int i = 0; i < minPoint_.getDimensions(); ++i) {
            if (i == dimension) {
                newMaxPoint.setValue(i, value);
            } else {
                newMaxPoint.setValue(i, maxPoint_.getValue(i));
            }
        }
        return new Hyperrectangle(minPoint_, newMaxPoint);
    }

    /**
     * produces a new Hyperrectangle split off from this one which is on the
     * greater-valued end of the specified dimension and value
     *
     * @param dimension the dimension of the Hyperrectangle to be split along
     * @param value the value of the specified dimension to be split greater
     * than
     * @return a new Hyperrectangle split off from this one with the specified
     * split dimension and value
     */
    public Hyperrectangle splitGreater(int dimension, double value) {
        OrderedTuple newMinPoint = new ArrayOrderedTuple(new double[minPoint_.getDimensions()]);
        for (int i = 0; i < minPoint_.getDimensions(); ++i) {
            if (i == dimension) {
                newMinPoint.setValue(i, value);
            } else {
                newMinPoint.setValue(i, minPoint_.getValue(i));
            }
        }
        return new Hyperrectangle(newMinPoint, maxPoint_);
    }

    /**
     * gets the dimensions of this Hyperrectangle
     *
     * @return the number of dimensions in this Hyperrectangle
     */
    @Override
    public int getDimensions() {
        return minPoint_.getDimensions();
    }

    /**
     * gets the min-point of this Hyperrectangle
     *
     * @return an OrderedTuple representing the min-point of this Hyperrectangle
     */
    public OrderedTuple getMinPoint() {
        return minPoint_;
    }

    /**
     * gets the max-point of this Hyperrectangle
     *
     * @return an OrderedTuple representing the max-point of this Hyperrectangle
     */
    public OrderedTuple getMaxPoint() {
        return maxPoint_;
    }

    /**
     * sets the min-point of this Hyperrectangle to the OrderedTuple specified
     *
     * @param minPoint the OrderedTuple to set this Hyperrectangle's min-point
     * to
     */
    public void setMinPoint(OrderedTuple minPoint) {
        if (minPoint.getDimensions() != minPoint_.getDimensions()) {
            throw new Error("The specified minPoint is not of the correct dimensions.");
        } else {
            minPoint_ = minPoint;
        }
    }

    /**
     * sets the ax-point of this Hyperrectangle to the OrderedTuple specified
     *
     * @param maxPoint the OrderedTuple to set this Hyperrectangle's max-point
     * to
     */
    public void setMaxPoint(OrderedTuple maxPoint) {
        if (maxPoint.getDimensions() != maxPoint_.getDimensions()) {
            throw new Error("The specified maxPoint is not of the correct dimensions.");
        } else {
            maxPoint_ = maxPoint;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hyperrectangle) {
            return minPoint_.equals(((Hyperrectangle) obj).getMinPoint())
                    && maxPoint_.equals(((Hyperrectangle) obj).getMaxPoint());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.minPoint_);
        hash = 19 * hash + Objects.hashCode(this.maxPoint_);
        return hash;
    }

    @Override
    public String toString() {
        return "Hyperrectangle{" + "minPoint_=" + minPoint_ + ", maxPoint_=" + maxPoint_ + '}';
    }
}

package edu.brown.cs32.bweedon.geometry;

import java.util.Objects;

/**
 * a class representing an n-dimensional Hypersphere;
 *
 * @author Ben Weedon (bweedon)
 */
public class Hypersphere implements Hypershape {

    private OrderedTuple center_;
    private double radius_;

    /**
     * constructs a Hypersphere with the specified center and radius
     *
     * @param center an OrderedTuple representing the center of this Hypersphere
     * @param radius the radius of this Hypersphere
     */
    public Hypersphere(OrderedTuple center, double radius) {
        center_ = center;
        radius_ = radius;
    }

    /**
     * determines if the specified OrderedTuple is inside this Hypersphere
     *
     * @param tuple an OrderedTuple
     * @return true if the specified OrderedTuple is inside or exactly on the
     * border of this Hypersphere, false if not
     */
    @Override
    public boolean tupleInShape(OrderedTuple tuple) {
        if (center_.getDimensions() != tuple.getDimensions()) {
            throw new Error("The number of dimensions in this OrderedTuple is not"
                    + " equal to the number of dimensions in the Hypersphere.");
        }
        return (center_.distance(tuple) <= radius_);
    }

    /**
     * determines if this Hypersphere intersects with the specified
     * Hyperrectangle
     *
     * @param rec a Hyperrectangle of the same dimensions as this Hypersphere
     * @return true if this Hypersphere crosses the borders of or touches the
     * borders of the specified Hyperrectangle, false if not
     */
    public boolean intersectsHyperrectangle(Hyperrectangle rec) {
        if (center_.getDimensions() != rec.getDimensions()) {
            throw new Error("The number of dimensions in this Hypersphere is not"
                    + " equal to the number of dimensions in the given Hyperrectangle.");
        }

        OrderedTuple closestPoint = new ArrayOrderedTuple(new double[center_.getDimensions()]);
        // determine each dimension of the closest point on the
        // Hyperrectangle's edge to this Hypersphere
        for (int i = 0; i < center_.getDimensions(); ++i) {
            double cent = center_.getValue(i);
            double recMin = rec.getMinPoint().getValue(i);
            double recMax = rec.getMaxPoint().getValue(i);
            if (cent <= recMin) {
                closestPoint.setValue(i, recMin);
            } else if ((cent > recMin) && (cent < recMax)) {
                closestPoint.setValue(i, cent);
            } else if (cent >= recMax) {
                closestPoint.setValue(i, recMax);
            }
        }

        // return whether this closest point is within the Hypersphere's radius
        return (center_.distance(closestPoint) <= radius_);
    }

    /**
     * gets the dimensions of this Hypersphere
     *
     * @return the number of dimensions in this Hypersphere
     */
    @Override
    public int getDimensions() {
        return center_.getDimensions();
    }

    /**
     * gets the center of this Hypersphere
     *
     * @return an OrderedTuple representing the center of this Hypersphere
     */
    public OrderedTuple getCenter() {
        return center_;
    }

    /**
     * sets the center of this Hypersphere
     *
     * @param center an OrderedTuple which will become the new center of this
     * Hypersphere
     */
    public void setCenter(OrderedTuple center) {
        center_ = center;
    }

    /**
     * gets the radius of this Hypersphere
     *
     * @return the radius of this Hypersphere
     */
    public double getRadius() {
        return radius_;
    }

    /**
     * sets the radius of this Hypersphere
     *
     * @param radius the new radius of this Hypersphere
     */
    public void setRadius(double radius) {
        radius_ = radius;
    }

    @Override
    public String toString() {
        return "Hypersphere{" + "center_=" + center_ + ", radius_=" + radius_ + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Hypersphere) {
            return center_.equals(((Hypersphere) obj).getCenter())
                    && (radius_ == ((Hypersphere) obj).getRadius());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.center_);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.radius_) ^ (Double.doubleToLongBits(this.radius_) >>> 32));
        return hash;
    }
}

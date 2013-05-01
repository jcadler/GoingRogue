package edu.brown.cs32.goingrogue.gameobjects.actions;

import edu.brown.cs32.goingrogue.gameobjects.creatures.Creature;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import static java.lang.Math.PI;
import static java.lang.Math.toDegrees;
import java.util.Objects;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class ArcAttackRange implements Range {

    private double _direction; // in radians
    private double _distance;
    private double _arcLength; // in radians
    private int _timer;
    private final int STARTING_TIMER;
    private final Arc2D FULL_ARC;
    private final double RANGE_CHECK_ARC_EXTENT = PI / 3.0; // in radians

    public ArcAttackRange(double direction, double distance, double arcLength, int timer) {
        _direction = direction;
        _distance = distance;
        _arcLength = arcLength;
        _timer = STARTING_TIMER = timer;
        Rectangle2D ellipseBounds = new Rectangle2D.Double(0.0 - _distance,
                0.0 - _distance, _distance * 2.0, _distance * 2.0);
        FULL_ARC = new Arc2D.Double(ellipseBounds, toDegrees(_direction - (_arcLength / 2.0)), toDegrees(_arcLength), Arc2D.PIE);
    }

    @Override
    public boolean inRange(Creature creature) {
        Point2D creaturePos = creature.getPosition();
        Rectangle2D ellipseBounds = new Rectangle2D.Double(creaturePos.getX() - _distance,
                creaturePos.getY() - _distance, _distance * 2.0, _distance * 2.0);
        FULL_ARC.setFrame(ellipseBounds);
        double startAngle = toDegrees(((((double) STARTING_TIMER - _timer) / STARTING_TIMER) * (FULL_ARC.getAngleExtent())) + FULL_ARC.getAngleStart());
        Arc2D attackArc = new Arc2D.Double(ellipseBounds, startAngle, RANGE_CHECK_ARC_EXTENT, Arc2D.PIE);
        return attackArc.contains(creaturePos);
    }

    @Override
    public void decrementTimer(int delta) {
        _timer -= delta;
    }

    public double getAngle() {
        double startAngle = toDegrees(((((double) STARTING_TIMER - _timer) / STARTING_TIMER) * (FULL_ARC.getAngleExtent())) + FULL_ARC.getAngleStart());
        return startAngle + (RANGE_CHECK_ARC_EXTENT / 2.0);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this._direction) ^ (Double.doubleToLongBits(this._direction) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this._distance) ^ (Double.doubleToLongBits(this._distance) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this._arcLength) ^ (Double.doubleToLongBits(this._arcLength) >>> 32));
        hash = 37 * hash + this._timer;
        hash = 37 * hash + this.STARTING_TIMER;
        hash = 37 * hash + Objects.hashCode(this.FULL_ARC);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.RANGE_CHECK_ARC_EXTENT) ^ (Double.doubleToLongBits(this.RANGE_CHECK_ARC_EXTENT) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArcAttackRange other = (ArcAttackRange) obj;
        if (Double.doubleToLongBits(this._direction) != Double.doubleToLongBits(other._direction)) {
            return false;
        }
        if (Double.doubleToLongBits(this._distance) != Double.doubleToLongBits(other._distance)) {
            return false;
        }
        if (Double.doubleToLongBits(this._arcLength) != Double.doubleToLongBits(other._arcLength)) {
            return false;
        }
        if (this._timer != other._timer) {
            return false;
        }
        if (this.STARTING_TIMER != other.STARTING_TIMER) {
            return false;
        }
        if (!Objects.equals(this.FULL_ARC, other.FULL_ARC)) {
            return false;
        }
        if (Double.doubleToLongBits(this.RANGE_CHECK_ARC_EXTENT) != Double.doubleToLongBits(other.RANGE_CHECK_ARC_EXTENT)) {
            return false;
        }
        return true;
    }
}
package edu.brown.cs32.bweedon.gameobjects.creatures;

import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import static java.lang.Math.PI;
import static java.lang.Math.toDegrees;

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
    public void decrementTimer() {
        --_timer;
    }
}
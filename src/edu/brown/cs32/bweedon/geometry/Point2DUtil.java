package edu.brown.cs32.bweedon.geometry;

import java.awt.geom.Point2D;
import static java.lang.Math.atan;
import static java.lang.Math.PI;

/**
 * Yet another class created because Java is bad. Ugh.
 *
 * @author Ben Weedon (bweedon)
 */
public class Point2DUtil {

    /**
     * get the angle from <i>p1</i> to <i>p2</i>
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the angle from <i>p1</i> to <i>p2</i>
     */
    public static double getAngleFromTo(Point2D p1, Point2D p2) {
        double xDiff = p2.getX() - p1.getX();
        double yDiff = p2.getY() - p1.getY();
        double angle = atan(yDiff / xDiff);
        if (xDiff < 0) {
            angle += PI;
        }
        return angle;
    }
}

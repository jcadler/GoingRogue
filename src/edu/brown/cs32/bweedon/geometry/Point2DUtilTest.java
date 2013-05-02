package edu.brown.cs32.bweedon.geometry;

import java.awt.geom.Point2D;
import org.junit.Test;
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static edu.brown.cs32.bweedon.geometry.Point2DUtil.getAngleFromTo;
import static org.junit.Assert.assertTrue;
import static java.lang.Math.abs;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class Point2DUtilTest {

    @Test
    public void testGetAngle() {
        Point2D p1 = new Point2D.Double(0.0, 0.0);
        Point2D p2 = new Point2D.Double(sqrt(3), 1.0);
        
        assertTrue(abs(getAngleFromTo(p1, p2) - (PI / 6.0)) < 0.001);
        assertTrue(abs(getAngleFromTo(p2, p1) - ((7.0 * PI) / 6.0)) < 0.001);
    }
}

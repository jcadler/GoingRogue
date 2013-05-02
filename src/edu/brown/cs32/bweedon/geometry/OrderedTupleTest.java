package edu.brown.cs32.bweedon.geometry;

import static java.lang.Math.sqrt;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * a test class to test the methods of OrderedTuples
 *
 * @author Ben Weedon (bweedon)
 */
public class OrderedTupleTest {

    @Test
    public void testDistance() {
        OrderedTuple t1_1 = new ArrayOrderedTuple(0.0);
        OrderedTuple t1_2 = new ArrayOrderedTuple(5.7);
        OrderedTuple t2_1 = new ArrayOrderedTuple(3.8, 5.6);
        OrderedTuple t2_2 = new ArrayOrderedTuple(9.5, 2.7);
        OrderedTuple t3_1 = new ArrayOrderedTuple(7.8, 28.9, 2.0);
        OrderedTuple t3_2 = new ArrayOrderedTuple(0.3, 8.4, 8.4);

        /*
         * assertTrue
         */
        // one-dimensional
        assertTrue(t1_1.distance(t1_1) == 0.0);
        assertTrue(t1_2.distance(t1_2) == 0.0);
        assertTrue(t1_1.distance(t1_2) == 5.7);
        assertTrue(t1_2.distance(t1_1) == 5.7);
        // two-dimensional
        assertTrue(t2_1.distance(t2_1) == 0.0);
        assertTrue(t2_2.distance(t2_2) == 0.0);
        assertTrue(t2_1.distance(t2_2) == sqrt(40.9));
        assertTrue(t2_2.distance(t2_1) == sqrt(40.9));
        // three-dimensional
        assertTrue(t3_1.distance(t3_1) == 0.0);
        assertTrue(t3_2.distance(t3_2) == 0.0);
        assertTrue(t3_1.distance(t3_2) == sqrt(517.46));
    }
}

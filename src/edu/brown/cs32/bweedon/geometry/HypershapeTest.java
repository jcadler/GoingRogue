package edu.brown.cs32.bweedon.geometry;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * a test class to test the methods of Hypershapes
 *
 * @author Ben Weedon (bweedon)
 */
public class HypershapeTest {

    @Test
    public void testTupleInShapeHyperrectangle() {
        /*
         * 1-dimensional
         */
        OrderedTuple t1_1 = new ArrayOrderedTuple(0);
        OrderedTuple t1_2 = new ArrayOrderedTuple(3);
        OrderedTuple t1_3 = new ArrayOrderedTuple(4);
        Hypershape r1_1 = new Hyperrectangle(t1_2, t1_3);
        Hypershape r1_2 = new Hyperrectangle(t1_1, t1_3);

        assertFalse(r1_1.tupleInShape(t1_1));
        assertTrue(r1_2.tupleInShape(t1_2));

        /*
         * 2-dimensional
         */
        OrderedTuple t2_1 = new ArrayOrderedTuple(-6, 4);
        OrderedTuple t2_2 = new ArrayOrderedTuple(-2.3, 4.6);
        OrderedTuple t2_3 = new ArrayOrderedTuple(0, 5);
        Hypershape r2_1 = new Hyperrectangle(t2_2, t2_3);
        Hypershape r2_2 = new Hyperrectangle(t2_1, t2_3);

        assertFalse(r2_1.tupleInShape(t2_1));
        assertTrue(r2_2.tupleInShape(t2_2));

        /*
         * 3-dimensional
         */
        OrderedTuple t3_1 = new ArrayOrderedTuple(-5, -2, 1);
        OrderedTuple t3_2 = new ArrayOrderedTuple(0, 0, 2);
        OrderedTuple t3_3 = new ArrayOrderedTuple(6, 0.2, 500.1);
        Hypershape r3_1 = new Hyperrectangle(t3_2, t3_3);
        Hypershape r3_2 = new Hyperrectangle(t3_1, t3_3);

        assertFalse(r3_1.tupleInShape(t3_1));
        assertTrue(r3_2.tupleInShape(t3_2));
    }

    @Test
    public void testTupleInShapeHypersphere() {
        /*
         * 1-dimensional
         */
        OrderedTuple t1_1 = new ArrayOrderedTuple(3);
        OrderedTuple t1_2 = new ArrayOrderedTuple(2);
        OrderedTuple t1_3 = new ArrayOrderedTuple(5);
        Hypershape s1_1 = new Hypersphere(t1_1, 1);

        assertTrue(s1_1.tupleInShape(t1_2));
        assertFalse(s1_1.tupleInShape(t1_3));

        /*
         * 2-dimensional
         */
        OrderedTuple t2_1 = new ArrayOrderedTuple(0, 0);
        OrderedTuple t2_2 = new ArrayOrderedTuple(2.9, 3);
        OrderedTuple t2_3 = new ArrayOrderedTuple(3.1, 4);
        Hypershape s2_1 = new Hypersphere(t2_1, 5);

        assertTrue(s2_1.tupleInShape(t2_2));
        assertFalse(s2_1.tupleInShape(t2_3));

        /*
         * 3-dimensional
         */
        OrderedTuple t3_1 = new ArrayOrderedTuple(0, 0, 0);
        OrderedTuple t3_2 = new ArrayOrderedTuple(2.9, 3, 2);
        OrderedTuple t3_3 = new ArrayOrderedTuple(40, 3, 29);
        Hypershape s3_1 = new Hypersphere(t3_1, 5);

        assertTrue(s3_1.tupleInShape(t3_2));
        assertFalse(s3_1.tupleInShape(t3_3));
    }

    @Test
    public void testIntersectsHyperrectangle() {
        /*
         * 2-dimensional
         */
        OrderedTuple t2_1 = new ArrayOrderedTuple(2, 3);
        OrderedTuple t2_2 = new ArrayOrderedTuple(4, 4);
        OrderedTuple t2_3 = new ArrayOrderedTuple(7, 10);
        OrderedTuple t2_4 = new ArrayOrderedTuple(5, 2);
        // TODO how to I do this without declaring as Hypersphere and Hyperrectangle,
        // instead of as Hypershape?
        Hypersphere s2_1 = new Hypersphere(t2_1, sqrt(5));
        Hypersphere s2_2 = new Hypersphere(t2_1, sqrt(5) - 0.001);
        Hypersphere s2_3 = new Hypersphere(t2_4, 2);
        Hypersphere s2_4 = new Hypersphere(t2_4, 2 - 0.001);
        Hyperrectangle r2_1 = new Hyperrectangle(t2_2, t2_3);

        assertTrue(s2_1.intersectsHyperrectangle(r2_1));
        assertFalse(s2_2.intersectsHyperrectangle(r2_1));
        assertTrue(s2_3.intersectsHyperrectangle(r2_1));
        assertFalse(s2_4.intersectsHyperrectangle(r2_1));

        /*
         * 3-dimensional
         */
        OrderedTuple t3_1 = new ArrayOrderedTuple(2, 3, 7);
        OrderedTuple t3_2 = new ArrayOrderedTuple(4, 4, -3.2);
        OrderedTuple t3_3 = new ArrayOrderedTuple(7, 10, 2);
        OrderedTuple t3_4 = new ArrayOrderedTuple(5, 2, 4.24);
        Hypersphere s3_1 = new Hypersphere(t3_1, sqrt(30));
        Hypersphere s3_2 = new Hypersphere(t3_1, sqrt(30) - 0.001);
        Hypersphere s3_3 = new Hypersphere(t3_4, sqrt(4 + pow(2.24, 2)));
        Hypersphere s3_4 = new Hypersphere(t3_4, sqrt(4 + pow(2.24, 2)) - 0.001);
        Hyperrectangle r3_1 = new Hyperrectangle(t3_2, t3_3);

        assertTrue(s3_1.intersectsHyperrectangle(r3_1));
        assertFalse(s3_2.intersectsHyperrectangle(r3_1));
        assertTrue(s3_3.intersectsHyperrectangle(r3_1));
        assertFalse(s3_4.intersectsHyperrectangle(r3_1));
    }
}

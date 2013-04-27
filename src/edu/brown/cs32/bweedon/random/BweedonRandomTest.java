package edu.brown.cs32.bweedon.random;

import org.junit.Test;
import static edu.brown.cs32.bweedon.random.BweedonRandom.randomInt;
import static edu.brown.cs32.bweedon.random.BweedonRandom.randomDouble;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ben Weedon (bweedon)
 */
public class BweedonRandomTest {

    @Test
    public void randomIntTest() {
        int result;

        for (int i = 0; i < 50; ++i) { // test 50 times
            result = randomInt(0, 0);
            assertTrue(result == 0);

            result = randomInt(0, 1);
            assertTrue((result == 0) || (result == 1));

            result = randomInt(1, 2);
            assertTrue((result == 1) || (result == 2));

            result = randomInt(5, 20);
            assertTrue((result <= 20) && (result >= 5));
        }
    }

    @Test
    public void randomDoubleTest() {
        double result;

        for (int i = 0; i < 50; ++i) { // test 50 times
            result = randomDouble(0.0, 0.0);
            assertTrue(result == 0.0);

            result = randomDouble(0.0, 1.0);
            assertTrue((result <= 1.0) && (result >= 0.0));

            result = randomDouble(1.0, 2.0);
            assertTrue((result <= 2.0) && (result >= 1.0));

            result = randomDouble(5.0, 20.0);
            assertTrue((result <= 20.0) && (result >= 5.0));
        }
    }
}

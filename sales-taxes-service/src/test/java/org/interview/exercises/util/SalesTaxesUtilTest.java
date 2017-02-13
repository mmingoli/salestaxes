package org.interview.exercises.util;

import org.testng.annotations.Test;

import static org.interview.exercises.util.SalesTaxesUtil.roundDoubleNearestHalf;
import static org.testng.Assert.*;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxesUtilTest {

    @Test
    public void testRoundDouble() throws Exception {
        assertEquals(roundDoubleNearestHalf(0), 0.0);
        assertEquals(roundDoubleNearestHalf(5), 5.0);
        assertEquals(roundDoubleNearestHalf(3.1), 3.1);
        assertEquals(roundDoubleNearestHalf(11.66), 11.65);
        assertEquals(roundDoubleNearestHalf(25.361), 25.35);
        assertEquals(roundDoubleNearestHalf(25.365), 25.35);
        assertEquals(roundDoubleNearestHalf(25.366), 25.35);
        assertEquals(roundDoubleNearestHalf(25.3693652), 25.35);
    }

}
package org.interview.exercises.util;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxesUtilTest {

    @Test
    public void testRoundDouble() throws Exception {
        assertEquals(SalesTaxesUtil.roundDouble(0), 0.0);
        assertEquals(SalesTaxesUtil.roundDouble(5), 5.0);
        assertEquals(SalesTaxesUtil.roundDouble(3.1), 3.1);
        assertEquals(SalesTaxesUtil.roundDouble(11.66), 11.66);
        assertEquals(SalesTaxesUtil.roundDouble(25.361), 25.36);
        assertEquals(SalesTaxesUtil.roundDouble(25.365), 25.36);
        assertEquals(SalesTaxesUtil.roundDouble(25.366), 25.37);
        assertEquals(SalesTaxesUtil.roundDouble(25.3693652), 25.37);
    }

}
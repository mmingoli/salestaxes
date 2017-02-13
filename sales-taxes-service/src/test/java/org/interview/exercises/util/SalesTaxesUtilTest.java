package org.interview.exercises.util;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.interview.exercises.util.SalesTaxesUtil.roundBigDecimalNearestHalf;
import static org.testng.Assert.*;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxesUtilTest {

    @Test
    public void testRoundBigDecimal() throws Exception {
        assertEquals(roundBigDecimalNearestHalf(BigDecimal.valueOf(0)), BigDecimal.valueOf(0.0).setScale(2));
        assertEquals(roundBigDecimalNearestHalf(BigDecimal.valueOf(5)), BigDecimal.valueOf(5.0).setScale(2));
        assertEquals(roundBigDecimalNearestHalf(BigDecimal.valueOf(3.1)), BigDecimal.valueOf(3.1).setScale(2));
        assertEquals(roundBigDecimalNearestHalf(BigDecimal.valueOf(11.66)), BigDecimal.valueOf(11.70).setScale(2));
        assertEquals(roundBigDecimalNearestHalf(BigDecimal.valueOf(25.31)), BigDecimal.valueOf(25.35).setScale(2));
        assertEquals(roundBigDecimalNearestHalf(BigDecimal.valueOf(25.365)), BigDecimal.valueOf(25.40).setScale(2));
        assertEquals(roundBigDecimalNearestHalf(BigDecimal.valueOf(25.366)), BigDecimal.valueOf(25.40).setScale(2));
        assertEquals(roundBigDecimalNearestHalf(BigDecimal.valueOf(25.3693652)), BigDecimal.valueOf(25.40).setScale(2));
    }

}
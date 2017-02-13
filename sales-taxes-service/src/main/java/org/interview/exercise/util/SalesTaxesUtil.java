package org.interview.exercise.util;

import java.math.BigDecimal;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxesUtil {

    public static final BigDecimal PRECISION = BigDecimal.valueOf(0.05);

    /**
     * this method round up to the nearest 0.05 a BigDecimal in input
     * @param toRound
     * @return rounded BigDecimal
     */
    public static BigDecimal roundBigDecimalNearestHalf (BigDecimal toRound) {
        return toRound.divide(PRECISION).setScale(0, BigDecimal.ROUND_UP).multiply(PRECISION).setScale(2);
    }

}

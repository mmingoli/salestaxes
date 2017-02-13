package org.interview.exercises.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxesUtil {

    public static final BigDecimal PRECISION = BigDecimal.valueOf(0.05);

    /**
     * This method round up to the nearest 0.05 a BigDecimal in input
     * @param toRound
     * @return rounded BigDecimal
     */
    public static BigDecimal roundBigDecimalNearestHalf (BigDecimal toRound) {
        return toRound.divide(PRECISION).setScale(0, BigDecimal.ROUND_UP).multiply(PRECISION);
    }

}

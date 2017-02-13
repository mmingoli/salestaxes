package org.interview.exercises.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxesUtil {

    /**
     * This method round up to the nearest 0.05 a double in input
     * @param toRound
     * @return rounded double
     */
    public static double roundDoubleNearestHalf (double toRound) {
        return Math.round(toRound * 20.0) / 20.0;
    }

}

package org.interview.exercises.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxesUtil {

    /**
     * This method round to the second decimal digit a double in input
     * through RoundingMode.HALF_UP
     * @param toRound
     * @return rounded double
     */
    public static double roundDouble (double toRound) {
        return new BigDecimal(toRound).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}

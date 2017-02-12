package org.interview.exercises.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxesUtil {

    public static double roundDouble (double toRound) {
        return new BigDecimal(toRound).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}

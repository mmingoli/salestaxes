package org.interview.exercises.applier.impl;

import org.interview.exercises.applier.SalesTaxApplier;
import org.interview.exercises.bean.PurchasingItem;

import java.math.BigDecimal;

import static org.interview.exercises.util.SalesTaxesUtil.roundBigDecimalNearestHalf;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class ImportDutyTaxApplier implements SalesTaxApplier {

    public static BigDecimal salesTaxPercentage = BigDecimal.valueOf(5.0);

    public PurchasingItem apply(PurchasingItem item) {
        if (item.isImported()) {
            BigDecimal salesTax = roundBigDecimalNearestHalf(item.getSalesTax()
                    .add(item.getUnitPrice()
                            .multiply(salesTaxPercentage)
                            .divide(BigDecimal.valueOf(100))
                    )
            );

            item = new PurchasingItem
                    .Builder(item.getQuantity(), item.getName(), item.getType(), item.getUnitPrice())
                    .imported(item.isImported())
                    .salesTax(salesTax)
                    .build();
        }
        return item;
    }

}

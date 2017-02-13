package org.interview.exercise.applier.impl;

import org.interview.exercise.applier.SalesTaxApplier;
import org.interview.exercise.bean.PurchasingItem;
import org.interview.exercise.util.SalesTaxesUtil;

import java.math.BigDecimal;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class ImportDutyTaxApplier implements SalesTaxApplier {

    public static BigDecimal salesTaxPercentage = BigDecimal.valueOf(5.0);

    public PurchasingItem apply(PurchasingItem item) {
        if (item.isImported()) {
            BigDecimal salesTax = SalesTaxesUtil.roundBigDecimalNearestHalf(item.getSalesTax()
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

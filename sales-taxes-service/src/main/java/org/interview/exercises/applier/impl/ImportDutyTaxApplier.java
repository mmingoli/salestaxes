package org.interview.exercises.applier.impl;

import org.interview.exercises.applier.SalesTaxApplier;
import org.interview.exercises.bean.PurchasingItem;

import static org.interview.exercises.util.SalesTaxesUtil.roundDoubleNearestHalf;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class ImportDutyTaxApplier implements SalesTaxApplier {

    public static double salesTaxPercentage = 5.0;

    public PurchasingItem apply(PurchasingItem item) {
        if (item.isImported()) {
            double salesTax = roundDoubleNearestHalf(item.getSalesTax() + (item.getUnitPrice() * salesTaxPercentage / 100));
            item = new PurchasingItem
                    .Builder(item.getQuantity(), item.getName(), item.getType(), item.getUnitPrice())
                    .imported(item.isImported())
                    .salesTax(salesTax)
                    .build();
        }
        return item;
    }

}

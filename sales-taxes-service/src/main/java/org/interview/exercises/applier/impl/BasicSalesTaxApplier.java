package org.interview.exercises.applier.impl;

import org.interview.exercises.applier.SalesTaxApplier;
import org.interview.exercises.bean.PurchasingItem;
import org.interview.exercises.bean.PurchasingItemType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class BasicSalesTaxApplier implements SalesTaxApplier {

    public  static double salesTaxPercentage = 10.0;
    private static List<PurchasingItemType> applicablePurchasingItemTypes = new ArrayList<PurchasingItemType>();

    static {
        applicablePurchasingItemTypes.add(PurchasingItemType.MUSIC);
        applicablePurchasingItemTypes.add(PurchasingItemType.COSMETICS);
    }

    public PurchasingItem apply(PurchasingItem item) {{}
        if (applicablePurchasingItemTypes.contains(item.getType())) {
            double salesTax = item.getSalesTax() + (item.getUnitPrice() * salesTaxPercentage / 100);
            item = new PurchasingItem
                    .Builder(item.getQuantity(), item.getName(), item.getType(), item.getUnitPrice())
                    .imported(item.isImported())
                    .salesTax(salesTax)
                    .build();
        }
        return item;
    }

}

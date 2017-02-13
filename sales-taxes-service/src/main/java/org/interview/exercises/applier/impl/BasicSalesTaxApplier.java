package org.interview.exercises.applier.impl;

import org.interview.exercises.applier.SalesTaxApplier;
import org.interview.exercises.bean.PurchasingItem;
import org.interview.exercises.bean.PurchasingItemType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.interview.exercises.util.SalesTaxesUtil.roundBigDecimalNearestHalf;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class BasicSalesTaxApplier implements SalesTaxApplier {

    public  static BigDecimal salesTaxPercentage = BigDecimal.valueOf(10.0);
    private static List<PurchasingItemType> applicablePurchasingItemTypes = new ArrayList<PurchasingItemType>();

    static {
        applicablePurchasingItemTypes.add(PurchasingItemType.MUSIC);
        applicablePurchasingItemTypes.add(PurchasingItemType.COSMETICS);
    }

    public PurchasingItem apply(PurchasingItem item) {{}
        if (applicablePurchasingItemTypes.contains(item.getType())) {
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

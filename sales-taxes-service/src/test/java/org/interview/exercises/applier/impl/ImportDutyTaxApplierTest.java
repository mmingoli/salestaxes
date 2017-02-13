package org.interview.exercises.applier.impl;

import org.interview.exercises.bean.PurchasingItem;
import org.interview.exercises.bean.PurchasingItemType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.interview.exercises.applier.impl.ImportDutyTaxApplier.salesTaxPercentage;
import static org.interview.exercises.util.SalesTaxesUtil.roundBigDecimalNearestHalf;
import static org.testng.Assert.assertEquals;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class ImportDutyTaxApplierTest {

    private PurchasingItem item1;
    private PurchasingItem item2;
    private ImportDutyTaxApplier importDutyTaxApplier = new ImportDutyTaxApplier();

    @BeforeMethod
    public void setUp() throws Exception {
        item1 = new PurchasingItem
                .Builder("test name", PurchasingItemType.MUSIC, BigDecimal.valueOf(17.3))
                .build();
        item2 = new PurchasingItem
                .Builder("test name", PurchasingItemType.MUSIC, BigDecimal.valueOf(13.7))
                .imported(true)
                .build();
    }

    @Test
    public void testApply() throws Exception {
        PurchasingItem taxedItem1 = importDutyTaxApplier.apply(item1);
        PurchasingItem taxedItem2 = importDutyTaxApplier.apply(item2);

        assertEquals(taxedItem1.getSalesTax(), item1.getSalesTax());
        assertEquals(taxedItem2.getSalesTax(), roundBigDecimalNearestHalf(
                    item2.getSalesTax().add(item2.getUnitPrice()
                            .multiply(salesTaxPercentage).divide(BigDecimal.valueOf(100))
                    )
                )
            );
    }

}
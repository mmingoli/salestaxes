package org.interview.exercise.applier.impl;

import org.interview.exercise.applier.impl.BasicSalesTaxApplier;
import org.interview.exercise.bean.PurchasingItem;
import org.interview.exercise.bean.PurchasingItemType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.interview.exercise.applier.impl.BasicSalesTaxApplier.salesTaxPercentage;
import static org.interview.exercise.util.SalesTaxesUtil.roundBigDecimalNearestHalf;
import static org.testng.Assert.assertEquals;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class BasicSalesTaxApplierTest {

    private PurchasingItem itemBooks;
    private PurchasingItem itemMusic;
    private PurchasingItem itemFood;
    private PurchasingItem itemMedicalProducts;
    private PurchasingItem itemCosmetics;
    private BasicSalesTaxApplier importDutyTaxApplier = new BasicSalesTaxApplier();

    @BeforeMethod
    public void setUp() throws Exception {
        itemBooks = new PurchasingItem
                .Builder("test name", PurchasingItemType.BOOKS, BigDecimal.valueOf(17.3))
                .build();
        itemMusic = new PurchasingItem
                .Builder("test name", PurchasingItemType.MUSIC, BigDecimal.valueOf(13.7))
                .imported(true)
                .build();
        itemFood = new PurchasingItem
                .Builder("test name", PurchasingItemType.FOOD, BigDecimal.valueOf(22.4))
                .build();
        itemMedicalProducts = new PurchasingItem
                .Builder("test name", PurchasingItemType.MEDICAL_PRODUCTS, BigDecimal.valueOf(3.3))
                .build();
        itemCosmetics = new PurchasingItem
                .Builder("test name", PurchasingItemType.COSMETICS, BigDecimal.valueOf(12.17))
                .build();
    }

    @Test
    public void testApply() throws Exception {
        PurchasingItem taxedItemBooks = importDutyTaxApplier.apply(itemBooks);
        PurchasingItem taxedItemMusic= importDutyTaxApplier.apply(itemMusic);
        PurchasingItem taxedItemFood = importDutyTaxApplier.apply(itemFood);
        PurchasingItem taxedItemMedicalProducts = importDutyTaxApplier.apply(itemMedicalProducts);
        PurchasingItem taxedItemCosmetics = importDutyTaxApplier.apply(itemCosmetics);


        assertEquals(taxedItemBooks.getSalesTax(), itemBooks.getSalesTax());
        assertEquals(taxedItemMusic.getSalesTax(), roundBigDecimalNearestHalf(
                itemMusic.getSalesTax().add(itemMusic.getUnitPrice()
                        .multiply(salesTaxPercentage).divide(BigDecimal.valueOf(100))
                )
        ));
        assertEquals(taxedItemFood.getSalesTax(), itemFood.getSalesTax());
        assertEquals(taxedItemMedicalProducts.getSalesTax(), itemMedicalProducts.getSalesTax());
        assertEquals(taxedItemCosmetics.getSalesTax(), roundBigDecimalNearestHalf(
                itemCosmetics.getSalesTax().add(itemCosmetics.getUnitPrice()
                        .multiply(salesTaxPercentage).divide(BigDecimal.valueOf(100))
                )
        ));
    }

}
package org.interview.exercises.applier.impl;

import org.interview.exercises.bean.PurchasingItem;
import org.interview.exercises.bean.PurchasingItemType;
import org.interview.exercises.util.SalesTaxesUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        itemBooks = new PurchasingItem.Builder("test name", PurchasingItemType.BOOKS, 17.3).build();
        itemMusic = new PurchasingItem.Builder("test name", PurchasingItemType.MUSIC, 13.7)
                .imported(true)
                .build();
        itemFood = new PurchasingItem.Builder("test name", PurchasingItemType.FOOD, 22.4).build();
        itemMedicalProducts = new PurchasingItem.Builder("test name", PurchasingItemType.MEDICAL_PRODUCTS, 3.3).build();
        itemCosmetics = new PurchasingItem.Builder("test name", PurchasingItemType.COSMETICS, 12.17).build();
    }

    @Test
    public void testApply() throws Exception {
        PurchasingItem taxedItemBooks = importDutyTaxApplier.apply(itemBooks);
        PurchasingItem taxedItemMusic= importDutyTaxApplier.apply(itemMusic);
        PurchasingItem taxedItemFood = importDutyTaxApplier.apply(itemFood);
        PurchasingItem taxedItemMedicalProducts = importDutyTaxApplier.apply(itemMedicalProducts);
        PurchasingItem taxedItemCosmetics = importDutyTaxApplier.apply(itemCosmetics);


        assertEquals(taxedItemBooks.getSalesTax(), itemBooks.getSalesTax());
        assertEquals(taxedItemMusic.getSalesTax(), SalesTaxesUtil.roundDouble(itemMusic.getSalesTax() +
                (itemMusic.getUnitPrice() * BasicSalesTaxApplier.salesTaxPercentage / 100)));
        assertEquals(taxedItemFood.getSalesTax(), itemFood.getSalesTax());
        assertEquals(taxedItemMedicalProducts.getSalesTax(), itemMedicalProducts.getSalesTax());
        assertEquals(taxedItemCosmetics.getSalesTax(), SalesTaxesUtil.roundDouble(itemCosmetics.getSalesTax() +
                (itemCosmetics.getUnitPrice() * BasicSalesTaxApplier.salesTaxPercentage / 100)));
    }

}
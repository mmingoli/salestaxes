package org.interview.exercises.bean;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class ReceiptTest {

    private static final double UNIT_PRICE1 = 10.15;
    private static final double UNIT_PRICE2 = 7.38;
    private static final double SALES_TAX1 = 1.45;
    private static final double SALES_TAX2 = 0.51;

    private Receipt receipt;

    @BeforeMethod
    public void setUp() throws Exception {
        receipt = new Receipt();
        receipt.addItem(new PurchasingItem.Builder("fight club", PurchasingItemType.BOOKS, UNIT_PRICE1)
                .salesTax(SALES_TAX1)
                .build());
        receipt.addItem(new PurchasingItem.Builder("moby dick", PurchasingItemType.BOOKS, UNIT_PRICE2)
                .salesTax(SALES_TAX2)
                .build());
    }

    @Test
    public void testGetTotalSalesTaxes() throws Exception {
        assertEquals(receipt.getTotalSalesTaxes(), SALES_TAX1 + SALES_TAX2);
    }

    @Test
    public void testGetTotalPrice() throws Exception {
        final double TOTAL_PRICE1 = UNIT_PRICE1 + SALES_TAX1;
        final double TOTAL_PRICE2 = UNIT_PRICE2 + SALES_TAX2;

        assertEquals(receipt.getTotalPrice(), TOTAL_PRICE1 + TOTAL_PRICE2);
    }

}
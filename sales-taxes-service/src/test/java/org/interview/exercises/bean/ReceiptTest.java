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

    private PurchasingItem item1;
    private PurchasingItem item2;
    private Receipt receipt;

    @BeforeMethod
    public void setUp() throws Exception {
        item1 = getPurchasingItem(UNIT_PRICE1, SALES_TAX1);
        item2 = getPurchasingItem(UNIT_PRICE2, SALES_TAX2);

        receipt = new Receipt();
        receipt.addItem(item1);
        receipt.addItem(item2);
    }

    @Test
    public void testGetTotalSalesTaxes() throws Exception {
        assertEquals(receipt.getTotalSalesTaxes(), item1.getTotalSalesTax() + item2.getTotalSalesTax());
    }

    @Test
    public void testGetTotalPrice() throws Exception {
        assertEquals(receipt.getTotalPrice(), item1.getTotalPrice() + item2.getTotalPrice());
    }

    private PurchasingItem getPurchasingItem(double unitPrice, double salesTax) {
        return new PurchasingItem.Builder("test name", PurchasingItemType.BOOKS, unitPrice)
                .salesTax(salesTax)
                .build();
    }

}
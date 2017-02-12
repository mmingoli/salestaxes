package org.interview.exercises.bean;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class PurchasingItemTest {

    private static final int QUANTITY = 3;
    private static final String NAME = "fight club";
    private static final PurchasingItemType TYPE = PurchasingItemType.BOOKS;
    private static final double UNIT_PRICE = 10.15;

    private PurchasingItem item;

    @Test
    public void testBuilderWithQuantity() throws Exception{
        item = new PurchasingItem.Builder(QUANTITY, NAME, TYPE, UNIT_PRICE).build();

        checkPurchasingItemInstance(QUANTITY, NAME, TYPE, UNIT_PRICE);
    }

    @Test
    public void testBuilderWithoutQuantity() throws Exception{
        item = new PurchasingItem.Builder(NAME, TYPE, UNIT_PRICE).build();

        checkPurchasingItemInstance(1, NAME, TYPE, UNIT_PRICE);
    }

    @Test
    public void testImported() throws Exception{
        item = new PurchasingItem.Builder(NAME, TYPE, UNIT_PRICE)
                .imported(true)
                .build();

        assertTrue(item.isImported());

        item = new PurchasingItem.Builder(NAME, TYPE, UNIT_PRICE)
                .imported(false)
                .build();

        assertFalse(item.isImported());
    }

    @Test
    public void testSalesTax() throws Exception{
        double salesTax = 11.4;
        item = new PurchasingItem.Builder(NAME, TYPE, UNIT_PRICE)
                .salesTax(salesTax)
                .build();

        assertEquals(item.getSalesTax(), salesTax);
    }

    private void checkPurchasingItemInstance(int quantity, String name, PurchasingItemType type, double unitPrice) {
        assertEquals(item.getQuantity(), quantity);
        assertEquals(item.getName(), name);
        assertEquals(item.getType(), type);
        assertEquals(item.getUnitPrice(), unitPrice);
    }
}

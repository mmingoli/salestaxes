package org.interview.exercise.bean;

import org.interview.exercise.bean.PurchasingItem;
import org.interview.exercise.bean.PurchasingItemType;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class PurchasingItemTest {

    private static final int QUANTITY = 3;
    private static final String NAME = "test name";
    private static final PurchasingItemType TYPE = PurchasingItemType.BOOKS;
    private static final BigDecimal UNIT_PRICE = BigDecimal.valueOf(10.15);
    public static final BigDecimal SALES_TAX = BigDecimal.valueOf(11.4);

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
    }

    @Test
    public void testSalesTax() throws Exception{
        item = getPurchasingItemWithSalesTax();

        assertEquals(item.getSalesTax(), SALES_TAX);
    }

    @Test
    public void testGetTotalSalesTaxes() throws Exception {
        item = getPurchasingItemWithSalesTax();

        assertEquals(item.getTotalSalesTax(), SALES_TAX.multiply(BigDecimal.valueOf(QUANTITY)));
    }

    @Test
    public void testGetTotalPrice() throws Exception {
        item = getPurchasingItemWithSalesTax();

        assertEquals(item.getTotalPrice(), (UNIT_PRICE.add(SALES_TAX)).multiply(BigDecimal.valueOf(QUANTITY)));
    }

    private PurchasingItem getPurchasingItemWithSalesTax() {
        return new PurchasingItem.Builder(QUANTITY, NAME, TYPE, UNIT_PRICE)
                .salesTax(SALES_TAX)
                .build();
    }

    private void checkPurchasingItemInstance(int quantity, String name, PurchasingItemType type, BigDecimal unitPrice) {
        assertEquals(item.getQuantity(), quantity);
        assertEquals(item.getName(), name);
        assertEquals(item.getType(), type);
        assertEquals(item.getUnitPrice(), unitPrice);
    }
}

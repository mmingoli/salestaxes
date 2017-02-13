package org.interview.exercise.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.interview.exercise.bean.PurchasingItem;
import org.interview.exercise.bean.PurchasingItemType;
import org.interview.exercise.bean.Receipt;
import org.interview.exercise.service.SalesTaxesService;
import org.interview.exercise.service.impl.SalesTaxesServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;
import static org.apache.commons.lang3.math.NumberUtils.toInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class InterviewExerciseStepdefs {

    public static final String IMPORTED_HEADER = "IMPORTED";
    public static final String QUANTITY_HEADER = "QUANTITY";
    public static final String NAME_HEADER = "NAME";
    public static final String TYPE_HEADER = "TYPE";
    public static final String UNIT_PRICE_HEADER = "UNIT_PRICE";
    public static final String TOTAL_PRICE_HEADER = "TOTAL_PRICE";

    private List<PurchasingItem> items = new ArrayList<PurchasingItem>();
    private SalesTaxesService salesTaxesService = new SalesTaxesServiceImpl();
    private Receipt receipt = new Receipt();

    @Given("^the below purchasing items list:$")
    public void theBelowPurchasingItemsList(DataTable dataTable) throws Throwable {
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            items.add(convertRowToPurchasingItem(row));
        }
    }

    @When("^the sales taxes service is called$")
    public void theSalesTaxesServiceIsCalled() throws Throwable {
        receipt = salesTaxesService.getReceipt(items);
    }

    @Then("^the receipt is made by the following purchasing items:$")
    public void theReceiptIsMadeByTheFollowingPurchasingItems(DataTable dataTable) throws Throwable {
        Receipt expectedReceipt = new Receipt();
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            expectedReceipt.addItem(convertRowToPurchasingItem(row));
        }

        checkReceipt(expectedReceipt);
    }

    @And("^total sales taxes is (.*)$")
    public void totalSalesTaxesIs(String totalStr) throws Throwable {
        assertEquals(new BigDecimal(totalStr), receipt.getTotalSalesTaxes());
    }

    @And("^total is (.*)$")
    public void totalIs(String totalStr) throws Throwable {
        assertEquals(new BigDecimal(totalStr), receipt.getTotalPrice());
    }

    private void checkReceipt(Receipt expectedReceipt) {
        final Iterator<PurchasingItem> actuaIT = receipt.itemsIterator();
        final Iterator<PurchasingItem> expectedIT = expectedReceipt.itemsIterator();
        while (actuaIT.hasNext() && expectedIT.hasNext()) {
            assertEquals(expectedIT.next(), actuaIT.next());
        }
        assertFalse(actuaIT.hasNext());
        assertFalse(expectedIT.hasNext());
    }

    private static final PurchasingItem convertRowToPurchasingItem(Map<String, String> row) {
        final boolean imported = parseBoolean(row.get(IMPORTED_HEADER));
        final int quantity = toInt(row.get(QUANTITY_HEADER));
        final String name = row.get(NAME_HEADER);
        final PurchasingItemType type = PurchasingItemType.valueOf(row.get(TYPE_HEADER));
        final BigDecimal unitPrice = new BigDecimal(row.get(UNIT_PRICE_HEADER));
        final BigDecimal totalPrice =
                (row.get(TOTAL_PRICE_HEADER) != null)?new BigDecimal(row.get(TOTAL_PRICE_HEADER)):BigDecimal.ZERO;
        final BigDecimal salesTax =
                (totalPrice.compareTo(BigDecimal.ZERO) == 1)?totalPrice.subtract(unitPrice):BigDecimal.ZERO;
        return new PurchasingItem
                .Builder(quantity, name, type, unitPrice)
                .imported(imported)
                .salesTax(salesTax)
                .build();
    }
}

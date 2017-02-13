package org.interview.exercises.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.interview.exercises.bean.PurchasingItem;
import org.interview.exercises.bean.PurchasingItemType;
import org.interview.exercises.bean.Receipt;
import org.interview.exercises.service.SalesTaxesService;
import org.interview.exercises.service.impl.SalesTaxesServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;
import static org.apache.commons.lang3.math.NumberUtils.toDouble;
import static org.apache.commons.lang3.math.NumberUtils.toInt;
import static org.interview.exercises.util.SalesTaxesUtil.roundDoubleNearestHalf;
import static org.testng.Assert.assertEquals;

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
    }

    @And("^total sales taxes is (.*)$")
    public void totalSalesTaxesIs(String totalStr) throws Throwable {
        assertEquals(receipt.getTotalSalesTaxes(), toDouble(totalStr));
    }

    @And("^total is (.*)$")
    public void totalIs(String totalStr) throws Throwable {
        assertEquals(receipt.getTotalPrice(), toDouble(totalStr));
    }

    private static final PurchasingItem convertRowToPurchasingItem(Map<String, String> row) {
        final boolean imported = parseBoolean(row.get(IMPORTED_HEADER));
        final int quantity = toInt(row.get(QUANTITY_HEADER));
        final String name = row.get(NAME_HEADER);
        final PurchasingItemType type = PurchasingItemType.valueOf(row.get(TYPE_HEADER));
        final double unitPrice = toDouble(row.get(UNIT_PRICE_HEADER));
        final double totalPrice = toDouble(row.get(TOTAL_PRICE_HEADER));
        final double salesTax = (totalPrice > 0)?totalPrice - unitPrice:0;
        return new PurchasingItem
                .Builder(quantity, name, type, unitPrice)
                .imported(imported)
                .salesTax(salesTax)
                .build();
    }
}

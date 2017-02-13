package org.interview.exercise.service;

import org.interview.exercise.applier.manager.SalesTaxApplierManager;
import org.interview.exercise.bean.PurchasingItem;
import org.interview.exercise.bean.Receipt;
import org.interview.exercise.service.SalesTaxesService;

import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public abstract class AbstractSalesTaxesService implements SalesTaxesService {

    @Override
    public Receipt getReceipt(List<PurchasingItem> items) {
        Receipt receipt = new Receipt();

        SalesTaxApplierManager salesTaxApplierManager = setUpSalesTaxApplierManager();

        for (PurchasingItem item :
                items) {
            receipt.addItem(salesTaxApplierManager.applySalesTax(item));
        }

        return receipt;
    }

    /**
     * method to set up the {@link SalesTaxApplierManager} with the chain of {@link org.interview.exercise.applier.SalesTaxApplier}
     * @return
     */
    protected abstract SalesTaxApplierManager setUpSalesTaxApplierManager();

}

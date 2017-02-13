package org.interview.exercise.service.impl;

import org.interview.exercise.applier.manager.SalesTaxApplierManager;
import org.interview.exercise.bean.PurchasingItem;
import org.interview.exercise.bean.Receipt;
import org.interview.exercise.service.SalesTaxesService;
import org.interview.exercise.applier.impl.BasicSalesTaxApplier;
import org.interview.exercise.applier.impl.ImportDutyTaxApplier;

import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class SalesTaxesServiceImpl implements SalesTaxesService {

    @Override
    public Receipt getReceipt(List<PurchasingItem> items) {
        Receipt receipt = new Receipt();

        SalesTaxApplierManager salesTaxApplierManager = new SalesTaxApplierManager.Builder()
                .addSalesTaxApplier(new BasicSalesTaxApplier())
                .addSalesTaxApplier(new ImportDutyTaxApplier())
                .build();

        for (PurchasingItem item :
                items) {
            receipt.addItem(salesTaxApplierManager.applySalesTax(item));
        }

        return receipt;
    }

}

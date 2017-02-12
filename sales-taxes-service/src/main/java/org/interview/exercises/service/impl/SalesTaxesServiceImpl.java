package org.interview.exercises.service.impl;

import org.interview.exercises.applier.impl.BasicSalesTaxApplier;
import org.interview.exercises.applier.impl.ImportDutyTaxApplier;
import org.interview.exercises.applier.manager.SalesTaxApplierManager;
import org.interview.exercises.bean.PurchasingItem;
import org.interview.exercises.bean.Receipt;
import org.interview.exercises.service.SalesTaxesService;

import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class SalesTaxesServiceImpl implements SalesTaxesService{

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

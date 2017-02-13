package org.interview.exercise.service.impl;

import org.interview.exercise.applier.impl.BasicSalesTaxApplier;
import org.interview.exercise.applier.impl.ImportDutyTaxApplier;
import org.interview.exercise.applier.manager.SalesTaxApplierManager;
import org.interview.exercise.service.AbstractSalesTaxesService;

/**
 * Created by mmingoli on 2/13/2017.
 */
public class SalesTaxesServiceImpl extends AbstractSalesTaxesService {

    @Override
    protected SalesTaxApplierManager setUpSalesTaxApplierManager() {
        return new SalesTaxApplierManager.Builder()
                .addSalesTaxApplier(new BasicSalesTaxApplier())
                .addSalesTaxApplier(new ImportDutyTaxApplier())
                .build();
    }

}

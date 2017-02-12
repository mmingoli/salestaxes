package org.interview.exercises.applier.chain;

import org.interview.exercises.applier.SalesTaxApplier;
import org.interview.exercises.bean.PurchasingItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class SalesTaxApplierChain {
    private List<SalesTaxApplier> salesTaxAppliers = new ArrayList<SalesTaxApplier>();

    public void addSalesTaxApplier(SalesTaxApplier salesTaxApplier){
        salesTaxAppliers.add(salesTaxApplier);
    }

    public PurchasingItem apply(PurchasingItem item){
        for (SalesTaxApplier salesTaxApplier :
                salesTaxAppliers) {
            item = salesTaxApplier.apply(item);
        }

        return item;
    }

}

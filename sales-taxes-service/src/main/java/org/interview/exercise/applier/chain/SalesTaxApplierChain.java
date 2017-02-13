package org.interview.exercise.applier.chain;

import org.interview.exercise.applier.SalesTaxApplier;
import org.interview.exercise.bean.PurchasingItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class SalesTaxApplierChain {
    private List<SalesTaxApplier> salesTaxAppliers = new LinkedList<SalesTaxApplier>();

    /**
     * it allows to add a {@link SalesTaxApplier} to the chain
     * @param salesTaxApplier
     */
    public void addSalesTaxApplier(SalesTaxApplier salesTaxApplier){
        salesTaxAppliers.add(salesTaxApplier);
    }

    /**
     * execute all the {@link SalesTaxApplier} maintaining the order of adding
     * @param item
     * @return item with all the sales taxes
     */
    public PurchasingItem apply(PurchasingItem item){
        for (SalesTaxApplier salesTaxApplier :
                salesTaxAppliers) {
            item = salesTaxApplier.apply(item);
        }

        return item;
    }

}

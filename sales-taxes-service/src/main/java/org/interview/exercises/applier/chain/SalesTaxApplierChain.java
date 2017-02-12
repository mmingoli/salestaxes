package org.interview.exercises.applier.chain;

import org.interview.exercises.applier.SalesTaxApplier;
import org.interview.exercises.bean.PurchasingItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class SalesTaxApplierChain {
    private List<SalesTaxApplier> salesTaxAppliers = new LinkedList<SalesTaxApplier>();

    /**
     * By this method it's possible to add a {@link SalesTaxApplier} to the chain
     * @param salesTaxApplier
     */
    public void addSalesTaxApplier(SalesTaxApplier salesTaxApplier){
        salesTaxAppliers.add(salesTaxApplier);
    }

    /**
     * Execute all the {@link SalesTaxApplier} in order as they were added
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

package org.interview.exercises.applier.manager;

import org.interview.exercises.applier.SalesTaxApplier;
import org.interview.exercises.applier.chain.SalesTaxApplierChain;
import org.interview.exercises.bean.PurchasingItem;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class SalesTaxApplierManager {
    private SalesTaxApplierChain salesTaxApplierChain;

    private SalesTaxApplierManager(Builder builder){
        salesTaxApplierChain = builder.getSalesTaxApplierChain();
    }

    public PurchasingItem applySalesTax(PurchasingItem item){
        return salesTaxApplierChain.apply(item);
    }

    public static class Builder {
        private SalesTaxApplierChain salesTaxApplierChain;

        public Builder() {
            this.salesTaxApplierChain = new SalesTaxApplierChain();
        }

        public SalesTaxApplierChain getSalesTaxApplierChain() {
            return salesTaxApplierChain;
        }

        public Builder addSalesTaxApplier(SalesTaxApplier salesTaxApplier){
            salesTaxApplierChain.addSalesTaxApplier(salesTaxApplier);
            return this;
        }

        public SalesTaxApplierManager build() {
            return new SalesTaxApplierManager(this);
        }
    }
}

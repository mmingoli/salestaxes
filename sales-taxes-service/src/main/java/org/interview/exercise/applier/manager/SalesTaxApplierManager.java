package org.interview.exercise.applier.manager;

import org.interview.exercise.applier.SalesTaxApplier;
import org.interview.exercise.applier.chain.SalesTaxApplierChain;
import org.interview.exercise.bean.PurchasingItem;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class SalesTaxApplierManager {
    private SalesTaxApplierChain salesTaxApplierChain;

    private SalesTaxApplierManager(Builder builder){
        salesTaxApplierChain = builder.getSalesTaxApplierChain();
    }

    /**
     * Context to call the chain of {@link SalesTaxApplier} which will apply
     * sales taxes to {@link PurchasingItem}
     * @param item
     * @return item with all the sales taxes
     */
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

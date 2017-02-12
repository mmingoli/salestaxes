package org.interview.exercises.applier;

import org.interview.exercises.bean.PurchasingItem;

/**
 * Created by mmingoli on 2/11/2017.
 */
public interface SalesTaxApplier {

    /**
     * The Strategy pattern interface to apply a sales tax to a {@link PurchasingItem}
     * @param item
     * @return item with possibly a sales tax
     */
    PurchasingItem apply(PurchasingItem item);

}

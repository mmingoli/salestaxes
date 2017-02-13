package org.interview.exercise.service;

import org.interview.exercise.bean.PurchasingItem;
import org.interview.exercise.bean.Receipt;

import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public interface SalesTaxesService {

    /**
     * Access point to the {@link SalesTaxesService}, it applies several sales taxes
     * specified in the implementation to a list of {@link PurchasingItem} in input
     * @param items
     * @return a {@link Receipt} of the purchasing items
     */
    Receipt getReceipt(List<PurchasingItem> items);

}

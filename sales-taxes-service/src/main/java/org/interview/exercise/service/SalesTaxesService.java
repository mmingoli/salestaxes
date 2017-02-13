package org.interview.exercise.service;

import org.interview.exercise.bean.PurchasingItem;
import org.interview.exercise.bean.Receipt;

import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public interface SalesTaxesService {

    /**
     * it applies several sales taxes to a list of {@link PurchasingItem} in input
     * @param items
     * @return a {@link Receipt} of the purchasing items
     */
    Receipt getReceipt(List<PurchasingItem> items);

}

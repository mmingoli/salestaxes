package org.interview.exercises.service;

import org.interview.exercises.bean.PurchasingItem;
import org.interview.exercises.bean.Receipt;

import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public interface SalesTaxesService {

    Receipt getReceipt(List<PurchasingItem> items);

}

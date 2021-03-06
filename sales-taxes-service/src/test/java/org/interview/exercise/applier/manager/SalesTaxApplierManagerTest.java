package org.interview.exercise.applier.manager;

import org.interview.exercise.applier.SalesTaxApplier;
import org.interview.exercise.applier.manager.SalesTaxApplierManager;
import org.interview.exercise.bean.PurchasingItem;
import org.interview.exercise.bean.PurchasingItemType;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxApplierManagerTest {

    private SalesTaxApplierManager salesTaxApplierManager;
    private PurchasingItem item = new PurchasingItem
            .Builder("test name", PurchasingItemType.BOOKS, BigDecimal.valueOf(10.15))
            .build();

    @Mock
    private SalesTaxApplier applier1;
    @Mock
    private SalesTaxApplier applier2;

    @BeforeMethod
    public void setUp() throws Exception {
        initMocks(this);

        when(applier1.apply(item)).thenReturn(item);
        when(applier2.apply(item)).thenReturn(item);

        salesTaxApplierManager = new SalesTaxApplierManager.Builder()
                .addSalesTaxApplier(applier1)
                .addSalesTaxApplier(applier2)
                .build();
    }

    @Test
    public void testApplySalesTax() throws Exception {
        salesTaxApplierManager.applySalesTax(item);

        verify(applier1, only()).apply(item);
        verify(applier2, only()).apply(item);
    }

}
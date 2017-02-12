package org.interview.exercises.applier.manager;

import org.interview.exercises.applier.SalesTaxApplier;
import org.interview.exercises.bean.PurchasingItem;
import org.interview.exercises.bean.PurchasingItemType;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxApplierManagerTest {

    private SalesTaxApplierManager salesTaxApplierManager;
    private PurchasingItem item = new PurchasingItem.Builder("fight club", PurchasingItemType.BOOKS, 10.15).build();

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
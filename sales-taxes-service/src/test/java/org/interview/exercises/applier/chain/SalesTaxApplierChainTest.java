package org.interview.exercises.applier.chain;

import org.interview.exercises.applier.SalesTaxApplier;
import org.interview.exercises.bean.PurchasingItem;
import org.interview.exercises.bean.PurchasingItemType;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by mmingoli on 2/12/2017.
 */
public class SalesTaxApplierChainTest {

    private SalesTaxApplierChain salesTaxApplierChain = new SalesTaxApplierChain();
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

        salesTaxApplierChain.addSalesTaxApplier(applier1);
        salesTaxApplierChain.addSalesTaxApplier(applier2);
    }

    @Test
    public void testApply() throws Exception {
        salesTaxApplierChain.apply(item);

        verify(applier1, only()).apply(item);
        verify(applier2, only()).apply(item);
    }
}
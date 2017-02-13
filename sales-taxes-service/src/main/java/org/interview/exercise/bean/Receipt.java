package org.interview.exercise.bean;

import org.interview.exercise.service.SalesTaxesService;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class Receipt {

    private List<PurchasingItem> items = new LinkedList<PurchasingItem>();

    /**
     * to add a purchasing item to the receipt that will be
     * returned by {@link SalesTaxesService}
     * @param item
     */
    public void addItem(PurchasingItem item) {
        items.add(item);
    }

    /**
     * 
     * @return the size of the list of {@link PurchasingItem} belonging to the receipt
     */
    public int size() {
        return items.size();
    }

    /**
     * 
     * @param item
     * @return true if the item is contained in the receipt, otherwise false
     */
    public boolean contains (PurchasingItem item) {
        return items.contains(item);
    }

    public Iterator<PurchasingItem> itemsIterator() {
        return (Iterator<PurchasingItem>) items.iterator();
    }

    /**
     *
     * @return total sales taxes for the list of {@link PurchasingItem}
     */
    public BigDecimal getTotalSalesTaxes() {
        BigDecimal totalSalesTaxes = BigDecimal.ZERO;
        for (PurchasingItem item :
                items) {
            totalSalesTaxes = (item != null)?totalSalesTaxes.add(item.getTotalSalesTax()):totalSalesTaxes;
        }

        return totalSalesTaxes;
    }

    /**
     *
     * @return total price (comprehensive of sales taxes) for the list of {@link PurchasingItem}
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        totalPrice.setScale(2);
        for (PurchasingItem item :
                items) {
            totalPrice = (item != null)?totalPrice.add(item.getTotalPrice()):totalPrice;
        }
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (items.size() != receipt.size()
                || getTotalSalesTaxes() != receipt.getTotalSalesTaxes()
                || getTotalPrice() != receipt.getTotalPrice()) {
            return false;
        }

        for (PurchasingItem item:
             items) {
            if (!receipt.contains(item)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "items=" + items +
                ", totalSalesTaxes=" + getTotalSalesTaxes() +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}

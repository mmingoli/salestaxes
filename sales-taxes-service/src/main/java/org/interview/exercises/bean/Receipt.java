package org.interview.exercises.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class Receipt {

    private List<PurchasingItem> items = new LinkedList<PurchasingItem>();

    public void addItem(PurchasingItem item) {
        items.add(item);
    }

    public List<PurchasingItem> getItems() {
        return items;
    }

    public double getTotalSalesTaxes() {
        double totalSalesTaxes = 0;
        for (PurchasingItem item :
                items) {
            totalSalesTaxes += (item != null)?item.getTotalSalesTax():0;
        }
        return totalSalesTaxes;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (PurchasingItem item :
                items) {
            totalPrice += (item != null)?item.getTotalPrice():0;
        }
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        return items.equals(receipt.items);
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

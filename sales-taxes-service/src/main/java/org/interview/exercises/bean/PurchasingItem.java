package org.interview.exercises.bean;

import java.math.BigDecimal;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class PurchasingItem {

    private int quantity;
    private String name;
    private PurchasingItemType type;
    private BigDecimal unitPrice;
    private BigDecimal salesTax;
    private boolean imported;

    private PurchasingItem(Builder builder) {
        this.quantity = builder.getQuantity();
        this.name = builder.getName();
        this.type = builder.getType();
        this.unitPrice = builder.getUnitPrice();
        this.salesTax = builder.getSalesTax();
        this.imported = builder.isImported();
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public PurchasingItemType getType() {
        return type;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public boolean isImported() {
        return imported;
    }

    public BigDecimal getTotalSalesTax() {
        return salesTax.multiply(new BigDecimal(quantity));
    }

    public BigDecimal getTotalPrice() {
        return (unitPrice.add(salesTax)).multiply(new BigDecimal(quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchasingItem item = (PurchasingItem) o;

        if (quantity != item.quantity) return false;
        if (imported != item.imported) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (type != item.type) return false;
        if (unitPrice != null ? !unitPrice.equals(item.unitPrice) : item.unitPrice != null) return false;
        return salesTax != null ? salesTax.equals(item.salesTax) : item.salesTax == null;
    }

    @Override
    public int hashCode() {
        int result = quantity;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (salesTax != null ? salesTax.hashCode() : 0);
        result = 31 * result + (imported ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PurchasingItem{" +
                "quantity=" + quantity +
                ", imported=" + imported +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", unitPrice=" + unitPrice +
                ", salesTax=" + salesTax +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }

    public static class Builder {

        private int quantity;
        private String name;
        private PurchasingItemType type;
        private BigDecimal unitPrice;
        private BigDecimal salesTax;
        private boolean imported;

        public Builder(String name, PurchasingItemType type, BigDecimal unitPrice) {
            this(1, name, type, unitPrice);
        }

        public Builder(int quantity, String name, PurchasingItemType type, BigDecimal unitPrice) {
            this.quantity = quantity;
            this.name = name;
            this.type = type;
            this.unitPrice = unitPrice;
            this.salesTax = BigDecimal.ZERO;
            this.imported = false;
        }

        public int getQuantity() {
            return quantity;
        }

        public String getName() {
            return name;
        }

        public PurchasingItemType getType() {
            return type;
        }

        public BigDecimal getUnitPrice() {
            return unitPrice;
        }

        public BigDecimal getSalesTax() {
            return salesTax;
        }

        public boolean isImported() {
            return imported;
        }

        public Builder salesTax(BigDecimal salesTax) {
            this.salesTax = salesTax;
            return this;
        }

        public Builder imported (boolean imported) {
            this.imported = imported;
            return this;
        }

        public PurchasingItem build() {
            return new PurchasingItem(this);
        }
    }
}

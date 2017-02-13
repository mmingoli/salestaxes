package org.interview.exercises.bean;

/**
 * Created by mmingoli on 2/11/2017.
 */
public class PurchasingItem {

    private int quantity;
    private String name;
    private PurchasingItemType type;
    private double unitPrice;
    private double salesTax;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public boolean isImported() {
        return imported;
    }

    public double getTotalSalesTax() {
        return salesTax * quantity;
    }

    public double getTotalPrice() {
        return (unitPrice + salesTax) * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchasingItem item = (PurchasingItem) o;

        if (quantity != item.quantity) return false;
        if (Double.compare(item.unitPrice, unitPrice) != 0) return false;
        if (Double.compare(item.salesTax, salesTax) != 0) return false;
        if (imported != item.imported) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        return type == item.type;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = quantity;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + type.hashCode();
        temp = Double.doubleToLongBits(unitPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(salesTax);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
        private double unitPrice;
        private double salesTax;
        private boolean imported;

        public Builder(String name, PurchasingItemType type, double unitPrice) {
            this(1, name, type, unitPrice);
        }

        public Builder(int quantity, String name, PurchasingItemType type, double unitPrice) {
            this.quantity = quantity;
            this.name = name;
            this.type = type;
            this.unitPrice = unitPrice;
            this.salesTax = 0.0;
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

        public double getUnitPrice() {
            return unitPrice;
        }

        public double getSalesTax() {
            return salesTax;
        }

        public boolean isImported() {
            return imported;
        }

        public Builder salesTax(double salesTax) {
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

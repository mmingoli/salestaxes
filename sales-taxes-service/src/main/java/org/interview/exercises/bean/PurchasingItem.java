package org.interview.exercises.bean;

import java.math.BigDecimal;

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

    public double getTotalPrice() {
        return unitPrice + salesTax;
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

package com.paypal.transactions;

import com.paypal.vault.customers.Customer;

public class Transaction {
    protected double amount;
    protected double taxAmount;
    protected int purchaseOrderNumber;
    protected int orderId;
    protected Customer customer;
    protected CreditCard creditCard;

    public Transaction(double amount, double taxAmount, int purchaseOrderNumber, int orderId,
                       Customer customer, CreditCard creditCard) {
        this.amount = amount;
        this.taxAmount = taxAmount;
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.orderId = orderId;
        this.customer = customer;
        this.creditCard = creditCard;
    }

    public Transaction(double amount, CreditCard creditCard) {
        this.amount = amount;
        this.creditCard = creditCard;
    }

    public double getAmount() {
        return amount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public int getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}

package com.paypal.transactions;

public class CreditCard {
    protected String cardholderName;
    protected String cardNumber;
    protected String expirationDate;
    protected int cvv;

    public CreditCard(String cardholderName, String cardNumber, String expirationDate, int cvv) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getCvv() {
        return cvv;
    }
}
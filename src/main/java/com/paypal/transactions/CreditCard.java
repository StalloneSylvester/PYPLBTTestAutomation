package com.paypal.transactions;

public class CreditCard {
    protected String cardholderName;
    protected int cardNumber;
    protected String expirationDate;
    protected int cvv;

    public CreditCard(String cardholderName, int cardNumber, String expirationDate, int cvv) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getCvv() {
        return cvv;
    }
}
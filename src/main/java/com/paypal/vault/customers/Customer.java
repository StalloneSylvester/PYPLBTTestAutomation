package com.paypal.vault.customers;

public class Customer {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String company;
    protected int phoneNumber;
    protected String website;
    protected int faxNumber;

    public Customer(String firstName, String lastName, String email,
                    String company, int phoneNumber, String website, int faxNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.faxNumber = faxNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public int getFaxNumber() {
        return faxNumber;
    }
}

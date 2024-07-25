package com.paypal.vault.customers;

import com.paypal.base.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomerPage extends WebPage {
    protected WebDriver driver;
    @FindBy(id = "toggleable_payment_method_present_false")
    protected WebElement woPaymentMethodRadiobutton;
    @FindBy(id = "customer_submit")
    protected WebElement createCustomerButton;
    @FindBy(css = "div.alert.success p")
    protected WebElement alertElement;
    @FindBy(css = "div.detail-card_title > h2")
    protected WebElement alertDetail;
    protected String alertMessage;


    public CreateNewCustomerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        alertMessage = "";
    }

    public void createNewCustomerWoCustomerDetails() {
        woPaymentMethodRadiobutton.click();
        createCustomerButton.click();
        setAlertMessage();
    }

    public void setAlertMessage() {
        waitForElementToBeVisible(alertElement);
        alertMessage = alertDetail.getText().trim();
    }

    public String getAlertMessage() {
        return alertMessage;
    }
}

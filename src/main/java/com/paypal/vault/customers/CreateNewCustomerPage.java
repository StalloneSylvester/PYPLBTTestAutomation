package com.paypal.vault.customers;

import com.paypal.base.PayPalBTPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Arrays;

public class CreateNewCustomerPage extends PayPalBTPage {
    protected WebDriver driver;
    @FindBy(id = "toggleable_payment_method_present_false")
    protected WebElement woPaymentMethodRadiobutton;
    @FindBy(id = "customer_submit")
    protected WebElement createCustomerButton;
    @FindBy(css = "div.alert.success p")
    protected WebElement alertElement;
    @FindBy(css = "a.button-secondary")
    protected WebElement newCustomerButton;
    protected String alertMessage;


    public CreateNewCustomerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        alertMessage = "";
    }

    public void createNewCustomerWoCustomerDetails() {
        navigateToCreateNewCustomerPage();
        waitForVisibilityOfElements(Arrays.asList(woPaymentMethodRadiobutton, createCustomerButton));
        woPaymentMethodRadiobutton.click();
        createCustomerButton.click();
        setAlertMessage();
    }

    public void setAlertMessage() {
        waitForElementToBeVisible(alertElement);
        alertMessage = alertElement.getText();
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    private void navigateToCreateNewCustomerPage() {
        topNavigationBar.goToModule("Vault");
        pauseBrowser(2);
        waitForElementToBeClickable(newCustomerButton);
        newCustomerButton.click();
        pauseBrowser(2);
    }

}

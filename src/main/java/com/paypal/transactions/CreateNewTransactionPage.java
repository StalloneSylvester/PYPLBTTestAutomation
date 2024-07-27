package com.paypal.transactions;

import com.paypal.base.PayPalBTPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.SecureRandom;
import java.util.Arrays;

public class CreateNewTransactionPage extends PayPalBTPage {
    @FindBy(id = "transaction_amount")
    protected WebElement amountField;
    @FindBy(id = "transaction_credit_card_number")
    protected WebElement creditCardNumberField;
    @FindBy(id = "transaction_credit_card_expiration_date")
    protected WebElement expirationDateField;
    @FindBy(id = "transaction_credit_card_cvv")
    protected WebElement cvvField;
    @FindBy(css = "a.btn.btn_secondary")
    protected WebElement newTransactionButton;
    @FindBy(id = "create_transaction_btn")
    protected WebElement createTransactionButton;
    @FindBy(css = "input#transaction_credit_card_cvv + div.formError")
    protected WebElement invalidCvvError;
    protected String errorMessage;

    public CreateNewTransactionPage(WebDriver driver) {
        super(driver);
    }

    public void createTransaction(Transaction transaction) {
        navigateToNewTransactionPage();
        waitForVisibilityOfElements(Arrays.asList(amountField, creditCardNumberField,
                expirationDateField, cvvField, createTransactionButton));
        amountField.sendKeys(String.valueOf(transaction.getAmount()));
        creditCardNumberField.sendKeys(transaction.getCreditCard().getCardNumber());
        expirationDateField.sendKeys(transaction.getCreditCard().getExpirationDate());
        cvvField.sendKeys(String.valueOf(transaction.getCreditCard().getCvv()));
        createTransactionButton.click();
        pauseBrowser(2);
        waitForElementToBeVisible(invalidCvvError);
        errorMessage = invalidCvvError.getText();
    }

    private void navigateToNewTransactionPage() {
        topNavigationBar.goToModule("Transactions");
        waitForElementToBeClickable(newTransactionButton);
        newTransactionButton.click();
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

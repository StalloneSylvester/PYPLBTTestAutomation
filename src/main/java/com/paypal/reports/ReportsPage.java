package com.paypal.reports;

import com.paypal.base.PayPalBTPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsPage extends PayPalBTPage {
    @FindBy(css = "div.navigation-list:nth-child(2) li:nth-child(3) a")
    protected WebElement exportCustomersRecordLink;
    @FindBy(css = "div.navigation-list:nth-child(2) li:nth-child(5) a")
    protected WebElement exportCustomersRecordWithPaymentMethodsLink;
    @FindBy(css = "div.navigation-list:nth-child(2) li:nth-child(7) a")
    protected WebElement exportCustomersRecordWithAddressesLink;
    @FindBy(css = "div.navigation-list:nth-child(2) li:nth-child(8) a")
    protected WebElement exportCustomersRecordWithUpdatedPaymentMethodsLink;
    @FindBy(name = "commit")
    protected WebElement filterAndDownloadButton;
    @FindBy(css = "div#categorized-downloads > div:nth-child(1) > div:nth-child(2) a")
    protected WebElement downloadButton;

    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    public void exportCustomersRecords() {
        navigateToReportsPage();
        waitForElementToBeClickableAndClick(exportCustomersRecordLink);
        waitForElementToBeClickableAndClick(filterAndDownloadButton);
        waitForElementToBeClickableAndClick(downloadButton);
    }

    public void exportCustomersRecordsWithPaymentMethods() {
        navigateToReportsPage();
        waitForElementToBeClickableAndClick(exportCustomersRecordWithPaymentMethodsLink);
        waitForElementToBeClickableAndClick(filterAndDownloadButton);
        waitForElementToBeClickableAndClick(downloadButton);
    }

    public void exportCustomersRecordsWithAddresses() {
        navigateToReportsPage();
        waitForElementToBeClickableAndClick(exportCustomersRecordWithAddressesLink);
        waitForElementToBeClickableAndClick(filterAndDownloadButton);
        waitForElementToBeClickableAndClick(downloadButton);
    }

    public void exportCustomersRecordsWithUpdatedPaymentMethods() {
        navigateToReportsPage();
        waitForElementToBeClickableAndClick(exportCustomersRecordWithUpdatedPaymentMethodsLink);
        waitForElementToBeClickableAndClick(filterAndDownloadButton);
        waitForElementToBeClickableAndClick(downloadButton);
    }


    private void navigateToReportsPage() {
        topNavigationBar.goToModule("Reports");
    }
}

package com.paypal.reports;

import com.paypal.base.PayPalBTPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.Map;

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

    public void export(ExportOption exportOption) {
        waitForElementToBeClickableAndClick(getExportOptionsMap().get(exportOption));
        waitForElementToBeClickableAndClick(filterAndDownloadButton);
        waitForElementToBeClickableAndClick(downloadButton);
    }

    public Map<ExportOption, WebElement> getExportOptionsMap() {
        Map<ExportOption, WebElement> exportOptionWebElementMap = new HashMap<>();
        exportOptionWebElementMap.put(ExportOption.CUSTOMER_RECORDS, exportCustomersRecordLink);
        exportOptionWebElementMap.put(ExportOption.CUSTOMER_RECORDS_WITH_ADDRESSES,
                exportCustomersRecordWithAddressesLink);
        exportOptionWebElementMap.put(ExportOption.CUSTOMER_RECORDS_WITH_PAYMENT_METHODS,
                exportCustomersRecordWithPaymentMethodsLink);
        exportOptionWebElementMap.put(ExportOption.CUSTOMER_RECORDS_WITH_UPDATED_PAYMENT_METHODS,
                exportCustomersRecordWithUpdatedPaymentMethodsLink);
        return exportOptionWebElementMap;
    }

    public enum ExportOption {
        CUSTOMER_RECORDS, CUSTOMER_RECORDS_WITH_PAYMENT_METHODS,
        CUSTOMER_RECORDS_WITH_ADDRESSES, CUSTOMER_RECORDS_WITH_UPDATED_PAYMENT_METHODS
    }
}

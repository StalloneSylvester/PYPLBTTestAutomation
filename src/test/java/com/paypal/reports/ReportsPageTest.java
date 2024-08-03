package com.paypal.reports;

import com.paypal.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportsPageTest extends BaseTest {
    protected ReportsPage reportsPage;
    protected int numberOfFilesInDownloadsBeforeExport;
    protected int numberOfFilesInDownloadsAfterExport;
    protected int EXPECTED_CHANGE_IN_FILE_COUNT = 1;

    @BeforeClass
    public void initReportsPage() {
        reportsPage = PageFactory.initElements(driver, ReportsPage.class);
    }

    @BeforeMethod
    public void setNumberOfFilesInDownloadsBeforeExport() {
        numberOfFilesInDownloadsBeforeExport = getNumberOfFilesInDownloads();
        navigateToPreviousPage();
    }

    @AfterMethod
    public void navigateToPreviousPage() {
        driver.navigate().back();
    }

    @Test(priority = 0)
    public void exportCustomersRecordsTest() {
        reportsPage.exportCustomersRecords();
        numberOfFilesInDownloadsAfterExport = getNumberOfFilesInDownloads();
        Assert.assertEquals(numberOfFilesInDownloadsAfterExport,
                numberOfFilesInDownloadsBeforeExport + EXPECTED_CHANGE_IN_FILE_COUNT);
    }

    @Test(priority = 1)
    public void exportCustomersRecordsWithPaymentMethodsTest() {
        reportsPage.exportCustomersRecordsWithPaymentMethods();
        numberOfFilesInDownloadsAfterExport = getNumberOfFilesInDownloads();
        Assert.assertEquals(numberOfFilesInDownloadsAfterExport,
                numberOfFilesInDownloadsBeforeExport + EXPECTED_CHANGE_IN_FILE_COUNT);
    }

    @Test(priority = 2)
    public void exportCustomersRecordsWithAddressesTest() {
        reportsPage.exportCustomersRecordsWithAddresses();
        numberOfFilesInDownloadsAfterExport = getNumberOfFilesInDownloads();
        Assert.assertEquals(numberOfFilesInDownloadsAfterExport,
                numberOfFilesInDownloadsBeforeExport + EXPECTED_CHANGE_IN_FILE_COUNT);
    }

    @Test(priority = 3)
    public void exportCustomersRecordsWithUpdatedPaymentMethodsTest() {
        reportsPage.exportCustomersRecordsWithUpdatedPaymentMethods();
        numberOfFilesInDownloadsAfterExport = getNumberOfFilesInDownloads();
        Assert.assertEquals(numberOfFilesInDownloadsAfterExport,
                numberOfFilesInDownloadsBeforeExport + EXPECTED_CHANGE_IN_FILE_COUNT);
    }
}

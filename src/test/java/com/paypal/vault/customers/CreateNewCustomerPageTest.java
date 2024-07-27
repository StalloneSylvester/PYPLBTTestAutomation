package com.paypal.vault.customers;

import com.paypal.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewCustomerPageTest extends BaseTest {
    protected CreateNewCustomerPage createNewCustomerPage;

    @BeforeClass
    public void initCreateNewCustomerPage() {
        createNewCustomerPage = PageFactory.initElements(driver, CreateNewCustomerPage.class);
    }

    @Test
    public void createNewCustomerWoDetailsTest() {
        createNewCustomerPage.createNewCustomerWoCustomerDetails();
        Assert.assertEquals(createNewCustomerPage.getAlertMessage(), "");
    }
}

package com.paypal.transactions;

import com.paypal.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewTransactionPageTest extends BaseTest {
    protected CreateNewTransactionPage createNewTransactionPage;

    @BeforeClass
    public void initNewTransactionPage() {
        createNewTransactionPage = PageFactory.initElements(driver, CreateNewTransactionPage.class);
    }

    @Test
    public void createTransactionNotAllowedWInvalidCvvTest() {
        createNewTransactionPage.createTransaction(getTransaction());
        Assert.assertEquals(createNewTransactionPage.getErrorMessage(),
                "CVV must be 4 digits for American Express and 3 digits for other card types.");
    }
}

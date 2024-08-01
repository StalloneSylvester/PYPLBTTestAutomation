package com.paypal.settings.team;

import com.paypal.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewUserPageTest extends BaseTest {
    protected CreateNewUserPage createNewUserPage;

    @BeforeClass
    public void initCreateNewUserPage() {
        createNewUserPage = PageFactory.initElements(driver, CreateNewUserPage.class);
    }

    @Test(priority = 0)
    public void createNewUserWithRequiredFieldsTest() {
        createNewUserPage.createNewUser(getRandomEmail());
        Assert.assertEquals(createNewUserPage.getAlertMessage(), "User was successfully created. " +
                "An activation email was sent to their email address.");
    }
}

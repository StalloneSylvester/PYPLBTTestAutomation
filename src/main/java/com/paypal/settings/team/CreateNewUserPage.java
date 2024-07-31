package com.paypal.settings.team;

import com.paypal.base.PayPalBTPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Arrays;

public class CreateNewUserPage extends PayPalBTPage {
    @FindBy(id = "user_email")
    protected WebElement emailField;
    @FindBy(name = "user_role_ids_1")
    protected WebElement crmRoleCheckbox;
    @FindBy(name = "commit")
    protected WebElement createUserButton;

    public CreateNewUserPage(WebDriver driver) {
        super(driver);
    }

    public void createNewUser(String email) {
        navigateToCreateNewUserPage();
        waitForVisibilityOfElements(Arrays.asList(emailField, crmRoleCheckbox, createUserButton));
        emailField.sendKeys(email);
        crmRoleCheckbox.click();
        createUserButton.click();
    }

    private void navigateToCreateNewUserPage() {

    }
}

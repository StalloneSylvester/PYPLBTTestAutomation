package com.paypal.settings.team;

import com.paypal.base.PayPalBTPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewUserPage extends PayPalBTPage {
    @FindBy(id = "user_email")
    protected WebElement emailField;
    @FindBy(css = "label[for='user_role_ids_1']")
    protected WebElement crmRoleCheckbox;
    @FindBy(name = "commit")
    protected WebElement createUserButton;
    @FindBy(css = "a.btn.btn_primary")
    protected WebElement newUserButton;
    @FindBy(css = "div.alert.success p")
    protected WebElement alertElement;
    protected String alertMessage;

    public CreateNewUserPage(WebDriver driver) {
        super(driver);
        alertMessage = "";
    }

    public void createNewUser(String email) {
        navigateToCreateNewUserPage();
        //waitForVisibilityOfElements(Arrays.asList(emailField, crmRoleCheckbox, createUserButton));
        waitForElementToBeVisible(emailField);
        emailField.sendKeys(email);
        pauseBrowser(5);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", emailField);
        pauseBrowser(5);
        javascriptExecutor.executeScript("arguments[0].click()", crmRoleCheckbox);
        waitForElementToBeVisible(createUserButton);
        createUserButton.click();
        waitForElementToBeVisible(alertElement);
        alertMessage = alertElement.getText();
    }

    private void navigateToCreateNewUserPage() {
        settingsDropdown.selectOption("Team");
        waitForElementToBeClickable(newUserButton);
        newUserButton.click();
    }

    public String getAlertMessage() {
        return alertMessage;
    }
}

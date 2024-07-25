package com.paypal.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Arrays;

public class LoginPage extends WebPage {
    @FindBy(id = "login")
    protected WebElement usernameField;
    @FindBy(id = "password")
    protected WebElement passwordField;
    @FindBy(name = "commit")
    protected WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void doLogin(String username, String password) {
        waitForVisibilityOfElements(Arrays.asList(usernameField, passwordField, loginButton));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}

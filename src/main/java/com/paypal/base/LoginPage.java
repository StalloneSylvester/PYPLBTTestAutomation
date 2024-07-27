package com.paypal.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Arrays;

public class LoginPage extends PayPalBTPage {
    @FindBy(id = "login")
    protected WebElement usernameField;
    @FindBy(id = "password")
    protected WebElement passwordField;
    @FindBy(name = "commit")
    protected WebElement loginButton;
    @FindBy(id = "acceptAllButton")
    protected WebElement acceptCookiesButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void doLogin(String username, String password) {
        pauseBrowser(5);
        waitForVisibilityOfElements(Arrays.asList(acceptCookiesButton, usernameField, passwordField, loginButton));
        pauseBrowser(5);
        acceptCookiesButton.click();
        pauseBrowser(5);
        usernameField.sendKeys(username);
        pauseBrowser(5);
        passwordField.sendKeys(password);
        pauseBrowser(5);
        loginButton.click();
    }
}

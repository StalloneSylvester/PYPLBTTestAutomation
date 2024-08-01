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
        //Putting pause while logging in to avoid captcha human verification
        pauseBrowser(TWO_SECONDS);
        waitForVisibilityOfElements(Arrays.asList(acceptCookiesButton, usernameField, passwordField, loginButton));
        pauseBrowser(TWO_SECONDS);
        acceptCookiesButton.click();
        pauseBrowser(TWO_SECONDS);
        usernameField.sendKeys(username);
        pauseBrowser(TWO_SECONDS);
        passwordField.sendKeys(password);
        pauseBrowser(TWO_SECONDS);
        loginButton.click();
    }
}

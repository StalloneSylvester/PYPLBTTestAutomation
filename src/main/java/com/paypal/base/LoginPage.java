package com.paypal.base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v127.page.model.Frame;
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
    @FindBy(className = "g-recaptcha")
    protected WebElement captcha;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void doLogin(String username, String password) {
        //Introducing a delay during login attempt to reduce the likelihood of
        //triggering CAPTCHA verification
        pauseBrowser(THREE_SECONDS);
        waitForVisibilityOfElements(Arrays.asList(acceptCookiesButton, usernameField, passwordField, loginButton));
        pauseBrowser(THREE_SECONDS);
        acceptCookiesButton.click();
        pauseBrowser(THREE_SECONDS);
        usernameField.sendKeys(username);
        pauseBrowser(THREE_SECONDS);
        passwordField.sendKeys(password);
        try {
            if (captcha.isDisplayed()) {
                //Delaying the execution to solve the CAPTCHA manually
                pauseBrowser(THIRTY_SECONDS);
            }
        } catch (NoSuchElementException e) {
            System.out.println("CAPTCHA not present");
        }
        loginButton.click();
    }
}

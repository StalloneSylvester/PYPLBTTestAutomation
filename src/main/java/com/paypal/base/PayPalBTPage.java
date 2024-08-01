package com.paypal.base;

import com.paypal.base.components.SettingsDropdown;
import com.paypal.base.components.TopNavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PayPalBTPage extends WebPage {
    protected TopNavigationBar topNavigationBar;
    protected SettingsDropdown settingsDropdown;

    public PayPalBTPage(WebDriver driver) {
        super(driver);
        topNavigationBar = PageFactory.initElements(driver, TopNavigationBar.class);
        settingsDropdown = PageFactory.initElements(driver, SettingsDropdown.class);
    }
}


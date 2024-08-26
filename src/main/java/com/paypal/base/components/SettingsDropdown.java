package com.paypal.base.components;

import com.paypal.base.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SettingsDropdown extends WebPage {
    @FindBy(css = "div[data-js = 'gear-container']")
    protected WebElement settingsDD;
    @FindBy(css = "div[data-js = 'gear-content'] a")
    protected List<WebElement> dropdownOptions;

    public SettingsDropdown(WebDriver driver) {
        super(driver);
    }

    public void selectOption(String ddOption) {
        waitForElementToBeClickableAndClick(settingsDD);
        waitForVisibilityOfElements(dropdownOptions);
        for (WebElement element : dropdownOptions) {
            if (element.getText().equalsIgnoreCase(ddOption)) {
                waitForElementToBeClickableAndClick(element);
                break;
            }
        }
    }
}

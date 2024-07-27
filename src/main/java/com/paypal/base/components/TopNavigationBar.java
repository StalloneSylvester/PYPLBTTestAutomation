package com.paypal.base.components;

import com.paypal.base.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopNavigationBar extends WebPage {
    @FindBy(css = "div.unified-panel-header__navigation a")
    protected List<WebElement> modules;

    public TopNavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToModule(String module) {
        waitForVisibilityOfElements(modules);
        for (WebElement moduleLink : modules) {
            if (moduleLink.getText().equalsIgnoreCase(module)) {
                moduleLink.click();
                break;
            }
        }
    }
}

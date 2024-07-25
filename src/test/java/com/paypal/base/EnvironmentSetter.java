package com.paypal.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class EnvironmentSetter {
    protected AbstractDriverOptions browserOptions;
    protected WebDriver driver;
    protected String SAUCE_LABS_URL = "https://ondemand.us-west-1.saucelabs.com:443/wd/hub";
    protected String LAMBDA_TEST_USERNAME = System.getenv("LAMBDA_TEST_USERNAME");
    protected String LAMBDA_TEST_ACCESS_KEY = System.getenv("LAMBDA_TEST_ACCESS_KEY");
    protected String BROWSERSTACK_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    protected String BROWSERSTACK_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    protected String BROWSERSTACK_URL = "http://" + BROWSERSTACK_USERNAME + ":" +
            BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub/";
    protected String LAMBDA_TEST_URL = "https://" + LAMBDA_TEST_USERNAME + ":" +
            LAMBDA_TEST_ACCESS_KEY + "@hub.lambdatest.com/wd/hub";
    protected URL url = null;

    protected void setEnvironment(String platform, String OS, String browser, String browserVersion) {
        setBrowserOptions(browser, OS, browserVersion);
        setPlatform(platform);
    }

    private void setPlatform(String platform) {
        if (platform == null) {
            platform = "sauceLabs";
        }
        if (platform.equalsIgnoreCase("sauceLabs")) {
            browserOptions.setCapability("sauce:options", getSauceOptions());
            setUrl(SAUCE_LABS_URL);
        } else if (platform.equalsIgnoreCase("lambdaTest")) {
            browserOptions.setCapability("LT:Options", getLambdaTestOptions());
            setUrl(LAMBDA_TEST_URL);
        } else if (platform.equalsIgnoreCase("browserstack")) {
            browserOptions.setCapability("bstack:options", getBrowserStackOptions());
            setUrl(BROWSERSTACK_URL);
        }
        driver = new RemoteWebDriver(url, getBrowserOptions());
    }

    protected void setDriverForLocal(String browser) {
        if (browser == null) {
            driver = new ChromeDriver();
            return;
        }
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }
    }

    private void setUrl(String urlString) {
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
        }
    }

    private Map<String, Object> getSauceOptions() {
        Map<String, Object> sauceOptions = new HashMap<>();
        String username = System.getenv("SAUCE_LABS_USERNAME");
        String accessKey = System.getenv("SAUCE_LABS_ACCESS_KEY");
        sauceOptions.put("username", username);
        sauceOptions.put("accessKey", accessKey);
        sauceOptions.put("build", "selenium-build-HBQ4H");
        sauceOptions.put("name", "Regression");
        sauceOptions.put("screenResolution", "1920x1080");
        return sauceOptions;
    }

    private Map<String, Object> getLambdaTestOptions() {
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", LAMBDA_TEST_USERNAME);
        ltOptions.put("accessKey", LAMBDA_TEST_ACCESS_KEY);
        ltOptions.put("project", "OrangeHRMTestAutomation");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("screenResolution", "1920x1080");
        return ltOptions;
    }

    private Map<String, Object> getBrowserStackOptions() {
        Map<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("platformName", "Windows");
        browserstackOptions.put("osVersion", "11");
        return browserstackOptions;
    }

    private void setBrowserOptions(String browser, String OS, String browserVersion) {
        if (!(browser != null && OS != null && browserVersion != null)) {
            browser = "chrome";
            OS = "Windows 11";
            browserVersion = "latest";
        }
        if (browser.equalsIgnoreCase("safari")) {
            browserOptions = new SafariOptions();
        } else if (browser.equalsIgnoreCase("firefox")) {
            browserOptions = new FirefoxOptions();
        } else if (browser.equalsIgnoreCase("edge")) {
            browserOptions = new EdgeOptions();
        } else {
            browserOptions = new ChromeOptions();
        }
        browserOptions.setPlatformName(OS);
        browserOptions.setBrowserVersion(browserVersion);
    }

    public AbstractDriverOptions getBrowserOptions() {
        return browserOptions;
    }


}

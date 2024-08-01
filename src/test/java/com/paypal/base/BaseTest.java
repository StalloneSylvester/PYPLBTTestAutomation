package com.paypal.base;

import com.github.javafaker.Faker;
import com.paypal.testutils.PropertiesReader;
import com.paypal.testutils.WebDriverProvider;
import com.paypal.transactions.CreditCard;
import com.paypal.transactions.Transaction;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends EnvironmentSetter {
    protected final String PAYPAL_BRAINTREE_URL = "https://sandbox.braintreegateway.com";
    protected String username;
    protected String password;
    protected PropertiesReader propertiesReader;
    protected static Faker faker;
    protected TakesScreenshot takesScreenshot;
    protected String platform;
    protected String OS;
    protected String browser;
    protected String browserVersion;
    protected LoginPage loginPage;


    @BeforeClass
    public void setUp() {
        platform = System.getProperty("platform");
        OS = System.getProperty("OS");
        browser = System.getProperty("browser");
        browserVersion = System.getProperty("browserVersion");
        if (platform == null) {
            platform = "local";
        }
        if (!platform.equalsIgnoreCase("local")) {
            setEnvironment(platform, OS, browser, browserVersion);
        } else {
            setDriverForLocal(browser);
        }
        takesScreenshot = (TakesScreenshot) driver;
        driver.manage().window().maximize();
        driver.get(PAYPAL_BRAINTREE_URL);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        pauseBrowser(4);
        propertiesReader = new PropertiesReader();
        username = propertiesReader.getProperty("username");
        password = propertiesReader.getProperty("password");
        loginPage.doLogin(username, password);
        new WebDriverProvider().set(driver);
        faker = new Faker();
    }

    @AfterClass
    public void
    tearDown() {
        driver.quit();
    }

    public void pauseBrowser(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Transaction getTransaction() {
        CreditCard card = new CreditCard("John", "376680816376961",
                "07/2025", 12345);
        return new Transaction(5000, card);
    }

    public String getRandomEmail() {
        return faker.name().firstName() + "@gmail.com";
    }
}

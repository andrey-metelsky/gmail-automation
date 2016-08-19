package com.gmail.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
/*import org.slf4j.LoggerFactory;*/

import java.net.MalformedURLException;

import static java.lang.Thread.currentThread;

public class BaseTest {

  /*  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.gmail.automation.BaseTest.class);*/

    private WebDriver driver;


    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = startChrome(appURL);
                break;
            case "firefox":
                driver = startFirefox(appURL);
                break;
            default:
                System.out.println("browser : " + browserType
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = startFirefox(appURL);
        }
    }

    private static WebDriver startChrome(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        String chromedriverPath = currentThread().getContextClassLoader().getResource("chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", chromedriverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver startFirefox(String appURL) {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    @Parameters({ "browserType", "appURL" })
    @BeforeMethod(groups = {"init"}, alwaysRun = true)
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            setDriver(browserType, appURL);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    @AfterMethod(groups = {"init"}, alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
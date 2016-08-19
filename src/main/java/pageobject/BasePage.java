package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.NoSuchElementException;

public class BasePage {

    WebDriverWait webDriverWait;
    WebDriver driver;

//    protected static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public WebDriver getWebDriver() {
        return driver;
    }

    public BasePage() {
        webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void sendKeys(final WebElement webElement, String text) {
        waitForClickable(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public WebElement waitForVisibility(WebElement webElement) {
        /*try {*/
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
      /*  } catch (NoSuchElementException nse) {
            LOGGER.error("", nse);
            return null;
        }*/
        return webElement;
    }

    public void waitForInvisibility(final By locator) {
      /*  try {*/
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
      /*  } catch (NoSuchElementException e) {
            LOGGER.error("", e);
        }*/
    }

    public WebElement waitForClickable(WebElement webElement) {
        waitForVisibility(webElement);
    /*    try {*/
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
     /*   } catch (NoSuchElementException nse) {
            LOGGER.error("Try to wait little more (wait for clickable)", nse);
        }*/
        return webElement;
    }

    public void pressEnter(final WebElement webElement) {
        waitForClickable(webElement);
        webElement.sendKeys(Keys.ENTER);
    }

    public void click(WebElement webElement) {
        safeClick(webElement);
    }

    private void safeClick(WebElement webElement) {
        waitForClickable(webElement);
        pureSafeClick(webElement);
    }

    private void pureSafeClick(WebElement webElement) {
        for (int i = 0; i < 10; i++) {
           /* try {*/
            webElement.click();
            break;
           /* } catch (Exception e) {
                LOGGER.error("Click failed", e);
                pause();
            }*/
        }
    }

    public void uploadFile(WebElement webElement, File file) {
        if (file != null) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) getWebDriver();
                jsExecutor.executeScript("arguments[0].setAttribute('style', 'margin: 0px; padding: 0px; width: 1px; height: 1px; position: absolute; opacity: 1;')", webElement);
            }
            webElement.sendKeys(file.getAbsolutePath());
    }

}



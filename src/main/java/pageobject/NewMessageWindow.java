package pageobject;

import businessobjects.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

import static org.testng.Assert.assertTrue;


public class NewMessageWindow extends BasePage {

    @FindBy(css = ".vO")
    private WebElement inputTo;

    @FindBy(css = ".aoT")
    private WebElement inputSubject;

    @FindBy(css = "[class='Am Al editable LW-avf']")
    private WebElement messageBody;

    @FindBy(css = "[class='a1 aaA aMZ']")
    private WebElement attachFiles;

    @FindBy(css = "[id=':7y']")
    private WebElement buttonSend;

    @FindBy(css = "div[aria-label*='Attachment']")
    private WebElement attachedFile;

    private By uploadProgressBarBy = By.cssSelector("[role='progressbar']");


    public GmailAccount fillInAndSendNewMessage(Message message) throws AWTException, InterruptedException {
        sendKeys(inputTo, message.getRecipient());
        sendKeys(inputSubject, message.getSubject());
        uploadFileViaWindowPrompt(attachFiles, message.getAttachment());
        assertTrue(isElementPresent(waitForVisibility(attachedFile)), "File isn't attached");
        click(buttonSend);
        return new GmailAccount();
    }
}

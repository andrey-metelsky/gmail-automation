package pageobject;

import businessobjects.Message;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.Files.deleteIfExists;
import static org.testng.Assert.assertEquals;
import static utils.utils.readLines;

public class GmailAccount extends BasePage {

    @FindBy(css = ".z0")
    private WebElement buttonCompose;

    @FindBy(css = "#gbqfq")
    private WebElement searcField;

    @FindBy(css = ".vh")
    private WebElement successMessage;

    @FindBy(css = "[class='gb_3a gbii']")
    private WebElement profileIcon;

    @FindBy(css = "[class='gb_Fa gb_Ce gb_Ke gb_rb']")
    private WebElement signOutButton;

    @FindBy(css = "[class='ae4 UI']")
    private WebElement rowMessage;

    @FindBy(css = "img.aYw")
    private WebElement attachedFileImage;

    @FindBy(css = "[class='aSK J-J5-Ji aYr']")
    private WebElement downLoadAttachment;

    public GmailAccount composeNewMessage(Message message) throws AWTException, InterruptedException {
        click(buttonCompose);
        new NewMessageWindow().fillInAndSendNewMessage(message);
        assertEquals(waitForVisibility(successMessage).getText(), "Your message has been sent. View message", "Message has been sent successfully");
        return this;
    }

    public GmailAccount verifyReceivedMessage(Message message) throws Exception {
        searchMessageBySubject(message);
        click(rowMessage);
        downloadFile(message);
        verifyFileContent(message);
        return this;
    }

    private GmailAccount downloadFile(Message message) throws IOException, InterruptedException {
        moveMouseCursorToWebElement(attachedFileImage);
        click(downLoadAttachment);
        pause();
        return this;
    }

    private GmailAccount searchMessageBySubject(Message message) {
        sendKeys(searcField, message.getSubject());
        pressEnter(searcField);
        return this;
    }

    public LoginPage signOut() {
        click(profileIcon);
        click(signOutButton);
        return new LoginPage();
    }

    private GmailAccount verifyFileContent(Message message) throws Exception {
        File file = new File(System.getProperty("user.home") + "/Downloads/" + message.getAttachment().getName());
        assertEquals(readLines(file).toString().replace("[", "").replace("]", ""), "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        return this;
    }
}

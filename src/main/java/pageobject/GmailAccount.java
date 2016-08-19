package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by andriy.metelsky on 8/18/2016.
 */
public class GmailAccount extends BasePage {

    @FindBy(css = ".T-I J-J5-Ji T-I-KE L3")
    private WebElement buttonCompose;


    public NewMessageWindow clickComposeButton() {
        click(buttonCompose);
        return new NewMessageWindow();
    }

}

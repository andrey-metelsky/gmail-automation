package pageobject;

import businessobjects.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#Email")
    private WebElement inputEmail;

    @FindBy(css = "#next")
    private WebElement butttonNext;

    @FindBy(css = "#Passwd")
    private WebElement inputPassword;

    @FindBy(css = "#signIn")
    private WebElement butttonSignIn;

    @FindBy(css = "#account-chooser-link")
    private WebElement linkSignInWithDifferentAccount;

    @FindBy(css = "#account-chooser-add-account")
    private WebElement linkAddAccount;



    public GmailAccount loginAsUser(User user) {
        if (isElementPresent(linkSignInWithDifferentAccount)) {
            click(linkSignInWithDifferentAccount);
            click(linkAddAccount);
        }
        sendKeys(inputEmail, user.getEmail());
        pressEnter(butttonNext);
        sendKeys(inputPassword, user.getPassword());
        pressEnter(butttonSignIn);
        return new GmailAccount();
    }
}

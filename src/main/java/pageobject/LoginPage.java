package pageobject;

import data.User;
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

    public GmailAccount loginAsUser(User user) {
        sendKeys(inputEmail, user.getLoginName());
        pressEnter(butttonNext);
        sendKeys(inputPassword, user.getPassword());
        pressEnter(butttonSignIn);
        return new GmailAccount();
    }


}

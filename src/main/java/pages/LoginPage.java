package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@name='email_address_mob_phone']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@name='login[password]']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='action login primary']")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/customer/account/login/referer/(.*)/";
    }

    public LoginPage checkIsRedirectToLoginPage() {
       checkUrlWithPattern();
        return this;
    }

    public void enterTextIntoInputEmail(String email) {;
        enterTextIntoInput(inputEmail, email);
    }

    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }
}

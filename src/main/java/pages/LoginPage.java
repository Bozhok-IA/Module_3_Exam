package pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@name='email_address_mob_phone']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@name='login[password]']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='action login primary']")
    private WebElement buttonSignIn;

    @FindBy(xpath = ".//div[@class='mage-error']")
    private List<WebElement> listErrorMessage;

    @FindBy(xpath = ".//div[@class='primary create-button']")
    private WebElement buttonNewUser;

    private String listErrorMessagesLocator = ".//div[@class='mage-error']";

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

    public LoginPage checkErrorMassage(String massages) {
        String[] expectedErrors = massages.split(";");
        webDriverWaite05.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath(listErrorMessagesLocator), expectedErrors.length));

        ArrayList<String> actualErrors = new ArrayList<>();
        for (WebElement error : listErrorMessage) {
            actualErrors.add(error.getText());
        }
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < expectedErrors.length; i++) {
            softAssertions.assertThat(expectedErrors[i])
                    .as("Error " + i)
                    .isIn(expectedErrors);
        }
        softAssertions.assertAll();

        return this;
    }

    public CreateNewCustomerPage clickOnButtonNewUser() {
        clickOnElement(buttonNewUser);
        return new CreateNewCustomerPage(webDriver);
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomerPage extends ParentPage {

    @FindBy(xpath = ".//input[@id='fullname']")
    private WebElement inputNameAndFullname;

    @FindBy(xpath = ".//input[@name='email_address_mob_phone']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='action submit primary']")
    private WebElement buttonRegistration;

    public CreateNewCustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/customer/account/create";
    }

    public CreateNewCustomerPage checkIsRedirectToCreateNewCustomerPage() {
        checkUrl();
        return this;
    }

    public CreateNewCustomerPage enterTextIntoInputNameAndFullnameForRedistrationForm(String nameAndFullname) {
        enterTextIntoInput(inputNameAndFullname, nameAndFullname);
        return this;

    }

    public CreateNewCustomerPage enterTextIntoInputEmailForRedistrationForm(String email) {
        enterTextIntoInput(inputEmail, email);
        return this;
    }

    public CreateNewCustomerPage enterTextIntoInputPasswordForRedistrationForm(String password) {
        enterTextIntoInput(inputPassword, password);
        return this;
    }

    public CreateNewCustomerPage clickOnButtonRegistration() {
        clickOnElement(buttonRegistration);
        return this;
    }
}

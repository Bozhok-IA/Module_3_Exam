package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@name='email_address_mob_phone']")
    private WebElement inputEmail;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterTextIntoInputEmail(String email) {
        WebElement inputEmail = webDriver.findElement(By.xpath(".//input[@name='email_address_mob_phone']"));
        enterTextIntoInput(inputEmail, email);
    }

    public void enterTextIntoInputPassword(String password) {
        WebElement inputPassword = webDriver.findElement(By.xpath(".//input[@name='login[password]']"));
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonSignIn() {
        WebElement buttonSignIn = webDriver.findElement(By.xpath(".//button[@class='action login primary']"));
        clickOnElement(buttonSignIn);
    }
}

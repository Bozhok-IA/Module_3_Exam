package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralPage extends ParentPage{

    @FindBy(xpath = ".//header[@class='page-header']//a[@class='desktop-registration-link']")
    private WebElement loginLink;

    public GeneralPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openGeneralPage() {
        try {
            webDriver.get("https://a-shop.ua/");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open Home page");
            Assert.fail("Can not open Home page");
        }
    }

    public GeneralPage checkIsLoginLinkVisible() {
        WebElement loginLink = webDriver.findElement(
                By.xpath(".//header[@class='page-header']//a[@class='desktop-registration-link']"));
        checkIsElementVisible(loginLink);
        logger.info("Login link is visible");
        return this;

    }

    public void clickOnLoginLink() {
        WebElement loginLink = webDriver.findElement(
                By.xpath(".//header[@class='page-header']//a[@class='desktop-registration-link']"));
        clickOnElement(loginLink);
    }



}

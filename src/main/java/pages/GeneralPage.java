package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralPage extends ParentPage{

    @FindBy(xpath = ".//header[@class='page-header']//a[@class='desktop-registration-link']")
    private WebElement loginLink;

    @FindBy(xpath = ".//i[@class='item-icon fas mgz-fa-home ']")
    private WebElement buttonHomePage;

    public GeneralPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openGeneralPage() {
        try {
            webDriver.get("https://a-shop.ua/");
            logger.info("General page was opened");
        } catch (Exception e) {
            logger.error("Can not open General page");
            Assert.fail("Can not open General page");
        }
    }

    public GeneralPage checkIsLoginLinkVisible() {
//        WebElement loginLink = webDriver.findElement(
//                By.xpath(".//header[@class='page-header']//a[@class='desktop-registration-link']"));
        checkIsElementVisible(loginLink);
        logger.info("Login link is visible");
        return this;

    }

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    public HomePage clickOnHomePage() {
        clickOnElement(buttonHomePage);
        return new HomePage(webDriver);
    }

}

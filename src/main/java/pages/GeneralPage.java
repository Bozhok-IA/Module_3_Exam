package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GeneralPage extends ParentPage{

    @FindBy(xpath = ".//header[@class='page-header']//a[@class='desktop-registration-link']")
    private WebElement loginLink;

    @FindBy(xpath = ".//i[@class='item-icon fas mgz-fa-home ']")
    private WebElement buttonHomePage;

    @FindBy(xpath = ".//a[@class='action showcart']")
    private WebElement buttonBasket;
    
    private String productCartLocator = ".//li[@class=\"item product product-item data-position=\"]";

    private String buttonBasketLocator = ".//button[@class=\"action tocart ash-secondary-btn\"]";

    @FindBy(xpath = ".//div[@class='product details product-item-details']")
    private WebElement elementCart;

    @FindBy(xpath = ".//button[@class=\"action tocart ash-secondary-btn added\"]")
    private WebElement buttonChangeName;

    public GeneralPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public void openGeneralPage() {
        try {
            webDriver.get(baseUrl);
            logger.info("General page was opened " + baseUrl);
        } catch (Exception e) {
            logger.error("Can not open General page");
            Assert.fail("Can not open General page");
        }
    }

    public GeneralPage checkIsLoginButtonVisible() {
        checkIsElementVisible(loginLink);
        logger.info("Login link is visible");
        return this;

    }

    public void clickOnLoginButton() {
        clickOnElement(loginLink);
    }

    public HomePage clickOnHomePage() {
        clickOnElement(buttonHomePage);
        return new HomePage(webDriver);
    }

    public BasketPage clickOnButtonBasket() {
        clickOnElement(buttonBasket);
        return new BasketPage(webDriver);
    }

    //hover cursor on the first element and click on the button "Add to basket"
    public GeneralPage hoverCursorOnFirstElementAndClickButtonAddToBasket() {
        List<WebElement> productList = webDriver.findElements(By.xpath(String.format(productCartLocator)));
        List<WebElement> buttonAdd = webDriver.findElements(By.xpath(String.format(buttonBasketLocator)));
        if (!productList.isEmpty()) {
            WebElement firstElement = productList.get(0);
            hoverOverElement(firstElement);
            WebElement buttonAddToBasket = buttonAdd.get(0);
            buttonAddToBasket.click();
            logger.info("Cursor was hovered and click on the first element");
        } else {
            logger.info("Product list is empty");
        }
        return this;
    }

    public GeneralPage checkIsNameButtonChange() {
        checkIsElementVisible(buttonChangeName);
        return this;
    }
}

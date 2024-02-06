package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCartPage extends ParentPage {

    @FindBy(xpath = ".//button[@id='product-addtocart-button']")
    private WebElement buttonInTheBasket;

    @FindBy(xpath = ".//div[@class='product attribute sku']")
    private WebElement productCode;

    @FindBy(xpath = ".//div[@class='swatch-option text']")
    private WebElement selectSize;

    @FindBy(xpath = ".//div[@class='swatch-option image selected']")
    private WebElement selectColour;

    @FindBy(xpath = ".//a[@class='action showcart']")
    private WebElement buttonGoToBasket;

    public ProductCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductCartPage checkIsRedirectToProductCartPage() {
        // TODO checkUrl();
        return this;
    }

    public ProductCartPage clickOnTheButtonAddToBasket() {
        clickOnElement(buttonInTheBasket);
        return this;
    }

    public ProductCartPage checkIsProductCodeVisible() {
        checkIsElementVisible(productCode);
        return this;
    }

    //method that will check if the element exists, if so click on it
    public ProductCartPage checkIsSelectSizePresentAndClickIfHisVisible() {
        if (isElementDisplayed(selectSize)) {
            clickOnElement(selectSize);
        } else {
            logger.info("Size is not present");
        }
        return this;
    }

    public ProductCartPage checkISelectColourPresentAndClickIfHisVisible() {
        if (isElementDisplayed(selectColour)) {
            clickOnElement(selectColour);
        } else {
            logger.info("Colour is not present");
        }
        return this;
    }

    public BasketPage clickOnTheButtonGoToBasket() {
        clickOnElement(buttonGoToBasket);
        return new BasketPage(webDriver);
    }
}

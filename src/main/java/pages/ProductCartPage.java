package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(xpath = ".//button[@class='action primary tocart added']")
    private WebElement buttonNameAdded;

    @FindBy(xpath = ".//button[@class='action search']")
    private WebElement buttonSearch;

    public ProductCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/(\\d+).html";
    }

    public ProductCartPage checkIsRedirectToProductCartPage() {
        checkUrlWithPattern();
        return this;
    }

    public ProductCartPage clickOnTheButtonAddToBasket() {
        clickOnElement(buttonInTheBasket);
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

    public String getProductName() {
        WebElement productName = webDriver.findElement(
                By.xpath(".//span[@data-ui-id='page-title-wrapper']"));
        logger.info("Product name is: " + productName.getText());
        return productName.getText();
    }

    public String getProductCode() {
        WebElement productCode = webDriver.findElement(
                By.xpath(".//div[@class='product attribute sku']//div[@class='value']"));
        logger.info("Product code is: " + productCode.getText());
        return productCode.getText();
    }

    public ProductCartPage checkIsNameButtonChange() {
        checkIsElementVisible(buttonNameAdded);
        return this;

    }

    public void enterProductCodeInSearch() {
        WebElement searchField = webDriver.findElement(By.xpath(".//input[@id='search']"));
        searchField.sendKeys(getProductCode());
    }

    public ResultSearch clickOnSearchButton() {
        WebElement buttonSearch = webDriver.findElement(By.xpath(".//button[@class='action search']"));
        webDriverWaite15.until(ExpectedConditions.elementToBeClickable(buttonSearch));
        buttonSearch.sendKeys(Keys.ENTER);
        return new ResultSearch(webDriver);
    }
}

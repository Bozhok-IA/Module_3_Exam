package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.headerElement.HeaderElement;

import java.util.List;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//picture[@class='product-image-photo']")
    private WebElement buttonProductCart;

    private String productCartLocator = ".//img[@class='product-image-photo']";


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/new.html";
    }

    public HeaderElement getHeader() {
        return new HeaderElement(webDriver);
    }


    public HomePage checkIsRedirectToHomePage() {
        checkUrl();
        return this;
    }

    private List<WebElement> getProductCartList() {
        return webDriver.findElements(By.xpath(String.format(productCartLocator)));
    }

    public ProductCartPage clickFirstProductCartAndGetProductName() {
        WebElement firstProductCart = getProductCartList().get(0);
        String productName = firstProductCart.getText();
        firstProductCart.click();
        logger.info("Product cart was clicked" + productName);
        return new ProductCartPage(webDriver);
    }
    // check and compare the first product name with the product name on the product page
    public boolean compareFirstProductCartNameWithProductPageName() {
        String firstProductName = getProductCartList().get(0).getText();
        String productPageName = new ProductCartPage(webDriver).getProductName();
        logger.info("Product name from the product cart: " + firstProductName);
        return firstProductName.equals(productPageName);
    }
}

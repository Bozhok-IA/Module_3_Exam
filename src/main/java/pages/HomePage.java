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

    public ProductCartPage clickFirstProductCart() {
        getProductCartList().get(0).click();
        logger.info("Product cart was clicked");
        return new ProductCartPage(webDriver);
    }
}

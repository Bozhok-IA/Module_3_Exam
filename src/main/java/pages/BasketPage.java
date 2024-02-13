package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasketPage extends ParentPage {

    @FindBy(xpath = ".//span[text()='Кошик']")
    private WebElement nameBasketPage;

    @FindBy(xpath = ".//h3[@class='title-empty-cart']")
    private WebElement titleEmptyCart;

    @FindBy(xpath = ".//button[@class='start-shopping']")
    private WebElement buttonStartShopping;

    @FindBy(xpath = ".//button[@class=\"action primary checkout\"]")
    private WebElement buttonToOrder;

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/checkout/cart/";
    }

    public BasketPage checkIsRedirectToBasketPage() {
        checkUrl();
        return this;
    }

    public BasketPage checkIsNameBasketPageVisible() {
        checkIsElementVisible(nameBasketPage);
        return this;
    }

    public BasketPage clearBasket() {
        List<WebElement> deleteButtons = webDriver.findElements(By.xpath(".//a[@class='action action-delete']"));
        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
            webDriverWaite05.until(ExpectedConditions.invisibilityOfAllElements(deleteButtons));
            logger.info("Basket was cleared");
        }
        return this;
    }

    public BasketPage checkIsButtonStartShoppingVisible() {
        webDriverWaite15.until(ExpectedConditions.visibilityOfAllElements(buttonStartShopping));
        checkIsElementVisible(buttonStartShopping);
        return this;
    }

    public void checkIsButtonToOrderVisible() {
        checkIsElementVisible(buttonToOrder);
    }

    public BasketPage checkTextInEmptyBasket(String text) {
     checkTextInElement(titleEmptyCart, text.toUpperCase());
        return this;
    }
}

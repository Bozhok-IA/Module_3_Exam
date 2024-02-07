package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends ParentPage{

    @FindBy(xpath = ".//span[text()='Кошик']")
    private WebElement nameBasketPage;

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
}

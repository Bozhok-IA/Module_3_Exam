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

    public BasketPage checkIsNameBasketPageVisible() {
        checkIsElementVisible(nameBasketPage);
        return this;
    }
}

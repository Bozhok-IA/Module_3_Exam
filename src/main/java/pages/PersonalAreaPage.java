package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalAreaPage extends ParentPage{

    @FindBy(xpath = ".//div[text()='Особистий кабінет']")
    private WebElement namePersonalArea;

    @FindBy(xpath = ".//span[text()='Мої замовлення']")
    private WebElement textMyOrders;

    public PersonalAreaPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/sales/order/history";
    }

    public PersonalAreaPage checkIsRedirectToPersonalArea() {
        checkUrl();
        return this;
    }

    public PersonalAreaPage checkIsNamePersonalAreaVisible() {
        checkIsElementVisible(namePersonalArea);
        return this;
    }

    public PersonalAreaPage checkIsTextMyOrdersVisible() {
        checkIsElementVisible(textMyOrders);
        return this;
    }
}

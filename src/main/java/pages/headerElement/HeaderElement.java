package pages.headerElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElement;
import pages.GeneralPage;

public class HeaderElement extends CommonActionsWithElement {
    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = ".//div[@class='page-header page-header-v1']//span[@class='account-name']")
    private WebElement profileName;

    @FindBy(xpath = ".//li[@class='customer-welcome active']//li[@class='authorization-link']")
    private WebElement buttonExit;

    public HeaderElement checkIsProfileNameVisible(String name) {
        checkTextInElement(profileName, name);
        return this;
    }

    public GeneralPage clickOnButtonExit() {
        clickOnElement(buttonExit);
        return new GeneralPage(webDriver);
    }
}

package pages.headerElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonActionsWithElement;
import pages.GeneralPage;

public class HeaderElement extends CommonActionsWithElement {
    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElement checkIsProfileNameVisible(String name) {
        WebElement profileName = webDriver.findElement(
                By.xpath(".//div[@class='page-header page-header-v1']//span[@class='account-name']"));
        checkTextInElement(profileName, name);
        return this;
    }

    public GeneralPage clickOnButtonExit() {
        WebElement buttonExit = webDriver.findElement(By.xpath(".//li[@class='customer-welcome active']//li[@class='authorization-link']"));
        clickOnElement(buttonExit);
        return new GeneralPage(webDriver);
    }
}

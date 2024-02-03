package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalOffice extends ParentPage {

    public PersonalOffice(WebDriver webDriver) {
        super(webDriver);
    }

    public PersonalOffice checkIsProfileNameVisible(String text) {
        WebElement profileName = webDriver.findElement(
                By.xpath(".//header[@class='page-header']//a[@class='desktop-registration-link']"));
        checkTextInElement(profileName, text);
        return this;
    }
}

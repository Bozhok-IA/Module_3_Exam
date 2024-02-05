package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.headerElement.HeaderElement;

public class PersonalOffice extends ParentPage {
    private HeaderElement headerElement;

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

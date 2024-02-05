package pages;

import org.openqa.selenium.WebDriver;
import pages.headerElement.HeaderElement;

public class HomePage extends ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElement getHeader() {
        return new HeaderElement(webDriver);
    }
}

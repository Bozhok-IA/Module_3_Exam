package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    private WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage loginPage() {
        return new LoginPage(webDriver);
    }

    public GeneralPage generalPage() {
        return new GeneralPage(webDriver);
    }

    public PersonalOffice personalOffice() {
        return new PersonalOffice(webDriver);
    }

    public HomePage homePage() {
        return new HomePage(webDriver);
    }
}

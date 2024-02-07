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

    public ProductCartPage productCartPage() {
        return new ProductCartPage(webDriver);
    }

    public HomePage homePage() {
        return new HomePage(webDriver);
    }

    public BasketPage basketPage() {
        return new BasketPage(webDriver);
    }

    public PersonalAreaPage personalArea() {
        return new PersonalAreaPage(webDriver);
    }
}

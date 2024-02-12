package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ResultSearch extends ParentPage {

    @FindBy(xpath = ".//span[@data-ui-id='page-title-wrapper']")
    private WebElement resultSearchMassage;


    private String resultSearchLocator = ".//span[@class='base' and contains(text(),\"Результати пошуку: '%s'\")]";

    @FindBy(xpath = ".//span[@class=\"base\"]")
    private WebElement elementTextSearchCode;

    public ResultSearch(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        logger.info("Get relative URL");
        return "/catalogsearch/result/\\?q=(\\d+)";
    }

    public ResultSearch checkIsRedirectToResultSearchPage() {
        checkUrlWithPattern();
        return this;
    }

    public ResultSearch checkIsMassageResultSearchVisible() {
        checkIsElementVisible(resultSearchMassage);
        return this;
    }

    public void checkAndCompareProductCodeWithResultSearchCode(String productCode) {
        String expectedText = String.format("Результати пошуку: '%s'", productCode).toUpperCase();
        Assert.assertEquals("Product code is not match", expectedText, elementTextSearchCode.getText());
    }
}

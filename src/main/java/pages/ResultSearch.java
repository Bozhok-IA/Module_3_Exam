package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultSearch extends ParentPage {

    @FindBy(xpath = ".//span[@data-ui-id='page-title-wrapper']")
    private WebElement resultSearch;

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
        checkIsElementVisible(resultSearch);
        return this;
    }

    public void checkAndCompareProductCodeWithResultSearchCode() {
        String productCode = new ProductCartPage(webDriver).getProductCode();
        String resultSearchCode = resultSearch.getText();
        logger.info("Product code: " + productCode);
        logger.info("Result search code: " + resultSearchCode);
        assert resultSearchCode.contains(productCode);
    }
}

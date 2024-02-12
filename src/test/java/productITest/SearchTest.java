package productITest;

import baseTest.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

public class SearchTest extends BaseTest {

@Test
    public void searchProductByCodeTest() {
        pageProvider.generalPage().openGeneralPage();
        pageProvider.generalPage().clickOnHomePage();
        pageProvider.homePage().checkIsRedirectToHomePage();
        pageProvider.homePage().clickFirstProductCartAndGetProductName();
        pageProvider.productCartPage().getProductName();
        String productCode = pageProvider.productCartPage().getProductCode();
        pageProvider.productCartPage().enterProductCodeInSearch();
        pageProvider.productCartPage().clickOnSearchButton();
        pageProvider.resultSearch().checkIsRedirectToResultSearchPage();
        pageProvider.resultSearch().checkIsMassageResultSearchVisible();
        pageProvider.resultSearch().checkAndCompareProductCodeWithResultSearchCode(productCode);
    }
}

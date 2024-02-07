package productITest;

import baseTest.BaseTest;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void putProductInTheBasket() {
        pageProvider.generalPage().openGeneralPage();
        pageProvider.generalPage().clickOnHomePage();
        pageProvider.homePage().checkIsRedirectToHomePage();
        pageProvider.homePage().clickFirstProductCart();
        pageProvider.productCartPage().checkIsRedirectToProductCartPage();
        pageProvider.productCartPage().checkIsProductCodeVisible();
        pageProvider.productCartPage().checkIsSelectSizePresentAndClickIfHisVisible();
        pageProvider.productCartPage().checkISelectColourPresentAndClickIfHisVisible();
        pageProvider.productCartPage().clickOnTheButtonAddToBasket();
        pageProvider.productCartPage().clickOnTheButtonGoToBasket();
        pageProvider.basketPage().checkIsRedirectToBasketPage();
        pageProvider.basketPage().checkIsNameBasketPageVisible();
    }
}

package productITest;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void putProductInTheBasket() {
        pageProvider.generalPage().openGeneralPage();
        pageProvider.generalPage().clickOnHomePage();
        pageProvider.homePage().checkIsRedirectToHomePage();
        pageProvider.homePage().clickFirstProductCartAndGetProductName();
        pageProvider.homePage().compareFirstProductCartNameWithProductPageName();
        pageProvider.productCartPage().checkIsRedirectToProductCartPage();
        pageProvider.productCartPage().checkIsSelectSizePresentAndClickIfHisVisible();
        pageProvider.productCartPage().checkISelectColourPresentAndClickIfHisVisible();
        pageProvider.productCartPage().clickOnTheButtonAddToBasket();
        pageProvider.productCartPage().checkIsNameButtonChange();
        pageProvider.productCartPage().clickOnTheButtonGoToBasket();
        pageProvider.basketPage().checkIsRedirectToBasketPage();
        pageProvider.basketPage().checkIsNameBasketPageVisible();
    }

    @After
    public void clearBasket() {
        pageProvider.generalPage().openGeneralPage();
        pageProvider.generalPage().clickOnBasketPage();
        pageProvider.basketPage().clearBasket();
        pageProvider.basketPage().checkIsButtonStartShoppingVisible();
    }
}

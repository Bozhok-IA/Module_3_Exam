package productITest;

import baseTest.BaseTest;
import org.junit.Test;

public class DeleteProductTest extends BaseTest {
    String TEXT_IN_EMPTY_BASKET = "У кошику немає жодного товару";

    @Test
    public void deleteProductFromBasket() {
        pageProvider.generalPage().openGeneralPage();
        pageProvider.generalPage().hoverCursorOnFirstElementAndClickButtonAddToBasket();
        pageProvider.generalPage().checkIsNameButtonChange();
        pageProvider.generalPage().clickOnButtonBasket();
        pageProvider.basketPage().checkIsRedirectToBasketPage();
        pageProvider.basketPage().checkIsNameBasketPageVisible();
        pageProvider.basketPage().checkIsButtonToOrderVisible();
        pageProvider.basketPage().clearBasket();
        pageProvider.basketPage().checkIsButtonStartShoppingVisible();
        pageProvider.basketPage().checkTextInEmptyBasket("У кошику немає жодного товару");
    }
}

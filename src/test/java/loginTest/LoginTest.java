package loginTest;

import baseTest.BaseTest;
import data.TestData;
import org.junit.After;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @After
public void spreadOut() {
        pageProvider.homePage().getHeader().clickOnButtonExit();
    }
    @Test
    public void validLoginTest() {
        pageProvider.generalPage().openGeneralPage();
        pageProvider.generalPage().checkIsLoginLinkVisible();
        pageProvider.generalPage().clickOnLoginLink();
        pageProvider.loginPage().enterTextIntoInputEmail(TestData.VALID_EMAIL);
        pageProvider.loginPage().enterTextIntoInputPassword(TestData.VALID_PASSWORD);
        pageProvider.loginPage().clickOnButtonSignIn();
       // pageProvider.homePage().getHeader().checkIsProfileNameVisible(TestData.PROFILE_NAME);


    }

}

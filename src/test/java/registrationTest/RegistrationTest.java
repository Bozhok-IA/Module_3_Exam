package registrationTest;

import baseTest.BaseTest;
import org.junit.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void validationMassagesTest() {
        pageProvider.generalPage().openGeneralPage();
        pageProvider.generalPage().checkIsLoginButtonVisible();
        pageProvider.generalPage().clickOnLoginButton();
        pageProvider.loginPage().checkIsRedirectToLoginPage();
        pageProvider.loginPage().clickOnButtonNewUser();
        pageProvider.createNewCustomerPage().checkIsRedirectToCreateNewCustomerPage();
        pageProvider.createNewCustomerPage().enterTextIntoInputNameAndFullnameForRedistrationForm("tr");
        pageProvider.createNewCustomerPage().enterTextIntoInputEmailForRedistrationForm("tr");
        pageProvider.createNewCustomerPage().enterTextIntoInputPasswordForRedistrationForm("tr");
        pageProvider.createNewCustomerPage().clickOnButtonRegistration();
        pageProvider.loginPage().checkErrorMassage(
                "Будь ласка введіть дійсне ім’я (Напр: Elton  John);Будь ласка введіть дійсну ел.адресу (Напр: johndoe@domain.com) або номер мобільного (В форматі: 38XXXXXXXXXX);Мінімальна довжина цього поля має бути рівною або більшою, ніж 3 символи. Початкові та кінцеві пробіли буде проігноровано.");


    }
}

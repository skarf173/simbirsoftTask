package tests;

import core.BaseTest;
import helpers.TestValues;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChekoutPage;
import pages.LoginPage;

public class SaucedemoTest extends BaseTest {

    // Тестирование удачной покупки
    @Test
    public void SuccessfulBuyTest() {
        ChekoutPage chekoutPage = new LoginPage()
                .auth_user(TestValues.TEST_LOGIN, TestValues.TEST_PASSWORD)
                .add_product()
                .chekout()
                .fill_fields(TestValues.TEST_FIRST_NAME, TestValues.TEST_SECOND_NAME, TestValues.TEST_POSTAL_CODE)
                .finish_click();
        Assert.assertEquals(chekoutPage.get_success_message(), TestValues.TEST_SUCCESS_MESSAGE);
        Assert.assertEquals(chekoutPage.get_url(), TestValues.TEST_URL);
    }

    // Тестирование вывода сообщения при неудачной авторизации
    @Test
    public void CheckingErrorMessageTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.auth_user(TestValues.TEST_LOGIN_TEST, TestValues.TEST_PASSWORD_TEST);
        Assert.assertEquals(loginPage.get_error_message(), TestValues.TEST_ERROR_MESSAGE);
    }

}
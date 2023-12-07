package practicum;

import org.junit.jupiter.api.*;
import practicum.pageobject.*;

import java.util.Random;

import static practicum.util.Logins.checkUserLogin;
import static practicum.util.Pages.*;

public class LoginTest extends TestBase
{
    @Test
    @DisplayName("Login from enter in account button")
    public void loginFromEnterInAccountButton()
    {
        String email = "test_login_email_" + new Random().nextInt(10000) + "@yandex.ru";
        String password = "test_password";
        String name = "test_name";

        userClient.registerUser(email, password, name);

        openMainPage(webDriver);

        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnEnterInAccountButton();

        checkUserLogin(webDriver, email, password);
        mainPage.checkMainPageOpened();

        userClient.deleteUser(email, password);
    }

    @Test
    @DisplayName("Login from personal area button")
    public void loginFromPersonalAreaButton()
    {
        String email = "test_login_email_" + new Random().nextInt(10000) + "@yandex.ru";
        String password = "test_password";
        String name = "test_name";

        userClient.registerUser(email, password, name);

        openMainPage(webDriver);

        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnPersonalAreaButton();

        checkUserLogin(webDriver, email, password);
        mainPage.checkMainPageOpened();

        userClient.deleteUser(email, password);
    }

    @Test
    @DisplayName("Login from button on register page")
    public void loginFromButtonOnRegisterPage()
    {
        String email = "test_login_email_" + new Random().nextInt(10000) + "@yandex.ru";
        String password = "test_password";
        String name = "test_name";

        userClient.registerUser(email, password, name);

        openRegisterPage(webDriver);

        MainPage mainPage = new MainPage(webDriver);
        RegisterPage registerPage = new RegisterPage(webDriver);

        registerPage.clickLoginButton();
        checkUserLogin(webDriver, email, password);
        mainPage.checkMainPageOpened();

        userClient.deleteUser(email, password);
    }

    @Test
    @DisplayName("Login from button on forgot password page")
    public void loginFromButtonOnForgotPasswordPage()
    {
        String email = "test_login_email_" + new Random().nextInt(10000) + "@yandex.ru";
        String password = "test_password";
        String name = "test_name";

        userClient.registerUser(email, password, name);

        openForgotPasswordPage(webDriver);

        MainPage mainPage = new MainPage(webDriver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);

        forgotPasswordPage.clickLoginButton();
        checkUserLogin(webDriver, email, password);
        mainPage.checkMainPageOpened();

        userClient.deleteUser(email, password);
    }
}

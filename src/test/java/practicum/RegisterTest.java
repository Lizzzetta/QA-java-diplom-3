package practicum;

import org.junit.jupiter.api.*;
import practicum.pageobject.RegisterPage;

import java.util.Random;

import static practicum.util.Pages.openRegisterPage;

public class RegisterTest extends TestBase
{
    @Test
    @DisplayName("Successful register user")
    public void registerUserSuccessful()
    {
        String email = "test_login_email_" + new Random().nextInt(10000) + "@yandex.ru";
        String password = "test_password";
        String name = "test_name";

        openRegisterPage(webDriver);

        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(password);
        registerPage.clickRegisterButton();

        userClient.checkUserRegistered(email, password);

        userClient.deleteUser(email, password);
    }

    @Test
    @DisplayName("Password must be more when 6 symbols")
    public void passwordMustBeMoreThenSixSymbols()
    {
        String email = "test_login_email_" + new Random().nextInt(10000) + "@yandex.ru";
        String shortPassword = "test_";
        String name = "test_name";

        openRegisterPage(webDriver);

        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.setName(name);
        registerPage.setEmail(email);
        registerPage.setPassword(shortPassword);
        registerPage.clickRegisterButton();

        registerPage.checkPasswordErrorShown();
    }
}

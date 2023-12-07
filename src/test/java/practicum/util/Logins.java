package practicum.util;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import practicum.pageobject.LoginPage;

public final class Logins
{
    private Logins()
    {
    }

    @Step("Login by user")
    public static void loginByUser(WebDriver webDriver, String email, String password)
    {
        LoginPage loginPage = new LoginPage(webDriver);
        doLogin(loginPage, email, password);
    }


    @Step("Check user login")
    public static void checkUserLogin(WebDriver webDriver, String email, String password)
    {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.checkLoginPageOpened();
        doLogin(loginPage, email, password);
    }

    private static void doLogin(LoginPage loginPage, String email, String password)
    {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }
}

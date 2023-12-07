package practicum.util;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public final class Pages
{
    public static final String REST_API_BASE_URL = "https://stellarburgers.nomoreparties.site/api";
    private static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    private Pages()
    {
    }

    @Step("Open main page")
    public static void openMainPage(WebDriver webDriver)
    {
        webDriver.get(MAIN_PAGE_URL);
    }

    @Step("Open register page")
    public static void openRegisterPage(WebDriver webDriver)
    {
        webDriver.get(REGISTER_PAGE_URL);
    }

    @Step("Open login page")
    public static void openLoginPage(WebDriver webDriver)
    {
        webDriver.get(LOGIN_PAGE_URL);
    }

    @Step("Open forgot password page")
    public static void openForgotPasswordPage(WebDriver webDriver)
    {
        webDriver.get(FORGOT_PASSWORD_PAGE_URL);
    }
}

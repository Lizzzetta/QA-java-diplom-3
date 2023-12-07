package practicum;

import org.junit.jupiter.api.*;
import practicum.pageobject.*;

import java.util.Random;

import static practicum.util.Logins.loginByUser;
import static practicum.util.Pages.openLoginPage;

public class PersonalAreaTest extends TestBase
{
    @Test
    @DisplayName("Open personal area page")
    public void openPersonalAreaPage()
    {
        String email = "test_login_email_" + new Random().nextInt(10000) + "@yandex.ru";
        String password = "test_password";
        String name = "test_name";

        userClient.registerUser(email, password, name);

        openLoginPage(webDriver);

        MainPage mainPage = new MainPage(webDriver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(webDriver);

        loginByUser(webDriver, email, password);
        mainPage.checkMainPageOpened();
        mainPage.clickOnPersonalAreaButton();
        personalAreaPage.checkPersonalAreaPageOpened();

        userClient.deleteUser(email, password);
    }

    @Test
    @DisplayName("Open main page from personal area page")
    public void openMainPageFromPersonalAreaPage()
    {
        String email = "test_login_email_" + new Random().nextInt(10000) + "@yandex.ru";
        String password = "test_password";
        String name = "test_name";

        userClient.registerUser(email, password, name);

        openLoginPage(webDriver);

        MainPage mainPage = new MainPage(webDriver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(webDriver);

        loginByUser(webDriver, email, password);
        mainPage.checkMainPageOpened();
        mainPage.clickOnPersonalAreaButton();
        personalAreaPage.checkPersonalAreaPageOpened();

        personalAreaPage.clickOnStellarBurgersLogo();
        mainPage.checkMainPageOpened();

        userClient.deleteUser(email, password);
    }

    @Test
    @DisplayName("Logout from personal area page")
    public void logoutFromPersonalAreaPage()
    {
        String email = "test_login_email_" + new Random().nextInt(10000) + "@yandex.ru";
        String password = "test_password";
        String name = "test_name";

        userClient.registerUser(email, password, name);

        openLoginPage(webDriver);

        MainPage mainPage = new MainPage(webDriver);
        PersonalAreaPage personalAreaPage = new PersonalAreaPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);

        loginByUser(webDriver, email, password);
        mainPage.checkMainPageOpened();
        mainPage.clickOnPersonalAreaButton();
        personalAreaPage.checkPersonalAreaPageOpened();

        personalAreaPage.clickOnLogoutButton();
        loginPage.checkLoginPageOpened();

        userClient.deleteUser(email, password);
    }
}

package practicum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class LoginPage
{
    private final WebDriver driver;

    private By loginTitle = By.xpath(".//h2[text() = 'Вход']");
    private By emailInputField = By.xpath(".//label[text() = 'Email']/parent::*/input");
    private By passwordInputField = By.xpath(".//label[text() = 'Пароль']/parent::*/input");
    private By loginButton = By.xpath(".//button[text() = 'Войти']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Check login page opened")
    public void checkLoginPageOpened()
    {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(loginTitle));
    }

    @Step("Set email field on login page")
    public void setEmail(String value)
    {
        driver.findElement(emailInputField).sendKeys(value);
    }

    @Step("Set password field on login page")
    public void setPassword(String value)
    {
        driver.findElement(passwordInputField).sendKeys(value);
    }

    @Step("Click login button")
    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
    }
}

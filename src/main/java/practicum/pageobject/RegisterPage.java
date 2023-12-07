package practicum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class RegisterPage
{
    private final WebDriver driver;

    private By nameInputField = By.xpath(".//label[text() = 'Имя']/parent::*/input");
    private By emailInputField = By.xpath(".//label[text() = 'Email']/parent::*/input");
    private By passwordInputField = By.xpath(".//label[text() = 'Пароль']/parent::*/input");

    private By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private By passwordError = By.xpath(".//p[text() = 'Некорректный пароль']");
    private By loginButton = By.xpath(".//a[text() = 'Войти']");

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Set name field on register page")
    public void setName(String value)
    {
        driver.findElement(nameInputField).sendKeys(value);
    }

    @Step("Set email field on register page")
    public void setEmail(String value)
    {
        driver.findElement(emailInputField).sendKeys(value);
    }

    @Step("Set password field on register page")
    public void setPassword(String value)
    {
        driver.findElement(passwordInputField).sendKeys(value);
    }

    @Step("Click register button")
    public void clickRegisterButton()
    {
        driver.findElement(registerButton).click();
    }

    @Step("Check password error shown")
    public void checkPasswordErrorShown()
    {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(passwordError));
    }

    @Step("Click login button on register page")
    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
    }
}

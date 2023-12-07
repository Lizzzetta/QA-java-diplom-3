package practicum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class ForgotPasswordPage
{
    private final WebDriver driver;

    private By loginButton = By.xpath(".//a[text() = 'Войти']");

    public ForgotPasswordPage(WebDriver webDriver)
    {
        this.driver = webDriver;
    }

    @Step("Click login button on forgot password page")
    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
    }
}

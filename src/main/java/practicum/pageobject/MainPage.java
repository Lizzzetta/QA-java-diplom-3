package practicum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class MainPage
{
    private final WebDriver driver;

    private By createBurgerTitle = By.xpath(".//h1[text() = 'Соберите бургер']");
    private By enterInAccountButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private By personalAreaButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Check main page opened")
    public void checkMainPageOpened()
    {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(createBurgerTitle));
    }

    @Step("Click on enter in account button")
    public void clickOnEnterInAccountButton()
    {
        driver.findElement(enterInAccountButton).click();
    }

    @Step("Click on personal area button")
    public void clickOnPersonalAreaButton()
    {
        driver.findElement(personalAreaButton).click();
    }

    @Step("Click on section tab")
    public void clickOnSectionTab(String title)
    {
        driver.findElement(By.xpath(".//span[text() = '" + title + "']")).click();
    }

    @Step("Check section visible")
    public void checkSectionVisible(String title)
    {
        new WebDriverWait(driver, 300).until(ExpectedConditions.elementToBeClickable(
                By.xpath(".//h2[text() = '" + title + "']")
        ));
    }
}

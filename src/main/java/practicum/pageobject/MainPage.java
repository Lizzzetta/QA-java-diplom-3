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

    @Step("Wait until section visible")
    public void waitUntilSectionVisible(String title)
    {
        new WebDriverWait(driver, 3).until(webDriver -> isSectionVisibleInViewport(title));
    }

    @Step("Get section visibility in viewport")
    public boolean isSectionVisibleInViewport(String title)
    {
        return (Boolean)((JavascriptExecutor)driver).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            ",
                driver.findElement(By.xpath(".//h2[text() = '" + title + "']"))
        );
    }
}

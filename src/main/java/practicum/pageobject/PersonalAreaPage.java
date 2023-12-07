package practicum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PersonalAreaPage
{
    private final WebDriver driver;

    private By personalAreaDescription = By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");
    private By stellarBurgersLogo = By.xpath(".//header/nav/div/a");
    private By logoutButton = By.xpath(".//button[text() = 'Выход']");

    public PersonalAreaPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Check personal area page opened")
    public void checkPersonalAreaPageOpened()
    {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(personalAreaDescription));
    }

    @Step("Click on stellar burgers logo")
    public void clickOnStellarBurgersLogo()
    {
        driver.findElement(stellarBurgersLogo).click();
    }

    @Step("Click on logout button")
    public void clickOnLogoutButton()
    {
        driver.findElement(logoutButton).click();
    }
}

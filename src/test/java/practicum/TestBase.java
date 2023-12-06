package practicum;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import practicum.client.UserClient;

import static practicum.util.Pages.REST_API_BASE_URL;
import static practicum.util.WebDrivers.initChromeWebDriver;

public class TestBase
{
    protected final UserClient userClient;
    protected WebDriver webDriver;

    public TestBase()
    {
        this.userClient = new UserClient(REST_API_BASE_URL);
    }

    @BeforeEach
    public void init()
    {
        webDriver = initChromeWebDriver();
    }

    @AfterEach
    public void close()
    {
        webDriver.quit();
    }
}

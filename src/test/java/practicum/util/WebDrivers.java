package practicum.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public final class WebDrivers
{
    private WebDrivers()
    {
    }

    public static WebDriver initChromeWebDriver()
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }
}

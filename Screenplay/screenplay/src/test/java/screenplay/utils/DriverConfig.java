package screenplay.utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfig implements DriverSource {

    @Override
    public WebDriver newDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

}

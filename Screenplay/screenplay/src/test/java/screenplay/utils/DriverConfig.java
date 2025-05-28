package screenplay.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfig implements DriverSource {

    @Override
    public WebDriver newDriver() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        ChromeOptions options = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver", "drivers/win/chromedriver.exe");

        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");

        return new ChromeDriver(options);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

}

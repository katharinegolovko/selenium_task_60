package by.issoft.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.MAC);
            driver = new RemoteWebDriver(new URL(
                    "http://192.168.100.30:4444/"), capabilities);
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }
}

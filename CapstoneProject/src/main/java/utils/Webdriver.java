package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Webdriver {
    public static WebDriver driver;   // make static

    public WebDriver initializeDriver(String url) {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        
        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
}

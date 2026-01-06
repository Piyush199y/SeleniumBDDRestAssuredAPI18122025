package org.piyush.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    // IMP NOTE :
    // There are two methods by which we can handle the browserUser
    // User can choose any method there as not linked but separate methods
    // Dont get confused in linking them

    public static Browser getBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            return new ChromeBrowser();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            return new FirefoxBrowser();

        } else {
            throw new RuntimeException("Browser not supported: " + browserName);
        }
    }

        public static WebDriver createDriver(String browser, ChromeOptions options) {

            WebDriver driver;

            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;
            }

            driver.manage().window().maximize();
            return driver;
        }


}

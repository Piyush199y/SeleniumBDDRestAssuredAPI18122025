package org.piyush.stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.piyush.browser.Browser;
import org.piyush.browser.BrowserFactory;
import org.piyush.driver.DriverManager;
import org.piyush.utils.ConfigReader;


public class Hooks {

    private Browser browser;

//    @Before
//    public void setUp() {
//        ConfigReader.loadConfig();
//        String browserName = ConfigReader.get("browser");
//
//        browser = BrowserFactory.getBrowser(browserName);
//        driver = browser.start();
//
//        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//
//        } else {
//            throw new RuntimeException("Browser not supported: " + browser);
//        }
//
//        driver.get(ConfigReader.get("url"));
//        System.out.println("=== Driver Initialized ===");
//
//    }

    @Before
    public void setUp() {
        ConfigReader.loadConfig();
        String browserName = ConfigReader.get("browser");

        WebDriver driver = BrowserFactory.createDriver(browserName);

        DriverManager.setDriver(driver);
    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        System.out.println("=== Driver Quit ===");
//        }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

}


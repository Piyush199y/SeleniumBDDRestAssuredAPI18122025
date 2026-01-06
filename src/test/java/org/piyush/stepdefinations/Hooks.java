package org.piyush.stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        System.out.println("Browser name = " + browserName);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = BrowserFactory.createDriver(browserName, options);
        System.out.println("HOOK DRIVER = " + driver);

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
        DriverManager.unload();
    }

}


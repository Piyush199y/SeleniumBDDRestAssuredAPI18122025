package org.piyush.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    // Commenting this to support Parallel execution as the driver.quit will not support thread local
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }

    public static void unload(){
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.quit();   // close browser for THIS thread
            driver.remove();        // VERY IMPORTANT for parallel execution
        }
    }
}

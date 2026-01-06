package org.piyush.utils;
import org.openqa.selenium.WebDriver;
import org.piyush.driver.DriverManager;

public class Helper {
    private WebDriver driver;

    public Helper(){
        this.driver = DriverManager.getDriver();
    }

    public void navigateToUrl(String url) {

        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        driver.get(url);
    }
}

package org.piyush.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.piyush.driver.DriverManager;
import org.piyush.utils.ConfigReader;

public class NaukariPage {

    private WebDriver driver;
    private static By userNameInput = By.xpath("//input[@id='usernameField']");
    private static By passwordInput = By.xpath("//input[@id='passwordField']");
    private static By loginButton = By.xpath("//button[text()='Login']");

    public NaukariPage(WebDriver driver){
        this.driver = DriverManager.getDriver();
    }

    public void userNavigateToGivenUrl(String url){
        ConfigReader.loadConfig();
        String inputUrl = ConfigReader.get(url);

        if (inputUrl == null || inputUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        if (!inputUrl.startsWith("http://") && !inputUrl.startsWith("https://")) {
            inputUrl = "https://" + inputUrl;
        }

        driver.get(inputUrl);

    }

    public void userLoginAndLandOnHomePage(){
        String url = ConfigReader.get("NaukariUrl");
    }

}

package org.piyush.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.piyush.driver.DriverManager;
import org.piyush.utils.ConfigReader;
import org.piyush.utils.Helper;

public class NaukariPage {

    public Helper helper;
    private WebDriver driver;
    private static By userNameInput = By.xpath("//input[@id='usernameField']");
    private static By passwordInput = By.xpath("//input[@id='passwordField']");
    private static By loginButton = By.xpath("//button[text()='Login']");

    public NaukariPage(){
        this.driver = DriverManager.getDriver();
    }

    public void userNavigateToGivenUrl(String url){
        ConfigReader.loadConfig();
        String inputUrl = ConfigReader.get(url);
        helper.navigateToUrl(inputUrl);
    }

    public void userLoginAndLandOnHomePage(){
        String url = ConfigReader.get("NaukariUrl");
        helper.navigateToUrl(url);
    }

}

package org.piyush.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.piyush.driver.DriverManager;
import org.piyush.stepdefinations.Hooks;

public class LoginPage {

    private WebDriver driver;
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By successMessage = By.id("flash");


    public LoginPage() {
        //this.driver = Hooks.driver;
        this.driver = DriverManager.getDriver();
    }


    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

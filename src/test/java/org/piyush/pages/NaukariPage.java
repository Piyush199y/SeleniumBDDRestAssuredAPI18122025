package org.piyush.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.piyush.driver.DriverManager;
import org.piyush.utils.ConfigReader;

import java.time.Duration;

public class NaukariPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private boolean flagForResume;
    private static By userNameInput = By.xpath("//input[@id='usernameField']");
    private static By passwordInput = By.xpath("//input[@id='passwordField']");
    private static By loginButton = By.xpath("//button[text()='Login']");
    private static By profileButton = By.xpath("//a[text()=' profile']");
    private static By deleteResButton = By.xpath("//span[@data-title='delete-resume']");
    private static By deleteConfirm = By.xpath("//p[contains(text(),'delete the resume')]/../div/button[text()='Delete']");
    private static By uploadResumeInput = By.id("attachCV");
    private static By resumeHeadline = By.id("resumeHeadlineTxt");
    private static By editResume = By.xpath("//span[contains(text(),'headline')]/following-sibling::span[text()='editOneTheme']");

    public NaukariPage(WebDriver driver){
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    public void userNavigateToGivenUrl(String url){
        String inputUrl = ConfigReader.get(url);

        if (inputUrl == null || inputUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        if (!inputUrl.startsWith("http://") && !inputUrl.startsWith("https://")) {
            inputUrl = "https://" + inputUrl;
        }

        driver.get(inputUrl);
        String title = driver.getTitle();
        System.out.println("Title of the page : "+title);

    }

    public void userLoginAndLandOnHomePage(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userNameInput));
        String user = ConfigReader.get("NaukariUser");
        String pass = ConfigReader.get("NaukariPass");
        driver.findElement(userNameInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void userUpdateProfile(){
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        driver.findElement(profileButton).click();

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(deleteResButton));
            WebElement e = driver.findElement(deleteResButton);
            actions.moveToElement(e);
            e.click();
            wait.until(ExpectedConditions.elementToBeClickable(deleteConfirm));
            driver.findElement(deleteConfirm).click();
        } catch(Exception e){
            System.out.println("Resume is not uploaded");
            flagForResume = false;
        }

        scrollToElement(driver,uploadResumeInput);

        WebElement uploadElement = driver.findElement(uploadResumeInput);
        uploadElement.sendKeys("C:\\Users\\piyus\\SeleniumBDDRestAssuredAPI18122025\\src\\test\\resources\\Piyush_Bansod_Resume.pdf");

        WebElement z = driver.findElement(editResume);
        actions.moveToElement(z);
        wait.until(ExpectedConditions.elementToBeClickable(editResume));
        z.click();

        WebElement resumeHeadline = driver.findElement(By.id("resumeHeadlineTxt"));
        wait.until(ExpectedConditions.elementToBeClickable(resumeHeadline));
        String existingText = resumeHeadline.getAttribute("value");
        System.out.println("Current length: " + existingText.length());

        if (existingText.length() == 250) {
            char lastChar = existingText.charAt(existingText.length() - 1);
            String modifiedText = existingText.substring(0, existingText.length() - 1);

            resumeHeadline.clear();
            resumeHeadline.sendKeys(modifiedText);
            resumeHeadline.sendKeys(String.valueOf(lastChar));

        } else {
            resumeHeadline.clear();
            resumeHeadline.sendKeys(existingText);
        }

        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    public static void scrollToElement(WebDriver driver, By by) {

        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",element);
        System.out.println("Scrolling is success to : " + element.getText());
    }

//    public static void scrollToElement(WebDriver driver, WebElement element) {
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(
//                "arguments[0].scrollIntoView({block: 'center'});",
//                element
//        );
//    }



}

package org.piyush.stepdefinations;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.piyush.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage();
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should see successful login message")
    public void user_should_see_success_message() throws InterruptedException {
        String msg = loginPage.getSuccessMessage();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));
        Thread.sleep(2000);
    }

}

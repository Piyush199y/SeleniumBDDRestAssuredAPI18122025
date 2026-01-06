package org.piyush.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.piyush.driver.DriverManager;
import org.piyush.pages.NaukariPage;

public class NaukariSteps {

    WebDriver driver = DriverManager.getDriver();
    public NaukariPage naukariPage;

    @Given("User lands on naukari login page using {string}")
    public void userLandsOnNaukariLoginPageUsing(String arg0) {
        naukariPage = new NaukariPage(driver);
        naukariPage.userNavigateToGivenUrl(arg0);
        naukariPage.userLoginAndLandOnHomePage();
    }

    @When("User update the summary")
    public void userUpdateTheSummary() {
        naukariPage.userUpdateProfile();
    }

    @And("Upload a new resume")
    public void uploadANewResume() {
    }

    @Then("the profile should get updated")
    public void theProfileShouldGetUpdated() {
    }

}

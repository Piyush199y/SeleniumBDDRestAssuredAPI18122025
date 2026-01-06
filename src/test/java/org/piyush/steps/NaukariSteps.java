package org.piyush.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.piyush.pages.NaukariPage;

public class NaukariSteps {

    public NaukariPage naukariPage;

    @Given("User lands on naukari login page using {string}")
    public void userLandsOnNaukariLoginPageUsing(String arg0) {
        naukariPage = new NaukariPage();
        naukariPage.userNavigateToGivenUrl(arg0);
    }

    @When("User update the summary")
    public void userUpdateTheSummary() {
    }

    @And("Upload a new resume")
    public void uploadANewResume() {
    }

    @Then("the profile should get updated")
    public void theProfileShouldGetUpdated() {
    }

}

package org.piyush.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.piyush.requests.LoginApi;

public class LoginApiSteps {

    Response response;

    @Given("API base URI is set")
    public void api_base_uri_is_set() {
        System.out.println("API run started ");
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("user sends POST request")
    public void user_sends_post_request() {
        response = LoginApi.sendPost();
    }


//    @Then("response status code should be {int}")
//    public void response_status_code_should_be(int statusCode) {
//        Assert.assertEquals(statusCode, response.getStatusCode());
//        System.out.println("Status code is : "+response.getStatusCode());
//    }
}

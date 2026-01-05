package org.piyush.steps;

import org.piyush.pojo.*;
import org.piyush.requests.UserApi;
import org.piyush.utils.ConfigReader;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

public class UserPostSteps {

    Response response;
    UserResponse userResponse;

    @Given("User API base URI is set")
    public void user_api_base_uri_is_set() {
        ConfigReader.loadConfig();
    }

    @When("user creates a user using POST API")
    public void user_creates_a_user_using_post_api() {

        AddressRequest address =
                new AddressRequest("Pune", "411001");

        UserRequest request =
                new UserRequest("piyush", 30, address);

        response = UserApi.createUser(request);
        userResponse = response.as(UserResponse.class);  // ⭐ JSON → POJO
    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status code is : "+response.getStatusCode());
        System.out.println("Response is : "+response.asPrettyString());
    }

    @Then("response id should not be null")
    public void response_id_should_not_be_null() {
        Assert.assertNotNull(userResponse.getId());
        System.out.println("response payload id is : "+ userResponse.getId());
    }

}

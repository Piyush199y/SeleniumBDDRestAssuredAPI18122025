package org.piyush.steps;

import org.piyush.pojo.Product;
import org.piyush.pojo.ProductRequest;
import org.piyush.requests.FakeStoreApi;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import org.piyush.utils.ConfigReader;

public class FakeStoreSteps {

    Response response;
    Product product;

    @Given("Fake Store API base URI is set")
    public void fake_store_api_base_uri_is_set() {
        ConfigReader.loadConfig();
        // No base URI needed since we use full URL
    }

    @When("user requests product details")
    public void user_requests_product_details() {
        response = FakeStoreApi.getProduct();
        product = response.as(Product.class);// ⭐ POJO mapping

        System.out.println("Response : " + response.asPrettyString());
    }

    @Then("product title should be {string}")
    public void product_title_should_be(String expectedTitle) {
        //Assert.assertEquals(expectedTitle, product.getTitle());
        Assert.assertTrue(product.getTitle().contains(expectedTitle));

        System.out.println("Product title : " + product.getTitle());

    }

    @And("product price should be {double}")
    public void product_price_should_be(double expectedPrice) {
        Assert.assertEquals(expectedPrice, product.getPrice(), 0.01);

        System.out.println("Price : " + product.getPrice());
    }

    @When("user creates a product using API")
    public void user_creates_a_product_using_api() {

        ProductRequest request = new ProductRequest(
                "Test Product",
                99.99,
                "Automation product",
                "https://i.pravatar.cc",
                "electronics"
        );

        response = FakeStoreApi.createProduct(request);
    }


    @And("product title in response should be {string}")
    public void product_title_in_response_should_be(String expectedTitle) {
        String actualTitle = response.jsonPath().getString("title");
        Assert.assertEquals(expectedTitle, actualTitle);
    }

//    @Then("response status code should be {int}")
//    public void response_status_code_should_be(int statusCode) {
//        Assert.assertEquals(statusCode, response.getStatusCode());
//        System.out.println("Status code is : "+response.getStatusCode());
//        System.out.println("Response is : "+response.asPrettyString());
//    }
}

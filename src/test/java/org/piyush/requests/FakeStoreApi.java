package org.piyush.requests;

import org.piyush.pojo.ProductRequest;
import org.piyush.utils.ConfigReader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class FakeStoreApi {

    public static Response getProduct() {

        return given()
                .baseUri(ConfigReader.get("api.base.url"))
                .basePath("/products/1")
                .when()
                .get();
    }

    public static Response createProduct(ProductRequest request) {

        return given()
                .baseUri(ConfigReader.get("api.base.url"))
                .basePath("/products")
                .header("Content-Type", "application/json")
                .body(request)   // ⭐ POJO → JSON
                .when()
                .post();
    }
}

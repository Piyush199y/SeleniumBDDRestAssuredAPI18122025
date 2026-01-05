package org.piyush.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class LoginApi {

    public static Response sendPost() {

        String payload = """
                {
                  "name": "Piyush",
                  "role": "Automation Tester"
                }
                """;

        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("https://postman-echo.com/post");
    }
}

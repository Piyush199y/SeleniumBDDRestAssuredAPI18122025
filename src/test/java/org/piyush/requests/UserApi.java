package org.piyush.requests;

import org.piyush.pojo.UserRequest;
import org.piyush.utils.ConfigReader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserApi {

    public static Response createUser(UserRequest request) {

        return given()
                .baseUri(ConfigReader.get("api.base.url"))
                .basePath("/users")
                .header("Content-Type", "application/json")
                .body(request)     // ⭐ POJO → JSON
                .when()
                .post();
    }
}

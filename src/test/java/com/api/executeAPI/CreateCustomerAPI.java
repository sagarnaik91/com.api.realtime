package com.api.executeAPI;

import com.api.setup.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class CreateCustomerAPI extends BaseTest {

    public static Response createCustomerWithValidKey(Hashtable<String, String> table) {
        return given().auth().basic(prop.getProperty("validSecretKey"), "")
                .formParam("email", table.get("email"))
                .formParam("description", table.get("description"))
                .formParam("name", table.get("name"))
                .post(prop.getProperty("customerApiEndpoint"));
    }

    public static Response createCustomerWithInvalidKey(Hashtable<String,String> table)
    {
        return given().auth().basic(prop.getProperty("inValidSecretKey"), "")
                .formParam("email", table.get("email"))
                .formParam("description", table.get("description"))
                .formParam("name", table.get("name"))
                .post(prop.getProperty("customerApiEndpoint"));
    }
}

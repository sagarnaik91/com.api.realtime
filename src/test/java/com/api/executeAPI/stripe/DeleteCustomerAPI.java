package com.api.executeAPI.stripe;

import com.api.setup.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class DeleteCustomerAPI extends BaseTest {

    public static Response deleteCustomerWithValidId(Hashtable<String, String> table) {
        return given().log().all().auth().basic(prop.getProperty("validSecretKey"), "")
                .delete(prop.getProperty("customerApiEndpoint") + "/" + table.get("id"));
    //Take the id to delete from https://dashboard.stripe.com/test/customers pwd id Thinkofsuccess706
    }

}

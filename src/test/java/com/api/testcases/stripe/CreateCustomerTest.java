package com.api.testcases.stripe;

import com.api.setup.BaseTest;
import com.api.utilities.DataUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateCustomerTest extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "datasets")
    public void cxCreationValidKey(String name, String email, String description) {
        Response res = given().auth().basic(prop.getProperty("validSecretKey"), "")
                .formParam("email", email)
                .formParam("description", description)
                .formParam("name", name)
                .post(prop.getProperty("customerApiEndpoint"));
        res.prettyPrint();
        System.out.println(res.getTime());
        System.out.println(res.statusCode());
        Assert.assertEquals(res.statusCode(), 200);
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "datasets")
    public void cxCreationInvalidKey(String name, String email, String description) {
        Response res = given().auth().basic(prop.getProperty("validSecretKey"), "")
                .formParam("email", email)
                .formParam("description", description)
                .formParam("name", name)
                .post(prop.getProperty("customerApiEndpoint"));
        res.prettyPrint();
        System.out.println(res.getTime());
        System.out.println(res.statusCode());
        Assert.assertEquals(res.statusCode(), 200);
    }


}

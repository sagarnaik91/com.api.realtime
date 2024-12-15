package com.api.testcases;

import com.api.executeAPI.CreateCustomerAPI;
import com.api.setup.BaseTest;
import com.api.utilities.DataUtil;
import com.api.utilities.TestParametrization;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class CreateCustomerTest_Optimized extends BaseTest {
    @Test(dataProviderClass = TestParametrization.class, dataProvider = "datasource")
    public void cxCreationValidKey(Hashtable<String, String> table) {
        Response res = CreateCustomerAPI.createCustomerWithValidKey(table);
        res.prettyPrint();
        System.out.println(res.getTime());
        System.out.println(res.statusCode());
        Assert.assertEquals(res.statusCode(), 200);
    }

    @Test(dataProviderClass = TestParametrization.class, dataProvider = "datasource")
    public void cxCreationInvalidKey(Hashtable<String, String> table) {
        Response res = CreateCustomerAPI.createCustomerWithInvalidKey(table);
        res.prettyPrint();
        System.out.println(res.getTime());
        System.out.println(res.statusCode());
        Assert.assertEquals(res.statusCode(), 401);
    }


}

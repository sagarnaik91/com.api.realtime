package com.api.testcases.payPal;

import com.api.executeAPI.payPal.OrderAPI;
import com.api.setup.BaseTest;
import com.api.utilities.TestParametrization;
import com.api.utilities.TestUtilities;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CreateOrderTest extends BaseTest {
    @Test(dataProviderClass = TestParametrization.class,dataProvider = "datasource")
    public static void createOrder(Hashtable<String,String> table)  {
        OrderAPI.getAccessToken();
        Response res = OrderAPI.createOrder(table);
        res.prettyPrint();
        Assert.assertEquals(TestUtilities.getJsonKeyValue(res.asString(), "status"), "CREATED");

    }

}

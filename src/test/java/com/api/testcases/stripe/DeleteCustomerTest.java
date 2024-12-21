package com.api.testcases.stripe;

import com.api.executeAPI.stripe.DeleteCustomerAPI;
import com.api.setup.BaseTest;
import com.api.utilities.TestParametrization;
import com.api.utilities.TestUtilities;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DeleteCustomerTest extends BaseTest {
    @Test(dataProviderClass = TestParametrization.class, dataProvider = "datasource")
    public static void deleteCustomer(Hashtable<String, String> table) {
        Response res = DeleteCustomerAPI.deleteCustomerWithValidId(table);
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertTrue(TestUtilities.hasKey(res.asString(), "id"));
        Assert.assertEquals(TestUtilities.getJsonKeyValue(res.asString(), "id"), table.get("id"));


    }
}

package com.api.testcases;

import com.api.executeAPI.DeleteCustomerAPI;
import com.api.setup.BaseTest;
import com.api.utilities.TestParametrization;
import com.api.utilities.TestUtilities;
import com.aventstack.extentreports.TestListener;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static com.api.executeAPI.DeleteCustomerAPI.deleteCustomerWithValidId;

public class DeleteCustomerTest extends BaseTest {
    @Test(dataProviderClass = TestParametrization.class, dataProvider = "datasource")
    public static void deleteCustomer(Hashtable<String, String> table) {
        Response res = DeleteCustomerAPI.deleteCustomerWithValidId(table);
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertTrue(TestUtilities.hasKey(res.asString(), "id"));
        Assert.assertEquals(TestUtilities.getJsonKeyValue(res.asString(), "id"), table.get("id"));


    }
}

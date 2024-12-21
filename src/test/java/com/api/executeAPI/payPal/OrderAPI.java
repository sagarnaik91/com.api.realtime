package com.api.executeAPI.payPal;

import com.api.pojo.Amount;
import com.api.pojo.Orders;
import com.api.pojo.PurchaseUnits;
import com.api.setup.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Hashtable;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class OrderAPI extends BaseTest {
    public static String clientID = prop.getProperty("payPalClientId");
    public static String clientSecret = prop.getProperty("payPalClientSecret");
    public static String access_token;
    static String orderId;

    public static String getAccessToken() {
        Response res = given().param("grant_type", "client_credentials")
                .auth().preemptive().basic(clientID, clientSecret)
                .post("v1/oauth2/token");
        res.prettyPrint();
        access_token = res.jsonPath().getString("access_token");
        return access_token;
    }

    public static Response createOrder(Hashtable<String,String> table) {
        ArrayList<PurchaseUnits> list = new ArrayList<PurchaseUnits>();
        list.add(new PurchaseUnits(table.get("reference_id"), table.get("currency_code"), table.get("value")));
        Orders orders = new Orders("CAPTURE", list);
        Response res = given().log().all().contentType(ContentType.JSON).auth().oauth2(access_token).body(orders).post("/v2/checkout/orders");
        orderId = res.jsonPath().getString("id");
        return res;
    }

    public static Response getOrder(Hashtable<String,String> table) {
        return given().log().all().auth().oauth2(access_token).get("v2/checkout/orders" + "/" + table.get("id"));

    }
}

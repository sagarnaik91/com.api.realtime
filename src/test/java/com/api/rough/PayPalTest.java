package com.api.rough;

import com.api.pojo.Amount;
import com.api.pojo.Orders;
import com.api.pojo.PurchaseUnits;
//import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class PayPalTest {
    static String clientID = "AQV5GfG1KCuIP2YLegv95MUSBo_PeOfBAMU5f2cL-bqOcIG98ZoaqAjXfkW4ysbi5VujgIlxSDYLfpCt";
    static String clientSecret = "EB7jQzo5EyMM9LKx5-zVIS3gohhT7vzGvUQQzc2dQ9bYtGoVoJlG5pmDZblyQDdv0m6C3nGoQd5ws-Ct";
    static String access_token;
    static String orderId;

    @Test(priority = 0)
    public static void getAccessToken() {
        baseURI = "https://api-m.sandbox.paypal.com";
        Response res = given().param("grant_type", "client_credentials")
                .auth().preemptive().basic(clientID, clientSecret)
                .post("v1/oauth2/token");
        res.prettyPrint();
        access_token = res.jsonPath().getString("access_token");
        System.out.println("Access token is --->" + access_token);


    }

    @Test(priority = 1, dependsOnMethods = "getAccessToken")
    public static void createOrder() {
        ArrayList<PurchaseUnits> list = new ArrayList<PurchaseUnits>();
        list.add(new PurchaseUnits("d9f80740-38f0-11e8-b467-0ed5f89f718b", "USD", "100"));
        Orders orders = new Orders("CAPTURE", list);
//        String payload = "{\n" +
//                "  \"intent\": \"CAPTURE\",\n" +
//                "  \"purchase_units\": [\n" +
//                "    {\n" +
//                "      \"reference_id\": \"d9f80740-38f0-11e8-b467-0ed5f89f718b\",\n" +
//                "      \"amount\": {\n" +
//                "        \"currency_code\": \"USD\",\n" +
//                "        \"value\": \"100.00\"\n" +
//                "      }\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
        Response res = given().log().all().contentType(ContentType.JSON).auth().oauth2(access_token).body(orders).post("/v2/checkout/orders");
        res.prettyPrint();
        Assert.assertEquals(res.jsonPath().getString("status"), "CREATED");
        orderId = res.jsonPath().getString("id");
    }

    @Test(priority = 2, dependsOnMethods = {"getAccessToken", "createOrder"})
    public static void getOrder() {
        Response res = given().log().all().auth().oauth2(access_token).get("v2/checkout/orders" + "/" + orderId);
        Assert.assertEquals(res.jsonPath().getString("status"), "CREATED");
    }
}

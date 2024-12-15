package com.api.setup;

import com.api.utilities.ExcelReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class BaseTest {
    public static Properties prop = new Properties();
    private FileInputStream fis;
    public static ExcelReader excel = new ExcelReader("src/test/resources/testdata.xlsx");
    @BeforeSuite
    public void setup() throws IOException {
        baseURI = "https://api.stripe.com";
        basePath = "v1";
        fis=new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
    }

    @AfterSuite
    public void tearDown() {

    }
}

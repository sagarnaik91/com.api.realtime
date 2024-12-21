package com.api.rough;

import java.io.*;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        //FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        //prop.load(fis);
        FileReader fr = new FileReader("src/test/resources/config.properties");
        BufferedReader br = new BufferedReader(fr);
        prop.load(br);
        System.out.println(prop.getProperty("validSecretKey"));
    }
}

//This class reads the data from the individual tab in excel sheet and pass it to the test in testcases.CreateCustomerTest
package com.api.utilities;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

import static com.api.setup.BaseTest.excel;

public class DataUtil {
    @DataProvider(name = "datasets")
    public Object[][] getData(Method m) {
        System.out.println("Sheetname is------->"+m.getName());
        String sheetname = m.getName();
        int rows = excel.getRowCount(sheetname);
        int cols = excel.getColumnCount(sheetname);
        Object[][] data = new Object[rows - 1][cols];
        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum - 2][colNum] = excel.getCellData(sheetname, colNum, rowNum);
            }
        }

        return data;
    }
}

//This class reads the data from the same tab in excel sheet and stores in Hashtable and passed to the tests in testcases.CreateCustomerTest_Optimized
package com.api.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class TestParametrization {
//    @Test(dataProvider = "datasource")
//    public void data(Hashtable<String, String> table) {
//        System.out.println(table.get("name") + " " + table.get("email") + " " + table.get("description"));
//    }

    @DataProvider(name = "datasource",parallel = true)
    public Object[][] getData(Method m) {
        ExcelReader excel = new ExcelReader(Constants.testdataset);
        int rows = excel.getRowCount(Constants.DATA_SHEET);
        String testName = m.getName();
        int testCaseRowNum = 1;
        for (testCaseRowNum = 1; testCaseRowNum < rows; testCaseRowNum++) {
            String TestCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
            if (TestCaseName.equalsIgnoreCase(testName)) {
                break;
            }


        }
        System.out.println("Testcase row start from " + testCaseRowNum);
        //Checking the total rows of test data
        int dataStartRowNum = testCaseRowNum + 2;
        int testRows = 0;
        while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {
            testRows++;
        }
        System.out.println("Total test data rows are " + testRows);
        //Checking the total columns
        int colStartColNum = testCaseRowNum + 1;
        int testCols = 0;
        while (!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals("")) {
            testCols++;
        }
        System.out.println("Total test data cols are " + testCols);
        //Printing the data
        Object[][] data = new Object[testRows][1];
        int i = 0;
        for (int rNum = dataStartRowNum; rNum < dataStartRowNum + testRows; rNum++) {
            Hashtable<String, String> table = new Hashtable<>();
            for (int cNum = 0; cNum < testCols; cNum++) {
                //System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));

                String testdata = excel.getCellData(Constants.DATA_SHEET, cNum, rNum);
                String col = excel.getCellData(Constants.DATA_SHEET, cNum, colStartColNum);
                table.put(col, testdata);
            }
            data[i][0] = table;
            i++;

        }
        return data;

    }
}

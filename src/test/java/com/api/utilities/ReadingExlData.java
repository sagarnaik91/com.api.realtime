//This class reads the data from the testdata tab in excel sheet for respective testName as matching in excel.
package com.api.utilities;

public class ReadingExlData {
    public static void main(String[] args) {
        ExcelReader excel = new ExcelReader(Constants.testdataset);
        int rows = excel.getRowCount(Constants.DATA_SHEET);
        String testName = "cxCreationValidKey";
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
        for (int rNum = dataStartRowNum; rNum < dataStartRowNum + testRows; rNum++) {
            for (int cNum = 0; cNum < testCols; cNum++) {
                System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
            }

        }
    }
}

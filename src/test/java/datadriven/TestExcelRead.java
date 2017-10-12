package datadriven;

import utilities.classes.ExcelDataReadUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Todd on 11/17/2016.
 */
public class TestExcelRead {
    public static void main(String[] args) throws IOException, IllegalAccessException {

        ExcelDataReadUtil.setExcelFile("c:/SeleniumDataFiles/MOCK_DATA.xlsx", "LoginTest");
        Object[][] testData = ExcelDataReadUtil.getTestData();

        readArray(testData);

    }
    //Good utility to view your arrays

    public static void readArray(Object[][] array)
    {
        for(int i = 1; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {

                System.out.println("Row " +i+ " Column " +j+ ": " + array[i][j]);
            }
            System.out.println();
        }
    }
}



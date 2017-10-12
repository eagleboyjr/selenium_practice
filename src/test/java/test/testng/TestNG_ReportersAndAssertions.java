package test.testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.lang.reflect.Array;

/**
 * Created by Todd on 10/31/2016.
 */
public class TestNG_ReportersAndAssertions {

    @Test(priority = 0)
    public void testStrings(){
        String actualString = "Test Reporters and Asserts";
        String expectedValue = "Test Reporters and Asserts";
        Reporter.log("The actual test string is: '"+ actualString + "'", true);
        Assert.assertEquals(actualString, expectedValue);
        Reporter.log("Verifying actualString with expected value...", true);
        Reporter.log("");
    }

    @Test(priority = 1)
    public void testInt(){
        int actualint =10;
        int expectedInt =10;
        Reporter.log("The actual integer is '" + actualint +"'", true);
        Assert.assertEquals(actualint,expectedInt);
        Reporter.log("Verifying the actual integer with the expected integer....", true);
        Reporter.log("");
    }

    @Test(priority = 2)
    public void testArrays(){
        int[] actualArray = {1,2,3,4};
        int[] expectedArray ={1,2,3,4};
        Reporter.log("The actual Array is '" + actualArray +"'", true);
        Assert.assertEquals(actualArray, expectedArray);
        Reporter.log("Verifying the actual array with the expected array....", true);
    }

}

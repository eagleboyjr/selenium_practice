package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Todd on 11/6/2016.
 */
public class MultipleTestCase2 {
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass(){
        report = ExtentFactory.getInstance();
        test = report.startTest("Test 2 -> Verification");
    }
    @Test
    private void testMethod(){
        test.log(LogStatus.INFO, "Test2 -> testMethod Started...");
        test.log(LogStatus.INFO, "Test2 -> testMethod Continuing...");
        test.log(LogStatus.INFO, "Test2 -> testMethod Ended...");
    }

    @AfterClass
    public void afterClass(){
        report.endTest(test);
        report.flush();
    }

}

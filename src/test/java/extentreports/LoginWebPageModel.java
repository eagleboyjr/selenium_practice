package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import javafx.animation.Animation;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.classes.FormUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/6/2016.
 */
public class LoginWebPageModel {
    private WebDriver driver;
    private String baseURL;
    ExtentReports report;
    ExtentTest test;
    HomePage hp;

    @BeforeClass
    public void beforeClass(){
        report = ExtentFactory.getInstance();
        test = report.startTest("Verify Welcome Text");
        driver = new FirefoxDriver();
        hp = new HomePage(driver, test);
        baseURL = "http://letskodeit.com";
        test.log(LogStatus.INFO, "Browser Started....");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(baseURL);
        test.log(LogStatus.INFO, "Web Application opened....");
    }

    @Test
    public void test1_validLoginTest()throws Exception {
//        hp.clickSignupLink();
//        hp.clickLoginLink();
//        hp.enterEmail("test@email.com");
//        hp.enterPassword("abcabc");
//        hp.clickButton();
        hp.login("test@email.com", "abcabc");

        boolean textPresent = hp.isWelcomeTextPresent();

        Assert.assertTrue(textPresent);
        test.log(LogStatus.PASS, "Verified Welcome test.");

    }

    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(4000);
        driver.quit();
        report.endTest(test);
        report.flush();
    }

}

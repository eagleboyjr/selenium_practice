package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.classes.FormUtils;


import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/6/2016.
 */
public class SeleniumLoginTest {
    private WebDriver driver;
    private String baseURL;
    FormUtils formActions;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass(){
        report = new ExtentReports("c:/LogFiles/logintest.html");
        test = report.startTest("Verify Welcome Text");
        driver = new FirefoxDriver();
        baseURL = "http://letskodeit.com";
        test.log(LogStatus.INFO, "Browser Started....");
        formActions = new FormUtils(driver);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(baseURL);
        test.log(LogStatus.INFO, "Web Application opened....");

    }

    @Test
    public void test1_invalidCredentials()throws Exception {
        formActions.clickElement(By.id("comp-iiqg1vggactionTitle"));
        test.log(LogStatus.INFO, "Clicked on 'Sign up' link.");
        formActions.clickElement(By.id("signUpDialogswitchDialogLink"));
        test.log(LogStatus.INFO, "Clicked on 'Login' link.");
        formActions.fillTextField("test@email.com", By.xpath("//div[@id='memberLoginDialogemail']//input"));
        test.log(LogStatus.INFO, "Entered Email.");
        formActions.fillTextField("abcabc", By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        test.log(LogStatus.INFO, "Entered Password.");
        formActions.clickElement(By.xpath("//div[@id='memberLoginDialogoklink']"));
        test.log(LogStatus.INFO, "Clicked on 'Go' button.");

        WebElement welcomeText = null;

        try{
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
        test.log(LogStatus.PASS, "Verified Welcome test.");

    }

    @AfterClass
    public void tearDown(){
       // driver.quit();
        report.endTest(test);
        report.flush();
    }

}

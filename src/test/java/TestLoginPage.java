import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import extentreports.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.classes.LetsKodeItPage;
import utilities.classes.ExtentsUtils;
import utilities.classes.FormUtils;

import java.util.concurrent.TimeUnit;


/**
 * Created by Todd on 11/9/2016.
 */
public class TestLoginPage {
    private WebDriver driver;
    private String baseURL;
    ExtentReports report;
    ExtentTest test;
    LetsKodeItPage loginPage;

    @Parameters("browserType")
    @BeforeClass
    public void beforeClass(String browserType)throws Exception{
        report = ExtentsUtils.getInstance("c:/Reporting/report.html", true);
        test = report.startTest("Starting login Test");
        if(browserType.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserType.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        loginPage = new LetsKodeItPage(driver, test);

        baseURL = "http://letskodeit.teachable.com/";
        test.log(LogStatus.INFO, "Browser Started....");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(baseURL);
        test.log(LogStatus.INFO, "Web Application opened....");
        Thread.sleep(15000);

    }

    @Test
    public void loginTest()throws Exception{
        loginPage.clickLLogInLink();
        loginPage.enterEmail("test@test.com");
        loginPage.enterPassword("aswqffgtfddser");
        loginPage.clickLoginButton();


        boolean textPresent = loginPage.isInvalidLogonExist();

        Assert.assertTrue(textPresent);
        test.log(LogStatus.PASS, "Verified email validation.");
    }

    @AfterClass
    public void afterClass()throws Exception{
        Thread.sleep(4000);
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}

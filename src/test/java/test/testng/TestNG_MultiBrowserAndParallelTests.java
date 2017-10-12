package test.testng;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.classes.SearchPage;
import utilities.classes.ExtentsUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/31/2016.
 */
public class TestNG_MultiBrowserAndParallelTests {
    private WebDriver driver;
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;

    static Logger log = Logger.getLogger(TestNG_MultiBrowserAndParallelTests.class);
    @Parameters("browserType")
    @BeforeClass
    public void beforeClass(String browserType)throws Exception {
        report = ExtentsUtils.getInstance("c:/Reporting/report.html", true);
        test = report.startTest("Starting login Test");
        if(browserType.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserType.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        baseUrl = "http://www.expedia.com/";
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        PropertyConfigurator.configure("C:/Users/Todd/IdeaProjects/seleniumpractice/src/test/java/basicweb/log4j.properties");
        driver.get(baseUrl);
        Thread.sleep(2000);
    }

    @Test
    public void searchFlights() throws Exception {
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextbox(driver, "New York");
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        SearchPage.fillDepartureTextBox(driver, "12/12/2016");
        SearchPage.fillReturnTextBox(driver, "12/22/2016");
        SearchPage.selectFlightAdults(driver, "2");
    }


    @AfterClass
    public void tearDown() throws Exception{
        driver.close();
        Thread.sleep(2000);
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}

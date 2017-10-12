package test.testng;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;
import page.classes.SearchPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/28/2016.
 */
public class TestNG_TestSuite {
    private WebDriver driver;
    private String baseUrl;
    static Logger log = Logger.getLogger(TestNG_TestSuite.class);

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PropertyConfigurator.configure("C:/Users/Todd/IdeaProjects/seleniumpractice/src/test/java/basicweb/log4j.properties");
        driver.get(baseUrl);
    }

    @Test
    public void test1_fillBasicInfo() throws Exception {
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextbox(driver, "New York");
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        SearchPage.fillDepartureTextBox(driver, "12/25/2016");
        SearchPage.fillReturnTextBox(driver, "12/31/2016");

    }


    @Test
    public void test2_fillAdvancedInfo()throws Exception{
        SearchPage.clickOnAdvancedLink(driver);
        SearchPage.clickOnNonStopCheckBox(driver);
        SearchPage.selectFlightClass(driver, "first");
    }


    @AfterClass
    public void afterMethod(){


    }
}

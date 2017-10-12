import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.classes.ExpediaSearchPage;
import test.testng.TestNG_TestCase;
import utilities.classes.FormUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/1/2016.
 */
public class TestMyClass {
    static Logger log = Logger.getLogger(TestMyClass.class);
    private WebDriver driver;
    private String baseURL;
    FormUtils formsFields;
    ExpediaSearchPage expediaForm;
    ExpediaSearchPage expediaForm1;


    @BeforeClass
    public void setup(){
        PropertyConfigurator.configure("C:/Users/Todd/IdeaProjects/seleniumpractice/src/test/java/basicweb/log4j.properties");


        driver = new FirefoxDriver();
        baseURL = "https://www.expedia.com/";
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        formsFields = new FormUtils(driver);
        //expediaForm = new ExpediaSearchPage(driver);
        expediaForm = new ExpediaSearchPage(formsFields = new FormUtils(driver));
        driver.get(baseURL);
      }

    @Test
    public  void testClasses(){


        expediaForm.navigateToFlightsTab();
        //formsFields.clickElement(By.id("tab-flight-tab"));
//        formsFields.fillTextField("Chicago", By.id("flight-origin"));
//        formsFields.fillTextField("New York", By.id("flight-destination"));
//        formsFields.fillTextField("12/02/2016", By.id("flight-departing"));
//        formsFields.fillTextField("12/02/2016", By.id("flight-returning"));
//        formsFields.clickElement(By.id("search-button"));
        expediaForm.fillOriginTextbox("San Francisco");
        expediaForm.fillDestinationTextBox("New York");
        expediaForm.fillDepartureTextBox("12/17/2016");
        expediaForm.fillReturnTextBox("12/31/2016");
        expediaForm.clickOnAdvancedLink();
        expediaForm.clickOnNonStopCheckBox();
        expediaForm.selectFlightClass("business");
        expediaForm.clickOnSearchButton();
        expediaForm.clickMorningFlight();

    }


    @AfterClass
    public void teardown()throws Exception{
        Thread.sleep(15000);
        driver.close();
        driver.quit();
    }
}

package seleniumgridtesting;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.ExpediaPageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/22/2016.
 */
public class FrameworkTestCase {
    private WebDriver driver;
    private String baseURL;
    ExpediaPageFactory flightsPage;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        baseURL = "http://www.expedia.com";
        flightsPage = new ExpediaPageFactory(driver);

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(baseURL);
    }


    @Test
    public void test(){
        flightsPage.clickFlightsPageLink();
        flightsPage.departureCity("New York");
        flightsPage.destinationCity("San Francisco");
        flightsPage.departureDate("12/02/2016");
        flightsPage.returnDate("12/12/2016");
    }

    @AfterClass
    public void afterClass(){

    }

}

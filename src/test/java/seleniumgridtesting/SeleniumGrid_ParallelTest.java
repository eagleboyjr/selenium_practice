package seleniumgridtesting;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.ExpediaPageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/22/2016.
 */
public class SeleniumGrid_ParallelTest {
    private WebDriver driver;
    private String baseURL;
    private String nodeURL;
    ExpediaPageFactory flightsPage;


    @BeforeClass
    public void beforeClass() throws MalformedURLException{
        baseURL = "http://www.expedia.com";
        nodeURL = "http://192.168.56.104:5556/wd/hub";
        DesiredCapabilities vmCaps = DesiredCapabilities.firefox();
        vmCaps.setBrowserName("firefox");
        vmCaps.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(nodeURL), vmCaps);

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

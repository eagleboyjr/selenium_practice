package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.classes.SearchPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/29/2016.
 */
public class ThrowAway {

    WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Todd\\browserdrivers\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        baseURL="https://www.expedia.com";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void testMethod(){
        driver.get(baseURL);
        SearchPage.navigateToFlightsTab(driver);
        //@Param takes "first", "premium","economy", "business"
        SearchPage.clickOnAdvancedLink(driver);
        SearchPage.clickOnNonStopCheckBox(driver);
        SearchPage.selectFlightClass(driver, "business");
    }


    @After
    public void tearDown(){

    }
}

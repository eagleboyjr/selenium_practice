package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.classes.SearchPagesFacory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/25/2016.
 */
public class FrameworkTestCase {
    private WebDriver driver;
    private String baseURL;
    SearchPagesFacory searchPage;

    @Before
    public void setup() throws  Exception {
        driver = new FirefoxDriver();
        baseURL = "https://www.expedia.com/";
        searchPage = new SearchPagesFacory(driver);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws  Exception {
        driver.get(baseURL);
        Thread.sleep(3000);
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("New Orleans");
        searchPage.setDepartureDate("10/26/2016");
        searchPage.setReturnDate("11/04/2016");
        searchPage.clickSearchButton();
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(30000);
        driver.quit();
    }

}

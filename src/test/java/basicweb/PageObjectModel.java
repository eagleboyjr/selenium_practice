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
 * Created by Todd on 10/24/2016.
 */
public class PageObjectModel {
    private WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        baseURL = "https://www.expedia.com/";

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void  test() throws Exception {
        driver.get(baseURL);
        Thread.sleep(2000);
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextbox(driver, "Washington DC");
        SearchPage.fillDestinationTextBox(driver, "Seattle");
        SearchPage.departureTextBox(driver).sendKeys("11/05/2016");
        SearchPage.returnTextBox(driver).sendKeys("11/29/2016");
        SearchPage.clickOnSearchButton(driver);


    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(40000);
        driver.quit();
    }
}

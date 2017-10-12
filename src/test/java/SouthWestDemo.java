import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.SouthWestPage;
import utilities.classes.FormUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/2/2016.
 */
public class SouthWestDemo {
    WebDriver driver;
    String baseURL;
    SouthWestPage flightPage;
    FormUtils forms;
    private JavascriptExecutor js;


    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
      //  js = (JavascriptExecutor) driver;
        baseURL = "https://www.southwest.com/";
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        flightPage = new SouthWestPage(driver);
        driver.get(baseURL);

    }

    @Test
    public  void southWestHomePageTest(){
        flightPage.fillOriginTextbox("New York");
        flightPage.fillDestinationTextBox("San Antonio");
        flightPage.fillDepartureTextBox("12/5");
        flightPage.fillReturnTextBox("12/15");
        flightPage.selectFlightAdults("3");
        flightPage.clickOnSearchButton();
        flightPage.clickOnNonStopOutBoundCheckBox();
        flightPage.clickOnNonStopInBoundCheckBox();

    }


    @AfterClass
    public void tearDown()throws Exception{
        Thread.sleep(10000);
        driver.close();
        driver.quit();

    }
}

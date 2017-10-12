package test.testng;




import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.log4testng.Logger;
import page.classes.SearchPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/27/2016.
 */


public class TestNG_TestCase {
    private WebDriver driver;
    private String baseURL;
    static Logger log = Logger.getLogger(TestNG_TestCase.class);

    @BeforeMethod
    public void beforeMethod(){
        PropertyConfigurator.configure("C:\\Users\\Todd\\IdeaProjects\\seleniumpractice\\src\\test\\java\\basicweb\\log4j.properties");
        driver = new FirefoxDriver();
        baseURL ="https://www.expedia.com/";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }


    @Test
    public void testMethod(){
        driver.get(baseURL);
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextbox(driver, "New York");
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        SearchPage.fillDepartureTextBox(driver, "11/15/2016");
        SearchPage.fillReturnTextBox(driver, "11/29/2016");
    }


    @AfterMethod
    public void afterMethod(){
        driver.close();
        driver.quit();

    }
}

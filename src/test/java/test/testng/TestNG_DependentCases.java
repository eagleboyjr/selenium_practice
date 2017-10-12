package test.testng;

import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import  org.apache.log4j.Logger;
import page.classes.SearchPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/30/2016.
 */
public class TestNG_DependentCases {
    private WebDriver driver;
    private String baseUrl;

    static Logger log = Logger.getLogger(TestNG_DependentCases.class);
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com";
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PropertyConfigurator.configure("C:\\Users\\Todd\\IdeaProjects\\seleniumpractice\\src\\main\\resources\\log4j.properties");
        driver.get(baseUrl);
    }

    @Test
    public void searchFlights() throws Exception {
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextbox(driver, "New York");
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        SearchPage.fillDepartureTextBox(driver, "12/12/2016");
        SearchPage.fillReturnTextBox(driver, "12/22/2016");
        SearchPage.clickOnSearchButton(driver);
    }

    @Test(dependsOnMethods = {"searchFlights"}) //<-- Makes this test caes dependent on the first, so it won't run first.//
    //Selenium may run the test methods in alphabetical order.  That's why you may need the "dependsOnMethods" and "dependsOnGroups functions
    public void aSelectMorningFlight() throws Exception{
        //Thread.sleep(5000);
       SearchPage.clickMorningFlight(driver);
    }

    @AfterClass
    public void afterClass() {
    }
}

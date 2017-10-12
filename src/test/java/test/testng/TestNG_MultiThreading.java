package test.testng;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/4/2016.
 */
public class TestNG_MultiThreading {
    WebDriver driver;
    String baseURL;
    static Logger log = Logger.getLogger(TestNG_GoogleSearch.class);

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        baseURL="https://www.expedia.com";
        PropertyConfigurator.configure("C:\\Users\\Todd\\IdeaProjects\\seleniumpractice\\src\\main\\resources\\log4j.properties");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    public void searchText() throws Exception{
        String title = "Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares";
        log.info("[START] Thread Id : " +
                Thread.currentThread().getId() + "is started!");
        driver.get(baseURL);
        System.out.println("Page Title is " + driver.getTitle());
        Assert.assertEquals(title, driver.getTitle());
        log.info("[END] Thread Id: " +
                Thread.currentThread().getId() + " is ended");
    }

    @AfterMethod
    public void afterMethod() {
    }
}

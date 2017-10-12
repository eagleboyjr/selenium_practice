package test.testng;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/4/2016.
 */
public class TestNG_GoogleSearch {
    WebDriver driver;
    String baseURL;
    static Logger log = Logger.getLogger(TestNG_GoogleSearch.class);



    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        baseURL="https://www.google.com";
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        PropertyConfigurator.configure("C:\\Users\\Todd\\IdeaProjects\\seleniumpractice\\src\\main\\resources\\log4j.properties");
        driver.get(baseURL);
    }

    @Test(threadPoolSize = 3, invocationCount = 3)
    public void searchText() throws Exception{
        log.info("[START] Thread Id : " +
        Thread.currentThread().getId() + " is started!");
        driver.findElement(By.id("gs_lc0")).sendKeys("Java Multithreading");
        log.info("Element found and search for Java MultuThreading");
        driver.findElement(By.id("gs_lc0")).sendKeys(Keys.RETURN);
        log.info("[END] Thread Id: " +
        Thread.currentThread().getId() + " is ended");
    }

    @AfterMethod
    public void afterMethod() {
    }
}
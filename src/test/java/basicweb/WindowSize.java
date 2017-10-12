package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/19/2016.
 */
public class WindowSize {
    private WebDriver driver;
    private JavascriptExecutor js;


    @Before
    public void setup(){
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

    }

    @Test
    public void testJavaScriptExecution() throws Exception{
        //1. Go to website using Javascript
        js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice'");

        //Size of window
        long height = (Long) js.executeScript("return window.innerHeight;");
        long width = (Long) js.executeScript("return window.innerWidth;");

        System.out.println("Height is: " + height);
        System.out.println("Width is: " + width);

    }

    @After
    public void tearDown()throws Exception{
        driver.quit();
    }
}


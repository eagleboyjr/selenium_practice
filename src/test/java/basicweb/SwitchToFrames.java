package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/22/2016.
 */
public class SwitchToFrames {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor js;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        baseURL = "https://letskodeit.teachable.com/p/practice";
    }


    @Test
    public void test() throws Exception {
        Thread.sleep(2000);
        driver.get(baseURL);

        //Scroll down to iFrame
        WebElement iFrame = driver.findElement(By.id("courses-iframe"));
        js.executeScript("arguments[0].scrollIntoView(true);", iFrame);

        //Switch to iframe using "id"
        driver.switchTo().frame("courses-iframe");

        //Switch to iframe using using "name"
        //driver.switchTo().frame("iframe-name");

        //Switch to iframe using using a number
        //driver.switchTo().frame(0);

        //Locate Element and send text
        WebElement searchBox = driver.findElement(By.id("search-courses"));

        searchBox.sendKeys("Python");

        //Switch back to parent html
        driver.switchTo().defaultContent();

        //Scroll up to top
        WebElement scrollToTop = driver.findElement(By.cssSelector("div[class='view-school']"));
        js.executeScript("arguments[0].scrollIntoView(true);", scrollToTop);
        //navbar-brand header-logo
        Thread.sleep(2000);

        driver.findElement(By.id("name")).sendKeys("Test Successful");
    }

    @After
    public void tearDown() throws  Exception {
        Thread.sleep(6000);
        driver.quit();
    }

}

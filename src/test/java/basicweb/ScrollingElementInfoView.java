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
 * Created by Todd on 10/19/2016.
 */
public class ScrollingElementInfoView {
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
        Thread.sleep(2000);

       //2. Scroll down

        js.executeScript("window.scrollBy(0, 1470);");
        Thread.sleep(2000);

       // Scroll up
        js.executeScript("window.scrollBy(0, -1470);");
        Thread.sleep(2000);

        //Scroll Element into view
        WebElement element = driver.findElement(By.id("mousehover"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -190);");
    }

    @After
    public void tearDown()throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }
}

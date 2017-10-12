import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/22/2016.
 */
public class SwitchToAlertDialog {

    WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //1. Go to website


    }

    @Test
    public void test() throws InterruptedException{
        driver.get(baseURL);
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("Todd");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();
    }

    @Test
    public void test1() throws InterruptedException{
        driver.get(baseURL);
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("Todd");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();
        //alert.dismiss();
    }


    @After
    public void tearDown()throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }
}


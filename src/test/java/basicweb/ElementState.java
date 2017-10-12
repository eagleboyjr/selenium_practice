package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/16/2016.
 */
public class ElementState {

    WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        baseURL = "https://www.google.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        driver.get(baseURL);
        WebElement e1 = driver.findElement(By.id("gs_htif0"));
       // e1.sendKeys("letskodeit");
        System.out.println("E1 is enabled: " + e1.isEnabled());

        WebElement e2 = driver.findElement(By.id("gs_taif0"));
       //e2.sendKeys("letskodeit");
        System.out.println("E2 is enabled: " + e2.isEnabled());

        WebElement e3 = driver.findElement(By.id("lst-ib"));
        e3.sendKeys("letskodeit");
        System.out.println("E3 is enabled: " + e3.isEnabled());


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}

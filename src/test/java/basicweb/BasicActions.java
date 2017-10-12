package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/15/2016.
 */
public class BasicActions {
    WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test(){
        //1. Go to website
        driver.get(baseURL);
       // driver.findElement(By.cssSelector("a[href='/sign_in']")).click(); --better, but not taught just yet
        //2. Click Login button
        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        //3. Find and clear user id textbox
        driver.findElement(By.xpath("//input[@id='user_email']")).clear();
        //4. Enter text
        driver.findElement(By.id("user_email")).sendKeys("testmail@email.com");
        //5. Find a cleay Password field
        driver.findElement(By.xpath("//input[@id='user_password']")).clear();
        //5. Enter Password
        driver.findElement(By.id("user_password")).sendKeys("abcdefg");
    }

    @After
    public void tearDown()throws Exception{
       driver.quit();
    }

}

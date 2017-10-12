package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/19/2016.
 */
public class SwitchWindow {
    FirefoxDriver driver;
    String baseURL;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws Exception {
        driver.get(baseURL);
        //Get the window handle
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Handle is: " + parentHandle);

        //Find and click the Open Window button
        WebElement openWindow = driver.findElement(By.id("openwindow"));
        openWindow.click();

        //Get all handles
        Set<String> handles = driver.getWindowHandles();

        //Switching between handles

        for (String handle : handles){
            System.out.println(handle);
            if (!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                WebElement searchBox = driver.findElement(By.id("search-courses"));
                searchBox.sendKeys("Python");
                driver.findElement(By.id("search-course-button")).click();
                Thread.sleep(5000);
                driver.close();
                break;
            }

            //Switch back to parent window
            driver.switchTo().window(parentHandle);System.out.println(handle);
            if (!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                WebElement searchBox = driver.findElement(By.id("search-courses"));
                searchBox.sendKeys("Python");
                driver.findElement(By.id("search-course-button")).click();
                Thread.sleep(5000);
                driver.close();
                break;
            }

            //Switch back to parent window
            driver.switchTo().window(parentHandle);
            driver.findElement(By.id("name")).sendKeys("Test Successful");
        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}

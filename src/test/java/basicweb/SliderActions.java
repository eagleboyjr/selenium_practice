package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/24/2016.
 */
public class SliderActions {
    WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        baseURL = "https://jqueryui.com/slider/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testSlider()throws Exception{
        //1. Go to website
        driver.get(baseURL);
        driver.switchTo().frame(0);
        Thread.sleep(2000);

        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));

        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, 100, 0).perform();
        Thread.sleep(2000);


    }

    @After
    public void tearDown()throws Exception{
        driver.quit();
    }

}

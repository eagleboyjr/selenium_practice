package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/22/2016.
 */
public class MouseHoverAction {
    WebDriver driver;
    JavascriptExecutor js;
    String  baseURL;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test()throws  Exception{
        //1. Go to website
        driver.get(baseURL);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 800);");

        Thread.sleep(2000);

        WebElement mainElement = driver.findElement(By.id("mousehover"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mainElement).perform();
        Thread.sleep(2000);
        WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
        Thread.sleep(2000);
        actions.moveToElement(subElement).click().perform();


    }

    @After
    public void tearDown()throws Exception{
        Thread.sleep(4000);
        driver.quit();
    }
}

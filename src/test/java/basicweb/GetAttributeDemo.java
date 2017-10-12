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
public class GetAttributeDemo {
    private WebDriver driver;
    private String baseURL;


    @Before
    public void setup() throws Exception {
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testGetAttribute() throws Exception {
        driver.get(baseURL);

        WebElement element = driver.findElement(By.id("name"));
        String elementAttribute = element.getAttribute("placeholder");

        System.out.println("The attribute value is: " + elementAttribute);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}

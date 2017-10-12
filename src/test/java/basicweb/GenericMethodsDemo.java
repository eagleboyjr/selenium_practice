package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import usefulmethods.GenericMethodsOld;

/**
 * Created by Todd on 10/17/2016.
 */
public class GenericMethodsDemo {

    private WebDriver driver;
    private String baseURL;
    private GenericMethodsOld gm;


    @Before
    public void setup() throws Exception {
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        gm = new GenericMethodsOld(driver);


    }

    @Test
    public void testGenericMethodClass() throws Exception {
        driver.get(baseURL);

        //Our new class.
        WebElement element = gm.getElement("name", "id");
        element.sendKeys("test");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}

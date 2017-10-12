package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/17/2016.
 */
public class isElementPresentDemo {

    private WebDriver driver;
    private String baseURL;
    private GenericMethods gm;


    @Before
    public void setup() throws Exception {
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        gm = new GenericMethods(driver);


    }

    @Test
    public void testGenericMethodClass() throws Exception {
        driver.get(baseURL);

        //Our new class.

        boolean result = gm.isElementPresent("name", "id");
        System.out.println("Element present is: " + result);

        boolean result1 = gm.isElementPresent("name-not-present", "id");
        System.out.println("Element present is: " + result1);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}

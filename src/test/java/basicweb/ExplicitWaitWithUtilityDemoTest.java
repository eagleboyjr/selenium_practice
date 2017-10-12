package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utilities.classes.WaitTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Todd on 10/17/2016.
 */
public class ExplicitWaitWithUtilityDemoTest {
    private WebDriver driver;
    String baseURL;
    WaitTypes wt;


    @Before
    public void setup() throws Exception {
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/p/practice";
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();

    }

    @Test
    public void testGetTest() throws Exception {
        driver.get(baseURL);

        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement emailField = wt.waitForElement(By.id("user_email"), 5);

        //... We created the "waitForElement".  We don't need the two following lines anymore.
//        WebDriverWait wait = new WebDriverWait(driver, 3);
//        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));

        emailField.sendKeys("test");

        wt.clickWhenReady(By.name("commit"), 4);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        //driver.quit();
    }

}
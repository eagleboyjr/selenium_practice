package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.StringHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/17/2016.
 */
public class ExplicitWaitDemo {
    private WebDriver driver;
    String baseURL;

    @Before
    public void setup() throws Exception {
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/p/practice";

        driver.manage().window().maximize();

    }

    @Test
    public void testGetTest() throws Exception {
        driver.get(baseURL);

        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));

        emailField.sendKeys("test");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}

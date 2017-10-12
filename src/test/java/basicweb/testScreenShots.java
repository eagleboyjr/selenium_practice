package basicweb;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by Todd on 10/19/2016.
 */
public class testScreenShots {
    private WebDriver driver;
    String baseURL;

    @Before
    public void setup() throws Exception {
        driver = new FirefoxDriver();
        baseURL = "https://www.expedia.com";
        driver.manage().window().maximize();
    }

    @Test
    public void testGetTest() throws Exception {
        driver.get(baseURL);
        driver.findElement(By.id("tab-flight-tab")).click();


        //Find Elements
        WebElement flight_origin = driver.findElement(By.id("flight-origin"));
        WebElement flight_destination = driver.findElement(By.id("flight-destination"));
        WebElement departure_date = driver.findElement(By.id("flight-departing"));
        WebElement return_date = driver.findElement(By.id("flight-returning"));
        WebElement search = driver.findElement(By.id("search-button"));

        //Send data to elements
        flight_origin.sendKeys("New York");
        flight_destination.sendKeys("New York");
        departure_date.sendKeys("10/22/2016");
        return_date.clear();
        return_date.sendKeys("10/29/2016");

        search.click();
    }

    public static String getRandomString(int length){
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopABCDEFGHIJKLMNOP1234567890";

        for(int i=0; i< length; i++){
            int index = (int) Math.random() * characters.length();
            sb.append((characters.charAt(index)));
        }
        return sb.toString();
    }

    @After
    public void tearDown() throws Exception {
        String fileName = getRandomString(10) + ".png";
        String directory = "C:\\SeleniumFileData\\";

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));

        Thread.sleep(5000);
        driver.quit();
    }
}

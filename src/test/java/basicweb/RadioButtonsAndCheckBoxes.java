package basicweb;

import com.sun.org.apache.xpath.internal.SourceTree;
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
public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              RadioButtonsAndCheckBoxes {

    WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void setUp() throws Exception {
        driver.get(baseURL);
        WebElement bmwButtonSelect = driver.findElement(By.id("bmwradio"));
        bmwButtonSelect.click();

        Thread.sleep(2000);

        WebElement benzButtonSelect = driver.findElement(By.id("benzradio"));
        benzButtonSelect.click();

        Thread.sleep(2000);

        WebElement bmwCheckBoxSelect = driver.findElement(By.id("bmwcheck"));
        bmwCheckBoxSelect.click();

        Thread.sleep(2000);

        WebElement benzCheckBoxSelect = driver.findElement(By.id("benzcheck"));
        benzCheckBoxSelect.click();

        System.out.println("BMW Radio Button is selected? "  + bmwButtonSelect.isSelected());
        System.out.println("Benz Radio Button is selected? "  + benzButtonSelect.isSelected());
        System.out.println("BMW Checkbox is selected? " + bmwCheckBoxSelect.isSelected());
        System.out.println("Benz Checkbox is selected? " + benzCheckBoxSelect.isSelected());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();


    }
}

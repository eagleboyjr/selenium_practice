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
public class ElementDisplayed {

    WebDriver driver;
    String baseURL1;
    String baseURL2;


    @Before
    public void setup(){
        driver = new FirefoxDriver();
        baseURL1 = "https://letskodeit.teachable.com/p/practice";
        baseURL2 = "https://www.expedia.com/";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLetsKodeIt() throws InterruptedException{
        driver.get(baseURL1);
        WebElement textBox = driver.findElement(By.id("displayed-text"));
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(3000);

        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        hideButton.click();
        System.out.println("Clicked on hide button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(3000);

        WebElement showButton = driver.findElement(By.id("show-textbox"));
        showButton.click();
        System.out.println("Clicked on show button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());
    }

    @Test
    public void testExpedia(){
        driver.get(baseURL2);

        WebElement childDropdown = driver.findElement(By.id("package-1-age-select-1"));
        System.out.println("Child Dropdown is Displayed: " + childDropdown.isDisplayed());
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }

}

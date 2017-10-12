package basicweb;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Todd on 10/13/2016.
 */
public class FIndByLinkTextDemo {


    public static void main(String[] args) throws Exception{
        WebDriver driver;
        driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        String baseURL ="http://demostore.x-cart.com";
        driver.manage().window().maximize();
        driver.get(baseURL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Superhero Mom Mug")));
        WebElement link = driver.findElement(By.linkText("Superhero Mom Mug"));
        link.click();

        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("Ghostbusters")).click();


        //driver.findElement(By.xpath(".//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[3]/a/span")).click(); -- works fine

        // WebElement link = driver.findElement(By.xpath(".//*[@class='collapse navbar-collapse']/ul/li/a/span[text()='Shipping']")); -- Works fine
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span[text()='Shipping']")));

       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Vinyl Idolz: Ghostbusters [Wholesale prices]")));
        //Assert.assertTrue("Ghostbusters link should exist!!", driver.findElements(By.partialLinkText("Vinyl Idolz:")).size() > 0);




    }
}

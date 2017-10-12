package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Todd on 10/13/2016.
 */
public class idNameDemo {
    public static void main(String[] args){

        WebDriver driver;
        driver = new FirefoxDriver();
        String baseURL ="http://www.google.com";
        driver.manage().window().maximize();
        driver.get(baseURL);

        WebElement googleTexBox = driver.findElement(By.id("lst-ib"));
        googleTexBox.clear();
        googleTexBox.sendKeys("letskodeit");
        WebElement gSearchButton = driver.findElement(By.name("btnG"));
        gSearchButton.click();


    }
}

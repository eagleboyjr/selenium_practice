package driverlisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Todd on 11/21/2016.
 */
public class WDEListeners {

    public static void main(String[] args){
        String baseURL="https://www.expedia.com/";
        WebDriver driver = new FirefoxDriver();

        EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
        HandleEvents he = new HandleEvents();
        edriver.register(he);

        edriver.get(baseURL);
        edriver.findElement(By.id("tab-flight-tab")).click();
    }
}

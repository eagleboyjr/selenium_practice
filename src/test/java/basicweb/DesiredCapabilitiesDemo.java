package basicweb;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Todd on 10/12/2016.
 */
public class DesiredCapabilitiesDemo {



    public static void main(String[] args) throws Exception{

        WebDriver driver;
        String baseURL = "https://letskodeit.teachable.com/pages/practice";
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setBrowserName("firefox");
        caps.setPlatform(Platform.WIN10);

        driver = new FirefoxDriver(caps);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
}


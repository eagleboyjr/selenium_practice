package utilities.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by Todd on 11/14/2016.
 */
public class LocalDriverFactory {
            public static WebDriver createInstance(String browserName) {
            WebDriver driver = null;
            if (browserName.toLowerCase().contains("firefox")) {
                driver = new FirefoxDriver();
                System.out.println("Firing up Firefox Driver.....");
                return driver;
            }
            if (browserName.toLowerCase().contains("internet")) {
                driver = new InternetExplorerDriver();
                return driver;
            }
            if (browserName.toLowerCase().contains("chrome")) {
                driver = new ChromeDriver();
                System.out.println("Firing up Chrome Driver.....");
                return driver;
            }
            return driver;
        }
}

package utilities.classes;

import org.openqa.selenium.WebDriver;

/**
 * Created by Todd on 11/14/2016.
 */
public class LocalDriverManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}

package profiles;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo {

    public static void main(String[] args) {
        // http://chromedriver.storage.googleapis.com/index.html
        String baseURL = "http://www.google.com";
        WebDriver driver;
        //System.setProperty("webdriver.chrome.driver", "/Users/<username>/Documents/workspace_personal/selenium/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\Todd\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\jliednjgoljbdkbmbbafkdaheckejdjo\\0.10.0_0.crx"));

        driver = new ChromeDriver(options);
        driver.get(baseURL);
    }
}
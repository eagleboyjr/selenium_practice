package testpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Todd on 10/12/2016.
 */
public class FirefoxDriverDemo {
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();
        String baseURL = "https://letskodeit.teachable.com/pages/practice";
        driver.get(baseURL);

    }
}

package testpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Todd on 10/12/2016.
 */
public class ChromeDriverWindow {

    public static void main(String[] args){

        //Setting driver to open Chrome
        //You can set the ChromeDriver file path using the System.setProperty method:
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Todd\\browserdrivers\\bin\\chromedriver.exe");
        // You can also set your path in as a system variable in windows, which I've done.

        //You can set the ChromeDriver file path using the System.setProperty method:
        System.setProperty("webdriver.ie.driver", "C:\\Users\\Todd\\browserdrivers\\bin\\IEDriverServer.exe");
        // You can also set your path in as a system variable in windows, which I've done.

        //Setting driver to open IE
        WebDriver driver = new ChromeDriver();
        String baseURL ="https://www.google.com";
        driver.get(baseURL);
    }
}

package testpack;

import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by Todd on 10/12/2016.
 */
public class FirstTestClass {

    WebDriver driver;

    enum BROWSER {
        chrome, explorer, firefox, edge;
    }

    @Before
    public void setDriver(){
        String browserName = System.getenv("browser");
        BROWSER browsertype = BROWSER.valueOf(browserName);
        switch(browsertype) {
            case chrome:
                driver = new ChromeDriver();
                break;
            case firefox:
                driver = new FirefoxDriver();
                break;
            case explorer:
                driver = new InternetExplorerDriver();
                break;
            case edge:
                driver = new EdgeDriver();
                break;
            default:
                driver = new FirefoxDriver();
        }

    }



}

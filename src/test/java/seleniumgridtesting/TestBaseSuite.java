package seleniumgridtesting;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import page.classes.ExpediaPageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/26/2016.
 */
public class TestBaseSuite {
    protected WebDriver driver;
    protected ExpediaPageFactory search;

    @Parameters({"platform", "browser", "version", "url"})
    @BeforeClass(alwaysRun = true)
    public  void setup(String platform, String browser, String version, String url)throws Exception{
        driver= getDriverInstance(platform, browser, version, url);
        search = PageFactory.initElements(driver, ExpediaPageFactory.class);
    }

    public static WebDriver getDriverInstance(String platform, String browser, String version, String url) throws MalformedURLException {
        WebDriver driver = null;
        String nodeURL = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Platforms
        if(platform.equalsIgnoreCase("Windows10")){
            capabilities.setPlatform(Platform.WIN10);
            nodeURL = "http://192.168.56.101:5555/wd/hub";
        }else if(platform.equalsIgnoreCase("MacOS")){
            capabilities.setPlatform(Platform.MAC);
            nodeURL = "http://192.168.56.102:5555/wd/hub";
        }else if(platform.equalsIgnoreCase("Windows8")){
            capabilities.setPlatform(Platform.WIN8_1);
        }else if(platform.equalsIgnoreCase("Windows7")){
            capabilities.setPlatform(Platform.WINDOWS);
        }

        //Browser
        if (browser.equalsIgnoreCase("firefox")){
            capabilities=DesiredCapabilities.firefox();
        }else if(browser.equalsIgnoreCase("chrome")){
            capabilities=DesiredCapabilities.chrome();
        }else if(browser.equalsIgnoreCase("ie11")){
            capabilities=DesiredCapabilities.internetExplorer();
        }else if(browser.equalsIgnoreCase("edge")){
            capabilities=DesiredCapabilities.edge();
        }else if(browser.equalsIgnoreCase("safari")){
        capabilities=DesiredCapabilities.safari();
        }

        //Version
        capabilities.setVersion(version);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);

        //Setup Driver
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //Open Browser and go to Website
        driver.get(url);
        return driver;
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}

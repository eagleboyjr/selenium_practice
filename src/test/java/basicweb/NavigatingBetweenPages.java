package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/16/2016.
 */
public class NavigatingBetweenPages {
    WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        //1. Go to website
        driver.get(baseURL);
        //2. Get title of web page
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        //3. Get current URL of web page
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentURL);

        //4. Instansiate URL String
        String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?reset_purchase_session=1";
        System.out.println("Navigating to login page...");
        //5. Navigate to the new URL String
        driver.navigate().to(urlToNavigate);

        //6. Get current URL
        currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentURL);

        Thread.sleep(2000);

        //5. Navigate back to the original URL
        driver.navigate().back();
        System.out.println("Navigating back...");
        currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentURL);

        Thread.sleep(2000);

        //6. Navigate forward once again.
        driver.navigate().forward();
        System.out.println("Navigating forward...");
        currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentURL);

        Thread.sleep(2000);

        //7. Navigate back to the original URL
        driver.navigate().back();
        System.out.println("Navigating back...");
        currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentURL);

        //8. Refresh the page
        driver.navigate().refresh();
        System.out.println("Refreshing page...");

        //9. Retrieve page source
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

    }

    @After
    public void tearDown()throws Exception{
        driver.quit();
    }
}

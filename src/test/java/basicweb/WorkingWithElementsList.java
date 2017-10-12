package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/16/2016.
 */
public class WorkingWithElementsList {
    WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test()throws Exception {
        boolean isChecked = false;
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type, 'radio') and contains(@name,'cars')]"));
        int listSize = radioButtons.size();
        System.out.println("Radio button array size is: " + listSize);

        for(int i=0; i  < listSize; i++ ){
            isChecked = radioButtons.get(i).isSelected();

            if(!isChecked){
                radioButtons.get(i).click();
                Thread.sleep(2000);
            }
        }

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}

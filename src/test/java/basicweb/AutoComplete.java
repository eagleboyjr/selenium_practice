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
 * Created by Todd on 10/18/2016.
 */
public class AutoComplete {
    private WebDriver driver;
    private  String baseURL;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        baseURL = "https://www.southwest.com/";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testAutoComplete() throws  Exception{
        driver.get(baseURL);
        String searchText = "New Orleans, LA - MSY";
        String partialText = "New";

        //Send test to "Departure" field
        WebElement text = driver.findElement(By.id("air-city-departure"));
        text.sendKeys(partialText);

        //Locate autocomplete dropdown
//        WebElement elementList = driver.findElement(By.xpath("//ul[@id='air-city-departure-menu']"));
//        System.out.println(elementList);
        //Pull results from drop down window
        List<WebElement> results = driver.findElements(By.cssSelector("li[id^='air-city-departure-menu-item']"));

        int size = results.size();
        System.out.println("The size of the list is: " + size);

        for(int i=0; i < size; i++){
            System.out.println(results.get(i).getText());
        }

        Thread.sleep(3000);

        for(WebElement result : results){
            if(result.getText().equals(searchText)){
                result.click();
                break;
            }
        }

    }

    @After
    public void tearDown() throws  Exception {
        Thread.sleep(3000);
        driver.quit();

    }

}

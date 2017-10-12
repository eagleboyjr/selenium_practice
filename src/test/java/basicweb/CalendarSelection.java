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
public class CalendarSelection
{
    private WebDriver driver;
    private String baseUrl1;


    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        baseUrl1 = "https://www.expedia.com/";

    }

    //@Test - first test won't run if commented out
    public void test(){
        driver.get(baseUrl1);
        //Click Flight Tab
        WebElement flightsTab = driver.findElement(By.id("tab-flight-tab"));
        flightsTab.click();
        //Click Departure Field
        WebElement departingField = driver.findElement(By.id("flight-departing"));
        departingField.click();
        //Select Date in Calendar
        WebElement selectDate = driver.findElement(By.cssSelector("button[data-month='9'][data-day='31']"));
        selectDate.click();

    }

    @Test
    public void test1() {
        driver.get(baseUrl1);
        //Click Flight Tab
        WebElement flightsTab = driver.findElement(By.id("tab-flight-tab"));
        flightsTab.click();
        //Click Departure Field
        WebElement departingField = driver.findElement(By.id("flight-departing"));
        departingField.click();
        WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"));

        List<WebElement> allValidDates = calMonth.findElements(By.cssSelector("button[class='datepicker-cal-date']"));
        System.out.println(allValidDates.size());

        for (WebElement date: allValidDates) {
            if(date.getText().equals("30")){
                date.click();
                break;
            }
        }
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(6000);
        driver.quit();

    }
}

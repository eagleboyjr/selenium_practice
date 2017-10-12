package page.classes;

import org.apache.log4j.Appender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;
import utilities.classes.WaitTypes;
import utilities.classes.FormUtils;

/**
 * Created by Todd on 11/1/2016.
 */
public class ExpediaSearchPage {
    static Logger log = Logger.getLogger(ExpediaSearchPage.class);
    static WebDriver driver;
    public static WebElement element = null;

    static  FormUtils formUtils;
    static WaitTypes wait;

    /**
     *  Returns the flight origin text box element
     *  @param driver
     *  @return
     */

    public ExpediaSearchPage(WebDriver driver){
        this.driver=driver;
        wait= new WaitTypes(driver);
    }

    public ExpediaSearchPage(Object obj ){
         Object formUtils = obj;
    }


    public static void fillOriginTextbox(String s){
        wait.waitForElement(By.id("flight-origin"),15);
        formUtils.fillTextField(s, By.id("flight-origin"));
        log.info("Enter Origin City as " + s);
    }

    /**
     *  Returns the flight destination text box element
     *  @param //driver
     *  @return
     */


    public static void fillDestinationTextBox (String s){
        formUtils.fillTextField(s, By.id("flight-destination"));
        log.info("Enter Destination City as " + s);
    }

    /**
     *  Returns the departure date text box element
     *  @param //driver
     *  @return
     */

    public static void fillDepartureTextBox(String s){
        formUtils.fillTextField(s, By.id("flight-departing"));
        log.info("Enter Departure Date as " + s);
    }

    /**
     *  Returns the return date text box element
     *  @param //driver
     *  @return
     */

    public static void  fillReturnTextBox(String s){
        formUtils.fillTextField(s, By.id("flight-returning"));
        log.info("Enter Return Date as " + s);
    }

    /**
     *  Returns the search box button element
     *  @param driver
     *  @return
     */


    /**
     *  Click the search button
     *  @param
     */

    public static void clickOnSearchButton (){
        formUtils.clickElement(By.id("search-button"));
        log.info("Search Button Clicked.");
    }

    /**
     *  Navigate to flights tab
     *  @param //driver
     */

    public static void navigateToFlightsTab(){
        formUtils.clickElement(By.id("tab-flight-tab"));
        log.info("Navigate to Flights page");
    }

    public static void clickOnAdvancedLink(){
        formUtils.clickElement(By.id("advanced-options"));
        log.info("Advanced link clicked");
    }

    public static void clickOnNonStopCheckBox(){
        formUtils.clickElement(By.id("advanced-flight-nonstop"));
        log.info("Non-stop checkbox clicked.");
    }

    public static void selectFlightClass(String s){
        formUtils.selectDropdown(s, By.id("flight-advanced-preferred-class"));
        log.info("Flight Class " + s + " selected.");
    }
    public static void clickMorningFlight(){
        wait.getWhenClickable(By.xpath(".//*[@id='leg0-morning-departure']"), 90);
        log.info("Clicked on Morning Time to filter results.");
    }

    public static void clearAllFields(WebDriver driver){
        driver.findElement(By.id("flight-origin")).clear();
        driver.findElement(By.id("flight-destination")).clear();
        driver.findElement(By.id("flight-departing")).clear();
        driver.findElement(By.id("flight-returning")).clear();
    }
    public static void selectFlightAdults(String s){
        formUtils.clickElement(By.id("flight-adults"));
        log.info("Selected number of adults for flight: " + s);
    }
}

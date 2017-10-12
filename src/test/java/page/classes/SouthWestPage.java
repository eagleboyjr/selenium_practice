package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;
import utilities.classes.FormUtils;
import utilities.classes.WaitTypes;

/**
 * Created by Todd on 11/2/2016.
 */
public class SouthWestPage {
    static Logger log = Logger.getLogger(SouthWestPage.class);
    static WebDriver driver;
    public static WebElement element = null;

    static FormUtils formUtils;
    static WaitTypes wait;

    /**
     *  Returns the flight origin text box element
     *  @param driver
     *  @return
     */

    public SouthWestPage(WebDriver driver){
        this.driver=driver;
        wait = new WaitTypes(driver);
       // formUtils = new FormUtils(driver);
    }
    //works with statement: "flightPage = new SouthWestPage(forms = new FormUtils(driver));"
    public SouthWestPage(Object obj ){
        Object formUtils = obj;
    }


    public static void fillOriginTextbox(String s){
        formUtils.fillTextField(s, By.id("air-city-departure"));
        log.info("Enter Origin City as " + s);
    }

    /**
     *  Returns the flight destination text box element
     *  @param
     *  @return
     */


    public static void fillDestinationTextBox (String s){
        formUtils.fillTextField(s, By.id("air-city-arrival"));
        log.info("Enter Destination City as " + s);
    }

    /**
     *  Returns the departure date text box element
     *  @param
     *  @return
     */

    public static void fillDepartureTextBox(String s){
        formUtils.fillTextField(s, By.id("air-date-departure"));
        log.info("Enter Departure Date as " + s);
    }

    /**
     *  Returns the return date text box element
     *  @param
     *  @return
     */

    public static void  fillReturnTextBox(String s){
        formUtils.fillTextField(s, By.id("air-date-return"));
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
        formUtils.clickElement(By.id("jb-booking-form-submit-button"));
        log.info("Search Button Clicked.");
    }

    /**
     *  Navigate to flights tab
     *  @param
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

    public static void clickOnNonStopOutBoundCheckBox(){
        wait.getWhenClickable(By.id("direct_outboundFilter"), 10);
    }

    public static void clickOnNonStopInBoundCheckBox(){
        wait.getWhenClickable(By.id("direct_inboundFilter"), 90);
    }


    public static void clearAllFields(WebDriver driver){
        driver.findElement(By.id("flight-origin")).clear();
        driver.findElement(By.id("flight-destination")).clear();
        driver.findElement(By.id("flight-departing")).clear();
        driver.findElement(By.id("flight-returning")).clear();
    }
    public static void selectFlightAdults(String s){
        formUtils.clickElement(By.id("air-pax-count-adults"));
        formUtils.typeAndEnterOption(s, By.xpath("//div[@class='js-number-selector-value number-selector--value']"));
        log.info("Selected number of adults for flight: " + s);
    }
}

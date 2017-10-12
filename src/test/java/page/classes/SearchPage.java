package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;
import utilities.classes.WaitTypes;

/**
 * Created by Todd on 10/24/2016.
 */
public class SearchPage {
    public static WebElement element = null;
    static Logger log = Logger.getLogger(SearchPage.class);

    /**
     *  Returns the flight origin text box element
     *  @param driver
     *  @return
     */

    public static WebElement originTextBox(WebDriver driver){
        element = driver.findElement(By.id("flight-origin"));
        log.info("Origin TextBox Element found.");
        return element;
    }

    public static void fillOriginTextbox(WebDriver driver, String s){
        element = originTextBox(driver);
        element.sendKeys(s);
        log.info("Enter Origin City as " + s);
    }

    /**
     *  Returns the flight destination text box element
     *  @param driver
     *  @return
     */

    public static WebElement destinationTextBox(WebDriver driver){
        element = driver.findElement(By.id("flight-destination"));
        log.info("Destination TextBox Element found.");
        return element;
    }

    public static void fillDestinationTextBox (WebDriver driver, String s){
        element = destinationTextBox(driver);
        element.sendKeys(s);
        log.info("Enter Destination City as " + s);
    }

    /**
     *  Returns the departure date text box element
     *  @param driver
     *  @return
     */

    public static WebElement departureTextBox(WebDriver driver){
        element = driver.findElement(By.id("flight-departing"));
        log.info("Departure Field Element found.");
        return element;
    }

    public static void fillDepartureTextBox(WebDriver driver, String s){
        element = departureTextBox(driver);
        element.sendKeys(s);
        log.info("Enter Departure Date as " + s);
    }

    /**
     *  Returns the return date text box element
     *  @param driver
     *  @return
     */

    public static WebElement returnTextBox(WebDriver driver){
        element = driver.findElement(By.id("flight-returning"));
        log.info("Return Field Element found.");

        return element;
    }

    public static void  fillReturnTextBox(WebDriver driver, String s){
        element = returnTextBox(driver);
        element.sendKeys(s);
        log.info("Enter Return Date as " + s);
    }

    /**
     *  Returns the search box button element
     *  @param driver
     *  @return
     */

    public static WebElement searchButton(WebDriver driver){
        element = driver.findElement(By.id("search-button"));
        log.info("Search ButtonElement Found.");
        return element;
    }

    /**
     *  Click the search button
     *  @param driver
     */

    public static void clickOnSearchButton (WebDriver driver){
        element = searchButton(driver);
        element.click();
        log.info("Search Button Clicked.");
    }

    /**
     *  Navigate to flights tab
     *  @param driver
     */

    public static void navigateToFlightsTab(WebDriver driver){
        //driver.findElement(By.id("header-history")).click();
        element = driver.findElement(By.id("tab-flight-tab-hp"));
        element.click();
        log.info("Navigate to Flights page");
    }

    public static void clickOnAdvancedLink(WebDriver driver){
        element = driver.findElement(By.id("advanced-options"));
        element.click();
        log.info("Advanced link clicked");
    }

    public static void clickOnNonStopCheckBox(WebDriver driver){
        element = driver.findElement(By.id("advanced-flight-nonstop"));
        element.click();
        log.info("Non-stop checkbox clicked.");
    }

    public static void selectFlightClass(WebDriver driver, String s){
       Select options = new Select(driver.findElement(By.id("flight-advanced-preferred-class")));
        options.selectByValue(s);
        log.info("Flight Class " + s + " selected.");
    }
    public static void clickMorningFlight(WebDriver driver){
        WebElement element = WaitTypes.getWhenVisible(driver,
                By.xpath(".//*[@id='leg0-morning-departure']"), 30);
        element.click();
        log.info("Clicked on Morning Time to filter results.");
    }

    public static void clearAllFields(WebDriver driver){
        driver.findElement(By.id("flight-origin")).clear();
        driver.findElement(By.id("flight-destination")).clear();
        driver.findElement(By.id("flight-departing")).clear();
        driver.findElement(By.id("flight-returning")).clear();
    }
    public static void selectFlightAdults(WebDriver driver, String s){
        Select options = new Select(driver.findElement(By.id("flight-adults")));
        options.selectByValue(s);
        log.info("Selected number of adults for flight: " + s);
    }
}


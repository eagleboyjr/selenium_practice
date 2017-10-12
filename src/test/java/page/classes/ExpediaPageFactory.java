package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.classes.WaitTypes;

/**
 * Created by Todd on 11/22/2016.
 */
public class ExpediaPageFactory {
    static WebDriver driver;
    static WaitTypes wait = new WaitTypes(driver);

    public ExpediaPageFactory(WebDriver driver){
        this.driver=driver;
        //PageFactory.initElements(driver, this);
    }

    @FindBy(id="flight-origin")
    static WebElement cityDeparture;

    @FindBy(id="flight-destination")
    static WebElement cityDestination;

    @FindBy(id="flight-departing")
    static WebElement departureDate;

    @FindBy(id="flight-returning")
    static WebElement returnDate;

    @FindBy(id="tab-flight-tab")
    static WebElement flightsLink;



    static public void clickFlightsPageLink(){
        flightsLink.click();
    }

    static public void departureCity(String s){
        cityDeparture.clear();
        cityDeparture.sendKeys(s);
    }

    static public void destinationCity(String s){
        cityDestination.clear();
        cityDestination.sendKeys(s);
    }

    static public void departureDate(String s){
        departureDate.clear();
        departureDate.sendKeys(s);
    }

    static public void returnDate(String s){
        returnDate.clear();
        returnDate.sendKeys(s);
    }
}

package page.classes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/25/2016.
 */
public class SeachPageFactory {

    @FindBy(id="tab-flight-tab")
    WebElement flightTab;

    @FindBy(id="flight-type-roundtrip-label")
    WebElement roundTrip;

    @FindBy(id="flight-type-multi-dest-label")
    WebElement multipleDestination;

    public void clickFlightsTab(){
        flightTab.click();
    }

    public void roundTrip(){
        roundTrip.click();
    }

    public void multipleDestination(){
        multipleDestination.click();
    }

}


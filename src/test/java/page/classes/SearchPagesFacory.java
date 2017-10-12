package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Todd on 10/25/2016.
 */
public class SearchPagesFacory {
    WebDriver driver;

    @FindBy(id="header-history")
    WebElement headerHistory;

    @FindBy(id="tab-flight-tab")
    WebElement flightTab;

    @FindBy(id="flight-origin")
    WebElement originCity;

    @FindBy(id="flight-destination")
    WebElement destinationCity;

    @FindBy(id="flight-departing")
    WebElement departureDate;

    @FindBy(id="flight-returning")
    WebElement returnDate;

    @FindBy(id="search-button")
    WebElement searchButton;

    public SearchPagesFacory(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFlightsTab(){
        headerHistory.click();
        flightTab.click();
    }

    public void setOriginCity(String origin){
        originCity.sendKeys(origin);
    }

    public void setDestinationCity(String destDate){
        destinationCity.sendKeys(destDate);
    }

    public void setDepartureDate(String departDate){
        departureDate.sendKeys(departDate);
    }
    public void setReturnDate(String retDate){
        returnDate.sendKeys(retDate);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

}

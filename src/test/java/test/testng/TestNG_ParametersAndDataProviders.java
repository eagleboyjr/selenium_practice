package test.testng;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;
import page.classes.SearchPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/31/2016.
 */
public class TestNG_ParametersAndDataProviders {
    private WebDriver driver;
    private String baseURL;
    static Logger log = Logger.getLogger(TestNG_ParametersAndDataProviders.class);


    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        baseURL="https://www.expedia.com/";
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        PropertyConfigurator.configure("C:/Users/Todd/IdeaProjects/seleniumpractice/src/test/java/basicweb/log4j.properties");

        driver.get(baseURL);
    }

    /**
    This method allows you to run the test multiple times with different inputs. We are using
    the "searchFlightsWithMultiData" method for this example.
    **/
    @DataProvider(name="fieldsInputs")
    public static Object[][] searchData(){
        return new Object[][]{{"New York","Chicago", "11/29/2016", "12/03/2016"},
                {"New York","Boston", "12/26/2016", "1/06/2017"}};
    }

    // This method relies the TestNGParamters.xml to retrieve the varaiables.
    @Parameters({"origin", "dest", "depDate", "retDate"})
    @Test
    public void searchFlights(String origin, String dest, String depDate, String retDate) throws Exception{
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextbox(driver, origin);
        SearchPage.fillDestinationTextBox(driver, dest);
        SearchPage.fillDepartureTextBox(driver, depDate);
        SearchPage.fillReturnTextBox(driver, retDate);
    }


    @Test(dataProvider = "fieldsInputs")
    public void searchFlightsWithMultiData(String origin, String dest, String depDate, String retDate)throws  Exception{
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.clearAllFields(driver);
        Thread.sleep(3000);
        SearchPage.fillOriginTextbox(driver, origin);
        SearchPage.fillDestinationTextBox(driver, dest);
        SearchPage.fillDepartureTextBox(driver, depDate);
        SearchPage.fillReturnTextBox(driver, retDate);
        Thread.sleep(3000);
    }


    @AfterClass
    public void afterClass(){

    }



}

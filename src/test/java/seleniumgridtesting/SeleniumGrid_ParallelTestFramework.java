package seleniumgridtesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by Todd on 11/26/2016.
 */
public class SeleniumGrid_ParallelTestFramework extends TestBaseSuite{

    @BeforeClass
    public void beforeClass() throws MalformedURLException{

    }

    @Test
    public void searchFlights() throws Exception{
        search.clickFlightsPageLink();
        search.departureCity("New York");
        search.destinationCity("San Francisco");
        search.departureDate("12/02/2016");
        search.returnDate("12/12/2016");

    }

    @AfterClass
    public void tearDown() throws Exception{

    }
}

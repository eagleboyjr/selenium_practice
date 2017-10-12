import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 12/16/2016.
 */
public class TableauRefresh {

    private WebDriver driver;
    private String URL;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        URL = "https://public.tableau.com/profile/cesar.picco#!/vizhome/Whatsflyingovermyhouse/planespotting";
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    @Test
    public void testing(){
        driver.get(URL);
    }
}

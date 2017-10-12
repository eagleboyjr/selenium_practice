package basicweb;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.classes.SearchPage;

public class UsingLog4j {
    static Logger log = Logger.getLogger(UsingLog4j.class);
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {
        PropertyConfigurator.configure("C:\\Users\\Todd\\IdeaProjects\\seleniumpractice\\src\\test\\java\\basicweb\\log4j.properties");
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        SearchPage.navigateToFlightsTab(driver);
        //log.info("Navigate to flights tab");
        SearchPage.fillOriginTextbox(driver, "New York");
        //log.info("Enter origin city");
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        //log.info("Enter destination city");
        SearchPage.departureTextBox(driver).sendKeys("12/25/2014");
        //log.info("Enter departure date");
        SearchPage.returnTextBox(driver).sendKeys("12/31/2014");
        //log.info("Enter return date");
    }

    @After
    public void tearDown() throws Exception {
    }
}
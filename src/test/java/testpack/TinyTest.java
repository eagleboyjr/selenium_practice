package testpack;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.apache.log4j.Logger;
import page.classes.TinyTestPage;
import test.testng.TestNG_DependentCases;
import utilities.classes.LocalDriverFactory;
import utilities.classes.LocalDriverManager;

import java.util.concurrent.TimeUnit;


/**
 * Created by Todd on 11/10/2016.
 */
public class TinyTest {
    private WebDriver driver;
    private TinyTestPage forms;
    String baseURL;
    static Logger log = Logger.getLogger(TinyTest.class);


    @Parameters("browserType")
   @BeforeClass
    public void beforeClass(String browserType) throws Exception{
        driver = LocalDriverFactory.createInstance(browserType);
        LocalDriverManager.setWebDriver(driver);

        PropertyConfigurator.configure("C:\\Users\\Todd\\IdeaProjects\\seleniumpractice\\src\\main\\resources\\log4j.properties");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

       baseURL = "http://southwest.com";
       LocalDriverManager.getDriver().get(baseURL);
        forms = new TinyTestPage( LocalDriverManager.getDriver());

        // driver.get(baseURL);
        System.out.println("This is @BeforeClass.......");

   }

   @Test
    public void testMethod() throws Exception{

       forms.fillOriginTextbox("Boston");
       forms.fillDestinationTextBox("Orlando");
       forms.fillDepartureTextBox("12/12");
       forms.fillReturnTextBox("12/22");
       System.out.println("This is @Test.......");
   }

   @AfterClass
    public void afterClass()throws Exception{
//        Thread.sleep(5000);
//        driver.quit();
       System.out.println("This is @AfterClass.......");
    }

    public void invokeBrowers(){

    }

}

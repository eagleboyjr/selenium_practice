package test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.classes.FormUtils;
import utilities.classes.TakeScreenshots;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/6/2016.
 */
public class TestNG_ScreenShotOnFailure {
    WebDriver driver;
    String baseURL;
    FormUtils formActions;

    @BeforeMethod
    public void setup() throws Exception{
        driver = new FirefoxDriver();
        baseURL = "http://www.letskodeit.com";
        formActions = new FormUtils(driver);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(baseURL);
     }

     @Test
    public void test1_invalidCredentials()throws Exception {
         formActions.clickElement(By.id("comp-iiqg1vggactionTitle"));
         formActions.clickElement(By.id("signUpDialogswitchDialogLink"));
         formActions.fillTextField("test@email.com", By.xpath("//div[@id='memberLoginDialogemail']//input"));
         formActions.fillTextField("abcabc", By.xpath("//div[@id='memberLoginDialogpassword']//input"));
         formActions.clickElement(By.xpath("//div[@id='memberLoginDialogoklink']"));

         WebElement welcomeText = null;

         try{
             welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
         }
         catch (NoSuchElementException e){
             System.out.println(e.getMessage());
         }
         Assert.assertTrue(welcomeText != null);
    }

    @AfterMethod
    public  void tearDown(ITestResult testResult)throws IOException{
        if(testResult.getStatus() == ITestResult.FAILURE){
            TakeScreenshots.setFilePath("c:/LogFiles");
            TakeScreenshots.screenShots(driver, testResult.getName());
        }
        driver.quit();
    }

}

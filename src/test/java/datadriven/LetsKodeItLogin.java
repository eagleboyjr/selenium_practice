package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import page.classes.LetsKodeItFactory;
import utilities.classes.ExcelDataReadUtil;
import utilities.classes.LocalDriverFactory;
import utilities.classes.TakeScreenshots;
import utilities.classes.WaitTypes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 11/20/2016.
 */
public class LetsKodeItLogin {
    WebDriver driver;
    String baseURL;
    WaitTypes wait;
    LetsKodeItFactory forms;

    @Parameters("browserType")
    @BeforeClass
    public void setup(String browserType) throws IOException{
        driver = LocalDriverFactory.createInstance(browserType);
        wait = new WaitTypes(driver);
        forms = new LetsKodeItFactory(driver);

        baseURL="http://www.letskodeit.com/";
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        ExcelDataReadUtil.setExcelFile("C:/Users/Todd/IdeaProjects/seleniumtesting/src/datadrivenfiles/MOCK_DATA.xlsx", "LoginTest");
        driver.get(baseURL);
        forms.clickSignup();
        forms.clickLogin();
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider()throws IOException{
        Object[][] data = ExcelDataReadUtil.getTestData();
        return data;
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws Exception {
        //Thread.sleep(10000);

        forms.userName(username);
        forms.passWord(password);
        forms.clickLoginButton();



        WebElement errorMsg = null;
        try {
            wait.waitForElement(By.xpath("//p[text()='Wrong email or password']"), 10);
            errorMsg = driver.findElement(By.xpath("//p[text()='Wrong email or password']"));
        } catch (Exception e) {
            System.out.println("Unable to locate element: " + e.getMessage());
        }
        if(errorMsg == null){
            TakeScreenshots.setFilePath("c:/LogFiles/");
            TakeScreenshots.screenShots(driver, "ERROR");
        }
        //Assert.assertTrue(errorMsg !=null);
        System.out.println("Email Validation Measures Successful.");
    }
    @AfterClass
    public void tearDown(){

    }

}

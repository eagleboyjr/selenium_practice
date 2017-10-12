import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import utilities.classes.*;

import java.io.IOException;

/**
 * Created by Todd on 11/15/2016.
 */
public class LetsKodItLoginTest {
    private WebDriver driver;
    private String baseURL;
    private FormUtils formActions;
    private WaitTypes wait;

    @Parameters("browserType")
    @BeforeClass
    public void setup(String browserType) throws IOException {
        driver = LocalDriverFactory.createInstance(browserType);
        LocalDriverManager.setWebDriver(driver);

        baseURL = "https://letskodeit.teachable.com/";
        LocalDriverManager.getDriver().get(baseURL);
        formActions = new FormUtils(LocalDriverManager.getDriver());
        wait = new WaitTypes(LocalDriverManager.getDriver());
        ExcelDataReadUtil.setExcelFile("c:/SeleniumDataFiles/MOCK_DATA.xlsx", "LoginTest");
    }

    @DataProvider(name = "loginTestData")
    public Object[][] dataProvider() throws IOException {
        Object[][] testData = ExcelDataReadUtil.getTestData();
        return testData;
    }


    @Test(dataProvider = "loginTestData")
    public void loginTest(String username, String password) throws Exception{

        formActions.clickElement(By.xpath(".//*[@id='navbar']/div/div/div/ul/li[2]/a"));
        wait.waitForElement(By.xpath(".//*[@id='user_email']"), 10);
        formActions.fillTextField(username, By.xpath(".//*[@id='user_email']"));
        formActions.fillTextField(password, By.xpath("//div/input[@id='user_password']"));
        formActions.clickElement(By.name("commit"));

        //isAvailable(WebElement var) -- to create later
        WebElement invalidEmail = null;

        try{
            wait.waitForElement(By.xpath("//div[contains(text(),' Invalid email or password')]"), 10);
            invalidEmail = driver.findElement(By.xpath("//div[contains(text(),' Invalid email or password')]"));

        }catch(Exception e){
            System.out.println("Login Element not found: " + e.getMessage());
        }
        Assert.assertTrue(invalidEmail !=null);
        System.out.println("Email Validation Measures Successful.");
    }

    @AfterClass
    public void tearDown() throws Exception{


    }


}

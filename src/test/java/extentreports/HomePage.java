package extentreports;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.classes.FormUtils;

/**
 * Created by Todd on 11/7/2016.
 */
public class HomePage {
    private static WebDriver driver;
    static FormUtils formActions;
    static ExtentTest test;

    public HomePage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        formActions = new FormUtils(driver);
        this.test = test;
    }

    public static void clickSignupLink(){
        formActions.clickElement(By.id("comp-iiqg1vggactionTitle"));
        test.log(LogStatus.INFO, "Clicked on 'Sign up' link.");
    }

    public static void clickLoginLink(){
        formActions.clickElement(By.id("signUpDialogswitchDialogLink"));
        test.log(LogStatus.INFO, "Clicked on 'Login' link.");
    }

    public static void enterEmail(String s){
        formActions.fillTextField(s, By.xpath("//div[@id='memberLoginDialogemail']//input"));
        test.log(LogStatus.INFO, "Entered Email.");
    }

    public static void enterPassword(String s){
        formActions.fillTextField(s, By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        test.log(LogStatus.INFO, "Entered Password.");
    }

    public static void clickButton() {
        formActions.clickElement(By.xpath("//div[@id='memberLoginDialogoklink']"));
        test.log(LogStatus.INFO, "Clicked on 'Go' button.");
    }

    public boolean isWelcomeTextPresent() {
        WebElement welcomeText = null;
        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
            if (welcomeText != null) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public void login(String email, String password){
        clickSignupLink();
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        clickButton();
    }
}

package page.classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.classes.FormUtils;
import utilities.classes.WaitTypes;
import utilities.classes.ExtentsUtils;

/**
 * Created by Todd on 11/9/2016.
 */
public class LetsKodeItPage {

    private static WebDriver driver;
    private static FormUtils formActions;
    private static WaitTypes wait;
    static ExtentTest test;

    public LetsKodeItPage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
        formActions = new FormUtils(driver);
        wait = new WaitTypes(driver);
    }

    public static void clickLearnNowButton(){
        formActions.clickElement(By.xpath("//span[text()='Learn Now']"));
        test.log(LogStatus.INFO, "Clicked 'Learn now' button.`");
    }
    public static void clickLLogInLink(){
        wait.getWhenClickable(By.xpath("//a[@href='/sign_in']"), 5);
        //formActions.clickElement(By.xpath("//a[@href='/sign_in']"));
        test.log(LogStatus.INFO, "Clicked 'Login' link.");
    }

    public static void enterEmail(String s){
        formActions.fillTextField(s,By.id("user_email") );
        test.log(LogStatus.INFO, "Entered Email.");
    }

    public static void enterPassword(String s){
        formActions.fillTextField(s, By.id("user_password"));
        test.log(LogStatus.INFO, "Entered Password.");
    }

    public static void clickLoginButton(){
        formActions.clickElement(By.name("commit"));
        test.log(LogStatus.INFO, "Clicked on 'Log In' button.");
    }

    public boolean isInvalidLogonExist() {
        WebElement invalidLogin = null;
        try {
            invalidLogin = driver.findElement(By.xpath("//div[contains(text(), ' Invalid email or password')]"));
            if (invalidLogin != null) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            test.log(LogStatus.ERROR, e.getMessage());
            return false;
        }
        return false;
    }

    public static void logIntoPage(String email, String password){
        clickLearnNowButton();
        clickLLogInLink();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }


}

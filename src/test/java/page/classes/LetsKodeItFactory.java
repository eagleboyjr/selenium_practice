package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.classes.WaitTypes;

/**
 * Created by Todd on 11/20/2016.
 */
public class LetsKodeItFactory {

    static WebDriver driver;
    static WaitTypes wait =new WaitTypes(driver);

    @FindBy(id="comp-iiqg1vggactionTitle")
    static  WebElement signupLink;

    @FindBy(id="signUpDialogswitchDialogLink")
    static WebElement loginLink;

    @FindBy(xpath="//div[@id='memberLoginDialogemail']//input")
    static  WebElement email;

    @FindBy(xpath="//div[@id='memberLoginDialogpassword']//input")
    static  WebElement password;

    @FindBy(id="memberLoginDialogoklabel")
    static  WebElement loginButton;

    public LetsKodeItFactory(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void clickLoginButton(){
        loginButton.click();
    }
    public static void clickSignup(){
        wait.waitForElement(By.id("comp-iiqg1vggactionTitle"),10);
        signupLink.click();
    }

    public static void clickLogin(){
        wait.waitForElement(By.id("signUpDialogswitchDialogLink"),10);
        loginLink.click();
    }

    public static void userName(String username){
        email.clear();
        email.sendKeys(username);
    }
    public static void passWord(String passwd){
        password.clear();
        password.sendKeys(passwd);
    }

}

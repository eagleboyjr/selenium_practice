package utilities.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Todd on 10/17/2016.
 */
public class WaitTypes {
    public static WebDriver driver;
    static WebElement element= null;

    public WaitTypes(WebDriver driver){
        this.driver = driver;
    }

    public static WebElement getWhenVisible(WebDriver driver, By by, int i) {
        WebElement element= null;
        WebDriverWait wait = new WebDriverWait(driver, i);
        element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }


    public WebElement waitForElement(By locator, int timeout){
        WebElement element = null;
        try {
            System.out.println("Waiting for max: " + timeout + " seconds for element to be available");

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element appeared on the web page.");

        }catch(Exception e){
            System.out.println("Element not visible after " + timeout + " seconds");
        }

        return element;
    }

    public void clickWhenReady(By locator, int timeout){

        try {
            System.out.println("Waiting for max: " + timeout + " seconds for element to be available");

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element is now clickable on the web page.");
            element.click();
        }catch(Exception e){
            System.out.println("Element not visible after " + timeout + " seconds");
        }

    }

    public static void getWhenClickable(By by, int i) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, i);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            element.click();
            System.out.println("Element has been clicked....");
        }catch (Exception e){
            System.out.println("Element not visible after " + i + " seconds"  +
                    ". Error message: " + e.getMessage());
        }
    }
}

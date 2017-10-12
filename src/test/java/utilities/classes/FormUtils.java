package utilities.classes;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Todd on 11/1/2016.
 */
public class FormUtils {

    public static WebDriver driver;
    public static WebElement element = null;

    public FormUtils(WebDriver driver){
        this.driver=driver;
    }

    public FormUtils(Object obj){
        Object wait = obj;
    }

    public static void fillTextField(String text, By by){
        try {
            element = driver.findElement(by);
            element.clear();
            element.sendKeys(text);
        }catch(Exception e){
            System.out.println("fillTextField failed with error: " + e.getMessage());
        }
    }

    public static void clickElement(By by){
        try {
            element = driver.findElement(by);
            element.click();
        }catch(Exception e){
            System.out.println("ClickElement failed with error: " + e.getMessage());
        }
    }

    public static void selectDropdown(String option, By by){
        try {
            Select options = new Select(driver.findElement(by));
            options.selectByValue(option);
        }catch(Exception e){
            System.out.println("selectDropdown failed with error: " + e.getMessage());
        }
    }

    public static String getElementText(By by) {
        element = driver.findElement(by);
        return element.getText();
    }

    public static void typeAndEnterOption (String text, By by){
        try {
            element = driver.findElement(by);
            element.sendKeys(text);
            element.sendKeys(Keys.RETURN);
        }catch (Exception e){
            System.out.println("typeAndEnterOption failed with error " + e.getMessage());
        }
    }

}

package usefulmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Todd on 10/17/2016.
 */
public class GenericMethods {

    WebDriver driver;

    public GenericMethods(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(String locator, String type){
        type = type.toLowerCase();

        if(type.equals("id")){
            System.out.println("Element found with id: " + locator);
            return  this.driver.findElement(By.id(locator));
        }else if(type.equals("xpath")){
            System.out.println("Element found with xpath: " + locator);
            return  this.driver.findElement(By.xpath(locator));
        }else if(type.equals("css")){
            System.out.println("Element found with cssSelector: " + locator);
            return  this.driver.findElement(By.cssSelector(locator));
        } else {
            System.out.println("Locator type noe found");
            return null;
        }
    }

    public List<WebElement> getElementList(String locator, String type){
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<WebElement>();
        if(type.equals("id")){
            elementList = this.driver.findElements(By.id(locator));
        }else if(type.equals("xpath")){
            elementList = this.driver.findElements(By.xpath(locator));
        }else if(type.equals("css")){
            elementList = this.driver.findElements(By.cssSelector(locator));
        } else {
            System.out.println("Locator type not found");
        }
        if(elementList.isEmpty()){
            System.out.println("Element not found with " + type + ": " + locator);
        } else {
            System.out.println("Element found with " + type + ": " + locator);
        }
        return elementList;
    }

    public boolean isElementPresent(String locator, String type){
        List<WebElement> elementList = getElementList(locator,type);

        int size = elementList.size();
        if (size> 0){
            return true;
        }else {
            return false;
        }
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
            WebElement element = null;
            System.out.println("Waiting for max: " + timeout + " seconds for element to be available");

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element is now clickable on the web page.");
            element.click();
        }catch(Exception e){
            System.out.println("Element not visible after " + timeout + " seconds");
        }

    }
}

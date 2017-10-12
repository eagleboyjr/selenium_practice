package usefulmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Todd on 10/17/2016.
 */
public class GenericMethodsOld {

    WebDriver driver;

    public GenericMethodsOld(WebDriver driver){
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
        if(type.equals("id")){
            System.out.println("Element found with id: " + locator);
            return  this.driver.findElements(By.id(locator));
        }else if(type.equals("xpath")){
            System.out.println("Element found with xpath: " + locator);
            return  this.driver.findElements(By.xpath(locator));
        }else if(type.equals("css")){
            System.out.println("Element found with cssSelector: " + locator);
            return  this.driver.findElements(By.cssSelector(locator));
        } else {
            System.out.println("Locator type not found");
            return null;
        }
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
}

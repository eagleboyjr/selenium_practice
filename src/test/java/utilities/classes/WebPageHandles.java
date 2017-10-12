package utilities.classes;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by Todd on 11/2/2016.
 */
public class WebPageHandles {
    static WebDriver driver;

    public WebPageHandles(WebDriver driver){
        this.driver=driver;
    }
    public void getAndCloseWindow (String parentHandle){

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            System.out.println(handle);
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentHandle);
    }

}

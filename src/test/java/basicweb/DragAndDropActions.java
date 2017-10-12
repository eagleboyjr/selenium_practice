package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Todd on 10/23/2016.
 */
public class DragAndDropActions {
    WebDriver driver;
    String baseURL;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        baseURL = "https://jqueryui.com/droppable/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testDragAndDrop()throws Exception{
        //1. Go to website
        driver.get(baseURL);
        Thread.sleep(2000);
        //2. Locate iFrame
        driver.switchTo().frame(0);

        //3. Locate draggable element
        WebElement draggable = driver.findElement(By.id("draggable"));

        //4. Locate droppable element
        WebElement droppable = driver.findElement(By.id("droppable"));

        //5. Instantiate "Actions" class
        Actions action = new Actions(driver);

        //6a. Actions Drag and drop method
        //action.dragAndDrop(draggable, droppable).build().perform();


        //6b. Actions ClickAnHold,MoveElementTo and Release methods
        action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();


        Thread.sleep(2000);



    }

    @After
    public void tearDown()throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }
}

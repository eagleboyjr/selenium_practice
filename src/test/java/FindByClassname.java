import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Todd on 10/14/2016.
 */
public class FindByClassname {

    public static void main(String[] args){

        WebDriver driver;
        driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        String baseURL ="http://demostore.x-cart.com";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.findElement(By.className("xcart-link")).click();

    }
}

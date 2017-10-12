package utilities.classes;

import org.apache.commons.io.FileUtils;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by Todd on 11/6/2016.
 */
public class TakeScreenshots {
   static WebDriver driver;
    static String filePath;
     public TakeScreenshots(WebDriver driver){
        this.driver = driver;
    }

     public static String screenShots(WebDriver driver, String fileName)throws IOException{
        fileName = fileName + ".png";
        String directory = filePath;
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        String destination  = directory + fileName;
        return destination;
    }

    public static void setFilePath(String filePaths){
        filePath = filePaths;

    }
}

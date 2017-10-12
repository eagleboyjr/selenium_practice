package utilities.classes;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * Created by Todd on 11/9/2016.
 */
public class ExtentsUtils {

    public static ExtentReports getInstance(String path, boolean append){
        ExtentReports extent;
        extent = new ExtentReports(path, append);
        extent
                .addSystemInfo("Selenium Version", "2.68")
                .addSystemInfo("Platform", "Windows 10");
        return extent;
    }

}

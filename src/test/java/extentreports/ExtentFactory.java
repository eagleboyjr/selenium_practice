package extentreports;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * Created by Todd on 11/6/2016.
 */
public class ExtentFactory {
    public static ExtentReports getInstance(){
        ExtentReports extent;
        String path = "c:/LoginFiles/report-demo.html";
        extent = new ExtentReports(path, false);
        extent
                .addSystemInfo("Selenium Version", "2.68")
                .addSystemInfo("Platform", "Windows 10");
        return extent;
    }
}

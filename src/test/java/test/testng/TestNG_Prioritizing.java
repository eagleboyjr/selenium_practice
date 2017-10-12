package test.testng;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.testng.annotations.*;

/**
 * Created by Todd on 10/30/2016.
 */
public class TestNG_Prioritizing {
    @BeforeClass
    public void beforeClass(){
        System.out.println("@BeforeClass runs before the class.");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("@BeforeMethod runs before every method.");
    }

    @Test(priority = 0)
    public void BMW3Series(){
        System.out.println("Running Test 1 - BMW3 Series.");
    }

    @Test(priority = 1)
    public void BMWX3(){
        System.out.println("Running Test 2 - BMW3 X3.");
    }

    @Test(priority = 2, enabled = false)// You can disable @Test cases using prioritization//
    public void AudiA6(){
        System.out.println("Running Test 3 - Audi A6.");
    }

    @Test(priority = 3)
    public void HondaAccord(){
        System.out.println("Running Test 4 - Honda Accord.");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("@AfterMethod runs after every method.");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("@After Class runs after the class");
    }

}

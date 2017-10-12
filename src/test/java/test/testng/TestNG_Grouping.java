package test.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Todd on 10/30/2016.
 */
public class TestNG_Grouping {

    @BeforeClass
    public void beforeClass(){
        System.out.println("@BeforeClass runs before the class.");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("@BeforeMethod runs before every method.");
    }

    @Test(groups={"Sedan", "BMW"})
    public void BMW3Series(){
        System.out.println("Running Test - BMW3 Series.");
    }

    @Test(groups={"SUV", "BMW"})
    public void BMWX3(){
        System.out.println("Running Test - BMW3 X3.");
    }

    @Test(groups={"Sedan", "Audi"})
    public void AudiA6(){
        System.out.println("Running Test - Audi A6.");
    }

    @Test(groups={"Sedan", "Honda"})
    public void HondaAccord(){
        System.out.println("Running Test - Honda Accord.");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("@AfterMethod runs after every method.");
    }


}

package basicweb;

import org.junit.*;

/**
 * Created by Todd on 10/15/2016.
 */
public class JUnitIntroduction {

    @BeforeClass
    public static void setupBeforeClass()throws Exception {
        System.out.println("Executed before class...");

    }

    @AfterClass
    public static void tearDownAfterClass()throws Exception {
        System.out.println("Executed after class...");

    }

    @Before  //Runs before every test
    public void setup(){
        System.out.println("Executed before test....");

    }

    @Test
    public void test(){
        System.out.println("Executed Test1...");
    }

    @Test
    public void test1(){
        System.out.println("Executed Test2...");
    }

    @Test
    public void test2(){
        System.out.println("Executed Test3...");
    }

    @After //Runs after every test
    public void tearDown(){
        System.out.println("Executed after test....");


    }

}

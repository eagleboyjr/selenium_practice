package basicweb;


import org.apache.log4j.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Todd on 10/26/2016.
 */
public class DemoLogging {

    static Logger log = Logger.getLogger(DemoLogging.class);
    static Appender append;

    @BeforeClass
    public static void setUpBeforeClass() throws  Exception {
        final PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("%d{yyyy-mm-dd} --%-10p %c -%m%n");
        append = new ConsoleAppender(layout);
        log.addAppender(append);

        log.setLevel(Level.INFO);

        log.info("Running before method");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        log.debug("Running after Method");
    }

    @Test

    public void test(){
        log.info("Running test method");
    }

}

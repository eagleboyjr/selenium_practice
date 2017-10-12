package basicweb;


import com.oracle.webservices.internal.api.message.PropertySet;

import org.apache.log4j.*;

import java.util.Properties;

/**
 * Created by Todd on 10/25/2016.
 */
public class LoggingDemo {
    static Logger log = Logger.getLogger(LoggingDemo.class);
    static Appender append;

    /**
     * Debug
     * Info
     * Warn
     * Error
     * Fatal
     * VM Argument: -Dlog4j.debug=true
     */

    public static void main(String [] args){
        append = new ConsoleAppender(new SimpleLayout());
        log.addAppender(append);
        PropertyConfigurator.configure("C:\\Users\\Todd\\IdeaProjects\\seleniumpractice\\src\\main\\resources\\log4j.properties");

        log.info("This message is an info");
        runMethod();
        log.debug("This message is a debug");
    }

    public static void runMethod() {
        log.info("This is from runMethod");
    }
}

package iTWO_Utilities;

import com.aventstack.extentreports.ExtentTest;
import iTWO_Listeners.ExtentReportListeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class Log extends ExtentReportListeners {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    //Initialize Log4j instance
    private static final Logger Log =  LogManager.getLogger(Log.class);
    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }
    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }
    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }
    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }
    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }


    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}


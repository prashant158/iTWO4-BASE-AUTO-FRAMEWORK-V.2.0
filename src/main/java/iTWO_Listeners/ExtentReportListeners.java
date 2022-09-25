package iTWO_Listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Connect_ConfigReader.ConfigReader;
import iTWO_Factory.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;


public class ExtentReportListeners extends DriverFactory implements ITestListener {

    private static final String OUTPUT_FOLDER = "./ExtentTestReport/";
    private static final String FILE_NAME = "AutomationTestReport.html";
    //public static boolean extentTest;
    public static ExtentTest extentTest = null;

    private static File fileConfig;
    public static ExtentReports extent = init();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    public static ExtentReports extentReports;
    public static ConfigReader config;
    
    private static ExtentReports init() {

        Path path = Paths.get(OUTPUT_FOLDER);
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        config = new ConfigReader();
        extentReports = new ExtentReports();
        fileConfig = new File("src/main/resources/spark-config.xml");
        //ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company Name", config.getCompanyName());
        extentReports.setSystemInfo("System Name", config.getSystemName());
        extentReports.setSystemInfo("Project Name", config.getProjectName());
        extentReports.setSystemInfo("Browser Name", config.getBrowser());
        extentReports.setSystemInfo("Test URL", config.getStagingURL());
        extentReports.setSystemInfo("Server Name", config.getServerName());
        extentReports.setSystemInfo("Build Version", config.getVersion());
        extentReports.setSystemInfo("Username", config.getUsername());
        extentReports.setSystemInfo("Password", config.getPassword());
        return extentReports;
    }

    public synchronized void onStart(ITestContext context) {
        System.out.println("Test Suite started!");
    }

    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Test Suite is ending!"));
        extent.flush();
        test.remove();
    }

    public synchronized void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String qualifiedName = result.getMethod().getQualifiedName();
        int last = qualifiedName.lastIndexOf(".");
        int mid = qualifiedName.substring(0, last).lastIndexOf(".");
        String className = qualifiedName.substring(mid + 1, last);

        System.out.println(methodName + " started!");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());

        extentTest.assignCategory(result.getTestContext().getSuite().getName());

        extentTest.assignCategory(className);

        test.set(extentTest);
        test.get().getModel().setStartTime(getTime(result.getStartMillis()));
    }

    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass(MarkupHelper.createLabel("Test passed ==>> " + result.getMethod().getMethodName(), ExtentColor.GREEN));
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));

    }

    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail("Test failed ==>> " + result.getMethod().getMethodName());
        test.get().fail(MarkupHelper.createLabel("Test failed ==>> " + result.getMethod().getMethodName(), ExtentColor.RED));
        try {
            test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath("." + getScreenshot()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(MarkupHelper.createLabel("Test Skipped ==>> " + result.getMethod().getMethodName(), ExtentColor.BLUE));
        try {
            test.get().skip(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath("." +getScreenshot()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
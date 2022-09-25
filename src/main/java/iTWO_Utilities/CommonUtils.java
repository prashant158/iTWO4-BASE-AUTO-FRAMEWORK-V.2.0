package iTWO_Utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import iTWO_Listeners.ExtentReportListeners;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
    public static String resultsFolder;
    public static void logWithoutScreenshot(WebDriver driver, Status status, String message) {
        if (ExtentReportListeners.extentTest!=null)
            ExtentReportListeners.extentTest.log(status,message);
    }

    public static void logWithScreenshot(WebDriver driver,Status status, String message) throws Exception {
        if (ExtentReportListeners.extentTest!=null)
        {
            ExtentReportListeners.extentTest.log(status,"<b>"+message+"</b>", MediaEntityBuilder.createScreenCaptureFromPath(CommonUtils.takeScreenshot(driver)).build());
        }
    }

    public static String takeScreenshot(WebDriver driver) throws Exception {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File( resultsFolder+ "\\" + Constants.SCREENSHOT_FOLDER + "\\" + getCurrentTimeStamp() + ".jpg");
            FileUtils.copyFile(scrFile, destFile);
            Log.info("Stored screenshot in file:" + destFile.getAbsolutePath());
            return destFile.getAbsolutePath();
        } catch (Exception e) {
            Log.error(e.getMessage());
            throw new Exception();
        }
    }


    public static String createOutputFolder() {
        boolean isTest = false;
        String strTimeStamp = getCurrentTimeStamp();
        String strFolderName = Constants.LOG_FOLDER_PREFIX + "_" + strTimeStamp;
        String strWorkingDir = Constants.USER_DIR;
        File objOutputFolder = null;
        if (isTest) {
            objOutputFolder = new File(strWorkingDir + "\\TEST_OUTPUT_FOLDER");
        } else {
            objOutputFolder = new File(strWorkingDir + "\\Results\\"+ strFolderName);
            if (!objOutputFolder.exists()) {
                if (objOutputFolder.mkdirs()) {
                    File objScreenshotFolder = new File(objOutputFolder.getAbsolutePath() + "\\" + Constants.SCREENSHOT_FOLDER);
                    if (objScreenshotFolder.mkdir()) {
                        System.out.println("Screenshot folder is created : " + objScreenshotFolder.getAbsolutePath());
                    }
                } else {
                    System.out.println("Failed to create TestOutputFolder!");
                }
            }
        }
        if (objOutputFolder != null) {
            resultsFolder = objOutputFolder.getAbsolutePath();
            return objOutputFolder.getAbsolutePath();
        } else {
            return strWorkingDir;
        }
    }

    public static String getCurrentTimeStamp() {

        SimpleDateFormat sdfDate = new SimpleDateFormat(Constants.FILE_SUFFIX_DATE_FORMAT);
        Date now = new Date();
        String strTimeStamp = sdfDate.format(now);
        Log.info(strTimeStamp);
        return strTimeStamp;
    }


}

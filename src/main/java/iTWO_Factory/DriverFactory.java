package iTWO_Factory;

import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver baseWebDriver;
    public static JavascriptExecutor jsDriver;
    public static NgWebDriver ngWebDriver;
    public JavascriptExecutor executor;
    public  Properties prop;

    public WebDriver BrowserFactory(String BrowserName) {

        if(BrowserName.equalsIgnoreCase("Chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--lang=en","--disable-notifications");
            //options.addArguments("headless");
            WebDriverManager.chromedriver().setup();
            baseWebDriver = new ChromeDriver(options);
            jsDriver =(JavascriptExecutor) baseWebDriver;
            ngWebDriver = new NgWebDriver(jsDriver);
            //baseWebDriver.manage().deleteAllCookies();
            baseWebDriver.manage().window().maximize();
            baseWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        }
        else if(BrowserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            baseWebDriver = new FirefoxDriver();
            jsDriver =(JavascriptExecutor) baseWebDriver;
            ngWebDriver = new NgWebDriver(jsDriver);
            baseWebDriver.manage().deleteAllCookies();
            baseWebDriver.manage().window().maximize();
        }
        else {
            System.out.println("Driver Not Supported");
        }
        return baseWebDriver;
    }

    public WebDriver getDriver() {

        return baseWebDriver;
    }

    public void setDriver(WebDriver driver) {
        this.baseWebDriver = driver;
    }


    public String getScreenshot() {
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
       // String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";

       String path = "./ExtentTestReport/screenshots/" + System.currentTimeMillis() + ".png";

        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public Properties init_properties(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/iTWO_ConfigData/Config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }



    public Properties init_prop() {
        prop = new Properties();
        FileInputStream ip = null;

        String envName = System.getProperty("env");// qa/dev/stage/uat

        if (envName == null) {
            System.out.println("Running on PROD env: ");
            try {
                ip = new FileInputStream("./src/test/resources/iTWO_ConfigData/Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Running on environment: " + envName);
            try {
                switch (envName.toLowerCase()) {
                    case "qa":
                        ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
                        break;
                    case "dev":
                        ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
                        break;
                    case "stage":
                        ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
                        break;
                    case "uat":
                        ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
                        break;

                    default:
                        System.out.println("please pass the right environment.....");
                        break;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }




}

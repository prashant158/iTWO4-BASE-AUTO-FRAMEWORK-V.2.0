package CCS_ConnectScripts;

import Connect_ConfigReader.ConfigReader;
import iTWO_Factory.DriverFactory;
import iTWO_testContext.TestContextUI;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

@Epic("Epic 001: Testing Basic Preparation module in iTWO4.O")
@Story("US  001: Test Case covered Create Project and create COS instance")

public class _01_BaseClass extends DriverFactory {
    public ConfigReader config;
    public static WebDriver webDriver;
    public static TestContextUI testContextUI;

    @BeforeTest
    public void init() {
        config = new ConfigReader();
        webDriver = BrowserFactory(config.getBrowser()); // invoke
        webDriver.get(config.getStagingURL());// passing url
        testContextUI = new TestContextUI();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
    }

    @AfterTest
    public void tearDown() {
        webDriver.close();
    }
}




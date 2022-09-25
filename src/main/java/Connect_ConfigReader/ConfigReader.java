package Connect_ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties pro;


    public ConfigReader() {

        File src = new File("./src/test/resources/iTWO_ConfigData/Config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);

        } catch (Exception e) {
            System.out.println("Not able to load config file");
        }
    }


    public String getDataFromConfig(String keyToSearch) {

        return pro.getProperty(keyToSearch);

    }

    public String getProjectName() {
        return pro.getProperty("projectName");

    }

    public String getCompanyName() {
        return pro.getProperty("CompanyName");

    }

    public String getSystemName() {
        return pro.getProperty("SystemName");

    }

    public String getAutomationTester() {
        return pro.getProperty("AutomationTester");

    }

    public String getBrowser() {
        return pro.getProperty("Browser");
    }

    public String getStagingURL() {
        return pro.getProperty("QA");

    }


    public String getUsername() {
        return pro.getProperty("username");

    }

    public String getPassword() {
        return pro.getProperty("password");

    }

    public String getVersion() {
        return pro.getProperty("version");

    }

    public String getServerName() {
        return pro.getProperty("serverName");

    }

}

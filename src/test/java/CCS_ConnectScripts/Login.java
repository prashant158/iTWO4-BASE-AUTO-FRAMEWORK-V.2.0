package CCS_ConnectScripts;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends _01_BaseClass {

    @Test(priority = 1)
    public void Test_Login() throws InterruptedException {
                // Login email address and Password from Properties
        testContextUI.getLoginPage().Login(config.getUsername(), config.getPassword());
        testContextUI.getLoginPage().loginClick();
        // Verify if login is successful
        String page_title = testContextUI.getHomePage().getTitle();
        Assert.assertEquals(page_title, "CCS Connect - Home");
    }

}

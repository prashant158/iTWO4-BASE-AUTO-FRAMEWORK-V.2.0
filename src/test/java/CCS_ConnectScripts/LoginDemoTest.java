package CCS_ConnectScripts;
import org.testng.annotations.Test;

public class LoginDemoTest extends _01_BaseClass {

    @Test(priority = 1)
    public void Login() {
        testContextUI.getLoginPage().Login(config.getUsername(), config.getPassword());
    }

    @Test(priority = 2)
    public void ClickLogin() {
        testContextUI.getLoginPage().loginClick();
    }

}

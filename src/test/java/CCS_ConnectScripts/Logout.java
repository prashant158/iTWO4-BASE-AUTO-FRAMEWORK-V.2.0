package CCS_ConnectScripts;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout extends _01_BaseClass {

    @Test(priority = 1)
    public void Test_Logout() throws InterruptedException {
        testContextUI.getHomePage().userMenuClick();
        testContextUI.getHomePage().logOutClick();
        testContextUI.getHomePage().getLogoutConfirm();
    }
}

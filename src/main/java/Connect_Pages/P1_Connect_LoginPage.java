package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P1_Connect_LoginPage extends ElementUtil {

    private final WebDriver driver;

    public P1_Connect_LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    WebElement username;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='LoginButton']")
    WebElement LoginClick;

    public void Login(String user, String pass) {
        setElement(username, user);
        setElement(password, pass);
        TimeUtil.veryShortTime();
    }

    public void loginClick() {
        TimeUtil.shortTime();
        clickOnElement(LoginClick);
        TimeUtil.midTime();
        TimeUtil.longTime();
        TimeUtil.longTime();
        TimeUtil.longTime();
        //TimeUtil.longTime();
    }
}

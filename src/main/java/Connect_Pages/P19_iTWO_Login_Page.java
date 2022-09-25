package Connect_Pages;

import iTWO_Utilities.Constants;
import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P19_iTWO_Login_Page extends ElementUtil {
    private WebDriver driver;

    public P19_iTWO_Login_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //verify page title
    @Step("Verify Login Page Title")
    public String getLoginPageTitle() {
        return waitForTitleIs(Constants.LOGIN_PAGE_TITLE, 10);
    }

    //Login page
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[@id='loginbutton']")
    WebElement loginBtn;

    @Step("Verify Application Login with valid username: {0} and password: {1}")
    public void loginToApplication(String name, String pass) {
        TimeUtil.longTime();
        setElement(username, name);
        setElement(password, pass);
    }

    @Step("Verify user able to login or not")
    public void LoginClick() throws Exception {
        TimeUtil.shortTime();
        clickOnElement(loginBtn);
        TimeUtil.midTime();
    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement Click_Continue;

    @FindBy(xpath = "(//*[contains(text(),'Englisch (en)')])[1]")
    WebElement Click_Englisch;
    @FindBy(xpath = "(//*[contains(text(),'Englisch (en)')])[2]")
    WebElement Click_Englisch2;

    @FindBy(xpath = "(//*[contains(text(),'English (en)')])[1]")
    WebElement Click_English;
    @FindBy(xpath = "(//*[contains(text(),'English (en)')])[2]")
    WebElement Click_English2;

    @FindBy(xpath = "//button[normalize-space()='Weiter']")
    WebElement Click_Weiter;

    @Step("Verify whether user able to select the company to create project")

    public void doSelectCompanyNew(String value1, String value2) {
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("(//button[@type='button'])[1]")));
        try {
            if (Click_Englisch.isDisplayed()) {
                clickOnElement(Click_Englisch);
            }
        } catch (NoSuchElementException e) {
            clickOnElement(Click_English);
        }

        clickOnElement(driver.findElement(By.xpath("(//button[@type='button'])[2]")));
        try {
            if (Click_Englisch2.isDisplayed()) {
                clickOnElement(Click_Englisch2);
            }
        } catch (NoSuchElementException e) {
            clickOnElement(Click_English);
        }

        clickOnElement(driver.findElement(By.xpath("//span[normalize-space()='" + value1 + "']//preceding::i[2]")));
        TimeUtil.veryShortTime();
        clickOnElement(driver.findElement(By.xpath("//span[normalize-space()='" + value2 + "']")));
        TimeUtil.veryShortTime();
        try {
            if (Click_Continue.isDisplayed()) {
                clickOnElement(Click_Continue);
            }
        } catch (NoSuchElementException e) {
            clickOnElement(Click_Weiter);
        }

        TimeUtil.midTime();
    }

    public void doSelectCompany(String value1, String value2) {
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//span[normalize-space()='" + value1 + "']//preceding::i[2]")));
        TimeUtil.veryShortTime();
        clickOnElement(driver.findElement(By.xpath("//span[normalize-space()='" + value2 + "']")));
        TimeUtil.veryShortTime();
        try {
            if (Click_Continue.isDisplayed()) {
                clickOnElement(Click_Continue);
            }
        } catch (NoSuchElementException e) {
            clickOnElement(Click_Weiter);
        }

        TimeUtil.midTime();
    }

    @FindBy(xpath = "//div[contains(@class,'menu main-color')]")
    WebElement LoginView;
    @FindBy(xpath = "//span[normalize-space()='Logout']")
    WebElement ClickLogout;

    @Step("Verify user should get logout")
    public void LogoutApp() {
        TimeUtil.midTime();
        clickOnElement(LoginView);
        clickOnElement(ClickLogout);
        TimeUtil.midTime();
    }


}

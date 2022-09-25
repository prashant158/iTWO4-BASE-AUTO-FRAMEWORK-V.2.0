package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P2_Connect_HomePage extends ElementUtil {
    private final WebDriver driver;

    public P2_Connect_HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@title='System Setup']")
    WebElement systemSetup;
    @FindBy(css = "div[data-title='Maintain Lists']")
    WebElement maintainListsOption;
    @FindBy(xpath = "//div[@title='Configuration']")
    WebElement configMenu;
    @FindBy(css = "div[data-title='Clients']")
    WebElement clientOption;
    @FindBy(css = "div[data-title='Bid Leads']")
    WebElement bidLeadsOption;
    @FindBy(css = "div[data-title='Contract Managers']")
    WebElement contractManagersOption;
    @FindBy(xpath = "//div[@title='Estimating']/i")
    WebElement estimatingMenu;
    @FindBy(xpath = "//div[@data-title='Bid List']")
    WebElement bidListOption;
    @FindBy(xpath = "//div[@title='Contracts']/i")
    WebElement contractsMenu;
    @FindBy(xpath = "//div[@data-title='Contract List']")
    WebElement contractListOption;
    @FindBy(css = "div[title='eRFQ'] i")
    WebElement eRFQMenu;
    @FindBy(css = "div[data-title='Vendor Management']")
    WebElement VendorManagementOption;
    @FindBy(css = "div[data-title='Create RFQ']")
    WebElement CreateERFQOption;
    @FindBy(css = "div[data-title='eRFQ Requests']")
    WebElement eRFQRequestsOption;
    @FindBy(xpath = "//i[@class='fas fa-ellipsis-v']")
    WebElement userMenu;
    @FindBy(xpath = "//div[@id='logoutButton']")
    WebElement logoutOption;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    WebElement logOutConfirm;
    @FindBy(xpath = "//div[@class='ccsc_modalbgccsc_modalbg']")
    WebElement homePageloading;
    @FindBy(xpath = "//div[@id='orgButton']")
    WebElement ChangeOrgButton;
    @FindBy(xpath = "//select[@name='Organization']")
    WebElement OrgDropDown;

    public void SystemSetupClick()
    {
        clickOnElement(systemSetup);
        TimeUtil.veryShortTime();
        //driver.switchTo().frame("fBody");
    }

    public void clickChangeOrgButton()
    {
        clickOnElement(ChangeOrgButton);
    }

    public void clickOrgDropDown()
    {
        clickOnElement(OrgDropDown);
    }

    public void OptionMaintainListsClick()
    {
        clickOnElement(maintainListsOption);

        TimeUtil.veryShortTime();
        //driver.switchTo().frame("fBody");
    }

    public void ConfigClick()
    {
        TimeUtil.veryShortTime();
        // WebDriverWait wait = new WebDriverWait(driver,50);
        // wait.until(ExpectedConditions.attributeContains(homePageloading,"style","display: none;"));
        // new WebDriverWait(baseWebDriver, Duration.ofSeconds(50)).until(ExpectedConditions.attributeContains(homePageloading,"style","display: none;"));
        clickOnElement(configMenu);
        TimeUtil.veryShortTime();
    }

    public void OptionClientClick()
    {
        clickOnElement(clientOption);
        TimeUtil.veryShortTime();
        //driver.switchTo().frame("fBody");
    }

    public void EstimatingClick()
    {
        TimeUtil.midTime();
        clickOnElement(estimatingMenu);
        TimeUtil.veryShortTime();
    }

    public void optionBidListClick()
    {
        clickOnElement(bidListOption);
        TimeUtil.veryShortTime();
        //driver.switchTo().frame("fBody");
    }

    public void ContractsClick()
    {
        TimeUtil.midTime();
        clickOnElement(contractsMenu);
        TimeUtil.veryShortTime();
    }

    public void optionContractListClick()
    {
        clickOnElement(contractListOption);
        TimeUtil.veryShortTime();
        //driver.switchTo().frame("fBody");
    }

    public void optionBidLeadsClick()
    {
        clickOnElement(bidLeadsOption);
        TimeUtil.veryShortTime();
        //driver.switchTo().frame("fBody");
    }

    public void optionContractManagersClick()
    {
        clickOnElement(contractManagersOption);
        TimeUtil.veryShortTime();
        //driver.switchTo().frame("fBody");
    }

    public void ERFQMenuClick()
    {
        clickOnElement(eRFQMenu);
        TimeUtil.veryShortTime();
        //driver.switchTo().frame("fBody");
    }

    public void optionVendorManagementClick()
    {
        clickOnElement(VendorManagementOption);
        TimeUtil.veryShortTime();
        //driver.switchTo().frame("fBody");
    }

    public void CreateERFQOptionClick()
    {
        TimeUtil.veryShortTime();
        // WebDriverWait wait = new WebDriverWait(driver,50);
        // wait.until(ExpectedConditions.attributeContains(homePageloading,"style","display: none;"));
        // new WebDriverWait(baseWebDriver, Duration.ofSeconds(50)).until(ExpectedConditions.attributeContains(homePageloading,"style","display: none;"));
        clickOnElement(CreateERFQOption);
        TimeUtil.veryShortTime();
    }

    public void ERFQRequestsOptionClick()
    {
        TimeUtil.veryShortTime();
        clickOnElement(eRFQRequestsOption);
        TimeUtil.veryShortTime();
    }

    public void eRFQRequestsOptionClick()
    {
        TimeUtil.veryShortTime();
        // WebDriverWait wait = new WebDriverWait(driver,50);
        // wait.until(ExpectedConditions.attributeContains(homePageloading,"style","display: none;"));
        // new WebDriverWait(baseWebDriver, Duration.ofSeconds(50)).until(ExpectedConditions.attributeContains(homePageloading,"style","display: none;"));
        clickOnElement(eRFQRequestsOption);
        TimeUtil.shortTime();
    }

    public void userMenuClick()
    {
        driver.switchTo().defaultContent();
        clickOnElement(userMenu);
    }

    public void logOutClick()
    {
        TimeUtil.veryShortTime();
        clickOnElement(logoutOption);
    }

    public String getTitle() {
        String title;
        title = driver.getTitle();
        return title;
    }

    public void getLogoutConfirm()
    {
        clickOnElement(logOutConfirm);
    }

    public void mainFrame()
    {
        driver.switchTo().defaultContent();
    }

}

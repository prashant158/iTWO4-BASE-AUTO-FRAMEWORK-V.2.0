package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P13_eRFQ_Page extends ElementUtil {
    private final WebDriver driver;

    @FindBy(css = "span[class='iti__country-name']")
    public List<WebElement> allFlags;
    @FindBy(css = "div[title='Add Row'] i")
    WebElement addRow;
    @FindBy(css = "div[title='Edit Row' i]")
    WebElement editRow;
    @FindBy(css = "div[data-editorid='name'] input")
    WebElement name;
    @FindBy(css = "div[data-editorid='contactname'] input")
    WebElement contactName;
    @FindBy(css = "div[data-editorid='contactnumber'] input")
    WebElement contact;
    @FindBy(className = "editor-select")
    WebElement sector;
    @FindBy(css = "div[data-editorid='subsectorid'] select")
    WebElement subSector;
    @FindBy(xpath = "(//button[normalize-space()='Cancel'])[2]")
    WebElement btnCancel;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement btnSave;
    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-left']/div[1]/div[2]")
    WebElement firstClient;
    @FindBy(xpath = "//span[@class='valmsg-span']")
    WebElement validation_msg;
    @FindBy(xpath = "//div[@class='iti__selected-flag']")
    WebElement contactFlag;
    @FindBy(css = "i[class='fas fa-ellipsis-v slick-gridmenu-button']")
    WebElement gridMenu;
    @FindBy(xpath = "//span[contains(text(),'Reset Defaults')]")
    WebElement reset;
    @FindBy(css = "div[title='Refresh']")
    WebElement refresh;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement yesNotification;
    @FindBy(xpath = "(//div[@class='gridtitle'])[1]")
    WebElement gridTitle;
    @FindBy(xpath = "(//div[@class='slick-pane slick-pane-top slick-pane-left']//div[@class='slick-headerrow ui-state-default'])[1]")
    WebElement SearchbarPresent;
    @FindBy(css = "div[title='Search'] i")
    WebElement search;
    @FindBy(xpath = "(//input[@type='text'])[1]")
    WebElement searchByBidNumber;
    @FindBy(xpath = "//img[@title='Load Package List']")
    WebElement loadPackageList;
    @FindBy(xpath = "(//img[@title='Package Setup'])[1]")
    WebElement packageSetup;
    @FindBy(xpath = "(//img[@title='Vendor Submission List'])[3]")
    WebElement vendorSubmissionList;
    @FindBy(xpath = "(//input[@id='1165'])[1]")
    WebElement compareQuoteAmar;
    @FindBy(xpath = "(//input[@id='1166'])[1]")
    WebElement compareQuoteAmarGmail;
    @FindBy(xpath = "//img[@id='btnCompareQuotes']")
    WebElement btnCompareQuote;
    @FindBy(xpath = "(//div[@class='quick-grid-header quick-grid-fixed-vertical'])[1]/div[2]/div")
    public List<WebElement> allColumnHeaders;
    @FindBy(xpath = "//img[@title='Vendor Submission List']")
    public List<WebElement> vendorSubmissionListIcon;
    @FindBy(xpath = "//div[@id='subcontractContainer']/div[2]/div[4]/div[3]/div[1]/div/div[2]")
    public List<WebElement> allPackages;
    @FindBy(xpath = "//div[@id='VendorGrid']/div[2]/div[4]/div[3]/div[1]/div/div[2]")
    public List<WebElement> allVendorsSubmitted;
    //@FindBy(xpath = "//div[@id='VendorGrid']/div[2]/div[4]/div[3]/div[1]/div/div[10]")
    //public List<WebElement> allViewIconsVendorSubmitted;
    @FindBy(xpath = "(//img[@title='View'])[1]")
    WebElement viewIcon;


    public P13_eRFQ_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickGridMenu() {
        clickOnElement(gridMenu);
    }

    public void clickResetDefault() {
        clickOnElement(reset);
    }

    public void acceptAlertGridNotification() {
        TimeUtil.veryShortTime();
        clickOnElement(yesNotification);
    }

    public void clickLoadPackageList() {
        clickOnElement(loadPackageList);
        TimeUtil.veryShortTime();
    }

    public void clickPackageSetupIcon() {
        clickOnElement(packageSetup);
        TimeUtil.shortTime();
    }

    public void clickVendorSubmissionListIcon(String PackageName) {
        TimeUtil.veryShortTime();
        int i;
        int count = allPackages.size();
        for (i = 0; i < count; i++) {
            String packageName = allPackages.get(i).getText();
            if (packageName.contains(PackageName)) {
                vendorSubmissionListIcon.get(i).click();
                break;
            }
        }
    }

    public void clickVendorQuotationViewIcon() {
        TimeUtil.veryShortTime();
        clickOnElement(viewIcon);
    }

    public void clickCompareQuoteAmar() {
        clickOnElement(compareQuoteAmar);
    }

    public void clickCompareQuoteAmarGmail() {
        clickOnElement(compareQuoteAmarGmail);
    }

    public void setBtnCompareQuote() {
        clickOnElement(btnCompareQuote);
    }

    public WebElement getGridTitle() {
        return gridTitle;
    }

    public void refreshClick() {
        clickOnElement(refresh);
        TimeUtil.midTime();
    }

    public int getColumnHeader() {
        TimeUtil.veryShortTime();
        int i;
        int noOfTimes = 0;
        int count = allColumnHeaders.size();
        for (i = 0; i < count; i++) {
            String columnHeader = allColumnHeaders.get(i).getText();
            if (columnHeader.contains("Quantity") || columnHeader.contains("Qty")) {
                noOfTimes = noOfTimes + 1;
            }
        }
        return noOfTimes;
    }

    public void setSearchByBidNumber(String bid_no) {
        //TimeUtil.VeryshortTime();

        if (SearchbarPresent.getAttribute("style").contains("display: none;")) {
            clickOnElement(search);
            setElement(searchByBidNumber, bid_no);
        }
        else
        {
            setElement(searchByBidNumber, bid_no);
        }
        TimeUtil.veryShortTime();
    }

}

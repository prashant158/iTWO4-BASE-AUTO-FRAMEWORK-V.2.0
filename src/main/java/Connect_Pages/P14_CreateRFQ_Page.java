package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P14_CreateRFQ_Page extends ElementUtil {
    private final WebDriver driver;

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
    @FindBy(xpath = "//img[@title='Package Setup']")
    public List<WebElement> packageSetupIcon;
    @FindBy(xpath = "(//div[@class='slick-cell l10 r10 selected'])[1]")
    WebElement topReceivedDate;
    @FindBy(xpath = "(//span[normalize-space()='Received'])[1]")
    WebElement receivedHeader;
    @FindBy(xpath = "//div[@id='subcontractContainer']/div[2]/div[4]/div[3]/div[1]/div/div[2]")
    public List<WebElement> allPackages;
    @FindBy(xpath = "//i[@title='View Request']")
    WebElement viewRequests;
    @FindBy(id = "btnNext")
    WebElement nextBtn;
    @FindBy(css = ".package_button.ccs_navtab.next.quoteSubmitAttachmentTabNextBtn")
    WebElement nextBtnAttachment;
    @FindBy(xpath = "//div[@id='ItemsGrid']/div[1]/div[2]/div[1]/div[1]")
    public List<WebElement> vendorQuoteItemsAllColumnHeaders;
    @FindBy(xpath = "//i[@title='Import Candy Data']")
    WebElement importIconPackage;
    @FindBy(xpath = "//table[@id='TblPackageDetails']/tbody[1]/tr[2]/td[1]/input[1]")
    WebElement selectPackageToImport;
    @FindBy(xpath = "//div[@class='item-details-editor-container']//img[@title='Select date']")
    WebElement calenderIcon;
    @FindBy(xpath = "(//img[@title='Select date'])[2]")
    WebElement calenderIconIntentionToBid;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement calenderNext;
    @FindBy(xpath = "(//a[normalize-space()='28'])[1]")
    WebElement calenderSelectDate28;
    @FindBy(xpath = "(//a[normalize-space()='25'])[1]")
    WebElement calenderSelectDate25;
    @FindBy(xpath = "(//input[@id='txtReturnTime'])[1]")
    WebElement returnTime;
    @FindBy(xpath = "(//button[normalize-space()='Import'])[1]")
    WebElement importBtn;
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Cancel'])[2]")
    WebElement cancelBtn;
    @FindBy(xpath = "//p[contains(text(),'Please note that the currency for this Bid will be')]")
    WebElement msgBidCurrencySet;
    @FindBy(xpath = "(//span[@class='overrideMsg'])[1]")
    WebElement packageAlreadyExistMsg;
    @FindBy(xpath = "(//input[@class='chkOverride'])[1]")
    WebElement overridePackageChkBox;
    @FindBy(xpath = "(//input[@id='IntentionDate'])[1]")
    WebElement intentionToBidDate;
    @FindBy(xpath = "(//textarea[@id='txtDescOfWork'])[1]")
    WebElement descriptionOfWork;

    public P14_CreateRFQ_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCalenderIconIntentionToBid() {
        clickOnElement(calenderIconIntentionToBid);
    }

    public void SetDescriptionOfWork(String Desc) {
        setElement(descriptionOfWork, Desc);
        TimeUtil.veryShortTime();
    }

    public void setIntentionToBidDate(String Date) {
        setElement(intentionToBidDate, Date);
        TimeUtil.veryShortTime();
    }

    public void clickOverridePackageChkBox() {
        clickOnElement(overridePackageChkBox);
    }

    public WebElement GetPackageAlreadyExistMsg() {
        return packageAlreadyExistMsg;
    }

    public void clickOnNextButton() {
        clickOnElement(nextBtn);
    }

    public void clickOnNextButtonToAttachment() {
        clickOnElement(nextBtnAttachment);
    }

    public WebElement getTopReceivedDate() {
        return topReceivedDate;
    }

    public WebElement getGridTitle() {
        return gridTitle;
    }

    public void refreshClick() {
        clickOnElement(refresh);
        TimeUtil.shortTime();
    }

    public void importIconPackageClick() {
        clickOnElement(importIconPackage);
        TimeUtil.veryShortTime();
    }

    public void selectPackageClick() {
        clickOnElement(selectPackageToImport);
        TimeUtil.veryShortTime();
    }

    public void receivedHeaderClick() {
        clickOnElement(receivedHeader);
        TimeUtil.midTime();
    }

    public void clickOnViewRequests() {
        clickOnElement(viewRequests);
        TimeUtil.midTime();
    }

    public void clickOnCalenderIcon() {
        clickOnElement(calenderIcon);
        TimeUtil.veryShortTime();
    }

    public void clickOnNextIcon() {
        clickOnElement(calenderNext);
        TimeUtil.veryShortTime();
    }

    public void selectCalenderDate() {
        clickOnElement(calenderSelectDate28);
        TimeUtil.veryShortTime();
    }

    public void selectCalenderDateForIntention() {
        clickOnElement(calenderSelectDate25);
        TimeUtil.veryShortTime();
    }

    public void ImportBtnClick() {
        clickOnElement(importBtn);
        TimeUtil.veryShortTime();
    }

    public void CancelBtnClick() {
        clickOnElement(cancelBtn);
        TimeUtil.veryShortTime();
    }

    public void enterReturnTime(String ReturnTime) {
        setElement(returnTime, ReturnTime);
        TimeUtil.veryShortTime();
    }

    public void getPackageSetupIcon(String PackageName) {
        TimeUtil.veryShortTime();
        int i;
        int count = allPackages.size();
        for (i = 0; i < count; i++) {
            String packageName = allPackages.get(i).getText();
            if (packageName.contains(PackageName)) {
                packageSetupIcon.get(i).click();
                break;
            }
        }
    }

    public int getVendorItemColumnHeaders() {
        TimeUtil.veryShortTime();
        int i;
        int noOfTimes = 0;
        int count = vendorQuoteItemsAllColumnHeaders.size();
        for (i = 0; i < count; i++) {
            String columnHeader = vendorQuoteItemsAllColumnHeaders.get(i).getText();
            if (columnHeader.contains("Quantity") || columnHeader.contains("Qty")) {
                noOfTimes = noOfTimes + 1;
            }
        }
        return noOfTimes;
    }

    public void setSearchByBidName(String bid_name) {
        //TimeUtil.VeryshortTime();

            clickOnElement(search);
            setElement(searchByBidNumber, bid_name);
    }

}

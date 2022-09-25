package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P9_Estimating_BidListPage extends ElementUtil {
    private final WebDriver driver;

    public P9_Estimating_BidListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[title='Add Row'] i")
    WebElement addRow;
    @FindBy(css = "div[title='Edit Row' i]")
    WebElement editRow;
    @FindBy(css = "div[data-editorid='number'] input")
    WebElement bidNo;
    @FindBy(css = "div[data-editorid='name'] input")
    WebElement bidName;
    @FindBy(css = "div[data-editorid='clientid'] select")
    WebElement bidClient;
    @FindBy(css = "div[data-editorid='bidleadid'] select")
    WebElement bidLead;
    @FindBy(css = "div[data-editorid='bidtypeid'] select")
    WebElement constructionType;
    @FindBy(css = "div[data-editorid='location'] div i")
    WebElement bidLocation;
    @FindBy(id = "dataeditor-startdate")
    WebElement bidDocumentReceived;
    @FindBy(id = "dataeditor-submissiondate")
    WebElement bidSubmissionDate;
    @FindBy(xpath = "//input[@id='dataeditor-submissiontime']")
    WebElement bidSubmissionTime;
    @FindBy(id = "dataeditor-siteinspectiondate")
    WebElement siteInspectionDate;
    @FindBy(css = "#dataeditor-eststartdate")
    WebElement startDate;
    @FindBy(css = "#dataeditor-estenddate")
    WebElement completionDate;
    @FindBy(css = "div[data-editorid='bidstatusid'] select")
    WebElement status;
    @FindBy(xpath = "(//button[normalize-space()='Cancel'])[2]")
    WebElement btnCancel;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement btnSave;
    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
    WebElement popupSave;
    @FindBy(css = "i[class='fas fa-ellipsis-v slick-gridmenu-button']")
    WebElement gridMenu;
    @FindBy(xpath = "//span[contains(text(),'Reset Defaults')]")
    WebElement reset;
    @FindBy(css = "div[title='Refresh']")
    WebElement refresh;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement yesNotification;
    @FindBy(xpath = "//button[contains(text(),'No')]")
    WebElement NoNotification;
    @FindBy(className = "gridtitle")
    WebElement gridTitle;
    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-left']/div[1]/div[2]")
    WebElement firstBid;
    @FindBy(xpath = "//input[@id='adautocomplete']")
    WebElement addressLookup;
    @FindBy(xpath = "//span[@class='valmsg-span']")
    WebElement validation_msg;
    @FindBy(css = "div[title='Search'] i")
    WebElement search;
    @FindBy(xpath = "(//input[@type='text'])[1]")
    WebElement searchByBidNumber;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    WebElement searchByBidName;
    @FindBy(xpath = "(//i[@title='Delete'])[1]")
    WebElement deleteBid;
    @FindBy(xpath = "(//i[@title='Import Candy Data'])[1]")
    WebElement importCandyData;
    @FindBy(xpath = "//i[@title='Import Data']")
    WebElement importButton;
    @FindBy(xpath = "//input[@id='chkUserAcknowledge']")
    WebElement userAcknowledgeCheckbox;
    @FindBy(xpath = "//input[@id='ExchangeRate']")
    WebElement exchangeRate;
    @FindBy(id = "BaseDate")
    WebElement baseDate;
    @FindBy(id = "btnProceed")
    WebElement btnProceed;
    @FindBy(xpath = "//button[@class='jqdialog_button']")
    WebElement btnCancelOnBidCurrency;
    @FindBy(xpath = "//div[contains(@style,'width: 1495px; display: none;')]")
    WebElement SearchbarNotPresent;
    @FindBy(xpath = "//div[@class='slick-pane slick-pane-top slick-pane-left']//div[@class='slick-headerrow ui-state-default']")
    WebElement SearchbarPresent;
    @FindBy(xpath = "(//i[@title='Bid Finalization'])[1]")
    WebElement bidFinalizationIcon;
    @FindBy(xpath = "//div[@class='ccs_tabheading']//span[contains(text(),'Topsheet')]")
    WebElement topSheetTitle;
    @FindBy(xpath = "(//label[normalize-space()='Are you sure you want to import this data?'])[1]")
    WebElement uploadNotificationMessage;
    @FindBy(xpath = "(//button[normalize-space()='Yes'])[1]")
    WebElement notificationImportYesbtn;


    public void addBidClick() {
        TimeUtil.veryShortTime();
        clickOnElement(addRow);
    }

    public void editBidClick() {
        if (editRow.isDisplayed()) {
           clickOnElement(editRow);
        }
    }

    public void searchClick() {
        clickOnElement(search);
    }

    public void setSearchByBidNumber(String bid_no) {
        //TimeUtil.VeryshortTime();

        if (SearchbarPresent.getAttribute("style").contains("display: none;")) {
            searchClick();
            setElement(searchByBidNumber, bid_no);
        }
        else
        {
            setElement(searchByBidNumber, bid_no);
        }
    }

    public void enterBidNo(String bid_no) {
        //TimeUtil.VeryshortTime();
        setElement(bidNo, bid_no);
    }

    public String BidNumberGeneration() {
        TimeUtil.veryShortTime();
        String RN = randomNumber(10000);
        String BIDNO = "BID" + RN;
        return BIDNO;
    }

    public void enterBidName(String bid_name) {
        //TimeUtil.VeryshortTime();
        setElement(bidName, bid_name);
    }

    public void setBidClient(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(bidClient, value);
    }

    public void setBidLead(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(bidLead, value);
    }

    public void setConstructionType(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(constructionType, value);
    }

    public void clickBidLocation() {
        clickOnElement(bidLocation);
    }

    public void enterDocReceivedDate(String doc_received_date) {
        //TimeUtil.VeryshortTime();
        setElement(bidDocumentReceived, doc_received_date);
    }

    public void enterBidSubmissionDate(String bid_submission_date) {
        //TimeUtil.VeryshortTime();
        setElement(bidSubmissionDate, bid_submission_date);
    }

    public void enterBidSubmissionTime(String bid_submission_time) {
        //TimeUtil.VeryshortTime();
        setElement(bidSubmissionTime, bid_submission_time);
    }

    public void enterSiteInspectionDate(String site_inspection_date) {
        //TimeUtil.VeryshortTime();
        setElement(siteInspectionDate, site_inspection_date);
    }

    public void enterStartDate(String start_date) {
        //TimeUtil.VeryshortTime();
        setElement(startDate, start_date);
    }

    public void enterCompletionDate(String completion_date) {
        //TimeUtil.VeryshortTime();
        setElement(completionDate, completion_date);
    }

    public void setStatus(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(status, value);
    }

    public void btnCancel() {
        //TimeUtil.VeryshortTime();
        clickOnElement(btnCancel);
    }

    public void btnSave() {
        TimeUtil.veryShortTime();
        clickOnElement(btnSave);
    }

    public void bidFinalizationIconClick() {
        TimeUtil.veryShortTime();
        clickOnElement(bidFinalizationIcon);
    }

    public WebElement getBidFinalizationTitle() {
        TimeUtil.veryShortTime();
        return topSheetTitle;
    }

    public void clickGridMenu() {
        clickOnElement(gridMenu);
    }

    public void clickResetDefault() {
        clickOnElement(reset);
    }

    public void acceptAlertNotification() {
        TimeUtil.veryShortTime();
        clickOnElement(yesNotification);
    }

    public void declineAlertNotification() {
        TimeUtil.veryShortTime();
        clickOnElement(NoNotification);
    }

    public WebElement getGridTitle() {
        return gridTitle;
    }

    public void refreshClick() {
        clickOnElement(refresh);
        TimeUtil.shortTime();
    }

    public WebElement getFirstBid() {
        TimeUtil.veryShortTime();
        return firstBid;
    }

    public WebElement getBidName() {
        TimeUtil.veryShortTime();
        return bidName;
    }

    public void getAddress(String address) {
        setElement(addressLookup, address);
        TimeUtil.veryShortTime();
        addressLookup.sendKeys(Keys.ARROW_DOWN);
        TimeUtil.veryShortTime();
        addressLookup.sendKeys(Keys.ENTER);
    }

    public void TAB(Integer no_of_times) {
        elementTabs(no_of_times);
        elementEnter();
    }

    public void RETURN() {
        searchByBidNumber.sendKeys(Keys.ENTER);
        TimeUtil.midTime();
    }

    public void btnPopupSave() {
        //TimeUtil.VeryshortTime();
        clickOnElement(popupSave);
    }

    public WebElement getValidation_msg() {
        TimeUtil.veryShortTime();
        return validation_msg;
    }

    public void deleteBidClick() {
        clickOnElement(deleteBid);
        TimeUtil.shortTime();
    }

    public void clickOnImportCandyData() {
        clickOnElement(importCandyData);
        TimeUtil.shortTime();
    }

    public void clickOnImportButton() {
        clickOnElement(importButton);
        TimeUtil.shortTime();
    }

    public void clickOnImportCheckbox() {
        clickOnElement(userAcknowledgeCheckbox);
        TimeUtil.shortTime();
    }

    public void setExchangeRate(String rate) {
        //TimeUtil.VeryshortTime();
        setElement(exchangeRate, rate);
    }

    public void setBaseDate(String date) {
        //TimeUtil.VeryshortTime();
        setElement(baseDate, date);
    }

    public void clickOnProceed() {
        clickOnElement(btnProceed);
        TimeUtil.shortTime();
    }

    public void clickOnBtnCancel() {
        clickOnElement(btnCancelOnBidCurrency);
        TimeUtil.shortTime();
    }

    public void clickOnBtnNotificationYes() {
        clickOnElement(notificationImportYesbtn);
        TimeUtil.midTime();
    }

    public WebElement notificationAlert(){
        return uploadNotificationMessage;
    }

}

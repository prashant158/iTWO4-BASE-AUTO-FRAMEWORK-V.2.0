package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P11_Contracts_ContractList extends ElementUtil {
    private final WebDriver driver;

    public P11_Contracts_ContractList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[title='Add Row'] i")
    WebElement addRow;
    @FindBy(css = "div[title='Edit Row' i]")
    WebElement editRow;
    @FindBy(css = "div[data-editorid='number'] input")
    WebElement contractNo;
    @FindBy(css = "div[data-editorid='name'] input")
    WebElement contractName;
    @FindBy(css = "div[data-editorid='clientid'] select")
    WebElement contractClient;
    @FindBy(css = "div[data-editorid='contractmanagerid'] select")
    WebElement contractManager;
    @FindBy(css = "div[data-editorid='bidtypeid'] select")
    WebElement contractType;
    @FindBy(css = "div[data-editorid='location'] div i")
    WebElement contractLocation;
    @FindBy(id = "dataeditor-startdate")
    WebElement contractStartDate;
    @FindBy(css = "#dataeditor-enddate")
    WebElement contractEndDate;
    @FindBy(xpath = "//div[@data-editorid='currencyid']/select")
    WebElement reportingCurrency;
    @FindBy(css = "#dataeditor-rate")
    WebElement exchangeRate;
    @FindBy(xpath = "(//select[@class='editor-select'])[5]")
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
    WebElement firstContractNo;
    @FindBy(xpath = "//input[@id='adautocomplete']")
    WebElement addressLookup;
    @FindBy(xpath = "//span[@class='valmsg-span']")
    WebElement validation_msg;
    @FindBy(css = "div[title='Search'] i")
    WebElement search;
    @FindBy(xpath = "(//input[@type='text'])[1]")
    WebElement searchByContractNumber;
    @FindBy(xpath = "(//i[@title='Delete'])[1]")
    WebElement deleteBid;
    @FindBy(xpath = "(//i[@title='Import Candy Data'])[1]")
    WebElement importCandyData;
    @FindBy(xpath = "//i[@title='Import Data']")
    WebElement importButton;
    @FindBy(xpath = "(//button[@class='jqdialog_button ui-button ui-corner-all ui-widget'][normalize-space()='Close'])[1]")
    WebElement closeCostReportUpload;


    @FindBy(xpath = "//input[@id='chkUserAcknowledge']")
    WebElement userAcknowledgeCheckbox;
    @FindBy(id = "BaseDate")
    WebElement baseDate;
    @FindBy(id = "btnProceed")
    WebElement btnProceed;
    @FindBy(xpath = "(//button[normalize-space()='Yes'])[1]")
    WebElement getYesNotification;
    @FindBy(xpath = "//div[contains(@style,'width: 1495px; display: none;')]")
    WebElement SearchbarNotPresent;
    @FindBy(xpath = "//div[@class='slick-pane slick-pane-top slick-pane-left']//div[@class='slick-headerrow ui-state-default']")
    WebElement SearchbarPresent;
    @FindBy(xpath = "(//i[@title='Cost Report'])[1]")
    WebElement costReportIcon;
    @FindBy(xpath = "(//i[@title='Cost Report List'])[1]")
    WebElement costReportListIcon;
    @FindBy(css = "div[id='tab1'] div[class='ccs_tabheading'] span:nth-child(1)")
    WebElement costReportTitle;



    public void addContractClick() {
        TimeUtil.veryShortTime();
        clickOnElement(addRow);
    }

    public void editContractClick() {
        if (editRow.isDisplayed()) {
           clickOnElement(editRow);
        }
    }

    public void searchClick() {
        clickOnElement(search);
    }

    public void setSearchByContractNumber(String contract_no) {
        //TimeUtil.VeryshortTime();

        if (SearchbarPresent.getAttribute("style").contains("display: none;")) {
            searchClick();
            setElement(searchByContractNumber, contract_no);
        }
        else
        {
            setElement(searchByContractNumber, contract_no);
        }
    }

    public void enterContractNo(String contract_no) {
        //TimeUtil.VeryshortTime();
        setElement(contractNo, contract_no);
    }

    public void enterContractName(String contract_name) {
        //TimeUtil.VeryshortTime();
        setElement(contractName, contract_name);
    }

    public void setContractClient(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(contractClient, value);
    }

    public void setContractManager(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(contractManager, value);
    }

    public void setContractType(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(contractType, value);
    }

    public void setReportingCurrency(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(reportingCurrency, value);
    }

    public void clickContractLocation() {
        clickOnElement(contractLocation);
    }

    public void enterContractStartDate(String doc_received_date) {
        //TimeUtil.VeryshortTime();
        setElement(contractStartDate, doc_received_date);
    }

    public void enterContractEndDate(String completion_date) {
        //TimeUtil.VeryshortTime();
        setElement(contractEndDate, completion_date);
    }

    public void setStatus(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(status, value);
    }

    public void btnCancel() {
        //TimeUtil.VeryshortTime();
        clickOnElement(btnCancel);
        TimeUtil.veryShortTime();
    }

    public void btnSave() {
        TimeUtil.veryShortTime();
        clickOnElement(btnSave);
    }

    public void btnNotificationYes() {
        TimeUtil.veryShortTime();
        clickOnElement(getYesNotification);
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

    public WebElement getFirstContractNo() {
        TimeUtil.veryShortTime();
        return firstContractNo;
    }

    public WebElement getBidName() {
        TimeUtil.veryShortTime();
        return contractName;
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
        searchByContractNumber.sendKeys(Keys.ENTER);
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

    public WebElement ImportButton() {
        return importButton;
    }

    public void clickOnCloseButton() {
        clickOnElement(closeCostReportUpload);
        TimeUtil.shortTime();
    }



    public void clickOnCostReportIcon() {
        clickOnElement(costReportIcon);
        TimeUtil.shortTime();
    }

    public void clickOnCostReportListIcon() {
        clickOnElement(costReportListIcon);
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

    public WebElement getCostReportTitle() {
        TimeUtil.veryShortTime();
        return costReportTitle;
    }



    public String ContractNoGeneration() {
        TimeUtil.veryShortTime();
        String RN = randomNumber(10000);
        String ContractNo = "CON" + RN;
        return ContractNo;
    }

}

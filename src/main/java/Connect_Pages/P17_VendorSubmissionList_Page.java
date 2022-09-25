package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P17_VendorSubmissionList_Page extends ElementUtil {
    private final WebDriver driver;
    @FindBy(xpath = "//img[@title='Package Setup']")
    public List<WebElement> packageSetupIcon;
    @FindBy(xpath = "//div[@id='subcontractContainer']/div[2]/div[4]/div[3]/div[1]/div/div[2]")
    public List<WebElement> allPackages;
    @FindBy(xpath = "//div[@id='ItemsGrid']/div[1]/div[2]/div[1]/div[1]")
    public List<WebElement> vendorQuoteItemsAllColumnHeaders;
    @FindBy(xpath = "//div[@class='uploaded-file-list']/div/div[1]")
    public List<WebElement> allAttachments;
    @FindBy(xpath = "//div[@class='uploaded-file-list']/div/div[4]")
    public List<WebElement> allAttachmentsCheckBoxes;
    @FindBy(xpath = "(//div[@class='vendorUploaded-file-list'])[1]/div/div[2]/div[2]")
    public List<WebElement> allVendorAttachmentsNames;
    @FindBy(xpath = "(//div[@class='vendorUploaded-file-list'])[1]/div/div[2]/div[5]/div[1]/div[1]")
    public List<WebElement> allVendorAttachmentsEyeIcons;
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
    @FindBy(xpath = "(//div[@class='slick-cell l10 r10 selected'])[1]")
    WebElement topReceivedDate;
    @FindBy(xpath = "(//span[normalize-space()='Received'])[1]")
    WebElement receivedHeader;
    @FindBy(xpath = "//i[@title='View Request']")
    WebElement viewRequests;
    @FindBy(id = "btnNext")
    WebElement nextBtn;
    @FindBy(css = ".package_button.ccs_navtab.next.quoteSubmitAttachmentTabNextBtn")
    WebElement nextBtnAttachment;
    @FindBy(xpath = "//i[@title='Import Candy Data']")
    WebElement importIconPackage;
    @FindBy(xpath = "(//input[@id='package_2347da43-e440-449e-a9e1-05abe27bcbba'])[1]")
    WebElement selectPackageToImport;
    @FindBy(xpath = "//div[@class='item-details-editor-container']//img[@title='Select date']")
    WebElement calenderIcon;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement calenderNext;
    @FindBy(xpath = "(//a[normalize-space()='28'])[1]")
    WebElement calenderSelectDate28;
    @FindBy(xpath = "(//input[@id='txtReturnTime'])[1]")
    WebElement returnTime;
    @FindBy(xpath = "(//button[normalize-space()='Import'])[1]")
    WebElement importBtn;
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Cancel'])[2]")
    WebElement cancelBtn;
    @FindBy(xpath = "(//div[@class='package_button btnAdjcn'])[1]")
    WebElement addDocumentsBtn;
    @FindBy(xpath = "//div[@id='jqcDocumentTreeContainer']/div[1]/div[1]/div[1]/div[1]/i")
    WebElement uploadDocumentTreeContainerExpand;
    @FindBy(xpath = "//div[@id='jqcDocumentTreeContainer']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    WebElement uploadDocumentSubTreeContainerExpand;
    @FindBy(xpath = "//div[@id='jqcDocumentTreeContainer']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
    WebElement uploadFileIcon;
    @FindBy(xpath = "(//span[@class='jqc-checkbox-checkmark'])[3]")
    WebElement includeDocument;
    @FindBy(xpath = "(//button[normalize-space()='Continue'])[1]")
    WebElement ContinueBtn;
    @FindBy(xpath = "(//i[@class='fas fa-caret-right'])[3]")
    WebElement attachmentStatutoryDocument;
    @FindBy(xpath = "(//div[@id='accordionContentsContainer'])[4]/div[1]/div[1]/div[1]/i")
    WebElement vendorSubCategory;
    @FindBy(xpath = "(//span[@class='jqc-checkbox-checkmark'])[3]")
    WebElement requiredFromVendor;
    @FindBy(xpath = "//div[@class='package_button ccs_navtab next quoteSubmitAttachmentTabNextBtn']")
    WebElement nextBtnToQuoteItems;
    @FindBy(xpath = "(//div[@class='package_button ccs_navtab next'])[1]")
    WebElement nextBtnToPublish;
    @FindBy(xpath = "//div[@title='Search Vendor']/i")
    WebElement searchVendor;
    @FindBy(xpath = "(//input[@id='vendor-code-search-input'])[1]")
    WebElement searchVendorByCode;
    @FindBy(xpath = "(//input[@id='btnSearch'])[1]")
    WebElement searchBtn;
    @FindBy(xpath = "(//div[@class='slick-viewport slick-viewport-top slick-viewport-left'])[3]/div[1]/div[1]/div[2]/div[1]/input")
    WebElement includeVendorCheckbox;
    @FindBy(xpath = "(//input[@id='btnAdd'])[1]")
    WebElement addVendorButton;
    @FindBy(xpath = "(//div[@id='btnSubmtPackage'])[1]")
    WebElement btnSubmitPackage;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    WebElement submissionConfirmYesBtn;
    @FindBy(xpath = "(//i[@title='Bid Settings'])[2]")
    WebElement bidSettings;
    @FindBy(xpath = "//div[@class='slick-viewport slick-viewport-top slick-viewport-left']/div[1]/div[1]/div[2]")
    WebElement firstRequestName;
    @FindBy(xpath = "//div[@class='slick-viewport slick-viewport-top slick-viewport-left']/div[1]/div[1]/div[10]")
    WebElement getStatusFromSearchedResult;
    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-left']/div[1]/div[7]")
    WebElement submissionStatus;
    @FindBy(xpath = "//p[contains(text(),'Please note that the currency for this Bid will be')]")
    WebElement msgBidCurrencySet;
    @FindBy(xpath = "//label[normalize-space()='Success']")
    WebElement msgImportSuccess;
    @FindBy(xpath = "//p[contains(text(),'To view consolidated reports at an Organizational ')]")
    WebElement msgImportDifferentCurrency;
    @FindBy(xpath = "(//div[@id='categoriesContainer'])[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/i")
    WebElement iconBtnExpand;
    @FindBy(xpath = "//div[@class='vendorPackageAttachmentsType-typeContainer-last']/div[1]/div[1]")
    WebElement fileUploadOption;
    @FindBy(xpath = "//span[normalize-space()='Submit']")
    WebElement submitTab;
    @FindBy(xpath = "(//div[@class='validation-attachment-container'])[1]/div")
    WebElement attachmentValidations;
    @FindBy(xpath = "(//div[@class='validation-pricing-container'])[1]/div")
    WebElement pricingValidations;
    @FindBy(xpath = "//div[@class='package_button ccs_navtab next quoteSubmitAttachmentTabNextBtn']")
    WebElement nxtBtnOnQuoteItem;
    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-left']/div[4]/div[8]")
    WebElement earthWorksItem1;
    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-left']/div[4]/div[8]/input")
    WebElement earthWorksItem1Input;
    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-left']/div[13]/div[8]")
    WebElement earthWorksItem8;
    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-left']/div[13]/div[8]/input")
    WebElement earthWorksItem8Input;
    @FindBy(xpath = "(//div[@class='package_button ccs_navtab next'])[1]")
    WebElement NxtBtnSubmit;
    @FindBy(xpath = "(//select[@class='filter-select'])[2]")
    WebElement statusFilter;
    @FindBy(xpath = "(//select[@id='QuoteCurrencyId'])[1]")
    WebElement quoteCurrency;
    @FindBy(xpath = "//div[@class='package_button'][normalize-space()='Submit']")
    WebElement quoteSubmitBtn;
    @FindBy(xpath = "(//input[@id='quoteCurrency'])[1]")
    WebElement quoteCurrencyAcknowledgement;
    @FindBy(xpath = "//button[@id='btnYes']")
    WebElement btnYesOnCurrencyAcknowledgement;
    @FindBy(xpath = "(//div[@class='ccs_pageheading'])[1]")
    WebElement pageHeading;
    @FindBy(xpath = "(//input[@id='Version'])[1]")
    WebElement packageVersionNo;
    @FindBy(xpath = "(//img[@title='View'])[1]")
    WebElement viewIcon;
    @FindBy(xpath = "//div[@id='ItemsGrid']/div[1]/div[4]/div[4]/div[2]/div[10]")
    WebElement TotalOnSubmittedQuoteAmount;
    @FindBy(xpath = "//div[@id='VendorGrid']/div[2]/div[4]/div[3]/div[1]/div[1]/div[8]/div")
    WebElement submittedQuoteVersion;
    @FindBy(xpath = "//div[@id='quoteItemsTab']//span[contains(text(),'Quote Items')]")
    WebElement quoteItemsTab;
    @FindBy(xpath = "//span[normalize-space()='Adjudication']")
    WebElement adjudicationTab;
    @FindBy(xpath = "//div[@id='tenderValue']")
    WebElement tenderValueOnAdj;
    @FindBy(xpath = "//div[normalize-space()='Accept For Adjudication']")
    WebElement acceptForAdjudicationBtn;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    WebElement confirmationYes;
    @FindBy(xpath = "//input[@id='ExchangeRate']")
    WebElement exchangeRateInput;
    @FindBy(xpath = "//input[@id='BaseDate']")
    WebElement baseDate;
    @FindBy(xpath = "//button[normalize-space()='Proceed']")
    WebElement proceedBtn;
    @FindBy(xpath = "//div[@id='VendorGrid']/div[2]/div[4]/div[3]/div[1]/div[1]/div[7]")
    WebElement submissionStatusNew;
    @FindBy(xpath = "(//div[@id='categoriesContainer'])[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")
    WebElement firstAttachmentAdjudication;
    @FindBy(xpath = "//div[@id='btnNext']")
    WebElement nextBtnToAttachmentAdjudication;
    @FindBy(xpath = "(//div[@id='categoriesContainer'])[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/i")
    WebElement iconFirstAttachmentExpand;


    public P17_VendorSubmissionList_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickIconFirstAttachmentExpand() {
        clickOnElement(iconFirstAttachmentExpand);
    }

    public void clickNextBtnToAttachmentAdjudication() {
        clickOnElement(nextBtnToAttachmentAdjudication);
    }

    public WebElement getFirstAttachmentAdjudication() {
        return firstAttachmentAdjudication;
    }

    public void clickProceedBtn() {
        clickOnElement(proceedBtn);
    }

    public void setBaseDate(String text) {
        setElement(baseDate, text);
    }

    public void setExchangeRateInput(String text) {
        setElement(exchangeRateInput, text);
    }

    public void clickConfirmationYes() {
        clickOnElement(confirmationYes);
    }

    public void clickAcceptForAdjudicationBtn() {
        clickOnElement(acceptForAdjudicationBtn);
    }

    public WebElement getTenderValueOnAdj() {
        return tenderValueOnAdj;
    }

    public void clickAdjudicationTab() {
        clickOnElement(adjudicationTab);
    }

    public void clickQuoteItemsTab() {
        clickOnElement(quoteItemsTab);
    }

    public WebElement getSubmittedQuoteVersion() {
        return submittedQuoteVersion;
    }

    public WebElement getTotalOnSubmittedQuoteAmount() {
        return TotalOnSubmittedQuoteAmount;
    }

    public void clickViewIcon() {
        clickOnElement(viewIcon);
    }

    public WebElement getPackageVersionNo() {
        return packageVersionNo;
    }

    public WebElement GridHeading() {
        return pageHeading;
    }

    public void clickBtnYesOnCurrencyAcknowledgement() {
        clickOnElement(btnYesOnCurrencyAcknowledgement);
    }

    public WebElement getStatusFromSearchedResult() {
        return getStatusFromSearchedResult;
    }

    public void clickQuoteCurrencyAcknowledgement() {
        clickOnElement(quoteCurrencyAcknowledgement);
    }

    public void clickQuoteSubmitBtn() {
        clickOnElement(quoteSubmitBtn);
    }

    public void selectQuoteCurrency(String value) {
        selectDropdown(quoteCurrency, value);
    }

    public void selectStatus(String value) {
        selectDropdown(statusFilter, value);
    }

    public void clickNxtBtnSubmit() {
        clickOnElement(NxtBtnSubmit);
    }

    public void EnterRates(String text) {
        elementTyping(text);
    }

    public void pressEnterKey() {
        elementEnter();
    }

    public void setEarthWorksItem8Input(String text) {
        setElement(earthWorksItem8Input, text);
    }

    public void clickEarthWorksItem8() {
        clickOnElement(earthWorksItem8);
    }

    public void setEarthWorksItem1Input(String text) {
        setElement(earthWorksItem1Input, text);
    }

    public void clickEarthWorksItem1() {
        clickOnElement(earthWorksItem1);
    }

    public void clickNxtBtnOnQuoteItem() {
        clickOnElement(nxtBtnOnQuoteItem);
    }

    public WebElement checkAttachmentValidation() {
        return attachmentValidations;
    }

    public WebElement checkPricingValidation() {
        return pricingValidations;
    }

    public void clickSubmitTab() {
        clickOnElement(submitTab);
    }

    public void clickFileUploadOption() {
        clickOnElement(fileUploadOption);
    }

    public void clickIconBtnExpand() {
        clickOnElement(iconBtnExpand);
    }

    public WebElement getMsgImportDifferentCurrency() {
        return msgImportDifferentCurrency;
    }

    public WebElement getMsgImportSuccess() {
        return msgImportSuccess;
    }

    public WebElement getMsgBidCurrencySet() {
        return msgBidCurrencySet;
    }

    public WebElement getSubmissionStatus() {
        return submissionStatus;
    }

    public WebElement clickFirstRequestName() {
        return firstRequestName;
    }

    public void clickAttachmentCheckboxToInclude(String AttachmentName) {
        TimeUtil.veryShortTime();
        int i;
        int count = allAttachments.size();
        for (i = 0; i < count; i++) {
            String attchmentName = allAttachments.get(i).getText();
            if (attchmentName.contains(AttachmentName)) {
                allAttachmentsCheckBoxes.get(i).click();
                break;
            }
        }
    }

    public void clickAttachmentEyeIcon(String AttachmentName) {
        TimeUtil.veryShortTime();
        int i;
        int count = allVendorAttachmentsNames.size();
        for (i = 0; i < count; i++) {
            String attachmentName = allVendorAttachmentsNames.get(i).getText();
            if (attachmentName.contains(AttachmentName)) {
                allVendorAttachmentsEyeIcons.get(i).click();
                break;
            }
        }
    }

    public void clickOnBidSettingsIcon() {
        clickOnElement(bidSettings);
    }

    public void ClickSubmissionConfirmYesBtn() {
        clickOnElement(submissionConfirmYesBtn);
    }

    public void clickSubmitPackageBtn() {
        clickOnElement(btnSubmitPackage);
    }

    public void clickAddVendorButton() {
        clickOnElement(addVendorButton);
    }

    public void clickIncludeVendorCheckbox() {
        clickOnElement(includeVendorCheckbox);
    }

    public void clickOnSearchBtn() {
        clickOnElement(searchBtn);
    }

    public void setSearchVendorByCode(String text) {
        setElement(searchVendorByCode, text);
    }

    public void openSearchVendor() {
        clickOnElement(searchVendor);
    }

    public void clickNextBtnToPublish() {
        clickOnElement(nextBtnToPublish);
    }

    public void clickNextBtnToQuoteItems() {
        clickOnElement(nextBtnToQuoteItems);
    }

    public void selectRequiredFromVendor() {
        clickOnElement(requiredFromVendor);
    }

    public void clickVendorSubCategory() {
        clickOnElement(vendorSubCategory);
    }

    public void clickAttachmentStatutoryDocument() {
        clickOnElement(attachmentStatutoryDocument);
    }

    public void clickContinueBtn() {
        clickOnElement(ContinueBtn);
    }

    public void clickIncludeDocumentCheckbox() {
        TimeUtil.midTime();
        clickOnElement(includeDocument);
    }

    public void clickUploadFileIcon() {
        clickOnElement(uploadFileIcon);
    }

    public void clickUploadDocumentsubTreeContainerExpand() {
        clickOnElement(uploadDocumentSubTreeContainerExpand);
    }

    public void clickUploadDocumentTreeContainerExpand() {
        clickOnElement(uploadDocumentTreeContainerExpand);
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

    public void clickOnAddDocuments() {
        TimeUtil.veryShortTime();
        clickOnElement(addDocumentsBtn);

    }

    public void selectCalenderDate() {
        clickOnElement(calenderSelectDate28);
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

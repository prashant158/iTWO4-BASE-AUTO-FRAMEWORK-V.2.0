package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P12_VendorManagementPage extends ElementUtil {
    private final WebDriver driver;

    @FindBy(css = "span[class='iti__country-name']")
    public List<WebElement> allFlags;
    @FindBy(className = "gridtitle")
    WebElement gridTitle;
    @FindBy(css = "div[title='Add Vendor'] i")
    WebElement addVendor;
    @FindBy(css = "div[title='Edit Vendor'] i")
    WebElement editVendor;
    @FindBy(id = "VendorCode")
    WebElement vendorCode;
    @FindBy(id = "VendorName")
    WebElement vendorName;
    @FindBy(xpath = "(//div[@class='eap_caretcell left'])[1]")
    WebElement contactGroupHeader;
    @FindBy(css = "div[title='Add Contact'] i")
    WebElement addContact;
    @FindBy(xpath = "//div[@title='Edit Contact']/i")
    WebElement editContact;
    @FindBy(id = "Name")
    WebElement name;
    @FindBy(id = "Contact")
    WebElement contact;
    @FindBy(id = "Designation")
    WebElement designation;
    @FindBy(id = "Email")
    WebElement email;
    @FindBy(xpath = "(//button[normalize-space()='Cancel'])[2]")
    WebElement btnCancel;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement btnSave;
    @FindBy(id = "btnSaveVendor")
    WebElement btnSaveVendor;
    @FindBy(xpath = "//button[@class='ccsnotify_button']")
    WebElement btnOK;
    @FindBy(css = "label[class='ccsnotify_body']")
    WebElement saveConfirmation;
    @FindBy(xpath = "//span[@class='valmsg-span']")
    WebElement vendorCodeValidation;
    @FindBy(xpath = "//input[@id='btnSubmitVendor']")
    WebElement finalizeVendor;
    @FindBy(xpath = "//body/div[6]")
    WebElement requiredDocumentValidation;
    @FindBy(xpath = "//input[@value='CANCEL']")
    WebElement getBtnCancel;
    @FindBy(xpath = "//div[normalize-space()='VENDOR003']")
    WebElement vendorlist;
    @FindBy(id = "btnDocUpload")
    WebElement btnUploadDocuments;
    @FindBy(xpath = "(//div[@id='jqcDocumentTreeContainer'])[1]/div[2]/div[1]/div[1]/div[1]/i")
    WebElement docCategoryTreeIconSecond;
    @FindBy(xpath = "(//i[@class='fas fa-caret-right'])[2]")
    WebElement docTypeTreeIcon;
    @FindBy(xpath = "(//div[@id='jqcDocumentTreeContainer'])[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")
    WebElement fileUploadOption;
    @FindBy(xpath = "(//td[contains(text(),'Amar')])[1]")
    WebElement contactDetailsRow;
    @FindBy(xpath = "(//button[@class='jqdialog_button ui-button ui-corner-all ui-widget'][normalize-space()='Close'])[1]")
    WebElement closeButtonVendorPopup;
    @FindBy(xpath = "(//div[@title='Search'])[1]/i")
    WebElement vendorSearchIcon;
    @FindBy(xpath = "//div[@class='slick-pane slick-pane-top slick-pane-left']//div[@class='slick-headerrow ui-state-default']")
    WebElement SearchbarPresent;
    @FindBy(xpath = "(//input[@type='text'])[1]")
    WebElement searchByVendorCode;
    @FindBy(xpath = "(//div[@class='slick-viewport slick-viewport-top slick-viewport-left'])[1]/div[1]/div[1]/div[3]")
    WebElement VendorNameFromGrid;


    public P12_VendorManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getVendorNameFromGrid() {
        return VendorNameFromGrid;
    }

    public void clickVendorSearchIcon() {
        clickOnElement(vendorSearchIcon);
    }

    public WebElement getGridTitle() {
        return gridTitle;
    }

    public void setAddVendor() {
        TimeUtil.veryShortTime();
        clickOnElement(addVendor);
    }

    public void editVendor() {
        TimeUtil.veryShortTime();
        clickOnElement(editVendor);
    }

    public void enterVendorCode(String vendor_code) {
        //TimeUtil.VeryshortTime();
        setElement(vendorCode, vendor_code);
    }

    public void setSearchVendors(String vendors) {
        //TimeUtil.VeryshortTime();

        if (SearchbarPresent.getAttribute("style").contains("display: none;")) {
            clickVendorSearchIcon();
            setElement(searchByVendorCode, vendors);
        }
        else
        {
            setElement(searchByVendorCode, vendors);
        }
    }

    public void enterVendorName(String vendor_name) {
        //TimeUtil.VeryshortTime();
        setElement(vendorName, vendor_name);
    }

    public void contactDetailsGroupClick() {
        TimeUtil.veryShortTime();
        clickOnElement(contactGroupHeader);
    }

    public void setAddVendorContact() {
        TimeUtil.veryShortTime();
        clickOnElement(addContact);
    }

    public void setEditVendorContact() {
        TimeUtil.veryShortTime();
        clickOnElement(editContact);
    }

    public void enterVendorContactName(String Contact_Name) {
        //TimeUtil.VeryshortTime();
        setElement(name, Contact_Name);
    }

    public void setContact(String no) {
        //TimeUtil.VeryshortTime();
        setElement(contact, no);
    }

    public void setDesignation(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(designation, value);
    }

    public void enterVendorContactEmail(String emailID) {
        //TimeUtil.VeryshortTime();
        setElement(email, emailID);
    }

    public void btnCancel() {
        //TimeUtil.VeryshortTime();
        clickOnElement(btnCancel);
    }

    public void btnSave() {
        TimeUtil.veryShortTime();
        clickOnElement(btnSave);
    }

    public void btnSaveVendor() {
        TimeUtil.veryShortTime();
        clickOnElement(btnSaveVendor);
    }

    public void setBtnOK() {
        TimeUtil.veryShortTime();
        clickOnElement(btnOK);
    }

    public WebElement getVerificationMsg() {
        return saveConfirmation;
    }

    public WebElement getVendorCodeValidation() {
        return vendorCodeValidation;
    }

    public void btnFinalizeVendor() {
        TimeUtil.veryShortTime();
        clickOnElement(finalizeVendor);
        TimeUtil.midTime();
    }

    public WebElement validationRequiredDocument() {
        TimeUtil.veryShortTime();
        return requiredDocumentValidation;
    }

    public void setCancelbtn() {
        TimeUtil.veryShortTime();
        clickOnElement(getBtnCancel);
    }

    public void setBtnUploadDocuments() {
        TimeUtil.veryShortTime();
        clickOnElement(btnUploadDocuments);
    }

    public void vendorGridClick() {
        TimeUtil.veryShortTime();
        clickOnElement(vendorlist);
    }

    public String VendorNumberGeneration() {
        TimeUtil.veryShortTime();
        String RN = randomNumber(10000);
        String Vendor_code = "VEN" + RN;
        return Vendor_code;
    }

    public void uploadDocumentCategoryTreeIcon() {
        TimeUtil.veryShortTime();
        clickOnElement(docCategoryTreeIconSecond);
    }

    public void uploadDocumentTypeTreeIcon() {
        TimeUtil.veryShortTime();
        clickOnElement(docTypeTreeIcon);
    }

    public void fileUploadOptionClick() {
        TimeUtil.veryShortTime();
        clickOnElement(fileUploadOption);

    }

    public WebElement fileUploadOptionElement() {
        TimeUtil.veryShortTime();
        return fileUploadOption;
    }

    public void uploadRequiredDoc(String location) {
        TimeUtil.veryShortTime();
        uploadFile(location);
    }

    public void clickContactDetailsRow() {
        TimeUtil.veryShortTime();
        clickOnElement(contactDetailsRow);
    }

    public void clickCloseBtn() {
        TimeUtil.midTime();
        clickOnElement(closeButtonVendorPopup);
    }

}

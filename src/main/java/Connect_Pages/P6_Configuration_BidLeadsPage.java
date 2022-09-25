package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P6_Configuration_BidLeadsPage extends ElementUtil {
    private final WebDriver driver;

    public P6_Configuration_BidLeadsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='iti__country-name']")
    public List<WebElement> allFlags;
    @FindBy(css = "div[title='Add Row'] i")
    WebElement addRow;
    @FindBy(css = "div[title='Edit Row']")
    WebElement editRow;
    @FindBy(css = "div[data-editorid$='titleid'] select")
    WebElement title;
    @FindBy(xpath = "//div[@data-editorid='name']//input[@type='text']")
    WebElement name;
    @FindBy(xpath = "//div[@data-editorid='surname']//input[@type='text']")
    WebElement surname;
    @FindBy(css = "div[data-editorid='contactnumber'] input")
    WebElement contact;
    @FindBy(xpath = "//div[@data-editorid='designationid']//select[@class='editor-select']")
    WebElement designation;
    @FindBy(xpath = "(//button[normalize-space()='Cancel'])[2]")
    WebElement btnCancel;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement btnSave;
    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-left']/div[1]/div[3]")
    WebElement firstBidLead;
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

    public void addBidLeadClick() {
        clickOnElement(addRow);
    }

    public void editBidLeadClick() {
        clickOnElement(editRow);
    }

    public void setTitleClick() {
        clickOnElement(title);
    }

    public void setTitle(Integer index) {
        TimeUtil.veryShortTime();
        selectDropdownByIndex(title, index);
    }

    public void enterBidLeadName(String bidLeadname) {
        //TimeUtil.VeryshortTime();
        setElement(name, bidLeadname);
    }

    public void enterBidLeadSurname(String bidLeadSurname) {
        //TimeUtil.VeryshortTime();
        setElement(surname, bidLeadSurname);
    }

    public void enterContactNo(String contactNo) {
        //TimeUtil.VeryshortTime();
        setElement(contact, contactNo);
    }

    public void setDesignation(String value) {
        //TimeUtil.VeryshortTime();
        selectDropdown(designation, value);
    }

    public void btnCancel() {
        //TimeUtil.VeryshortTime();
        clickOnElement(btnCancel);
    }

    public void btnSave() {
        clickOnElement(btnSave);
    }

    public WebElement getFirstBidLead() {
        TimeUtil.veryShortTime();
        return firstBidLead;
    }

    public WebElement getValidation_msg() {
        TimeUtil.veryShortTime();
        return validation_msg;
    }

    public void getContactFlag(String text) {
        TimeUtil.veryShortTime();
        clickOnElement(contactFlag);
        //ArrayList <String> flags = allFlags;
        int i;
        int count = allFlags.size();
        for (i = 0; i < count; i++) {
            if (allFlags.get(i).getText().contains(text)) {
                allFlags.get(i).click();
                break;
            }
        }
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

    public void refreshClick() {
        clickOnElement(refresh);
        TimeUtil.shortTime();
    }

    public String BidLeadNameGeneration() {
        TimeUtil.veryShortTime();
        String RN = randomNumber(10000);
        String BidLeadName = "Lead" + RN;
        return BidLeadName;
    }

}

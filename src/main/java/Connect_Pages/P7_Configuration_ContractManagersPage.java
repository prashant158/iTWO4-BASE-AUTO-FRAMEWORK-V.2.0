package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P7_Configuration_ContractManagersPage extends ElementUtil {
    private final WebDriver driver;

    public P7_Configuration_ContractManagersPage(WebDriver driver) {
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
    WebElement firstManager;
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

    public void addContractManagerClick() {
        clickOnElement(addRow);
    }

    public void editContractManagerClick() {
        clickOnElement(editRow);
    }

    public void setTitleClick() {
        clickOnElement(title);
    }

    public void setTitle(Integer index) {
        TimeUtil.veryShortTime();
        selectDropdownByIndex(title, index);
    }

    public void enterContractManagerName(String ContractManagerName) {
        //TimeUtil.VeryshortTime();
        setElement(name, ContractManagerName);
    }

    public void enterContractManagerSurname(String ContractManagerSurname) {
        //TimeUtil.VeryshortTime();
        setElement(surname, ContractManagerSurname);
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

    public WebElement getFirstManager() {
        TimeUtil.veryShortTime();
        return firstManager;
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

    public String ContractManagerGeneration() {
        TimeUtil.veryShortTime();
        String RN = randomNumber(10000);
        String Manager = "Manager" + RN;
        return Manager;
    }

}

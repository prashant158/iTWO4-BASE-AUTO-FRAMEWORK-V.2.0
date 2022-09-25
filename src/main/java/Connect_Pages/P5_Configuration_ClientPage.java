package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.Log;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P5_Configuration_ClientPage extends ElementUtil {
    private final WebDriver driver;

    public P5_Configuration_ClientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
    @FindBy(css = ".valmsg-span")
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
    @FindBy(xpath = "//div[@class='gridtitle']")
    WebElement gridTitle;

    public void addClientClick() {
        TimeUtil.veryShortTime();
        clickOnElement(addRow);
    }

    public void editClientClick()
    {
        clickOnElement(editRow);
    }

    public String ClientNameGeneration()
    {
        TimeUtil.veryShortTime();
        String RN = randomNumber(10000);
        String Client_Name = "Client" + RN;
        return Client_Name;
    }

    public void enterClientName(String client_name) throws Exception {
        Log.info("Entering Method: [" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
        try {
            //TimeUtil.VeryshortTime();
            setElement(name, client_name);
        } catch (Exception e) {
           throw new Exception("Error occurred in " + Thread.currentThread().getStackTrace()[1].getMethodName() + " :\n" + e.getMessage());
        }
    }

    public void enterNameOfContact(String contact_person_name) {
        //TimeUtil.VeryshortTime();
        setElement(contactName, contact_person_name);
    }

    public void setContact(String no) {
        //TimeUtil.VeryshortTime();
        setElement(contact, no);
    }

    public void setSector(int value) {
        //TimeUtil.VeryshortTime();
        selectDropdownByIndex(sector, value);
    }

    public void setSubSector(int SubSectorValue) {
        //TimeUtil.VeryshortTime();
        selectDropdownByIndex(subSector, SubSectorValue);
    }

    public void btnCancel() {
        //TimeUtil.VeryshortTime();
        clickOnElement(btnCancel);
    }

    public void btnSave() {
        clickOnElement(btnSave);
    }

    public WebElement getFirstClient() {
        TimeUtil.veryShortTime();
        return firstClient;
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

    public WebElement getGridTitle() {
        return gridTitle;
    }

    public void refreshClick() {
        clickOnElement(refresh);
        TimeUtil.shortTime();
    }

}

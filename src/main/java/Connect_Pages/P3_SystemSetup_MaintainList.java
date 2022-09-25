package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P3_SystemSetup_MaintainList extends ElementUtil {
    private final WebDriver driver;

    public P3_SystemSetup_MaintainList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@title='Copy from Global'])[3]")
    WebElement copyFromGlobalDesignation;
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement selectDesignation;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;
    @FindBy(xpath = "(//div[@title='Save List'])[3]")
    WebElement saveButton;
    @FindBy(xpath = "(//div[@title='Add Item'])[3]")
    WebElement addItemToList;
    @FindBy(xpath = "//div[@id='configurationContainer']/div[3]/div[1]/div[2]/div[2]/div/div")
    public List<WebElement> allDesignations;

    public void setCopyFromGlobal() {
        TimeUtil.veryShortTime();
        clickOnElement(copyFromGlobalDesignation);
    }

    public void selectDesignation() {
        TimeUtil.veryShortTime();
        clickOnElement(selectDesignation);
    }

    public void setAddButton() {
        TimeUtil.veryShortTime();
        clickOnElement(addButton);
    }

    public void setSaveButton() {
        TimeUtil.veryShortTime();
        clickOnElement(saveButton);
    }

    public void setAddItemToList() {
        TimeUtil.veryShortTime();
        clickOnElement(addItemToList);
    }

    public int designationCount() {
        TimeUtil.veryShortTime();
        int count;
        count = allDesignations.size();
        return count;
    }

    public String ItemNumberGeneration() {
        TimeUtil.veryShortTime();
        String RN = randomNumber(1000);
        String Item_code = "NewItem" + RN;
        return Item_code;
    }

    public void enterItemName(String text) {
        elementTyping(text);
    }

}

package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P18_QuoteCompare_Page extends ElementUtil {
    private final WebDriver driver;
    @FindBy(xpath = "//img[@title='Package Setup']")
    public List<WebElement> packageSetupIcon;
    @FindBy(xpath = "//div[@id='subcontractContainer']/div[2]/div[4]/div[3]/div[1]/div/div[2]")
    public List<WebElement> allPackages;
    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> AllCheckBoxes;
    @FindBy(xpath = "(//div[@class='grid-canvas grid-canvas-top grid-canvas-left'])[1]/div/div[7]")
    public List<WebElement> AllSubmissionStatus;
    @FindBy(xpath = "//div[@class='quick-grid-row quick-grid-header-group-row']/div[2]/div[1]/div[2]")
    WebElement Vendor1Code;
    @FindBy(xpath = "//div[@class='quick-grid-row quick-grid-header-group-row']/div[3]/div[1]/div[2]")
    WebElement Vendor2Code;
    @FindBy(xpath = "(//div[@class='quick-grid-container'])[2]/div[2]/div[1]/div[3]")
    WebElement quoteAmountVendor1;
    @FindBy(xpath = "//div[@class='quick-grid-row quick-grid-header-group-row']/div[3]/div[1]/div[1]")
    WebElement Vendor2Name;
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement SelectVendorToUpload;
    @FindBy(xpath = "(//input[@id='btnUploadToCandy'])[1]")
    WebElement UploadToCandyBtn;
    @FindBy(xpath = "(//button[normalize-space()='Yes'])[1]")
    WebElement YesBtn;
    @FindBy(xpath = "//label[contains(text(),'The selected quote(s) have successfully')]")
    WebElement PrepareUploadCandyMsg;
    @FindBy(xpath = "//button[@class='ccsnotify_button']")
    WebElement OkBtn;



    public P18_QuoteCompare_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOkBtn() {
        clickOnElement(OkBtn);
    }

    public WebElement confirmationMsg() {
        return PrepareUploadCandyMsg;
    }

    public void clickYesBtn() {
        clickOnElement(YesBtn);
    }

    public void clickUploadToCandyBtn() {
        clickOnElement(UploadToCandyBtn);
    }

    public void clickVendorCheckbox() {
        clickOnElement(SelectVendorToUpload);
    }

    public WebElement getQuoteAmountVendor1() {
        return quoteAmountVendor1;
    }

    public WebElement getFirstVendorCode() {
        return Vendor1Code;
    }

    public WebElement getSecondVendorCode() {
        return Vendor2Code;
    }

    public WebElement getSecondVendorName() {
        return Vendor2Name;
    }

    public boolean getSubmissionStatus() {
        TimeUtil.veryShortTime();
        String SubmissionStatus = "Accepted for Adjudication";
        boolean isAcceptedForAdjudication = true;
        boolean isActive;
        int i;
        int count = AllCheckBoxes.size();
        for (i = 0; i < count; i++) {
            /* if (AllCheckBoxes.get(i).getAttribute("class").contains("chkActive")) {
               SubmissionStatus != AllSubmissionStatus.get(i).getText();
               break;
           } */
            isActive = AllCheckBoxes.get(i).getAttribute("class").contains("chkActive");
            if (isActive) {
                if (!SubmissionStatus.equals(AllSubmissionStatus.get(i).getText())) {
                    isAcceptedForAdjudication = false;
                    break;
                }
            }
        }
        return isAcceptedForAdjudication;
    }
}

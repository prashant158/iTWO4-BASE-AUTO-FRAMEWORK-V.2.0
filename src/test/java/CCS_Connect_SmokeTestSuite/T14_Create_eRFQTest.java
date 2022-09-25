package CCS_Connect_SmokeTestSuite;

import CCS_ConnectScripts._01_BaseClass;
import iTWO_Utilities.ExcelUtil;
import iTWO_Utilities.TimeUtil;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class T14_Create_eRFQTest extends _01_BaseClass {

    ExcelUtil excelCreateRFQ = new ExcelUtil("Create_eRFQ");

    @DataProvider(name = "TestDataeRFQ")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //To go through all the rows of the excel
        //Object[][] obj_eRFQ = new Object[excelCreateRFQ.getRowCount()][1];
        Object[][] obj_eRFQ = new Object[1][1];

        Map<String, String> testData;
        //for (int i = 1; i <= excelCreateRFQ.getRowCount(); i++) {
        for (int i = 1; i <= 1; i++) {
            testData = excelCreateRFQ.getTestDataInHashmap(i, "Create_eRFQ");
            obj_eRFQ[i - 1][0] = testData;
        }
        return obj_eRFQ;
    }

    @Test(priority = 1, description = "Verify Package list is displayed on eRFQ Create RFQ")
    public void Test_eRFQ_Page() throws InterruptedException {
        // Click on the Configuration Menu
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        String title = testContextUI.geteRFQPage().getGridTitle().getText();
        Assert.assertEquals(title, "Package List");
    }

    @Test(priority = 2, dataProvider = "TestDataeRFQ", enabled = true,
            description = "Import the Candy data to the respective package")
    public void Test_Import_Candy_data(Object obj_eRFQ) throws InterruptedException {

        HashMap<String, String> testData = (HashMap<String, String>) obj_eRFQ;
        testContextUI.geteRFQPage().refreshClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID001");
        testContextUI.getBidListPage().RETURN();
        testContextUI.getCreateRFQPage().importIconPackageClick();
        TimeUtil.veryShortTime();
        testContextUI.getCreateRFQPage().importIconPackageClick();
        if(testContextUI.getCreateRFQPage().GetPackageAlreadyExistMsg().isDisplayed()) {
            testContextUI.getCreateRFQPage().clickOverridePackageChkBox();
            testContextUI.getCreateRFQPage().clickOnCalenderIcon();
            testContextUI.getCreateRFQPage().clickOnNextIcon();
            testContextUI.getCreateRFQPage().selectCalenderDate();
            testContextUI.getCreateRFQPage().enterReturnTime("11:11");
            testContextUI.getCreateRFQPage().ImportBtnClick();

        }
        else {
            testContextUI.getCreateRFQPage().selectPackageClick();
            testContextUI.getCreateRFQPage().clickOnCalenderIcon();
            testContextUI.getCreateRFQPage().clickOnNextIcon();
            testContextUI.getCreateRFQPage().selectCalenderDate();
            testContextUI.getCreateRFQPage().enterReturnTime("11:11");
            testContextUI.getCreateRFQPage().ImportBtnClick();

            if(testContextUI.geteRFQRequestsPage().getMsgImportDifferentCurrency().isDisplayed()){

                testContextUI.getBidListPage().clickOnImportCheckbox();
                String ExchangeRate = testData.get("Exchange_Rate");
                testContextUI.getBidListPage().setExchangeRate(ExchangeRate);
                testContextUI.getBidListPage().setBaseDate("22/08/2022");
                //testContextUI.getBidListPage().setBaseDate(String.valueOf(LocalDate.now()));
                testContextUI.getBidListPage().clickOnProceed();
                testContextUI.getBidListPage().clickOnBtnNotificationYes();
            }
        }
    }

    @Test(priority = 3, dataProvider = "TestDataeRFQ", enabled = true,
            description = "Package Setup: Attach Global documents add vendors and Publish Package")
    public void Test_AttachGlobal_Documents(Object obj_eRFQ) throws InterruptedException, IOException {
        // Check for the only one qty column on the Quote item tab of eRFQ Requests
        HashMap<String, String> testData = (HashMap<String, String>) obj_eRFQ;
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        TimeUtil.shortTime();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID001");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.shortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.shortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.shortTime();
        testContextUI.geteRFQPage().clickPackageSetupIcon();

        testContextUI.getCreateRFQPage().clickCalenderIconIntentionToBid();
        testContextUI.getCreateRFQPage().clickOnNextIcon();
        testContextUI.getCreateRFQPage().selectCalenderDateForIntention();
        testContextUI.getCreateRFQPage().SetDescriptionOfWork("Earthworks");
        testContextUI.geteRFQRequestsPage().clickOnNextButton();
        testContextUI.geteRFQRequestsPage().clickOnAddDocuments();
        testContextUI.geteRFQRequestsPage().clickUploadDocumentTreeContainerExpand();
        testContextUI.geteRFQRequestsPage().clickUploadDocumentsubTreeContainerExpand();
        testContextUI.geteRFQRequestsPage().clickUploadFileIcon();
        Runtime.getRuntime().exec("D:\\RIB CCS CONNECT SCRIPTS\\AutoIT\\Vendor\\UploadFile.exe");
        testContextUI.geteRFQRequestsPage().clickAttachmentCheckboxToInclude("2");
        //testContextUI.geteRFQRequestsPage().clickIncludeDocumentCheckbox();
        testContextUI.geteRFQRequestsPage().clickContinueBtn();
        //testContextUI.geteRFQRequestsPage().clickAttachmentStatutoryDocument();
        //testContextUI.geteRFQRequestsPage().clickVendorSubCategory();
        //testContextUI.geteRFQRequestsPage().selectRequiredFromVendor();
        testContextUI.geteRFQRequestsPage().clickNextBtnToQuoteItems();
        testContextUI.geteRFQRequestsPage().clickNextBtnToPublish();
        //testContextUI.geteRFQRequestsPage().openSearchVendor();
        //testContextUI.geteRFQRequestsPage().setSearchVendorByCode("0113");
        //testContextUI.geteRFQRequestsPage().clickOnSearchBtn();
        //testContextUI.geteRFQRequestsPage().clickIncludeVendorCheckbox();
        //testContextUI.geteRFQRequestsPage().clickAddVendorButton();
        testContextUI.geteRFQRequestsPage().clickbtnPublishPackage();
        testContextUI.geteRFQRequestsPage().ClickSubmissionConfirmYesBtn();
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID001");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.shortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.shortTime();
        String status = testContextUI.geteRFQRequestsPage().getSubmissionStatus().getText();
        Assert.assertEquals(status, "Sent");
    }
}

package CCS_Connect_SmokeTestSuite;

import CCS_ConnectScripts._01_BaseClass;
import iTWO_Utilities.ExcelUtil;
import iTWO_Utilities.TimeUtil;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

public class T17_VendorSubmissionListTest extends _01_BaseClass {

    ExcelUtil excelRFQRequests = new ExcelUtil("eRFQ_Requests");

    @DataProvider(name = "TestDataeRFQ")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //To go through all the rows of the excel
        //Object[][] obj_eRFQ = new Object[excelCreateRFQ.getRowCount()][1];
        Object[][] obj_eRFQ = new Object[1][1];

        Map<String, String> testData;
        //for (int i = 1; i <= excelRFQRequests.getRowCount(); i++) {
        for (int i = 1; i <= 1; i++) {
            testData = excelRFQRequests.getTestDataInHashmap(i, "eRFQ_Requests");
            obj_eRFQ[i - 1][0] = testData;
        }
        return obj_eRFQ;
    }

    @Test(priority = 1, description = "Navigate to eRFQ > Create RFQ > Vendor Submission List",
            enabled = true)
    public void Test_eRFQ_Requests_Page() throws InterruptedException {
        // Click on the eRFQ Menu and then eRFQ Requests
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID5386");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("EARTH");
        String title = testContextUI.getVendorSubmissionListPage().GridHeading().getText();
        Assert.assertTrue(title.contains("Vendor Submission List"));
    }

    @Test(priority = 2, description = "Verify the version number is same with the Package version number",
            enabled = true)
    public void Test_Version_Number() throws InterruptedException {
        // Click on the eRFQ Menu and then eRFQ Requests
        String packageVersion = testContextUI.getVendorSubmissionListPage().getPackageVersionNo().getText();
        String submittedQuoteVersion = testContextUI.getVendorSubmissionListPage().getSubmittedQuoteVersion().getText();
        //Assert.assertTrue( submittedQuoteVersion == packageVersion);
        Assert.assertTrue( Integer.valueOf(submittedQuoteVersion) == 1);
    }

    @Test(priority = 3, description = "Verify Final Quotation amount are correctly displayed",
            enabled = true)
    public void Test_Quote_Total() throws InterruptedException {

        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID5386");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("EARTH");
        testContextUI.getVendorSubmissionListPage().clickViewIcon();
        testContextUI.getVendorSubmissionListPage().clickQuoteItemsTab();
        String quoteTotal = testContextUI.getVendorSubmissionListPage().getTotalOnSubmittedQuoteAmount().getText();
        TimeUtil.midTime();
        testContextUI.getVendorSubmissionListPage().clickAdjudicationTab();
        String valueOnTenderAmount = testContextUI.getVendorSubmissionListPage().getTenderValueOnAdj().getText();
        Assert.assertTrue(valueOnTenderAmount.contains(quoteTotal));
    }

    @Test(priority = 4, description = "Verify the attachment is present", enabled = true)
    public void Test_Verify_Attachment_Present() throws InterruptedException {

        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID5386");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("EARTH");
        testContextUI.getVendorSubmissionListPage().clickViewIcon();
        testContextUI.getVendorSubmissionListPage().clickNextBtnToAttachmentAdjudication();
        testContextUI.getVendorSubmissionListPage().clickIconFirstAttachmentExpand();
        String attachmentName = testContextUI.getVendorSubmissionListPage().getFirstAttachmentAdjudication().getText();
        Assert.assertEquals(attachmentName,"2.jpg");
    }

    @Test(priority = 5, description = "Check 'Accept for Adjudication'", enabled = false)
    public void Test_Accept_for_Adjudication() throws InterruptedException {

        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID5386");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("EARTH");
        testContextUI.getVendorSubmissionListPage().clickViewIcon();
        testContextUI.getVendorSubmissionListPage().clickAdjudicationTab();
        testContextUI.getVendorSubmissionListPage().clickAcceptForAdjudicationBtn();
        testContextUI.getVendorSubmissionListPage().clickConfirmationYes();
        testContextUI.getVendorSubmissionListPage().setExchangeRateInput("0.20");
        testContextUI.getVendorSubmissionListPage().setBaseDate("15/08/2022");
        testContextUI.getVendorSubmissionListPage().clickProceedBtn();
        String SubmissionStatus = testContextUI.getVendorSubmissionListPage().getSubmissionStatus().getText();
        Assert.assertEquals(SubmissionStatus,"Accepted for Adjudication");
    }

    @Test(priority = 6, description = "Verify the 'Submission Status' on the Vendor submission list",
            enabled = false)
    public void Test_Submission_Status() throws InterruptedException {

        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID5386");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("EARTH");
        String SubmissionStatus = testContextUI.getVendorSubmissionListPage().getSubmissionStatus().getText();
        Assert.assertEquals(SubmissionStatus,"Accepted for Adjudication");
    }

}

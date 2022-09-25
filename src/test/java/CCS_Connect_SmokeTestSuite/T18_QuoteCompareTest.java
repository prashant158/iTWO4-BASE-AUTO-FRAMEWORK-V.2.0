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

public class T18_QuoteCompareTest extends _01_BaseClass {

    ExcelUtil excelQuoteCompare = new ExcelUtil("quote_Compare");

    @DataProvider(name = "TestDataQuoteCompare")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //To go through all the rows of the excel
        //Object[][] obj_eRFQ = new Object[excelQuoteCompare.getRowCount()][1];
        Object[][] obj_quoteCompare = new Object[1][1];

        Map<String, String> testData;
        //for (int i = 1; i <= excelQuoteCompare.getRowCount(); i++) {
        for (int i = 1; i <= 1; i++) {
            testData = excelQuoteCompare.getTestDataInHashmap(i, "quote_Compare");
            obj_quoteCompare[i - 1][0] = testData;
        }
        return obj_quoteCompare;
    }

    @Test(priority = 1, enabled = true,
            description = "Verify 'Quote Compare Screen' shows the data for the selected vendors correctly")
    public void Test_VendorCode_On_QuoteCompare() throws InterruptedException {
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID065");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("PLUMB");
        testContextUI.geteRFQPage().clickCompareQuoteAmar();
        testContextUI.geteRFQPage().clickCompareQuoteAmarGmail();
        testContextUI.geteRFQPage().setBtnCompareQuote();
        String FirstVendor = testContextUI.getQuoteComparePage().getFirstVendorCode().getText();
        String SecondVendor = testContextUI.getQuoteComparePage().getSecondVendorCode().getText();
        Assert.assertTrue(FirstVendor.contains("0113"));
        Assert.assertTrue(SecondVendor.contains("AmarGmail"));
    }

    @Test(priority = 2, enabled = true,
            description = "Verify the final Quotation amount for each selected vendor")
    public void Test_FinalQuoteAmount(Object obj_quoteCompare) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_quoteCompare;
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID065");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("PLUMB");
        testContextUI.geteRFQPage().clickCompareQuoteAmar();
        testContextUI.geteRFQPage().clickCompareQuoteAmarGmail();
        testContextUI.geteRFQPage().setBtnCompareQuote();
        String QuoteAmt1 = testContextUI.getQuoteComparePage().getQuoteAmountVendor1().getText();
        String Vendor1_Total = testData.get("Vendor1_Total");
        Assert.assertEquals(QuoteAmt1, Vendor1_Total);
    }

    @Test(priority = 3, enabled = true, description = "Check if only those quotes 'Accepted for Adjudication' should be ticked for comparison")
    public void Test_Submission_Status_and_Checkboxes(Object obj_quoteCompare) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_quoteCompare;
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID065");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("PLUMB");
        boolean CorrectStatus = testContextUI.getQuoteComparePage().getSubmissionStatus();
        Assert.assertEquals(CorrectStatus, true);
    }

    @Test(priority = 4, enabled = true,
            description = "Verify if only selected vendors are displayed on the comparison page")
    public void Test_SelectedVendorName_QuoteCompare() throws InterruptedException {

        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID065");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("PLUMB");
        //testContextUI.geteRFQPage().clickCompareQuoteAmar();
        testContextUI.geteRFQPage().clickCompareQuoteAmarGmail();
        testContextUI.geteRFQPage().setBtnCompareQuote();
        String SecondVendorName = testContextUI.getQuoteComparePage().getSecondVendorName().getText();
        Assert.assertTrue(SecondVendorName.contains("Amar"));
    }

    @Test(priority = 5, enabled = true,
            description = "Confirm sending data back to Candy Functionality")
    public void Test_SendData_Candy() throws InterruptedException {

        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID065");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("PLUMB");
        //testContextUI.geteRFQPage().clickCompareQuoteAmar();
        testContextUI.geteRFQPage().clickCompareQuoteAmarGmail();
        testContextUI.geteRFQPage().setBtnCompareQuote();
        testContextUI.getQuoteComparePage().clickVendorCheckbox();
        testContextUI.getQuoteComparePage().clickUploadToCandyBtn();
        testContextUI.getQuoteComparePage().clickYesBtn();
        String ConfirmationMsg = testContextUI.getQuoteComparePage().confirmationMsg().getText();
        Assert.assertTrue(ConfirmationMsg.contains("successfully been prepared for download to Candy"));
        testContextUI.getQuoteComparePage().clickOkBtn();

    }

}

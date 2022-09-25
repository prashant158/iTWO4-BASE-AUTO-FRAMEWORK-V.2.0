package CCS_Connect_SmokeTestSuite;

import CCS_ConnectScripts._01_BaseClass;
import iTWO_Utilities.ExcelUtil;
import iTWO_Utilities.TimeUtil;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class T09_Estimating_BidListTest extends _01_BaseClass {

    ExcelUtil excelBidList = new ExcelUtil("Estimating_BidList");

    @DataProvider(name = "TestDataBidList")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //To go through all the rows of the excel
        //Object[][] obj_BidList = new Object[excelBidList.getRowCount()][1];
        Object[][] obj_BidList = new Object[1][1];

        Map<String, String> testData;
        //for (int i = 1; i <= excelBidList.getRowCount(); i++) {
        for (int i = 1; i <= 1; i++) {
            testData = excelBidList.getTestDataInHashmap(i, "Estimating_BidList");
            obj_BidList[i - 1][0] = testData;
        }
        return obj_BidList;
    }

    @Test(priority = 1, description = "Verify Bid List page is loaded")
    public void Test_BidList_Page() throws InterruptedException {
        // Click on the Estimating Menu
        testContextUI.getHomePage().EstimatingClick();
        testContextUI.getHomePage().optionBidListClick();
        String title = testContextUI.getBidListPage().getGridTitle().getText();
        Assert.assertEquals(title, "Bid List");
    }

    @Test(priority = 2, dataProvider = "TestDataBidList", enabled = true,
            description = "Verify saving of a new 'Bid'")
    public void Test_Save_Bid(Object obj_BidList) throws InterruptedException {
        // Click on Add new Bid
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getBidListPage().refreshClick();
        testContextUI.getBidListPage().addBidClick();
        TimeUtil.midTime();
        //String bid_number = testData.get("Bid_Number");
        String bid_number = testContextUI.getBidListPage().BidNumberGeneration();
        testContextUI.getBidListPage().enterBidNo(bid_number);
        //String bid_name = testData.get("Bid_Name");
        testContextUI.getBidListPage().enterBidName(bid_number);
        String BidClient = testData.get("Bid_Client");
        testContextUI.getBidListPage().setBidClient(BidClient);
        String BidLead = testData.get("Bid_Lead");
        testContextUI.getBidListPage().setBidLead(BidLead);
        String ConstructionType = testData.get("Construction_type");
        testContextUI.getBidListPage().setConstructionType(ConstructionType);
        String DocumentReceived = testData.get("Doc_Received_date");
        testContextUI.getBidListPage().enterDocReceivedDate(DocumentReceived);
        String SubmissionDate = testData.get("Submission_date");
        testContextUI.getBidListPage().enterBidSubmissionDate(SubmissionDate);
        //String SubmissionTime = testData.get("submission_time");
        testContextUI.getBidListPage().enterBidSubmissionTime("12:00");
        String InspectionDate = testData.get("Inspection_date");
        testContextUI.getBidListPage().enterSiteInspectionDate(InspectionDate);
        String StartDate = testData.get("start_date");
        testContextUI.getBidListPage().enterStartDate(StartDate);
        String CompletionDate = testData.get("completion_date");
        testContextUI.getBidListPage().enterCompletionDate(CompletionDate);
        String Status = testData.get("status");
        testContextUI.getBidListPage().setStatus(Status);
        testContextUI.getBidListPage().clickBidLocation();
        testContextUI.getBidListPage().getAddress("Canada Corner, Nashik");
        testContextUI.getBidListPage().TAB(6);
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().btnSave();
        testContextUI.getBidListPage().addBidClick();
        testContextUI.getBidListPage().btnCancel();
        String BidNumber = testContextUI.getBidListPage().getFirstBid().getText();
        //Assert.assertEquals(BidNumber, bid_number);
        Assert.assertEquals(BidNumber, bid_number);
    }

    @Test(priority = 4, dataProvider = "TestDataBidList", enabled = false,
            description = "Verify 'Edit' existing Bid record")
    public void Test_Edit_Bid(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getBidListPage().refreshClick();
        testContextUI.getBidListPage().setSearchByBidNumber("BID084");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.getBidListPage().editBidClick();
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().editBidClick();
        String ConstructionType = testData.get("Construction_type");
        testContextUI.getBidListPage().setConstructionType(ConstructionType);
        String DocumentReceived = testData.get("Doc_Received_date");
        testContextUI.getBidListPage().enterDocReceivedDate(DocumentReceived);
        String SubmissionDate = testData.get("Submission_date");
        String InspectionDate = testData.get("Inspection_date");
        testContextUI.getBidListPage().enterSiteInspectionDate(InspectionDate);
        String StartDate = testData.get("start_date");
        testContextUI.getBidListPage().enterStartDate(StartDate);
        String CompletionDate = testData.get("completion_date");
        testContextUI.getBidListPage().enterCompletionDate(CompletionDate);
        String Status = testData.get("status");
        testContextUI.getBidListPage().setStatus(Status);
        testContextUI.getBidListPage().clickBidLocation();
        testContextUI.getBidListPage().getAddress("Canada Corner, Nashik");
        testContextUI.getBidListPage().TAB(6);
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().btnSave();
        //testContextUI.getBidListPage().btnCancel();
        String BidNumber = testContextUI.getBidListPage().getFirstBid().getText();
        Assert.assertEquals(BidNumber, "BID086");
        //Assert.assertEquals(BidNumber, "BID087");
    }

    @Test(priority = 3, dataProvider = "TestDataBidList", enabled = true,
    description = "Check for the duplicate Bid number")
    public void Test_Duplicate_Bid_No(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getBidListPage().refreshClick();
        testContextUI.getBidListPage().addBidClick();
        TimeUtil.midTime();
        //String bid_number = testData.get("Bid_Number");
        testContextUI.getBidListPage().enterBidNo("BID001");
        //String bid_name = testData.get("Bid_Name");
        testContextUI.getBidListPage().enterBidName("B001");
        String BidClient = testData.get("Bid_Client");
        testContextUI.getBidListPage().setBidClient(BidClient);
        String BidLead = testData.get("Bid_Lead");
        testContextUI.getBidListPage().setBidLead(BidLead);
        String ConstructionType = testData.get("Construction_type");
        testContextUI.getBidListPage().setConstructionType(ConstructionType);
        String DocumentReceived = testData.get("Doc_Received_date");
        testContextUI.getBidListPage().enterDocReceivedDate(DocumentReceived);
        String SubmissionDate = testData.get("Submission_date");
        testContextUI.getBidListPage().enterBidSubmissionDate(SubmissionDate);
        String InspectionDate = testData.get("Inspection_date");
        testContextUI.getBidListPage().enterSiteInspectionDate(InspectionDate);
        String StartDate = testData.get("start_date");
        testContextUI.getBidListPage().enterStartDate(StartDate);
        String CompletionDate = testData.get("completion_date");
        testContextUI.getBidListPage().enterCompletionDate(CompletionDate);
        String Status = testData.get("status");
        testContextUI.getBidListPage().setStatus(Status);
        testContextUI.getBidListPage().clickBidLocation();
        testContextUI.getBidListPage().getAddress("Canada Corner, Nashik");
        testContextUI.getBidListPage().TAB(6);
       //String SubmissionTime = testData.get("submission_time");
        testContextUI.getBidListPage().enterBidSubmissionTime("12:00");
        testContextUI.getBidListPage().btnSave();
        //testContextUI.getBidListPage().btnCancel();
        String Validation_Msg = testContextUI.getBidListPage().getValidation_msg().getText();
        Assert.assertEquals(Validation_Msg, "Bid number already exists");
        testContextUI.getBidListPage().btnCancel();
    }

    @Test(priority = 5, dataProvider = "TestDataBidList", enabled = true,
    description = "Import Candy data for a Bid and Capture the exchange rate if Bid & org currency are different")
    public void Test_ImportBid_From_Candy(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().setSearchByBidNumber("BID001");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().clickOnImportCandyData();
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().clickOnImportCandyData();
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().clickOnImportButton();
        TimeUtil.veryShortTime();
        if(testContextUI.getBidListPage().notificationAlert().isDisplayed()){
            testContextUI.getBidListPage().clickOnBtnNotificationYes();
        }
        else {

            testContextUI.getBidListPage().clickOnImportCheckbox();
            String ExchangeRate = testData.get("Exchange_Rate");
            testContextUI.getBidListPage().setExchangeRate(ExchangeRate);
            testContextUI.getBidListPage().setBaseDate("22/08/2022");
            //testContextUI.getBidListPage().setBaseDate(String.valueOf(LocalDate.now()));
            testContextUI.getBidListPage().clickOnProceed();
            //testContextUI.getBidListPage().clickOnBtnCancel();
        }
        String GridTitle = testContextUI.getBidListPage().getBidFinalizationTitle().getText();
        Assert.assertEquals(GridTitle, "Topsheet");
    }

    @Test(priority = 6, dataProvider = "TestDataBidList", enabled = true,
    description = "Verify the topSheet page is loaded")
    public void Test_BidFinalization(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getHomePage().EstimatingClick();
        testContextUI.getHomePage().optionBidListClick();
        testContextUI.getBidListPage().setSearchByBidNumber("BID001");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().bidFinalizationIconClick();
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().bidFinalizationIconClick();
        TimeUtil.veryShortTime();
        String GridTitle = testContextUI.getBidListPage().getBidFinalizationTitle().getText();
        Assert.assertEquals(GridTitle, "Topsheet");
    }

    @Test(priority = 7, dataProvider = "TestDataBidList", enabled = false)
    public void Test_SearchAndDelete_Bid(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;

        TimeUtil.midTime();
        testContextUI.getBidListPage().setSearchByBidNumber("BID021");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.getBidListPage().deleteBidClick();
        testContextUI.getBidListPage().deleteBidClick();
        testContextUI.getBidListPage().declineAlertNotification();
    }
}

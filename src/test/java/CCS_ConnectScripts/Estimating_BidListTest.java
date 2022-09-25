package CCS_ConnectScripts;

import com.codoid.products.utils.DateUtil;
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

public class Estimating_BidListTest extends _01_BaseClass {

    ExcelUtil excelBidList = new ExcelUtil("Estimating_BidList");

    @DataProvider(name = "TestDataBidList")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //To go through all the rows of the excel
        //Object[][] obj_client = new Object[excelBidList.getRowCount()][1];
        Object[][] obj_BidList = new Object[1][1];

        Map<String, String> testData;
        //for (int i = 1; i <= excelBidList.getRowCount(); i++) {
        for (int i = 1; i <= 1; i++) {
            testData = excelBidList.getTestDataInHashmap(i, "Estimating_BidList");
            obj_BidList[i - 1][0] = testData;
        }
        return obj_BidList;
    }

    @Test(priority = 1)
    public void Test_BidList_Page() throws InterruptedException {
        // Click on the Configuration Menu
        testContextUI.getHomePage().EstimatingClick();
        testContextUI.getHomePage().optionBidListClick();
        String title = testContextUI.getBidListPage().getGridTitle().getText();
        Assert.assertEquals(title, "Bid List");
    }

    @Test(priority = 2, dataProvider = "TestDataBidList", enabled = false)
    public void Test_Save_Bid(Object obj_BidList) throws InterruptedException {
        // Click on Add new client
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getBidListPage().addBidClick();
        TimeUtil.midTime();
        String bid_number = testData.get("Bid_Number");
        testContextUI.getBidListPage().enterBidNo(bid_number);
        String bid_name = testData.get("Bid_Name");
        testContextUI.getBidListPage().enterBidName(bid_name);
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
        String SubmissionTime = testData.get("submission_time");
        testContextUI.getBidListPage().enterBidSubmissionTime(SubmissionTime);
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
        //testContextUI.getBidListPage().btnSave();
        testContextUI.getBidListPage().btnCancel();
        String BidNumber = testContextUI.getBidListPage().getFirstBid().getText();
        //Assert.assertEquals(BidNumber, bid_number);
        Assert.assertEquals(BidNumber, "BID058");
    }

    @Test(priority = 3, dataProvider = "TestDataBidList", enabled = false)
    public void Test_Edit_Bid(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getBidListPage().editBidClick();
        TimeUtil.veryShortTime();
        String bid_name = testData.get("Bid_Name");
        testContextUI.getBidListPage().enterBidName(bid_name);
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
        String SubmissionTime = testData.get("submission_time");
        testContextUI.getBidListPage().enterBidSubmissionTime(SubmissionTime);
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
        //testContextUI.getBidListPage().btnSave();
        testContextUI.getBidListPage().btnCancel();
        String BidNumber = testContextUI.getBidListPage().getFirstBid().getText();
        //Assert.assertEquals(BidNumber, bid_number);
        Assert.assertEquals(BidNumber, "BID058");
    }

    @Test(priority = 4, dataProvider = "TestDataBidList", enabled = false)
    public void Test_Same_Bid_No(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getBidListPage().addBidClick();
        TimeUtil.midTime();
        //String bid_number = testData.get("Bid_Number");
        testContextUI.getBidListPage().enterBidNo("BID057");
        String bid_name = testData.get("Bid_Name");
        testContextUI.getBidListPage().enterBidName(bid_name);
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
        String SubmissionTime = testData.get("submission_time");
        testContextUI.getBidListPage().enterBidSubmissionTime(SubmissionTime);
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
        String Validation_Msg = testContextUI.getBidListPage().getValidation_msg().getText();
        Assert.assertEquals(Validation_Msg, "Bid number already exists");
    }

    @Test(priority = 5, dataProvider = "TestDataBidList", enabled = false)
    public void Test_SearchBidNo(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getBidListPage().clickGridMenu();
        testContextUI.getBidListPage().clickResetDefault();
        testContextUI.getBidListPage().acceptAlertNotification();
        testContextUI.getBidListPage().refreshClick();
        TimeUtil.midTime();
        testContextUI.getBidListPage().setSearchByBidNumber("BID021");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.getBidListPage().editBidClick();
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().editBidClick();
        TimeUtil.veryShortTime();
        String Validation_BidNumber = testContextUI.getBidListPage().getBidName().getAttribute("value");
        Assert.assertEquals(Validation_BidNumber, "BID021");
        testContextUI.getBidListPage().btnCancel();
    }

    @Test(priority = 6, dataProvider = "TestDataBidList", enabled = false)
    public void Test_SearchAndDelete_Bid(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getBidListPage().clickGridMenu();
        testContextUI.getBidListPage().clickResetDefault();
        testContextUI.getBidListPage().acceptAlertNotification();
        testContextUI.getBidListPage().refreshClick();
        TimeUtil.midTime();
        testContextUI.getBidListPage().setSearchByBidNumber("BID021");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.getBidListPage().deleteBidClick();
        testContextUI.getBidListPage().deleteBidClick();
        testContextUI.getBidListPage().declineAlertNotification();
    }

    @Test(priority = 7, dataProvider = "TestDataBidList", enabled = true)
    public void Test_ImportBid_From_Candy(Object obj_BidList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        testContextUI.getBidListPage().clickGridMenu();
        testContextUI.getBidListPage().clickResetDefault();
        testContextUI.getBidListPage().acceptAlertNotification();
        testContextUI.getBidListPage().refreshClick();
        TimeUtil.midTime();
        testContextUI.getBidListPage().setSearchByBidNumber("BID069");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.getBidListPage().clickOnImportCandyData();
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().clickOnImportCandyData();
        TimeUtil.midTime();
        testContextUI.getBidListPage().clickOnImportButton();
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().clickOnImportCheckbox();
        String ExchangeRate = testData.get("Exchange_Rate");
        testContextUI.getBidListPage().setExchangeRate(ExchangeRate);
        testContextUI.getBidListPage().setBaseDate(String.valueOf(LocalDate.now()));
        // testContextUI.getBidListPage().clickOnProceed();
        testContextUI.getBidListPage().clickOnBtnCancel();


    }

    /*@Test(priority = 3, dataProvider = "TestDataBidList", enabled = true)
    public void Test_Edit_Client(Object obj_BidList) throws InterruptedException {
        // Click on Edit client
        testContextUI.getClientPage().editClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(sector);
        String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(SubSector);
        testContextUI.getClientPage().btnCancel();
        String client_name = testContextUI.getClientPage().getFirstClient().getText();
        //Assert.assertEquals(client_name, name);
        Assert.assertEquals(client_name, "DERME");

    }

    @Test(priority = 4, dataProvider = "TestDataBidList", enabled = true)
    public void Test_Name_Validation(Object obj_BidList) throws InterruptedException {
        // Click on Add client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(sector);
        String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(SubSector);
        testContextUI.getClientPage().btnSave();
        String val_msg = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please enter at least 4 characters!");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 5, dataProvider = "TestDataBidList", enabled = true)
    public void Test_Contact_Validation(Object obj_BidList) throws InterruptedException {
        // Click on Add client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(sector);
        String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(SubSector);
        testContextUI.getClientPage().btnSave();
        String val_msg_contact = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg_contact, "Phone number is required!");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 6, dataProvider = "TestDataBidList", enabled = true)
    public void Test_Client_Name_Validation(Object obj_BidList) throws InterruptedException {
        // Click on Add client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        //String ContactName = testData.get("Contact_name");
        //testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(sector);
        String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(SubSector);
        testContextUI.getClientPage().btnSave();
        String val_msg_name = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg_name, "Please enter at least 4 characters!");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 7, dataProvider = "TestDataBidList", enabled = true)
    public void Test_SubSector_Validation(Object obj_BidList) throws InterruptedException {
        // Click on Edit client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(sector);
        //String SubSector = testData.get("sub_sector");
        //testContextUI.getClientPage().setSubSector(Integer.valueOf(SubSector));
        testContextUI.getClientPage().btnSave();
        String val_msg_subSector = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg_subSector, "Please select a valid option!");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 8, dataProvider = "TestDataBidList", enabled = true)
    public void Test_ContactFlag_Validation(Object obj_BidList) throws InterruptedException {
        // Click on Edit client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_BidList;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        testContextUI.getClientPage().getContactFlag("India");
        //String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact("909887889");
        String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(sector);
        String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(SubSector);
        testContextUI.getClientPage().btnSave();
        String val_msg = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Invalid entry");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 9, enabled = true)
    public void Test_GridResetToDefault() throws InterruptedException {
        // Click on Edit client
        testContextUI.getClientPage().clickGridMenu();
        testContextUI.getClientPage().clickResetDefault();
        testContextUI.getClientPage().acceptAlertGridNotification();
        testContextUI.getClientPage().refreshClick();
        String first_client = testContextUI.getClientPage().getFirstClient().getText();
        Assert.assertTrue(first_client.equalsIgnoreCase("DERME"));
        //testContextUI.getHomePage().mainFrame();
    }*/

}

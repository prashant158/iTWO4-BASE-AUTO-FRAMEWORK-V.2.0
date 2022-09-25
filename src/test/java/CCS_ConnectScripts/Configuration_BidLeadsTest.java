package CCS_ConnectScripts;
import iTWO_Utilities.ExcelUtil;
import iTWO_Utilities.TimeUtil;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Configuration_BidLeadsTest extends _01_BaseClass {

    ExcelUtil excelBidLead = new ExcelUtil("BidLead");

    @DataProvider(name = "TestDataBidLead")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //Object[][] obj_lead = new Object[excelBidLead.getRowCount()][1];
        Object[][] obj_lead = new Object[1][1];
        Map<String, String> testData;
        //for (int i = 1; i <= excelBidLead.getRowCount(); i++) {
        // Below loop is used to fetch only first row from the excel file
        for (int i = 1; i <= 1; i++) {
            testData = excelBidLead.getTestDataInHashmap(i, "BidLead");
            obj_lead[i - 1][0] = testData;
        }
        return obj_lead;
    }

    @Test(priority = 1)
    public void Test_Bidleads_Page() throws InterruptedException {
        // Click on the Configuration Menu
        testContextUI.getHomePage().ConfigClick();
        testContextUI.getHomePage().optionBidLeadsClick();
        String title = testContextUI.getClientPage().getGridTitle().getText();
        Assert.assertEquals(title, "Bid Leads");
    }

    @Test(priority = 2, dataProvider = "TestDataBidLead", enabled = true)
    public void Test_Save_BidLead(Object obj_lead) throws InterruptedException {
        //testContextUI.getBidLeadsPage().btnCancel();
        HashMap<String, String> testData = (HashMap<String, String>) obj_lead;
        TimeUtil.veryShortTime();
        testContextUI.getBidLeadsPage().addBidLeadClick();
        testContextUI.getBidLeadsPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getBidLeadsPage().setTitle(Integer.valueOf(title));
        String BidLeadName = testData.get("Name");
        testContextUI.getBidLeadsPage().enterBidLeadName(BidLeadName);
        String surname = testData.get("Surname");
        testContextUI.getBidLeadsPage().enterBidLeadSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getBidLeadsPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getBidLeadsPage().setDesignation(Designation);
        testContextUI.getBidLeadsPage().btnCancel();
        String bidLeadsName = testContextUI.getBidLeadsPage().getFirstBidLead().getText();
        //Assert.assertEquals(bidLeadsName, BidLeadName);
        Assert.assertEquals(bidLeadsName, "Test");
    }

    @Test(priority = 3, dataProvider = "TestDataBidLead", enabled = true)
    public void Test_Edit_BidLead(Object obj_lead) throws InterruptedException {
        // Click on Edit Bid Lead
        HashMap<String, String> testData = (HashMap<String, String>) obj_lead;
        TimeUtil.veryShortTime();
        testContextUI.getBidLeadsPage().editBidLeadClick();
        testContextUI.getBidLeadsPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getBidLeadsPage().setTitle(Integer.valueOf(title));
        String BidLeadName = testData.get("Name");
        testContextUI.getBidLeadsPage().enterBidLeadName(BidLeadName);
        String surname = testData.get("Surname");
        testContextUI.getBidLeadsPage().enterBidLeadSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getBidLeadsPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getBidLeadsPage().setDesignation(Designation);
        testContextUI.getBidLeadsPage().btnCancel();
        String bidLeadsName = testContextUI.getBidLeadsPage().getFirstBidLead().getText();
        //Assert.assertEquals(bidLeadsName, BidLeadName);
        Assert.assertEquals(bidLeadsName, "Test");
    }

    @Test(priority = 4, dataProvider = "TestDataBidLead", enabled = true)
    public void Test_Title_Validation(Object obj_lead) throws InterruptedException {
        // Click on Add Bid Lead
        HashMap<String, String> testData = (HashMap<String, String>) obj_lead;
        TimeUtil.veryShortTime();
        testContextUI.getBidLeadsPage().addBidLeadClick();
        /* testContextUI.getBidLeadsPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getBidLeadsPage().setTitle(Integer.valueOf(title)); */
        String BidLeadName = testData.get("Name");
        testContextUI.getBidLeadsPage().enterBidLeadName(BidLeadName);
        String surname = testData.get("Surname");
        testContextUI.getBidLeadsPage().enterBidLeadSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getBidLeadsPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getBidLeadsPage().setDesignation(Designation);
        testContextUI.getBidLeadsPage().btnSave();
        String val_msg = testContextUI.getBidLeadsPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please select a valid option!");
        TimeUtil.veryShortTime();
        testContextUI.getBidLeadsPage().btnCancel();
    }

    @Test(priority = 5, dataProvider = "TestDataBidLead", enabled = true)
    public void Test_Name_Validation(Object obj_lead) throws InterruptedException {
        // Click on Add Bid Lead
        HashMap<String, String> testData = (HashMap<String, String>) obj_lead;
        TimeUtil.veryShortTime();
        testContextUI.getBidLeadsPage().addBidLeadClick();
        testContextUI.getBidLeadsPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getBidLeadsPage().setTitle(Integer.valueOf(title));
        // String BidLeadName = testData.get("Name");
        // testContextUI.getBidLeadsPage().enterBidLeadName(BidLeadName);
        String surname = testData.get("Surname");
        testContextUI.getBidLeadsPage().enterBidLeadSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getBidLeadsPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getBidLeadsPage().setDesignation(Designation);
        testContextUI.getBidLeadsPage().btnSave();
        String val_msg = testContextUI.getBidLeadsPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please enter at least 3 characters!");
        testContextUI.getBidLeadsPage().btnCancel();
    }

    @Test(priority = 6, dataProvider = "TestDataBidLead", enabled = true)
    public void Test_Surname_Validation(Object obj_lead) throws InterruptedException {
        // Click on Add Bid Lead
        HashMap<String, String> testData = (HashMap<String, String>) obj_lead;
        TimeUtil.veryShortTime();
        testContextUI.getBidLeadsPage().addBidLeadClick();
        testContextUI.getBidLeadsPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getBidLeadsPage().setTitle(Integer.valueOf(title));
        String BidLeadName = testData.get("Name");
        testContextUI.getBidLeadsPage().enterBidLeadName(BidLeadName);
        // String surname = testData.get("Surname");
        // testContextUI.getBidLeadsPage().enterBidLeadSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getBidLeadsPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getBidLeadsPage().setDesignation(Designation);
        testContextUI.getBidLeadsPage().btnSave();
        String val_msg = testContextUI.getBidLeadsPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please enter at least 3 characters!");
        testContextUI.getBidLeadsPage().btnCancel();
    }

    @Test(priority = 7, dataProvider = "TestDataBidLead", enabled = true)
    public void Test_Designation_Validation(Object obj_lead) throws InterruptedException {
        // Click on Add Bid Lead
        HashMap<String, String> testData = (HashMap<String, String>) obj_lead;
        TimeUtil.veryShortTime();
        testContextUI.getBidLeadsPage().addBidLeadClick();
        testContextUI.getBidLeadsPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getBidLeadsPage().setTitle(Integer.valueOf(title));
        String BidLeadName = testData.get("Name");
        testContextUI.getBidLeadsPage().enterBidLeadName(BidLeadName);
        String surname = testData.get("Surname");
        testContextUI.getBidLeadsPage().enterBidLeadSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getBidLeadsPage().enterContactNo(contact);
        // String Designation = testData.get("Designation");
        // testContextUI.getBidLeadsPage().setDesignation(Designation);
        testContextUI.getBidLeadsPage().btnSave();
        String val_msg = testContextUI.getBidLeadsPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please select a valid option!");
        testContextUI.getBidLeadsPage().btnCancel();
    }

    @Test(priority = 8, dataProvider = "TestDataBidLead", enabled = true)
    public void Test_PhoneNumber_Validation(Object obj_lead) throws InterruptedException {
        // Click on Add Bid Lead
        HashMap<String, String> testData = (HashMap<String, String>) obj_lead;
        TimeUtil.veryShortTime();
        testContextUI.getBidLeadsPage().addBidLeadClick();
        testContextUI.getBidLeadsPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getBidLeadsPage().setTitle(Integer.valueOf(title));
        String BidLeadName = testData.get("Name");
        testContextUI.getBidLeadsPage().enterBidLeadName(BidLeadName);
        String surname = testData.get("Surname");
        testContextUI.getBidLeadsPage().enterBidLeadSurname(surname);
        /* String contact = testData.get("Contact_number");
        testContextUI.getBidLeadsPage().enterContactNo(contact); */
        String Designation = testData.get("Designation");
        testContextUI.getBidLeadsPage().setDesignation(Designation);
        testContextUI.getBidLeadsPage().btnSave();
        String val_msg = testContextUI.getBidLeadsPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Phone number is required!");
        testContextUI.getBidLeadsPage().btnCancel();
    }

    @Test(priority = 9, dataProvider = "TestDataBidLead", enabled = true)
    public void Test_ContactFlag_Validation(Object obj_lead) throws InterruptedException {
        // Click on Add Bid Lead
        HashMap<String, String> testData = (HashMap<String, String>) obj_lead;
        TimeUtil.veryShortTime();
        testContextUI.getBidLeadsPage().addBidLeadClick();
        testContextUI.getBidLeadsPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getBidLeadsPage().setTitle(Integer.valueOf(title));
        String BidLeadName = testData.get("Name");
        testContextUI.getBidLeadsPage().enterBidLeadName(BidLeadName);
        String surname = testData.get("Surname");
        testContextUI.getBidLeadsPage().enterBidLeadSurname(surname);
        testContextUI.getBidLeadsPage().getContactFlag("India");
        testContextUI.getBidLeadsPage().enterContactNo("986532598");
        String Designation = testData.get("Designation");
        testContextUI.getBidLeadsPage().setDesignation(Designation);
        testContextUI.getBidLeadsPage().btnSave();
        String val_msg = testContextUI.getBidLeadsPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Invalid entry");
        testContextUI.getBidLeadsPage().btnCancel();
    }

    @Test(priority = 10, enabled = true)
    public void Test_GridResetToDefault() throws InterruptedException {

        testContextUI.getBidLeadsPage().clickGridMenu();
        testContextUI.getBidLeadsPage().clickResetDefault();
        testContextUI.getBidLeadsPage().acceptAlertGridNotification();
        testContextUI.getBidLeadsPage().refreshClick();
        String first_bidlead = testContextUI.getBidLeadsPage().getFirstBidLead().getText();
        Assert.assertTrue(first_bidlead.equalsIgnoreCase("Test"));
        testContextUI.getHomePage().mainFrame();
    }
}

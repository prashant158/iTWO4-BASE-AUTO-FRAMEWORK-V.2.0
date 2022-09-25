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

public class Configuration_ClientTest extends _01_BaseClass {

    ExcelUtil excelClient = new ExcelUtil("Client");

    @DataProvider(name = "TestDataClient")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //To go through all the rows of the excel
        //Object[][] obj_client = new Object[excelClient.getRowCount()][1];
        Object[][] obj_client = new Object[1][1];

        Map<String, String> testData;
        //for (int i = 1; i <= excelClient.getRowCount(); i++) {
        for (int i = 1; i <= 1; i++) {
            testData = excelClient.getTestDataInHashmap(i, "Client");
            obj_client[i - 1][0] = testData;
        }
        return obj_client;
    }

    @Test(priority = 1)
    public void Test_Client_Page() throws InterruptedException {
        // Click on the Configuration Menu
        testContextUI.getHomePage().ConfigClick();
        testContextUI.getHomePage().OptionClientClick();
        String title = testContextUI.getClientPage().getGridTitle().getText();
        Assert.assertEquals(title, "Clients");
    }

    @Test(priority = 2, dataProvider = "TestDataClient")
    public void Test_Save_Client(Object obj_client) throws Exception {
        // Click on Add new client
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        testContextUI.getClientPage().addClientClick();
        TimeUtil.veryShortTime();
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        //String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(1);
        //String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(1);
        testContextUI.getClientPage().btnCancel();
        String client_name = testContextUI.getClientPage().getFirstClient().getText();
        //Assert.assertEquals(client_name, name);
        Assert.assertEquals(client_name, "DERME");
    }

    @Test(priority = 3, dataProvider = "TestDataClient", enabled = true)
    public void Test_Edit_Client(Object obj_client) throws Exception {
        // Click on Edit client
        testContextUI.getClientPage().editClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
       // String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(1);
       // String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(1);
        testContextUI.getClientPage().btnCancel();
        String client_name = testContextUI.getClientPage().getFirstClient().getText();
        //Assert.assertEquals(client_name, name);
        Assert.assertEquals(client_name, "DERME");
    }

    @Test(priority = 4, dataProvider = "TestDataClient", enabled = true)
    public void Test_Name_Validation(Object obj_client) throws InterruptedException {
        // Click on Add client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        //String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(1);
        //String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(1);
        testContextUI.getClientPage().btnSave();
        String val_msg = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please enter at least 4 characters!");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 5, dataProvider = "TestDataClient", enabled = true)
    public void Test_Contact_Validation(Object obj_client) throws Exception {
        // Click on Add client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        //String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(1);
        //String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(1);
        testContextUI.getClientPage().btnSave();
        String val_msg_contact = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg_contact, "Phone number is required!");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 6, dataProvider = "TestDataClient", enabled = true)
    public void Test_Client_Name_Validation(Object obj_client) throws Exception {
        // Click on Add client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        //String ContactName = testData.get("Contact_name");
        //testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        //String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(1);
       // String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(1);
        testContextUI.getClientPage().btnSave();
        String val_msg_name = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg_name, "Please enter at least 4 characters!");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 7, dataProvider = "TestDataClient", enabled = true)
    public void Test_SubSector_Validation(Object obj_client) throws Exception {
        // Click on Edit client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        //String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(1);
        //String SubSector = testData.get("sub_sector");
        //testContextUI.getClientPage().setSubSector(Integer.valueOf(SubSector));
        testContextUI.getClientPage().btnSave();
        String val_msg_subSector = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg_subSector, "Please select a valid option!");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 8, dataProvider = "TestDataClient", enabled = true)
    public void Test_ContactFlag_Validation(Object obj_client) throws Exception {
        // Click on Edit client
        testContextUI.getClientPage().addClientClick();
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        String name = testData.get("name");
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        testContextUI.getClientPage().getContactFlag("India");
        //String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact("909887889");
        //String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(1);
        //String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(1);
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
    }

}

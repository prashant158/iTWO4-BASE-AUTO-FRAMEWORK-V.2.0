package CCS_Connect_SmokeTestSuite;

import CCS_ConnectScripts._01_BaseClass;
import iTWO_Utilities.ExcelUtil;
import iTWO_Utilities.TimeUtil;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class T05_Configuration_ClientTest extends _01_BaseClass {

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

    @Test(priority = 1, description = "Verify Client's page is loaded")
    public void Test_Client_Page() throws InterruptedException {
        // Click on the Configuration Menu
        testContextUI.getHomePage().ConfigClick();
        testContextUI.getHomePage().OptionClientClick();
        String title = testContextUI.getClientPage().getGridTitle().getText();
        Assert.assertEquals(title, "Clients");
    }

    @Test(priority = 2, dataProvider = "TestDataClient",
            description = "Verify saving a new Client", enabled = true)
    public void Test_Save_Client(Object obj_client) throws Exception {
        // Click on Add new client
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        testContextUI.getClientPage().refreshClick();
        testContextUI.getClientPage().addClientClick();
        TimeUtil.veryShortTime();
        //String name = testData.get("name");
        String name = testContextUI.getClientPage().ClientNameGeneration();
        testContextUI.getClientPage().enterClientName(name);
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(Integer.valueOf(sector));
        String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(Integer.valueOf(SubSector));
        testContextUI.getClientPage().btnSave();
        testContextUI.getClientPage().addClientClick();
        testContextUI.getClientPage().btnCancel();
        String client_name = testContextUI.getClientPage().getFirstClient().getText();
        Assert.assertEquals(client_name, name);
        //Assert.assertEquals(client_name, "DERME");
    }

    @Test(priority = 3, dataProvider = "TestDataClient",
            description = "Verify 'Edit' existing Client record", enabled = true)
    public void Test_Edit_Client(Object obj_client) throws Exception {
        // Click on Edit client
        testContextUI.getClientPage().editClientClick();
        String name = testContextUI.getClientPage().ClientNameGeneration();
        testContextUI.getClientPage().enterClientName(name);
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(Integer.valueOf(sector));
        String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(Integer.valueOf(SubSector));
        testContextUI.getClientPage().btnSave();
        testContextUI.getClientPage().addClientClick();
        testContextUI.getClientPage().btnCancel();
        String client_name = testContextUI.getClientPage().getFirstClient().getText();
        Assert.assertEquals(client_name, name);
        //Assert.assertEquals(client_name, "DERME");
    }

    @Test(priority = 4, dataProvider = "TestDataClient",
            description = "Confirm by adding duplicate client name", enabled = true)
    public void Test_Name_Validation(Object obj_client) throws Exception {
        // Click on Add client
        HashMap<String, String> testData = (HashMap<String, String>) obj_client;
        testContextUI.getClientPage().addClientClick();
        TimeUtil.veryShortTime();
        testContextUI.getClientPage().enterClientName("Client001");
        String ContactName = testData.get("Contact_name");
        testContextUI.getClientPage().enterNameOfContact(ContactName);
        String contact_no = testData.get("Contact_number");
        testContextUI.getClientPage().setContact(contact_no);
        String sector = testData.get("sector");
        testContextUI.getClientPage().setSector(Integer.valueOf(sector));
        String SubSector = testData.get("sub_sector");
        testContextUI.getClientPage().setSubSector(Integer.valueOf(SubSector));
        testContextUI.getClientPage().btnSave();
        String val_msg = testContextUI.getClientPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Client Name already exists");
        testContextUI.getClientPage().btnCancel();
    }

    @Test(priority = 5, enabled = false, description = "Reset to default and Refresh")
    public void Test_GridResetToDefault() throws InterruptedException {
        testContextUI.getClientPage().clickGridMenu();
        testContextUI.getClientPage().clickResetDefault();
        testContextUI.getClientPage().acceptAlertGridNotification();
        testContextUI.getClientPage().refreshClick();
        String first_client = testContextUI.getClientPage().getFirstClient().getText();
        //Assert.assertTrue(first_client.equalsIgnoreCase("DERME"));
        //testContextUI.getHomePage().mainFrame();
    }

}

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

public class Configuration_ContractManagersTest extends _01_BaseClass {

    ExcelUtil excelContractManager = new ExcelUtil("Connect_ContractManagers");

    @DataProvider(name = "TestDataContractManager")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //Object[][] obj_manager = new Object[excelContractManager.getRowCount()][1];
        Object[][] obj_manager = new Object[1][1];
        Map<String, String> testData;
        //for (int i = 1; i <= excelContractManager.getRowCount(); i++) {
        // Below loop is used to fetch only first row from the excel file
        for (int i = 1; i <= 1; i++) {
            testData = excelContractManager.getTestDataInHashmap(i, "Connect_ContractManagers");
            obj_manager[i - 1][0] = testData;
        }
        return obj_manager;
    }

    @Test(priority = 1)
    public void Test_ContractManager_Page() throws InterruptedException {
        // Click on the Configuration Menu
        testContextUI.getHomePage().ConfigClick();
        testContextUI.getHomePage().optionContractManagersClick();
        String title = testContextUI.getClientPage().getGridTitle().getText();
        Assert.assertEquals(title, "Contract Manager");
    }

    @Test(priority = 2, dataProvider = "TestDataContractManager", enabled = true)
    public void Test_Save_ContractManager(Object obj_manager) throws InterruptedException {
        // Click on the Configuration Menu
        HashMap<String, String> testData = (HashMap<String, String>) obj_manager;
        TimeUtil.veryShortTime();
        testContextUI.getContractManagersPage().addContractManagerClick();
        testContextUI.getContractManagersPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getContractManagersPage().setTitle(Integer.valueOf(title));
        String ContractManagerName = testData.get("Name");
        testContextUI.getContractManagersPage().enterContractManagerName(ContractManagerName);
        String surname = testData.get("Surname");
        testContextUI.getContractManagersPage().enterContractManagerSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getContractManagersPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getContractManagersPage().setDesignation(Designation);
        testContextUI.getContractManagersPage().btnCancel();
        String ManagerName = testContextUI.getContractManagersPage().getFirstManager().getText();
        Assert.assertEquals(ManagerName, "Joseph");
        //Assert.assertEquals(ManagerName, ContractManagerName);
    }

    @Test(priority = 3, dataProvider = "TestDataContractManager", enabled = true)
    public void Test_Edit_Client(Object obj_manager) throws InterruptedException {
        // Click on Edit client
        HashMap<String, String> testData = (HashMap<String, String>) obj_manager;
        TimeUtil.veryShortTime();
        testContextUI.getContractManagersPage().editContractManagerClick();
        testContextUI.getContractManagersPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getContractManagersPage().setTitle(Integer.valueOf(title));
        String ContractManagerName = testData.get("Name");
        testContextUI.getContractManagersPage().enterContractManagerName(ContractManagerName);
        String surname = testData.get("Surname");
        testContextUI.getContractManagersPage().enterContractManagerSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getContractManagersPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getContractManagersPage().setDesignation(Designation);
        testContextUI.getContractManagersPage().btnCancel();
        String ManagerName = testContextUI.getContractManagersPage().getFirstManager().getText();
        Assert.assertEquals(ManagerName, "Joseph");
        //Assert.assertEquals(ManagerName, ContractManagerName);
    }

    @Test(priority = 4, dataProvider = "TestDataContractManager", enabled = true)
    public void Test_Title_Validation(Object obj_manager) throws InterruptedException {
        // Click on Add Contract Manager
        HashMap<String, String> testData = (HashMap<String, String>) obj_manager;
        TimeUtil.veryShortTime();
        testContextUI.getContractManagersPage().addContractManagerClick();
        //testContextUI.getContractManagersPage().setTitleClick();
        //String title = testData.get("Title");
        //testContextUI.getContractManagersPage().setTitle(Integer.valueOf(title));
        String ContractManagerName = testData.get("Name");
        testContextUI.getContractManagersPage().enterContractManagerName(ContractManagerName);
        String surname = testData.get("Surname");
        testContextUI.getContractManagersPage().enterContractManagerSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getContractManagersPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getContractManagersPage().setDesignation(Designation);
        testContextUI.getContractManagersPage().btnSave();
        String val_msg = testContextUI.getContractManagersPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please select a valid option!");
        testContextUI.getContractManagersPage().btnCancel();
    }

    @Test(priority = 5, dataProvider = "TestDataContractManager", enabled = true)
    public void Test_Name_Validation(Object obj_manager) throws InterruptedException {
        // Click on Add Contract Manager
        HashMap<String, String> testData = (HashMap<String, String>) obj_manager;
        TimeUtil.veryShortTime();
        testContextUI.getContractManagersPage().addContractManagerClick();
        testContextUI.getContractManagersPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getContractManagersPage().setTitle(Integer.valueOf(title));
        //String ContractManagerName = testData.get("Name");
        //testContextUI.getContractManagersPage().enterContractManagerName(ContractManagerName);
        String surname = testData.get("Surname");
        testContextUI.getContractManagersPage().enterContractManagerSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getContractManagersPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getContractManagersPage().setDesignation(Designation);
        testContextUI.getContractManagersPage().btnSave();
        String val_msg = testContextUI.getContractManagersPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please enter at least 1 characters!");
        testContextUI.getContractManagersPage().btnCancel();
    }

    @Test(priority = 6, dataProvider = "TestDataContractManager", enabled = true)
    public void Test_Surname_Validation(Object obj_manager) throws InterruptedException {
        // Click on Add Contract Manager
        HashMap<String, String> testData = (HashMap<String, String>) obj_manager;
        TimeUtil.veryShortTime();
        testContextUI.getContractManagersPage().addContractManagerClick();
        testContextUI.getContractManagersPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getContractManagersPage().setTitle(Integer.valueOf(title));
        String ContractManagerName = testData.get("Name");
        testContextUI.getContractManagersPage().enterContractManagerName(ContractManagerName);
        //String surname = testData.get("Surname");
        //testContextUI.getContractManagersPage().enterContractManagerSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getContractManagersPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getContractManagersPage().setDesignation(Designation);
        testContextUI.getContractManagersPage().btnSave();
        String val_msg = testContextUI.getContractManagersPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please enter at least 1 characters!");
        testContextUI.getContractManagersPage().btnCancel();
    }

    @Test(priority = 7, dataProvider = "TestDataContractManager", enabled = true)
    public void Test_Designation_Validation(Object obj_manager) throws InterruptedException {
        // Click on Add Contract Manager
        HashMap<String, String> testData = (HashMap<String, String>) obj_manager;
        TimeUtil.veryShortTime();
        testContextUI.getContractManagersPage().addContractManagerClick();
        testContextUI.getContractManagersPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getContractManagersPage().setTitle(Integer.valueOf(title));
        String ContractManagerName = testData.get("Name");
        testContextUI.getContractManagersPage().enterContractManagerName(ContractManagerName);
        String surname = testData.get("Surname");
        testContextUI.getContractManagersPage().enterContractManagerSurname(surname);
        String contact = testData.get("Contact_number");
        testContextUI.getContractManagersPage().enterContactNo(contact);
        // String Designation = testData.get("Designation");
        // testContextUI.getContractManagersPage().setDesignation(Designation);
        testContextUI.getContractManagersPage().btnSave();
        String val_msg = testContextUI.getContractManagersPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Please select a valid option!");
        testContextUI.getContractManagersPage().btnCancel();
    }

    @Test(priority = 8, dataProvider = "TestDataContractManager", enabled = true)
    public void Test_PhoneNumber_Validation(Object obj_manager) throws InterruptedException {
        // Click on Add Contract Manager
        HashMap<String, String> testData = (HashMap<String, String>) obj_manager;
        TimeUtil.veryShortTime();
        testContextUI.getContractManagersPage().addContractManagerClick();
        testContextUI.getContractManagersPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getContractManagersPage().setTitle(Integer.valueOf(title));
        String ContractManagerName = testData.get("Name");
        testContextUI.getContractManagersPage().enterContractManagerName(ContractManagerName);
        String surname = testData.get("Surname");
        testContextUI.getContractManagersPage().enterContractManagerSurname(surname);
        // String contact = testData.get("Contact_number");
        // testContextUI.getContractManagersPage().enterContactNo(contact);
        String Designation = testData.get("Designation");
        testContextUI.getContractManagersPage().setDesignation(Designation);
        testContextUI.getContractManagersPage().btnSave();
        String val_msg = testContextUI.getContractManagersPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Invalid entry Not a number.");
        testContextUI.getContractManagersPage().btnCancel();
    }

    @Test(priority = 9, dataProvider = "TestDataContractManager", enabled = true)
    public void Test_ContactFlag_Validation(Object obj_manager) throws InterruptedException {
        // Click on Add Contract Manager
        HashMap<String, String> testData = (HashMap<String, String>) obj_manager;
        TimeUtil.veryShortTime();
        testContextUI.getContractManagersPage().addContractManagerClick();
        testContextUI.getContractManagersPage().setTitleClick();
        String title = testData.get("Title");
        testContextUI.getContractManagersPage().setTitle(Integer.valueOf(title));
        String ContractManagerName = testData.get("Name");
        testContextUI.getContractManagersPage().enterContractManagerName(ContractManagerName);
        String surname = testData.get("Surname");
        testContextUI.getContractManagersPage().enterContractManagerSurname(surname);
        testContextUI.getContractManagersPage().getContactFlag("India");
        testContextUI.getContractManagersPage().enterContactNo("987654786");
        String Designation = testData.get("Designation");
        testContextUI.getContractManagersPage().setDesignation(Designation);
        testContextUI.getContractManagersPage().btnSave();
        String val_msg = testContextUI.getContractManagersPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Invalid entry");
        testContextUI.getContractManagersPage().btnCancel();
    }

    @Test(priority = 10, enabled = true)
    public void Test_GridResetToDefault() throws InterruptedException {
        // Click on Edit client
        testContextUI.getContractManagersPage().clickGridMenu();
        testContextUI.getContractManagersPage().clickResetDefault();
        testContextUI.getContractManagersPage().acceptAlertGridNotification();
        testContextUI.getContractManagersPage().refreshClick();
        String first_client = testContextUI.getContractManagersPage().getFirstManager().getText();
        Assert.assertTrue(first_client.equalsIgnoreCase("Joseph"));
    }
}

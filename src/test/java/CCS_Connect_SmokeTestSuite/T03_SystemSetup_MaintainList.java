package CCS_Connect_SmokeTestSuite;

import CCS_ConnectScripts._01_BaseClass;
import iTWO_Utilities.ExcelUtil;
import iTWO_Utilities.TimeUtil;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.validation.constraints.AssertTrue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class T03_SystemSetup_MaintainList extends _01_BaseClass {

    ExcelUtil excelClient = new ExcelUtil("MaintainList");

    @DataProvider(name = "TestData")
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

    @Test(priority = 1, description = "Verify 'Copy from Global' functionality and saving data", enabled = false)
    public void Test_CopyFromGlobal() throws InterruptedException {
        testContextUI.getHomePage().SystemSetupClick();
        testContextUI.getHomePage().OptionMaintainListsClick();
        int count = testContextUI.getMaintainList().designationCount();
        testContextUI.getMaintainList().setCopyFromGlobal();
        testContextUI.getMaintainList().selectDesignation();
        testContextUI.getMaintainList().setAddButton();
        testContextUI.getMaintainList().setSaveButton();
        int newCount = testContextUI.getMaintainList().designationCount();
        Assert.assertTrue(count < newCount);
    }

    @Test(priority = 2, description = "Confirm manually adding new item and Save")
    public void Test_AddNewItem() throws InterruptedException {
        testContextUI.getHomePage().SystemSetupClick();
        testContextUI.getHomePage().OptionMaintainListsClick();
        int count = testContextUI.getMaintainList().designationCount();
        testContextUI.getMaintainList().setAddItemToList();
        String itemName = testContextUI.getMaintainList().ItemNumberGeneration();
        testContextUI.getMaintainList().enterItemName(itemName);
        testContextUI.getMaintainList().setSaveButton();
        int newCount = testContextUI.getMaintainList().designationCount();
        Assert.assertTrue(count < newCount);
    }

}

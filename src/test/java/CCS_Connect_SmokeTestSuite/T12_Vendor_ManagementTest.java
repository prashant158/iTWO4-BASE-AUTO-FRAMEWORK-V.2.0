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
import java.util.Random;

public class T12_Vendor_ManagementTest extends _01_BaseClass {

    ExcelUtil excelVendorList = new ExcelUtil("Vendor_Management");

    @DataProvider(name = "TestDataVendorManagement")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //To go through all the rows of the excel
        //Object[][] obj_client = new Object[excelVendorList.getRowCount()][1];
        Object[][] obj_VendorList = new Object[1][1];

        Map<String, String> testData;
        //for (int i = 1; i <= excelVendorList.getRowCount(); i++) {
        for (int i = 1; i <= 1; i++) {
            testData = excelVendorList.getTestDataInHashmap(i, "Vendor_Management");
            obj_VendorList[i - 1][0] = testData;
        }
        return obj_VendorList;
    }

    @Test(priority = 1, description = "Verify Vendor List page is loaded")
    public void Test_Vendor_Page() throws InterruptedException {
        // Click on the Configuration Menu
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().optionVendorManagementClick();
        String title = testContextUI.getVendorManagementPage().getGridTitle().getText();
        Assert.assertEquals(title, "Vendor List");
    }

    @Test(priority = 2, dataProvider = "TestDataVendorManagement", enabled = true,
            description = "Verify the saving of a new vendor")
    public void Test_Add_Vendor(Object obj_VendorList) throws InterruptedException {

        HashMap<String, String> testData = (HashMap<String, String>) obj_VendorList;
        testContextUI.getVendorManagementPage().setAddVendor();
        TimeUtil.midTime();
        String vendor_Code = testContextUI.getVendorManagementPage().VendorNumberGeneration();
        testContextUI.getVendorManagementPage().enterVendorCode(vendor_Code);
        String vendor_Name = testData.get("Vendor_Name");
        testContextUI.getVendorManagementPage().enterVendorName(vendor_Name);
        testContextUI.getVendorManagementPage().contactDetailsGroupClick();
        testContextUI.getVendorManagementPage().setAddVendorContact();
        String vendorContactName = testData.get("VendorContactName");
        testContextUI.getVendorManagementPage().enterVendorContactName(vendorContactName);
        String vendor_Contact = testData.get("Vendor_Contact");
        testContextUI.getVendorManagementPage().setContact(vendor_Contact);
        String designation = testData.get("Designation");
        testContextUI.getVendorManagementPage().setDesignation(designation);
        String email = testData.get("Email");
        testContextUI.getVendorManagementPage().enterVendorContactEmail(email);
        testContextUI.getVendorManagementPage().btnSave();
        TimeUtil.veryShortTime();
        testContextUI.getVendorManagementPage().btnSaveVendor();
        String confirmationMsg = testContextUI.getVendorManagementPage().getVerificationMsg().getText();
        Assert.assertEquals(confirmationMsg, "Vendor Information saved successfully!");
        testContextUI.getVendorManagementPage().setBtnOK();
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().optionVendorManagementClick();
    }

    @Test(priority = 3, dataProvider = "TestDataVendorManagement", enabled = true,
            description = "Verify if adding duplicate Vendor code")
    public void Test_Add_DuplicateVendor(Object obj_VendorList) throws InterruptedException {
        // Click on Add new Vendor
        HashMap<String, String> testData = (HashMap<String, String>) obj_VendorList;
        testContextUI.getVendorManagementPage().setAddVendor();
        TimeUtil.shortTime();
        testContextUI.getVendorManagementPage().enterVendorCode("VENDOR001");
        String vendor_Name = testData.get("Vendor_Name");
        testContextUI.getVendorManagementPage().enterVendorName(vendor_Name);
        String validationMsg = testContextUI.getVendorManagementPage().getVendorCodeValidation().getText();
        Assert.assertEquals(validationMsg, "Vendor code already exists");
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().optionVendorManagementClick();
    }

    @Test(priority = 4, dataProvider = "TestDataVendorManagement", enabled = false,
            description = "'Edit' Vendor details and verify the vendor details")
    public void Test_Edit_Vendor(Object obj_VendorList) throws InterruptedException {

        HashMap<String, String> testData = (HashMap<String, String>) obj_VendorList;
        testContextUI.getVendorManagementPage().setSearchVendors("VEN0003");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.getVendorManagementPage().editVendor();
        TimeUtil.veryShortTime();
        testContextUI.getVendorManagementPage().editVendor();
        TimeUtil.shortTime();
        testContextUI.getVendorManagementPage().enterVendorName("Quality Building Suppliers");
        testContextUI.getVendorManagementPage().btnFinalizeVendor();
        testContextUI.getVendorManagementPage().getVendorNameFromGrid().click();
        String VendorName = testContextUI.getVendorManagementPage().getVendorNameFromGrid().getText();
        Assert.assertTrue(VendorName.contains("Quality Building"));
    }

    @Test(priority = 5, dataProvider = "TestDataVendorManagement", enabled = true,
            description = "Verify finalization of the vendor if required documents are not attached")
    public void Test_Vendor_Finalization_WhenRequiredDocumentsNotAttached(Object obj_VendorList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_VendorList;

        testContextUI.getVendorManagementPage().setAddVendor();
        TimeUtil.shortTime();
        String vendor_Code = testContextUI.getVendorManagementPage().VendorNumberGeneration();
        testContextUI.getVendorManagementPage().enterVendorCode(vendor_Code);
        String vendor_Name = testData.get("Vendor_Name");
        testContextUI.getVendorManagementPage().enterVendorName(vendor_Name);
        testContextUI.getVendorManagementPage().contactDetailsGroupClick();
        testContextUI.getVendorManagementPage().setAddVendorContact();
        String vendorContactName = testData.get("VendorContactName");
        testContextUI.getVendorManagementPage().enterVendorContactName(vendorContactName);
        String vendor_Contact = testData.get("Vendor_Contact");
        testContextUI.getVendorManagementPage().setContact(vendor_Contact);
        String designation = testData.get("Designation");
        testContextUI.getVendorManagementPage().setDesignation(designation);
        String email = testData.get("Email");
        testContextUI.getVendorManagementPage().enterVendorContactEmail(email);
        testContextUI.getVendorManagementPage().btnSave();
        TimeUtil.veryShortTime();
        testContextUI.getVendorManagementPage().btnFinalizeVendor();
        String validation = testContextUI.getVendorManagementPage().validationRequiredDocument().getText();
        // testContextUI.getVendorManagementPage().setBtnOK();
        Assert.assertTrue(validation.contains("Unable to finalize vendor as there are some required documents that are missing."));
        //Assert.(validation, "Vendor Information saved successfully!");
        testContextUI.getVendorManagementPage().setBtnOK();
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().optionVendorManagementClick();
    }

    @Test(priority = 6, dataProvider = "TestDataVendorManagement", enabled = true,
            description = "Edit Vendor details and Verify the required document validations for adding new vendor")
    public void Test_Upload_Required_Vendor_Document(Object obj_VendorList) throws InterruptedException, IOException {

        HashMap<String, String> testData = (HashMap<String, String>) obj_VendorList;
        testContextUI.getVendorManagementPage().setSearchVendors("VEN0003");
        testContextUI.getBidListPage().RETURN();
        TimeUtil.shortTime();
        testContextUI.getVendorManagementPage().editVendor();
        TimeUtil.veryShortTime();
        testContextUI.getVendorManagementPage().editVendor();
        TimeUtil.shortTime();
        testContextUI.getVendorManagementPage().enterVendorName("Quality Building Suppliers");
        /*testContextUI.getVendorManagementPage().contactDetailsGroupClick();
        // Click on Add Contact button
        testContextUI.getVendorManagementPage().clickContactDetailsRow();
        testContextUI.getVendorManagementPage().setEditVendorContact();
        String designation = testData.get("Designation");
        testContextUI.getVendorManagementPage().setDesignation(designation);
        testContextUI.getVendorManagementPage().btnSave();*/
        TimeUtil.veryShortTime();
        testContextUI.getVendorManagementPage().setBtnUploadDocuments();
        testContextUI.getVendorManagementPage().uploadDocumentCategoryTreeIcon();
        testContextUI.getVendorManagementPage().uploadDocumentTypeTreeIcon();
        testContextUI.getVendorManagementPage().fileUploadOptionClick();
        Runtime.getRuntime().exec("D:\\RIB CCS CONNECT SCRIPTS\\AutoIT\\Vendor\\UploadFile.exe");
        testContextUI.getVendorManagementPage().clickCloseBtn();
        testContextUI.getVendorManagementPage().btnFinalizeVendor();
        testContextUI.getVendorManagementPage().getVendorNameFromGrid().click();
        String VendorName = testContextUI.getVendorManagementPage().getVendorNameFromGrid().getText();
        Assert.assertTrue(VendorName.contains("Quality Building"));
    }

}

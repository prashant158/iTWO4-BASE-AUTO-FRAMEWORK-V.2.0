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

public class T11_Contracts_ContractListTest extends _01_BaseClass {

    ExcelUtil excelContractList = new ExcelUtil("Contract_List");

    @DataProvider(name = "TestDataContractList")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //To go through all the rows of the excel
        //Object[][] obj_ContractList = new Object[excelContractList.getRowCount()][1];
        Object[][] obj_ContractList = new Object[1][1];

        Map<String, String> testData;
        //for (int i = 1; i <= excelContractList.getRowCount(); i++) {
        for (int i = 1; i <= 1; i++) {
            testData = excelContractList.getTestDataInHashmap(i, "Contract_List");
            obj_ContractList[i - 1][0] = testData;
        }
        return obj_ContractList;
    }

    @Test(priority = 1, description = "Verify Contract List page is loaded")
    public void Test_Contract_Page() throws InterruptedException {
        // Click on the Configuration Menu
        testContextUI.getHomePage().ContractsClick();
        testContextUI.getHomePage().optionContractListClick();
        String title = testContextUI.getContractListPage().getGridTitle().getText();
        Assert.assertEquals(title, "Contract List");
    }

    @Test(priority = 2, dataProvider = "TestDataContractList", enabled = true,
            description = "Verify saving of a new 'Contract'")
    public void Test_Save_Contract(Object obj_ContractList) throws InterruptedException {
        // Click on Add new Contract
        HashMap<String, String> testData = (HashMap<String, String>) obj_ContractList;
        testContextUI.getContractListPage().refreshClick();
        testContextUI.getContractListPage().addContractClick();
        TimeUtil.midTime();
        //String contract_number = testData.get("Contract_Number");
        String contract_number = testContextUI.getContractListPage().ContractNoGeneration();
        testContextUI.getContractListPage().enterContractNo(contract_number);
        //String contract_name = testData.get("Contract_Name");
        testContextUI.getContractListPage().enterContractName(contract_number);
        String contractClient = testData.get("Contract_Client");
        testContextUI.getContractListPage().setContractClient(contractClient);
        String ContractManager = testData.get("Contract_Manager");
        testContextUI.getContractListPage().setContractManager(ContractManager);
        String ContractType = testData.get("Contract_type");
        testContextUI.getContractListPage().setContractType(ContractType);
        String StartDate = testData.get("start_date");
        testContextUI.getContractListPage().enterContractStartDate(StartDate);
        String end_date = testData.get("end_date");
        testContextUI.getContractListPage().enterContractEndDate(end_date);
        String ReportingCurrency = testData.get("Reporting_Currency");
        testContextUI.getContractListPage().setReportingCurrency(ReportingCurrency);
        String ExchangeRate = testData.get("Exchange_Rate");
        testContextUI.getContractListPage().setExchangeRate(ExchangeRate);
        String Status = testData.get("status");
        testContextUI.getContractListPage().setStatus(Status);
        testContextUI.getContractListPage().clickContractLocation();
        testContextUI.getContractListPage().getAddress("Canada Corner, Nashik");
        testContextUI.getContractListPage().TAB(6);
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().btnSave();
        testContextUI.getContractListPage().addContractClick();
        testContextUI.getContractListPage().btnCancel();
        String ContractNumber = testContextUI.getContractListPage().getFirstContractNo().getText();
        Assert.assertEquals(ContractNumber, contract_number);
        //Assert.assertEquals(ContractNumber, "BID084");
    }

    @Test(priority = 3, dataProvider = "TestDataContractList", enabled = true,
            description = "Verify 'Edit' existing Contract details")
    public void Test_Edit_Contract(Object obj_ContractList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_ContractList;
        testContextUI.getContractListPage().refreshClick();
        testContextUI.getContractListPage().setSearchByContractNumber("Contra001");
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.getContractListPage().editContractClick();
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().editContractClick();
        //String contract_number = testData.get("Contract_Number");
        //testContextUI.getContractListPage().enterContractNo(contract_number);
        //String contract_name = testData.get("Contract_Name");
        String contractClient = testData.get("Contract_Client");
        testContextUI.getContractListPage().setContractClient(contractClient);
        String ContractManager = testData.get("Contract_Manager");
        testContextUI.getContractListPage().setContractManager(ContractManager);
        String ContractType = testData.get("Contract_type");
        testContextUI.getContractListPage().setContractType(ContractType);
        String StartDate = testData.get("start_date");
        testContextUI.getContractListPage().enterContractStartDate(StartDate);
        String end_date = testData.get("end_date");
        testContextUI.getContractListPage().enterContractEndDate(end_date);
        String ReportingCurrency = testData.get("Reporting_Currency");
        testContextUI.getContractListPage().setReportingCurrency(ReportingCurrency);
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().btnSave();
        //testContextUI.getContractListPage().btnCancel();
        String ContractName = testContextUI.getContractListPage().getFirstContractNo().getText();
        Assert.assertEquals(ContractName, "Contra001");
    }

    @Test(priority = 4, dataProvider = "TestDataContractList", enabled = true,
            description = "Check if duplicate contract number is entered when Adding new Contract")
    public void Test_Duplicate_Contract_No(Object obj_ContractList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_ContractList;
        testContextUI.getContractListPage().addContractClick();
        TimeUtil.midTime();
        testContextUI.getContractListPage().enterContractNo("Contra001");
        String contract_name = testData.get("Contract_Name");
        testContextUI.getContractListPage().enterContractName(contract_name);
        String contractClient = testData.get("Contract_Client");
        testContextUI.getContractListPage().setContractClient(contractClient);
        String ContractManager = testData.get("Contract_Manager");
        testContextUI.getContractListPage().setContractManager(ContractManager);
        String ContractType = testData.get("Contract_type");
        testContextUI.getContractListPage().setContractType(ContractType);
        String StartDate = testData.get("start_date");
        testContextUI.getContractListPage().enterContractStartDate(StartDate);
        String end_date = testData.get("end_date");
        testContextUI.getContractListPage().enterContractEndDate(end_date);
        String ReportingCurrency = testData.get("Reporting_Currency");
        testContextUI.getContractListPage().setReportingCurrency(ReportingCurrency);
        String ExchangeRate = testData.get("Exchange_Rate");
        testContextUI.getContractListPage().setExchangeRate(ExchangeRate);
        String Status = testData.get("status");
        testContextUI.getContractListPage().setStatus(Status);
        testContextUI.getContractListPage().clickContractLocation();
        testContextUI.getContractListPage().getAddress("Canada Corner, Nashik");
        testContextUI.getContractListPage().TAB(6);
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().btnSave();
        //testContextUI.getContractListPage().btnCancel();
        String val_msg = testContextUI.getContractManagersPage().getValidation_msg().getText();
        Assert.assertEquals(val_msg, "Contract Number Already Used.");
        testContextUI.getContractListPage().btnCancel();
    }

    @Test(priority = 5, dataProvider = "TestDataContractList", enabled = true,
            description = "Import Candy data for a Contract")
    public void Test_ImportContract_From_Candy(Object obj_ContractList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_ContractList;
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().setSearchByContractNumber("AP05");
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.getContractListPage().clickOnImportCandyData();
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().clickOnImportCandyData();
        TimeUtil.midTime();
        if(testContextUI.getContractListPage().ImportButton().isDisplayed()) {
            testContextUI.getContractListPage().clickOnImportButton();
            TimeUtil.veryShortTime();
            testContextUI.getContractListPage().btnNotificationYes();
            TimeUtil.shortTime();
            String title = testContextUI.getContractListPage().getCostReportTitle().getText();
            Assert.assertEquals(title, "Summary");

        }
        else
        {
            testContextUI.getContractListPage().clickOnCloseButton();
            Assert.assertTrue(1<0);
        }

    }

    @Test(priority = 6, dataProvider = "TestDataContractList", enabled = true,
            description = "Verify Cost report summary is loaded")
    public void Test_CostReportSummary(Object obj_ContractList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_ContractList;
        testContextUI.getHomePage().ContractsClick();
        testContextUI.getHomePage().optionContractListClick();
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().setSearchByContractNumber("Contra001");
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.getContractListPage().clickOnCostReportIcon();
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().clickOnCostReportIcon();
        String title = testContextUI.getContractListPage().getCostReportTitle().getText();
        Assert.assertEquals(title, "Summary");
    }

    @Test(priority = 7, dataProvider = "TestDataContractList", enabled = true,
            description = "Verify Cost report List summary is loaded")
    public void Test_CostReportList(Object obj_ContractList) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj_ContractList;
        testContextUI.getHomePage().ContractsClick();
        testContextUI.getHomePage().optionContractListClick();
        testContextUI.getContractListPage().refreshClick();
        TimeUtil.midTime();
        testContextUI.getContractListPage().setSearchByContractNumber("Contra001");
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.getContractListPage().clickOnCostReportListIcon();
        TimeUtil.veryShortTime();
        testContextUI.getContractListPage().clickOnCostReportListIcon();
        String title = testContextUI.getContractListPage().getGridTitle().getText();
        Assert.assertEquals(title, "Cost Report List");
    }

}

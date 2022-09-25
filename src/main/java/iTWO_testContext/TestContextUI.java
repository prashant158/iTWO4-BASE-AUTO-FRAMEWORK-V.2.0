package iTWO_testContext;

import Connect_Pages.*;
import iTWO_Factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class TestContextUI extends DriverFactory {
    P19_iTWO_Login_Page loginPage;
    P20_Project_Module_page iTWO4_project;
    P1_Connect_LoginPage demoPage;
    P2_Connect_HomePage homePage;
    P5_Configuration_ClientPage clientPage;
    P6_Configuration_BidLeadsPage bidLeadsPage;
    P7_Configuration_ContractManagersPage contractManagersPage;
    P9_Estimating_BidListPage bidListPage;
    P11_Contracts_ContractList contractListPage;
    P13_eRFQ_Page eRFQPage;
    P14_CreateRFQ_Page CreateRFQ;
    P15_eRFQRequests_Page eRFQRequests;
    P3_SystemSetup_MaintainList maintainList;
    P12_VendorManagementPage vendorManagement;
    P17_VendorSubmissionList_Page vendorSubmissionList;
    P18_QuoteCompare_Page quoteComparePage;

    public P1_Connect_LoginPage getLoginPage()
    {
        return (demoPage == null) ? demoPage = new P1_Connect_LoginPage(getDriver()) : demoPage;
    }

    public P15_eRFQRequests_Page geteRFQRequestsPage() {
        return (eRFQRequests == null) ? eRFQRequests = new P15_eRFQRequests_Page(getDriver()) : eRFQRequests;
    }

    public P17_VendorSubmissionList_Page getVendorSubmissionListPage() {
        return (vendorSubmissionList == null) ? vendorSubmissionList = new P17_VendorSubmissionList_Page(getDriver()) : vendorSubmissionList;
    }

    public P18_QuoteCompare_Page getQuoteComparePage() {
        return (quoteComparePage == null) ? quoteComparePage = new P18_QuoteCompare_Page(getDriver()) : quoteComparePage;
    }

    public P2_Connect_HomePage getHomePage() {
        return (homePage == null) ? homePage = new P2_Connect_HomePage(getDriver()) : homePage;
    }

    public P3_SystemSetup_MaintainList getMaintainList() {
        return (maintainList == null) ? maintainList = new P3_SystemSetup_MaintainList(getDriver()) : maintainList;
    }

    public P5_Configuration_ClientPage getClientPage() {
        return (clientPage == null) ? clientPage = new P5_Configuration_ClientPage(getDriver()) : clientPage;
    }

    public P6_Configuration_BidLeadsPage getBidLeadsPage() {
        return (bidLeadsPage == null) ? bidLeadsPage = new P6_Configuration_BidLeadsPage(getDriver()) : bidLeadsPage;
    }

    public P7_Configuration_ContractManagersPage getContractManagersPage() {
        return (contractManagersPage == null) ? contractManagersPage = new P7_Configuration_ContractManagersPage(getDriver()) : contractManagersPage;
    }

    public P9_Estimating_BidListPage getBidListPage() {
        return (bidListPage == null) ? bidListPage = new P9_Estimating_BidListPage(getDriver()) : bidListPage;
    }

    public P11_Contracts_ContractList getContractListPage() {
        return (contractListPage == null) ? contractListPage = new P11_Contracts_ContractList(getDriver()) : contractListPage;
    }

    public P19_iTWO_Login_Page getiTWOLoginPage() {
        return (loginPage == null) ? loginPage = new P19_iTWO_Login_Page(getDriver()) : loginPage;
    }

    public P20_Project_Module_page getiTWO4_project() {
        return (iTWO4_project == null) ? iTWO4_project = new P20_Project_Module_page(getDriver()) : iTWO4_project;
    }

    public P13_eRFQ_Page geteRFQPage() {
        return (eRFQPage == null) ? eRFQPage = new P13_eRFQ_Page(getDriver()) : eRFQPage;
    }

    public P14_CreateRFQ_Page getCreateRFQPage() {
        return (CreateRFQ == null) ? CreateRFQ = new P14_CreateRFQ_Page(getDriver()) : CreateRFQ;
    }

    public P12_VendorManagementPage getVendorManagementPage() {
        return (vendorManagement == null) ? vendorManagement = new P12_VendorManagementPage(getDriver()) : vendorManagement;
    }

    public void initializePageObjectClasses(WebDriver driver) {
        loginPage = new P19_iTWO_Login_Page(driver);
        iTWO4_project = new P20_Project_Module_page(driver);
        demoPage = new P1_Connect_LoginPage(driver);
        homePage = new P2_Connect_HomePage(driver);
        clientPage = new P5_Configuration_ClientPage(driver);
        bidLeadsPage = new P6_Configuration_BidLeadsPage(driver);
        contractManagersPage = new P7_Configuration_ContractManagersPage(driver);
        bidListPage = new P9_Estimating_BidListPage(driver);
        contractListPage = new P11_Contracts_ContractList(driver);
        eRFQPage = new P13_eRFQ_Page(driver);
        eRFQRequests = new P15_eRFQRequests_Page(driver);
        CreateRFQ = new P14_CreateRFQ_Page(driver);
        maintainList = new P3_SystemSetup_MaintainList(driver);
        vendorManagement = new P12_VendorManagementPage(driver);
        vendorSubmissionList = new P17_VendorSubmissionList_Page(driver);
        quoteComparePage = new P18_QuoteCompare_Page(driver);
    }
}

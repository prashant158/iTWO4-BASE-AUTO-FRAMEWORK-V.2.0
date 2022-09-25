package CCS_ConnectRegressionPerSprint;

import CCS_ConnectScripts._01_BaseClass;
import iTWO_Utilities.TimeUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesSprint83 extends _01_BaseClass {

    @Test(priority = 1, description = "Navigate to eRFQ > eRFQ Request", enabled = true)
    public void Test_eRFQ_Requests() throws InterruptedException {
        // Click on the eRFQ Menu and then eRFQ Requests
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().eRFQRequestsOptionClick();
        String title = testContextUI.geteRFQPage().getGridTitle().getText();
        Assert.assertEquals(title, "Requests Received");
    }

    @Test(priority = 2,
            description = "Check latest package requests on eRFQ Request list", enabled = true)
    public void Test_eRFQRequests_topRowDate() throws InterruptedException {
        // Check the latest Received date and which should be on the top line
        TimeUtil.veryShortTime();
        testContextUI.geteRFQRequestsPage().refreshClick();
        String date = testContextUI.geteRFQRequestsPage().getTopReceivedDate().getText();
        Assert.assertEquals(date, "27 Jun 2022");
    }

    @Test(priority = 3, description = "Old packages listing on eRFQ request list", enabled = true)
    public void Test_eRFQRequests_oldestReceivedDate() throws InterruptedException {
        // Sort the Request Received column and check the top row (which shows old record)
        testContextUI.geteRFQRequestsPage().refreshClick();
        testContextUI.geteRFQRequestsPage().receivedHeaderClick();
        String date = testContextUI.geteRFQRequestsPage().getTopReceivedDate().getText();
        Assert.assertEquals(date, "03 Aug 2021");
    }

    @Test(priority = 4, enabled = true
            ,description = "Removal of Vendors quantity column from quote comparison page")

    public void Test_QuoteCompare_VendorQty() throws InterruptedException {
        // To verify only one Qty column is present for each selected vendor
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().refreshClick();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID065");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("PLUMB");
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickCompareQuoteAmar();
        testContextUI.geteRFQPage().clickCompareQuoteAmarGmail();
        testContextUI.geteRFQPage().setBtnCompareQuote();
        testContextUI.geteRFQPage().getColumnHeader();
        int QtyColumnsOnGrid = testContextUI.geteRFQPage().getColumnHeader();
        Assert.assertTrue(QtyColumnsOnGrid == 1);
    }

    @Test(priority = 5, description = "Edit the  “Qty” column on quote item tab"
           ,enabled = true)
    public void Test_eRFQRequests_Quantity() throws InterruptedException {
        // Check for the only one qty column on the Quote item tab of eRFQ Requests
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().eRFQRequestsOptionClick();
        testContextUI.geteRFQPage().refreshClick();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID073");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.geteRFQRequestsPage().clickOnViewRequests();
        //TimeUtil.veryShortTime();
        //testContextUI.geteRFQRequestsPage().clickOnViewRequests();
        TimeUtil.midTime();
        testContextUI.geteRFQRequestsPage().clickOnNextButton();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQRequestsPage().clickOnNextButtonToAttachment();
        int QtyColumnsOnGrid = testContextUI.geteRFQRequestsPage().getVendorItemColumnHeaders();
        Assert.assertTrue(QtyColumnsOnGrid == 1);
    }

    @Test(priority = 6, description = "Edit the  “Qty” column on Vendor Submission list"
            ,enabled = true)
    public void Test_VendorSubmissionList_Quantity() throws InterruptedException {
        // Check for the only one qty column on the Quote item tab of eRFQ Requests
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().CreateERFQOptionClick();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().refreshClick();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().setSearchByBidNumber("BID065");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickLoadPackageList();
        TimeUtil.midTime();
        testContextUI.geteRFQPage().clickVendorSubmissionListIcon("PLUMB");
        TimeUtil.veryShortTime();
        testContextUI.geteRFQPage().clickVendorQuotationViewIcon();
        TimeUtil.midTime();
        testContextUI.geteRFQRequestsPage().clickOnNextButton();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQRequestsPage().clickOnNextButtonToAttachment();
        int QtyColumnsOnGrid = testContextUI.geteRFQRequestsPage().getVendorItemColumnHeaders();
        Assert.assertTrue(QtyColumnsOnGrid == 1);
    }
}

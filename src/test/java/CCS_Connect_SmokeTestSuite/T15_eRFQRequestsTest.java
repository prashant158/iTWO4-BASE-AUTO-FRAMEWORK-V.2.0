package CCS_Connect_SmokeTestSuite;

import CCS_ConnectScripts._01_BaseClass;
import iTWO_Utilities.ExcelUtil;
import iTWO_Utilities.TimeUtil;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class T15_eRFQRequestsTest extends _01_BaseClass {

    ExcelUtil excelRFQRequests = new ExcelUtil("eRFQ_Requests");

    @DataProvider(name = "TestDataeRFQ")
    public Object[][] testDataSupplied() throws EncryptedDocumentException, IOException {
        //To go through all the rows of the excel
        //Object[][] obj_eRFQ = new Object[excelCreateRFQ.getRowCount()][1];
        Object[][] obj_eRFQ = new Object[1][1];

        Map<String, String> testData;
        //for (int i = 1; i <= excelRFQRequests.getRowCount(); i++) {
        for (int i = 1; i <= 1; i++) {
            testData = excelRFQRequests.getTestDataInHashmap(i, "eRFQ_Requests");
            obj_eRFQ[i - 1][0] = testData;
        }
        return obj_eRFQ;
    }

    @Test(priority = 1, description = "Navigate to eRFQ > eRFQ Request", enabled = true)
    public void Test_eRFQ_Requests_Page() throws InterruptedException {
        // Click on the eRFQ Menu and then eRFQ Requests
        testContextUI.getHomePage().ERFQMenuClick();
        testContextUI.getHomePage().eRFQRequestsOptionClick();
        String title = testContextUI.geteRFQPage().getGridTitle().getText();
        Assert.assertEquals(title, "Requests Received");
    }

    @Test(priority = 2,
            description = "Verify vendor can view/open the Vendor Request", enabled = false)
    public void Test_Vendor_Requests() throws InterruptedException {
        testContextUI.geteRFQRequestsPage().setSearchByBidNumberOnRequests("BID001");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.shortTime();
        String requestName = testContextUI.geteRFQRequestsPage().getFirstRequestName().getText();
        Assert.assertEquals(requestName, "Construction Computer Software (Pty) Ltd");
    }

    @Test(priority = 3, description = "Upload a document that is marked as 'Required' by Org User for the vendor ",
            enabled = true)
    public void Test_upload_Required_documents() throws InterruptedException, IOException {
        // Sort the Request Received column and check the top row (which shows old record)
        testContextUI.geteRFQRequestsPage().setSearchByBidNumberOnRequests("BID001");
        //testContextUI.geteRFQRequestsPage().selectStatus("Open");
        TimeUtil.veryShortTime();
        testContextUI.getBidListPage().RETURN();
        TimeUtil.veryShortTime();
        testContextUI.geteRFQRequestsPage().clickOnViewRequests();
        //TimeUtil.veryShortTime();
        //testContextUI.geteRFQRequestsPage().clickOnViewRequests();

        if (testContextUI.geteRFQRequestsPage().isPricingValidationModalPresent()) {

            testContextUI.geteRFQRequestsPage().clickRadioOptionOnPriceRateConfirmation();
            testContextUI.geteRFQRequestsPage().clickProceedBtn();
            TimeUtil.midTime();
            testContextUI.geteRFQRequestsPage().clickOnNextButton();
            TimeUtil.veryShortTime();
            //testContextUI.geteRFQRequestsPage().clickOnNextButtonToAttachment();
            testContextUI.geteRFQRequestsPage().clickIconBtnExpand();
            testContextUI.geteRFQRequestsPage().clickFileUploadOption();
            testContextUI.geteRFQRequestsPage().clickOnNextButtonToAttachment();
            //testContextUI.geteRFQRequestsPage().uploadAttachment();
            Runtime.getRuntime().exec("D:\\RIB CCS CONNECT SCRIPTS\\AutoIT\\Vendor\\UploadFile.exe");
            testContextUI.geteRFQRequestsPage().clickSubmitTab();
            String validationMsg = testContextUI.geteRFQRequestsPage().checkAttachmentValidation().getText();
            Assert.assertEquals(validationMsg, "Attachment validations successful");

        } else {
            TimeUtil.veryShortTime();
            testContextUI.geteRFQRequestsPage().clickOnNextButton();
            TimeUtil.veryShortTime();
            //testContextUI.geteRFQRequestsPage().clickOnNextButtonToAttachment();
            testContextUI.geteRFQRequestsPage().clickIconBtnExpand();
            testContextUI.geteRFQRequestsPage().clickFileUploadOption();
            //testContextUI.geteRFQRequestsPage().clickOnNextButtonToAttachment();
            //testContextUI.geteRFQRequestsPage().uploadAttachment();
            Runtime.getRuntime().exec("D:\\RIB CCS CONNECT SCRIPTS\\AutoIT\\Vendor\\UploadFile.exe");
            testContextUI.geteRFQRequestsPage().clickSubmitTab();
            String validationMsg = testContextUI.geteRFQRequestsPage().checkAttachmentValidation().getText();
            Assert.assertEquals(validationMsg, "Attachment validations successful");
        }
    }

        @Test(priority = 4, description = "Verify the attached documents are displayed, and the vendor can view them",
                enabled = true)
        public void Test_attached_docs () throws InterruptedException, IOException {
            // Sort the Request Received column and check the top row (which shows old record)
            testContextUI.getHomePage().ERFQMenuClick();
            testContextUI.getHomePage().eRFQRequestsOptionClick();
            testContextUI.geteRFQRequestsPage().setSearchByBidNumberOnRequests("BID001");
            //testContextUI.geteRFQRequestsPage().selectStatus("Open");
            TimeUtil.veryShortTime();
            testContextUI.getBidListPage().RETURN();
            TimeUtil.veryShortTime();
            testContextUI.geteRFQRequestsPage().clickOnViewRequests();
            //TimeUtil.veryShortTime();
            //testContextUI.geteRFQRequestsPage().clickOnViewRequests();
            TimeUtil.midTime();
            testContextUI.geteRFQRequestsPage().clickOnNextButton();
            TimeUtil.veryShortTime();
            testContextUI.geteRFQRequestsPage().clickIconBtnExpand();
            Assert.assertTrue(testContextUI.geteRFQRequestsPage().getAttachment("1.jpg"));
        }

        @Test(priority = 5, description = "Confirm submitting a quotation if all items don't have a rate",
            enabled = true)
            public void Test_PricingValidations_WhenNoRatesPresent () throws InterruptedException {
            // Sort the Request Received column and check the top row (which shows old record)
            testContextUI.getHomePage().ERFQMenuClick();
            testContextUI.getHomePage().eRFQRequestsOptionClick();
            testContextUI.geteRFQRequestsPage().setSearchByBidNumberOnRequests("BID001");
            //testContextUI.geteRFQRequestsPage().selectStatus("Open");
            TimeUtil.veryShortTime();
            testContextUI.getBidListPage().RETURN();
            TimeUtil.midTime();
            testContextUI.geteRFQRequestsPage().clickOnViewRequests();
            //TimeUtil.veryShortTime();
            //testContextUI.geteRFQRequestsPage().clickOnViewRequests();
            TimeUtil.midTime();
            testContextUI.geteRFQRequestsPage().selectQuoteCurrency("ZAR-Rand");
            testContextUI.geteRFQRequestsPage().clickOnNextButton();
            testContextUI.geteRFQRequestsPage().clickSubmitTab();
            String pricingValidation = testContextUI.geteRFQRequestsPage().checkPricingValidation().getText();
            Assert.assertEquals(pricingValidation, "Not all items have been priced. Please ensure these items are at least qualified under the Rate Type column to proceed with submitting this quote.");
        }


    @Test(priority = 6, description = "Check and verify entering rate on the Quote item tab",
                enabled = true)
        public void Test_add_rates_ToQuoteItems () throws InterruptedException {
            // Sort the Request Received column and check the top row (which shows old record)
            testContextUI.getHomePage().ERFQMenuClick();
            testContextUI.getHomePage().eRFQRequestsOptionClick();
            testContextUI.geteRFQRequestsPage().setSearchByBidNumberOnRequests("BID001");
            //testContextUI.geteRFQRequestsPage().selectStatus("Open");
            TimeUtil.veryShortTime();
            testContextUI.getBidListPage().RETURN();
            TimeUtil.veryShortTime();
            testContextUI.geteRFQRequestsPage().clickOnViewRequests();
            //TimeUtil.veryShortTime();
            //testContextUI.geteRFQRequestsPage().clickOnViewRequests();
            TimeUtil.shortTime();
            testContextUI.geteRFQRequestsPage().selectQuoteCurrency("ZAR-Rand");
            testContextUI.geteRFQRequestsPage().clickOnNextButton();
            TimeUtil.veryShortTime();
            testContextUI.geteRFQRequestsPage().clickOnNextButtonToAttachment();
            TimeUtil.veryShortTime();
            testContextUI.geteRFQRequestsPage().clickearthWorksItem1();
            testContextUI.geteRFQRequestsPage().setEarthWorksItem1Input("20.3");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().EnterRates("10.3");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().EnterRates("10.3");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().EnterRates("10.3");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().EnterRates("10.3");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().EnterRates("10.3");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().EnterRates("10.3");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().clickearthWorksItem8();
            testContextUI.geteRFQRequestsPage().setEarthWorksItem8Input("15.2");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().EnterRates("15.2");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().EnterRates("15.2");
            testContextUI.geteRFQRequestsPage().pressEnterKey();
            testContextUI.geteRFQRequestsPage().clickNxtBtnSubmit();
            String pricingValidation = testContextUI.geteRFQRequestsPage().checkPricingValidation().getText();
            Assert.assertEquals(pricingValidation, "Pricing validations successful.");
        }

        @Test(priority = 7, description = "Submit Quotation back to the Org user",
                enabled = true)
        public void Test_SubmitQuote () throws InterruptedException {
            testContextUI.geteRFQRequestsPage().clickQuoteSubmitBtn();
            testContextUI.geteRFQRequestsPage().clickQuoteCurrencyAcknowledgement();
            testContextUI.geteRFQRequestsPage().clickBtnYesOnCurrencyAcknowledgement();
            testContextUI.geteRFQRequestsPage().setSearchByBidNumberOnRequests("BID001");
            String getStatus = testContextUI.geteRFQRequestsPage().getStatusFromSearchedResult().getText();
            Assert.assertEquals(getStatus, "Submitted");
        }

    }

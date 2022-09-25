package Connect_Pages;

import iTWO_Utilities.ElementUtil;
import iTWO_Utilities.TimeUtil;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class P20_Project_Module_page extends ElementUtil {
    private WebDriver driver;
    public static String NewProjectNum;
    public static String PrjSearchFlag = "FromExcel";
    public static String BOQPrevious_value;
    public static String BOQFinal_value;
    public static String BillNetAmount;

    public P20_Project_Module_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[normalize-space()='Project']")
    WebElement project_module;

    /**
     * FunctionTag: PRJF#1 |
     * The function is used to open project module from tile
     */
    public void selectProjectModule() {
        TimeUtil.midTime();
        clickOnElement(project_module);
        TimeUtil.shortTime();
    }

    @FindBy(xpath = "//button[@title='Refresh (Ctrl+R)']")
    WebElement refreshClick;

    /**
     * FunctionTag: PRJF#2
     * The function is used to refresh main window
     */
    public void doRefresh_Window() {
        TimeUtil.longTime();
        clickOnElement(refreshClick);
        TimeUtil.shortTime();
    }

    @FindBy(xpath = "(//input[@placeholder='Search Term'])[1]")
    WebElement projectSearchField;

    /**
     * FunctionTag: PRJF#3 |
     * Clear search field in project module
     */
    public void clearProjectsSearch() {
        TimeUtil.shortTime();
        JSElementClear(projectSearchField);
        TimeUtil.midTime();
    }


    @FindBy(xpath = "(//button[contains(@title,'New Record')])[1]")
    WebElement newRecord;

    /**
     * FunctionTag: PRJF#4 |
     * Check presence of New Record button in Project Module
     */
    public void presenceOfNewRecordBtn() {
        vefiyElementPresent(newRecord);
        TimeUtil.shortTime();
    }

    /**
     * FunctionTag: PRJF#5
     * Select New Record button in project module and open add new record popup
     *
     * @throws Exception
     */
    public void doClickOnNewRecordBtn() throws Exception {
        TimeUtil.midTime();
        elementActionsClick(newRecord);
        TimeUtil.shortTime();
        SwitchToPopUp();
        TimeUtil.veryShortTime();
    }


    @FindBy(xpath = "//div[@role='dialog']//label[contains(text(),'Number')]//following-sibling::div[1]//input[1]")
    WebElement ProjectNo;
    @FindBy(xpath = "//div[@role='dialog']//label[text()='Name']//following-sibling::div[1]//input[1]")
    WebElement Enter_Name;
    @FindBy(xpath = "//div[@role='dialog']//label[text()='Cost Group Configuration']//following::div[1]//span[1]")
    WebElement DropDwn_CostGroupConfig;
    @FindBy(xpath = "//div[@role='dialog']//label[text()='Clerk']//following::input[1]")
    WebElement Enter_Clerk;
    @FindBy(xpath = "//div[@role='dialog']//label[text()='Rubric Category']//following::div[1]//button[2]")
    WebElement DropDwn_RubricCtg;
    @FindBy(xpath = "//div[@role='dialog']//label[text()='Group']//following::div[1]//button[2]")
    WebElement DropDwn_Group;
    @FindBy(xpath = "//button[normalize-space()='OK']")WebElement Click_Ok;


    /**
     * FunctionTag: PRJF#6
     * Function is used to create project by filling some important data
     */
    public void doCreateProject(String name, String costGroupConfig, String rubricCategory, String project_no, String Category_Title, String clerk) {
        setElement(ProjectNo, project_no);
        TimeUtil.veryShortTime();
        setElement(Enter_Name, name);
        TimeUtil.veryShortTime();
        try {
            WebElement DupliNumber = driver.findElement(By.xpath("//div[contains(text(),'The project number should be unique')]"));
            if (DupliNumber != null) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("-Hss");
                LocalTime localTime = LocalTime.now();
                NewProjectNum = project_no + dtf.format(localTime);
                JSElementClear(ProjectNo);
                setElement(ProjectNo, NewProjectNum);
                PrjSearchFlag = "Modified";
            }
        } catch (NoSuchElementException e) {
            System.out.println("All data is unique");
        }

        clickOnElement(DropDwn_CostGroupConfig);
        TimeUtil.veryShortTime();
        clickOnElement(driver.findElement(By.xpath("//li[contains(text(),'" + costGroupConfig + "')]")));
        TimeUtil.veryShortTime();
        /*Enter_Clerk.clear();
        TimeUtil.midTime();
        setElement(Enter_Clerk,clerk);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + clerk + "']")));
        TimeUtil.midTime();*/
        clickOnElement(driver.findElement(By.xpath("//div[@role='dialog']//label[contains(text(),'Category')]//following::div[1]//button[2]")));
        TimeUtil.veryShortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + rubricCategory + "']")));
        TimeUtil.veryShortTime();
        clickOnElement(Click_Ok);
        TimeUtil.midTime();
    }

    @FindBy(xpath = "//button[@title='Unsaved Data']//*[local-name()='svg']")
    WebElement Click_ALL_Save;

    /**
     * FunctionTag: PRJF#7
     * Function is used to save all changes
     */
    public void do_AllSave() {
        TimeUtil.midTime();
        clickOnElement(Click_ALL_Save);
        TimeUtil.shortTime();
    }

    @FindBy(xpath = "//nav[@id='commandBar']//button[contains(@title,'Search')]")
    WebElement SideBar_Search;

    /**
     * FunctionTag: PRJF#8
     * Function is used to select sidebar
     */
    public void doSelectSearchSideBar() {
        TimeUtil.shortTime();
        clickOnElement(SideBar_Search);
        TimeUtil.shortTime();
    }

    @FindBy(xpath = "//input[@id='GoogleSearchInput']")
    WebElement Search_Input;
    @FindBy(xpath = "//button[@class='btn btn-default tlb-icons ico-search']")
    WebElement Search_Button;

    /**
     * FunctionTag: PRJF#9
     *
     * @param project Function is used to search the project from sidebar
     */
    public void doSearchProject(String project) {
        TimeUtil.shortTime();
        Search_Input.clear();
        switch (PrjSearchFlag) {
            case "FromExcel":
                setElement(Search_Input, project);
                TimeUtil.veryShortTime();
                clickOnElement(Search_Button);
                TimeUtil.shortTime();
                clickOnElement(SideBar_Search);
                TimeUtil.shortTime();
                break;
            case "Modified":
                setElement(Search_Input, NewProjectNum);
                TimeUtil.veryShortTime();
                clickOnElement(Search_Button);
                TimeUtil.shortTime();
                clickOnElement(SideBar_Search);
                TimeUtil.shortTime();
                break;
        }
    }

    @FindBy(xpath = "//button[@title='Copy record including dependencies']")
    WebElement CopyRecord_Click;


    /**
     * FunctionTag: PRJF#10
     * Function is used to select project copy record button
     *
     * @throws Exception
     */
    public void doSelectCopyRecordBtn() throws Exception {
        TimeUtil.shortTime();
        clickOnElement(CopyRecord_Click);
        TimeUtil.veryShortTime();
        SwitchToPopUp();
        TimeUtil.veryShortTime();
    }

    @FindBy(xpath = "//button[normalize-space()='Next']")
    WebElement NextBtn_Click;
    @FindBy(xpath = "//input[@data-ng-model='entity.Project.ProjectName']")
    WebElement Enter_name;
    @FindBy(xpath = "//input[@data-ng-model='entity.Project.copyObject.scheduling.schedule.schedule']")
    WebElement check_Schedule;
    @FindBy(xpath = "//label[normalize-space()='Select']//input[@type='checkbox']")
    WebElement check_allEstimate;
    @FindBy(xpath = "//button[normalize-space()='Finish']")
    WebElement Click_Finish;


    /**
     * FunctionTag: PRJF#11
     * the function is used to do project record copy process
     *
     * @param name
     * @param projectno1
     */
    public void doProjectCopyRecord(String name, String projectno1) {
        TimeUtil.shortTime();
        clickOnElement(NextBtn_Click);
        TimeUtil.shortTime();
        Enter_name.clear();
        TimeUtil.veryShortTime();
        setElement(ProjectNo, projectno1);
        TimeUtil.veryShortTime();
        setElement(Enter_name, name);
        TimeUtil.veryShortTime();
        try {
            WebElement DupliNumber = driver.findElement(By.xpath("//div[contains(text(),'The project number should be unique')]"));
            if (DupliNumber.isDisplayed()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("-Hss");
                LocalTime localTime = LocalTime.now();
                NewProjectNum = projectno1 + dtf.format(localTime);
                TimeUtil.midTime();
                JSElementClear(ProjectNo);
                TimeUtil.midTime();
                setElement(ProjectNo, NewProjectNum);
                TimeUtil.shortTime();
                PrjSearchFlag = "CopyProjectNum";
            }
        } catch (NoSuchElementException e) {
            System.out.println("Complete data is unique");
        }
        TimeUtil.veryShortTime();
        clickOnElement(NextBtn_Click);
        TimeUtil.veryShortTime();
        JSElementClick(check_Schedule);
        TimeUtil.veryShortTime();
        JSElementClick(check_allEstimate);
        TimeUtil.shortTime();
        for (int i = 3; i <= 7; i++) {
            WebElement checkBox1 = driver.findElement(By.xpath("//div[@role='dialog']//div/section[3]/div/form/div/div/div/div[" + i + "]//input[1]"));
            if (!checkBox1.isSelected()) {
                clickOnElement(checkBox1);
            }
        }
        TimeUtil.shortTime();
        clickOnElement(NextBtn_Click);
        TimeUtil.shortTime();
        for (int i = 1; i <= 10; i++) {
            WebElement checkBox2 = driver.findElement(By.xpath("//div[@role='dialog']//div[1]//form[1]//div[1]//div[1]//div[1]//div[" + i + "]//div[1]//div[1]//input[1]"));
            if (!checkBox2.isSelected()) {
                clickOnElement(checkBox2);
            }
        }
        TimeUtil.shortTime();
        clickOnElement(NextBtn_Click);
        TimeUtil.shortTime();
        clickOnElement(Click_Finish);
        SwitchToBack();
        TimeUtil.shortTime();

    }


    /**
     * FunctionTag: PRJF#12
     * The function specially designed to calculate project copy record processing time
     */
    public void calculate_copyProject_LoadTime() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        do {
            try {
                String loadElement = driver.findElement(By.xpath("//span[contains(text(),'Deep Copy in Progress, this Operation may take sev')]")).getText();
                if (loadElement != null) {
                    long tm = (stopWatch.getTime() / 1000) % 60;
                    System.out.println(loadElement + ">>>" + tm + ">>" + "Time in Second");
                } else {
                    break;
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Error is==>>>" + e);
                break;
            } catch (NoSuchElementException ex) {
                System.out.println("Error is==>>>" + ex);
                break;
            }

        } while (true);

    }


    /**
     * FunctionTag: PRJF#13
     * Validation method | Used to verify whether project record copied or not
     *
     * @param copyPrjNum
     */
    public void checkCopyProject(String copyPrjNum) {
        String value;
        switch (PrjSearchFlag) {
            case "FromExcel":
                value = copyPrjNum.toUpperCase();
                String getProjectNum = driver.findElement(By.xpath("//div[contains(text(),'" + value + "')]")).getText();
                Assert.assertEquals(getProjectNum, value);
                break;
            case "CopyProjectNum":
                value = NewProjectNum.toUpperCase();
                String getProjectNum1 = driver.findElement(By.xpath("//div[contains(text(),'" + value + "')]")).getText();
                Assert.assertEquals(getProjectNum1, value);
                break;
        }
    }


    // Sales Process - Pooja

    @FindBy(xpath = "//button[@title='Wizard']")WebElement Wizard;
    @FindBy(xpath = "//button[@title='Pin Selected Item']")
    WebElement Click_Pinned_Button;

    /**
     * FunctionTag:-
     * This function is used to pin the copyed project
     */
    public void pin_Project() {
        TimeUtil.veryShortTime();
        clickOnElement(Click_Pinned_Button);
        TimeUtil.shortTime();

    }


    @FindBy(xpath = "//span[normalize-space()='BoQ']")WebElement BOQPage;
    public void getBOQValue(){
        clickOnElement(BOQPage);
        TimeUtil.midTime();
        WebElement BOQfinalValue = driver.findElement(By.xpath("//div[normalize-space()='Rohbau']/following::div[1]"));
        TimeUtil.midTime();
        BOQPrevious_value= BOQfinalValue.getText();

    }


    @FindBy(xpath = "//span[normalize-space()='Estimate']")WebElement Click_Estimate_Tab;
    @FindBy(xpath = "//button[@title='Open Estimation']")WebElement Click_Open_Estimate;
    @FindBy(xpath = "//button[@title='Wizard']")WebElement Click_Wizard;
    @FindBy(xpath = "//li[contains(text(),'Create Bid')]")WebElement Click_Create_Bid;
    @FindBy(css = "input[type='text'][data-ng-model='searchValue']")WebElement ClerkNameSearch;
    @FindBy(xpath = "//label[normalize-space()='Business Partner']/following::button[2]")WebElement Select_BusinessPartner;
    @FindBy(xpath = "//button[@title='search']")WebElement Click_Search;
    @FindBy(xpath = "//input[@placeholder='Insert search Term']")WebElement Input_BP;
    @FindBy(xpath = "//button[normalize-space()='OK']")WebElement Click_OK;
    @FindBy(xpath = "//button[normalize-space()='Next']")WebElement Click_Next;
    @FindBy(xpath = "//button[normalize-space()='Execute']")WebElement Click_Execute;
    @FindBy(xpath = "//li[contains(text(),'Change Bid Status')]")WebElement Change_BidStatus;
    @FindBy(xpath = "//a[normalize-space()='Submitted']")WebElement Select_Submitted;
    @FindBy(xpath = "(//span[contains(text(),'In Progress')])[1]/following::div[2]")WebElement Bid_Description;

    public void create_Bid(String ClerkNam, String Business_PartnerName, String Bid_DescriptionValue) throws Exception {
        TimeUtil.shortTime();
        clickOnElement(Click_Estimate_Tab);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(with(By.xpath("(//div[contains(text(),'In Progress')])[2]")).below(By.xpath("(//div[@title='Status'])[3]"))));
        TimeUtil.shortTime();
        clickOnElement(Click_Open_Estimate);
        TimeUtil.shortTime();
        WebElement WizardTitle= driver.findElement(By.xpath("//div[@translate='cloud.desktop.sdWizardTitle']"));
        if(WizardTitle.isDisplayed())
        {
            TimeUtil.shortTime();
            clickOnElement(Click_Create_Bid);
            TimeUtil.shortTime();
        }else{
            TimeUtil.shortTime();
            clickOnElement(Wizard);
        }
        TimeUtil.midTime();
        clickOnElement(Click_Create_Bid);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//label[normalize-space()='Clerk']/following::span[1]")));
        TimeUtil.shortTime();

        try{
            SwitchToPopUp();
            ClerkNameSearch.clear();
            TimeUtil.shortTime();
            setElement(ClerkNameSearch, ClerkNam);
            TimeUtil.shortTime();
            clickOnElement(driver.findElement(By.cssSelector("button[title='search']")));
            TimeUtil.shortTime();
            clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + ClerkNam + "']")));
            TimeUtil.shortTime();
            clickOnElement(driver.findElement(By.cssSelector("button[type='button'][data-ng-disabled='okBtnDisabled()']")));
            SwitchToBack();
        }catch(NoSuchElementException e)
        {
            e.printStackTrace();

        }
        TimeUtil.midTime();
        clickOnElement(Select_BusinessPartner);
        TimeUtil.shortTime();
        Input_BP.clear();
        TimeUtil.shortTime();
        setElement(Input_BP, Business_PartnerName);
        TimeUtil.shortTime();
        clickOnElement(Click_Search);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + Business_PartnerName + "']")));
        TimeUtil.midTime();
        clickOnElement(Click_OK);
        TimeUtil.shortTime();
        clickOnElement(Click_Next);
        TimeUtil.midTime();
        clickOnElement(Click_Execute);
        TimeUtil.longTime();
        TimeUtil.longTime();
        clickOnElement(Bid_Description);
        TimeUtil.midTime();
        /*setElement(driver.findElement(By.xpath("//input[@data-ng-model='value']")),Bid_DescriptionValue);
        TimeUtil.midTime();*/

    }

    public void change_BidStatus(){

        WebElement WizardTitle= driver.findElement(By.xpath("//div[@translate='cloud.desktop.sdWizardTitle']"));
        if(WizardTitle.isDisplayed())
        {
            JSElementClick(Change_BidStatus);
            TimeUtil.shortTime();

        }else{
            TimeUtil.shortTime();
            clickOnElement(Wizard);
            TimeUtil.shortTime();
        }
        try {
            JSElementClick(driver.findElement(By.xpath("(//li[contains(text(),'Change Bid Status')])[1]")));
            TimeUtil.midTime();
            clickOnElement(Select_Submitted);
            TimeUtil.shortTime();
            clickOnElement(Click_Ok);
            TimeUtil.midTime();
        }catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }

    }

    @FindBy(xpath = "(//span[contains(text(),'Submitted')])[1]/following::div[3]")WebElement GetBidProject_No;
    @FindBy(xpath = "(//span[contains(text(),'Submitted')])[1]/following::div[4]")WebElement GetBidNet_Amount;

    public void getBid_values()
    {
        String GetBidProjectNo= GetBidProject_No.getText();
        System.out.println("Project Numner is ==>"+GetBidProjectNo);
        String GetBidNetAmount = GetBidNet_Amount.getText();
        System.out.println("Bid Net Amout is ==>"+ GetBidNetAmount);
    }

    @FindBy(xpath = "//li[contains(text(),'Create Contract')]")WebElement Create_Contact;
    @FindBy(xpath = "//li[contains(text(),'Change Contract Status')]")WebElement Change_Contract_Status;
    @FindBy(xpath = "//a[normalize-space()='Contracted']")WebElement Select_Contract_Status;

    public void create_Contract() {
        TimeUtil.longTime();
        WebElement WizardTitle= driver.findElement(By.xpath("//div[@translate='cloud.desktop.sdWizardTitle']"));
        try{
            if(WizardTitle.isDisplayed())
            {
                TimeUtil.shortTime();
                clickOnElement(Create_Contact);
                TimeUtil.shortTime();
            }else{
                clickOnElement(Wizard);
                TimeUtil.shortTime();
                clickOnElement(Create_Contact);
                TimeUtil.shortTime();
                clickOnElement(driver.findElement(By.xpath("//button[normalize-space()='OK']")));
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
            clickOnElement(Create_Contact);
            TimeUtil.shortTime();
            clickOnElement(driver.findElement(By.xpath("//button[normalize-space()='OK']")));
        }
        clickOnElement(driver.findElement(By.xpath("//button[normalize-space()='OK']")));
        TimeUtil.longTime();
        clickOnElement(driver.findElement(By.xpath("(//span[contains(text(),'In Progress')])[1]")));
        TimeUtil.midTime();


    }

    public void change_ContractStatus()
    {
        WebElement WizardTitle = driver.findElement(By.xpath("//div[@translate='cloud.desktop.sdWizardTitle']"));
        try {
            if (WizardTitle.isDisplayed()) {
                TimeUtil.shortTime();
                clickOnElement(Change_Contract_Status);
                TimeUtil.shortTime();
            } else {
                clickOnElement(Wizard);
            }
        }catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        TimeUtil.shortTime();
        clickOnElement(Change_Contract_Status);
        TimeUtil.shortTime();
        clickOnElement(Select_Contract_Status);
        TimeUtil.midTime();
        clickOnElement(Click_Ok);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("(//span[contains(text(),'Contracted')])[1]")));
        TimeUtil.longTime();
    }

    @FindBy(xpath = "(//span[contains(text(),'Contracted')])[1]/following::div[4]")WebElement GetContractNet_Amount;
    @FindBy(xpath = "(//span[contains(text(),'Contracted')])[1]/following::div[7]")WebElement GetContactBP_Name;

    public void getContractValue()
    {
        try{
            TimeUtil.midTime();
            String GetContactNetAmount= GetContractNet_Amount.getText();
            System.out.println("Contact Net Amount is ==>"+GetContactNetAmount);
            TimeUtil.midTime();
            String GetContactBPName= GetContactBP_Name.getText();
            System.out.println("Contract Business partner Name is ==>"+GetContactBPName);
            Assert.assertEquals(GetContactNetAmount,GetBidNet_Amount.getText());
            TimeUtil.midTime();
        }catch(NoSuchElementException e){

        }

    }

    @FindBy(xpath = "//li[contains(text(),'Create WIP')]")WebElement Create_WIP;
    @FindBy(xpath = "//div[@role='dialog']//div[1]//div[1]/div[3]/div[1]/input[1]")WebElement Enter_Description;
    @FindBy(xpath = "//span[normalize-space()='BoQ']")WebElement Click_BoQ;
    @FindBy(xpath = "//div[normalize-space()='Position']/following::div[6]")WebElement Click_Quantity;
    @FindBy(xpath = "//input[@data-ng-model='value']")WebElement Enter_Quantity;
    @FindBy(xpath = "//button[@title='Unsaved Data']")WebElement Click_UnSave;
    @FindBy(xpath = "//span[normalize-space()='WIP']")WebElement Click_WIP;
    @FindBy(xpath = "//li[contains(text(),'Change WIP Status')]")WebElement Change_WIP_Status;
    @FindBy(xpath = "//a[normalize-space()='Approved']")WebElement Select_Approved;


    public void create_WIP(String Description,String WIPQuantity,String Business_PartnerName) {
        WebElement WizardTitle = driver.findElement(By.xpath("//div[@translate='cloud.desktop.sdWizardTitle']"));
        try {
            if (WizardTitle.isDisplayed()) {
                TimeUtil.shortTime();
                JSElementClick(Create_WIP);
                TimeUtil.shortTime();
            } else {
                TimeUtil.shortTime();
                clickOnElement(Wizard);
                TimeUtil.shortTime();
            }
        }catch (NoSuchElementException e)
        {
            e.printStackTrace();
            clickOnElement(Wizard);
        }
        TimeUtil.midTime();
        JSElementClick(Create_WIP);
        TimeUtil.midTime();
        Enter_Description.clear();
        TimeUtil.shortTime();
        setElement(Enter_Description, Description);
        TimeUtil.shortTime();
        clickOnElement(Click_Ok);
        TimeUtil.longTime();
        TimeUtil.midTime();
        String WIPNetAmountPrevious = driver.findElement(By.xpath("(//span[contains(text(),'In Progress')])[1]/following::div[5]")).getText();
        System.out.println("Wip NetAmount is ==> "+WIPNetAmountPrevious);
        TimeUtil.midTime();
        clickOnElement(Click_BoQ);
        TimeUtil.midTime();
        clickOnElement(Click_Quantity);
        TimeUtil.midTime();
        setElement(Enter_Quantity,WIPQuantity);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='Position']/following::div[8]")));
        TimeUtil.shortTime();
        clickOnElement(Click_UnSave);
        TimeUtil.midTime();
        clickOnElement(Click_WIP);
        TimeUtil.midTime();
    }

    public void change_WIPStstus(String Business_PartnerCode){

        String WIPNetAmountPrevious = driver.findElement(By.xpath("(//span[contains(text(),'In Progress')])[1]/following::div[5]")).getText();
        try{
            WebElement BusinessPartnerName= driver.findElement(By.xpath("(//span[contains(text(),'In Progress')])[1]/following::div[4]"));
            String BPName= BusinessPartnerName.getText();
            TimeUtil.midTime();
            String WIPNetAmountFinal = driver.findElement(By.xpath("(//span[contains(text(),'In Progress')])[1]/following::div[5]")).getText();
            TimeUtil.midTime();
            Assert.assertEquals(BPName,Business_PartnerCode);
            TimeUtil.midTime();
            Assert.assertEquals(WIPNetAmountFinal,WIPNetAmountPrevious);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

        TimeUtil.midTime();

    }

    @FindBy(xpath = "(//li[contains(text(),'Create Bill')])[1]")
    WebElement Create_Bill;
    @FindBy(xpath = "//input[@data-ng-model='entity.Description']")
    WebElement Bill_Description;

    public void create_Bill(String Bill_description) {
        try {
            clickOnElement(Wizard);
            TimeUtil.midTime();
            clickOnElement(Change_WIP_Status);
            TimeUtil.midTime();
            clickOnElement(Select_Approved);
            TimeUtil.midTime();
            clickOnElement(Click_Ok);
            TimeUtil.midTime();
            clickOnElement(driver.findElement(By.xpath("//span[normalize-space()='Approved']")));
            TimeUtil.midTime();
            clickOnElement(Wizard);
            TimeUtil.midTime();
            clickOnElement(Create_Bill);
            TimeUtil.midTime();
            setElement(Bill_Description, Bill_description);
            TimeUtil.midTime();
            clickOnElement(Click_Ok);
            TimeUtil.longTime();
            TimeUtil.midTime();

        }catch (NoSuchMethodError e){
            e.printStackTrace();
        }
    }



    public void getBOQFinalValue(){
        TimeUtil.midTime();
        WebElement BillNet_Amount=driver.findElement(By.xpath("//label[normalize-space()='Net Amount']/following::div[1]"));
        BillNetAmount=BillNet_Amount.getText();
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.cssSelector("button[title='Go To Project']")));
        TimeUtil.longTime();
        TimeUtil.midTime();
        clickOnElement(BOQPage);
        TimeUtil.longTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='iTWO Cloud Project']")));
        TimeUtil.midTime();
        try{
            WebElement BOQfinalValue = driver.findElement(By.xpath("//div[normalize-space()='Rohbau']/following::div[1]"));
            TimeUtil.midTime();
            BOQFinal_value= BOQfinalValue.getText();
            System.out.println("Current value is ==>"+BOQFinal_value);
            System.out.println("Previous value is ==>"+BOQPrevious_value);
             Assert.assertNotEquals(BOQfinalValue,BillNet_Amount);
             Assert.assertEquals(BOQFinal_value,BOQPrevious_value,"Final value of BOQ should not be equal to Previous value of BOQ before starting the process ");
            System.out.println("Assertion Failed due as BOQ previous and Current value is not equal");

        }catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }



    }

    public void checkProjectStatus(){
        WebElement Status_Project= driver.findElement(By.xpath("//label[normalize-space()='Status']/following::div[@class='input-group-content ng-binding']"));
        String Status=Status_Project.getText();
        SoftAssert softAssertion= new SoftAssert();
        Assert.assertEquals(Status,"Sales","Status should be Same");
        WebElement ProjectType=driver.findElement(By.xpath("//label[normalize-space()='Type']/following::div[@class='input-group-content ng-binding']"));
        String Type=ProjectType.getText();
        Assert.assertEquals(Type,"iTWO Cloud Project","This field is disabled-iTWO Cloud Project");
        WebElement ProjectIndex=driver.findElement(By.xpath("//label[normalize-space()='Index']/following::input[1]"));
        String Index=ProjectIndex.getText();
        Assert.assertEquals(Index,"","This field is disabled - default value 0");
        WebElement Category_Type= driver.findElement(By.xpath("//label[normalize-space()='Category']/following::div[@class='input-group-content ng-binding']"));
        String Category= Category_Type.getText();
        Assert.assertEquals(Category,"Construction Project","Project category is Construction project");
        WebElement ProjectNo=driver.findElement(By.xpath("//label[normalize-space()='Project Number']/following::input[1]"));
        Assert.assertEquals(ProjectNo.getText(),NewProjectNum,"Project number entered/generated automatically on the Create Project window is same");

    }



    /*-------------------------------------------------Project Characteristic------------------------------------------*/


    @FindBy(xpath = "//button[@title='Characteristics']")
    WebElement Project_Characteristics;
    @FindBy(xpath = "(//button[contains(@title,'New Record')])[2]")WebElement New_Character;
    @FindBy(xpath = "//input[@data-ng-model='displayText']")WebElement Set_Character_Code;
    @FindBy(xpath = "//button[contains(@data-ng-repeat,'button in options.buttons')]//img")WebElement Click_Code_Lookup;
    @FindBy(xpath = "(//i[@ng-click='selectNodeHead(node,$event)'])[1]")WebElement Expand_Root;
    /**
     * FunctionTag:-
     * @param Character_Code
     * This function validated the project characteristic in created project also validate all the code assoiciated with
     * project
     */
    public void prjF1_Project_Characteristics(String Character_Code,String Root_Name,String Training_Value,String Descrip)
    {
        try
        {       if(Project_Characteristics.isDisplayed()){
            clickOnElement(Project_Characteristics);
            TimeUtil.midTime();
            clickOnElement(New_Character);
            TimeUtil.veryShortTime();
        }

                /*setElement(Set_Character_Code,Character_Code);
                TimeUtil.VeryshortTime();
                clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='"+Character_Code+"']")));
                TimeUtil.shortTime();*/
            clickOnElement(Click_Code_Lookup);
            TimeUtil.midTime();
            SwitchToPopUp();
            TimeUtil.shortTime();
            clickOnElement(driver.findElement(By.xpath("//div[@role='dialog']//span[contains(text(),'Root')]/parent::div[1]/parent::div[1]/i[1]")));
            TimeUtil.veryShortTime();
            clickOnElement(driver.findElement(By.xpath("//span[normalize-space()='"+Root_Name+"']")));
            TimeUtil.shortTime();
            if(!driver.findElement(By.xpath("//div[normalize-space()='"+Training_Value+"']")).isDisplayed()){
                TimeUtil.shortTime();
                clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='"+Training_Value+"']")));
                TimeUtil.shortTime();
                clickOnElement(Click_Ok);
                TimeUtil.midTime();
                String GetText= driver.findElement(By.xpath("//div[normalize-space()='"+Training_Value+"']/following::div[1]")).getText();
                WebElement Description =driver.findElement(By.xpath("//div[normalize-space()='"+Training_Value+"']/following::div[normalize-space()='"+GetText+"']/following::input[@type='checkbox']"));

                if(!Description.isDisplayed()) {
                    clickOnElement(Description);
                }

            }else{

                clickOnElement(driver.findElement(By.xpath("//button[normalize-space()='Cancel']")));

            }

            TimeUtil.midTime();
            clickOnElement(driver.findElement(By.xpath("//button[@title='Unsaved Data']//*[name()='svg']")));

        }catch(NoSuchElementException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /*------------------------------Project Moditication  FTC_002---------------------------------------------------*/

    @FindBy(xpath = "//input[@placeholder='Insert Filter']")
    WebElement Enter_Search_Input;
    @FindBy(xpath = "//button[@title='Pin Selected Item']")
    WebElement Click_Pin_Selected_Item;

    public void search_Project(String project) {
        TimeUtil.shortTime();
        clickOnElement(Click_Search);
        TimeUtil.shortTime();
        if (Enter_Search_Input != null) {
            Enter_Search_Input.clear();
        }
        setElement(Enter_Search_Input, project);
        TimeUtil.shortTime();
        clickOnElement(refreshClick);
        TimeUtil.midTime();
        clickOnElement(Click_Pin_Selected_Item);
        TimeUtil.shortTime();
        clickOnElement(refreshClick);
    }

    @FindBy(xpath = "//button[@title='Project Details']")
    WebElement Click_Project_Details;
    @FindBy(xpath = "//input[@data-ng-model='entity.ProjectNo']")
    WebElement Edit_Project_Number;
    @FindBy(xpath = "//input[@data-ng-model='entity.ProjectName']")
    WebElement Edit_Name;
    @FindBy(xpath = "//input[@data-ng-model='entity.ProjectName']//following::input[1]")
    WebElement Edit_Name2;
    @FindBy(xpath = "//input[@data-ng-model='entity.ProjectName']//following::input[2]")
    WebElement Edit_MatchCode;
    @FindBy(xpath = "//textarea[@data-ng-model='entity.ProjectDescription']")
    WebElement Edit_Description;
    @FindBy(xpath = "//label[normalize-space()='Clerk']//following::button[2]")
    WebElement Click_Edit_Button;
    @FindBy(xpath = "//input[@data-ng-model='searchValue']")
    WebElement Input_Search;
    @FindBy(xpath = "//button[normalize-space()='Refresh']")
    WebElement Click_Refresh_Button;
    @FindBy(xpath = "//div[normalize-space()='Smith, John']")
    WebElement Select_Clerk;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement Click_Ok_Button;
    @FindBy(xpath = "(//div[@data-ng-class='getEditIcon()'])[6]")
    WebElement Click_Dropdown_Profit_Center;
    @FindBy(xpath = "//input[@data-ng-model='entity.StartDate']")
    WebElement Enter_Start_Date;
    @FindBy(xpath = "//input[@data-ng-model='entity.EndDate']")
    WebElement Enter_Finish_Date;
    @FindBy(xpath = "//label[normalize-space()='Business Unit']//following::button[2]")
    WebElement Click_Business_Unit_Dropdown;
    @FindBy(xpath = "//textarea[@data-ng-model='entity.Remark']")
    WebElement Enter_Remark;
    @FindBy(xpath = "//label[normalize-space()='Date Effective']//following::input[1]")
    WebElement Enter_DateEffective;
    @FindBy(xpath = "//label[normalize-space()='Project Category']//following::button[1]")
    WebElement Clear_ProjectCategory;
    @FindBy(xpath = "(//div[@data-ng-class='getEditIcon()'])[9]")
    WebElement Click_ProjectCategory_Dropdown;
    @FindBy(xpath = "//label[normalize-space()='Project Quantity Control']//following::button[1]")
    WebElement Clear_ProjectQuantity_Control;
    @FindBy(xpath = "//label[normalize-space()='Project Quantity Control']//following::button[2]")
    WebElement Click_ProjectQuantity_Control_Dropdown;
    public void editBasicData(String Project_Num, String Name,String clerk, String Name2, String Matchcode, String Description, String ProfitCenter_Code, String Start_Date, String Finish_Date, String Business_unit, String Remark, String Date_Effective,
                              String Project_Category, String ProjectQuantity_Control) {
        clickOnElement(Click_Pin_Selected_Item);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//h2[@title='Project Details']/following::button[1]")));
        clickOnElement(Click_Project_Details);
        TimeUtil.shortTime();
        Edit_Project_Number.clear();
        setElement(Edit_Project_Number, Project_Num);
        TimeUtil.midTime();
        try {
            WebElement DupliNumber = driver.findElement(By.xpath("//div[contains(text(),'The project number should be unique')]"));
            if (DupliNumber != null) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("-Hss");
                LocalTime localTime = LocalTime.now();
                TimeUtil.shortTime();
                NewProjectNum = Project_Num + dtf.format(localTime);
                JSElementClear(Edit_Project_Number);
                TimeUtil.shortTime();
                setElement(Edit_Project_Number, NewProjectNum);
                TimeUtil.shortTime();
                PrjSearchFlag = "Modified";
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("All data is unique");
        }
        TimeUtil.midTime();
        JSElementClear(Edit_Name);
        TimeUtil.shortTime();
        setElement(Edit_Name, Name);
        TimeUtil.midTime();
        /*setElement(Edit_Name2, Name2);
        TimeUtil.midTime();*/
        JSElementClear(Edit_MatchCode);
        setElement(Edit_MatchCode, Matchcode);
        TimeUtil.shortTime();
        JSElementClear(Edit_Description);
        TimeUtil.shortTime();
        setElement(Edit_Description, Description);
        TimeUtil.shortTime();
        clickOnElement(Click_Edit_Button);
        TimeUtil.shortTime();
        if (Input_Search != null) {
            Input_Search.clear();
        }
        TimeUtil.shortTime();
        clickOnElement(Click_Refresh_Button);
        TimeUtil.midTime();
        JSElementClick(driver.findElement(By.xpath("//div[normalize-space()='Smith, John']")));
        TimeUtil.shortTime();
        JSElementClick(Click_Ok_Button);
        TimeUtil.shortTime();
        clickOnElement(Click_Dropdown_Profit_Center);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + ProfitCenter_Code + "']")));
        TimeUtil.shortTime();
        JSElementClear(Enter_Start_Date);
        setElement(Enter_Start_Date, Start_Date);
        TimeUtil.shortTime();
        JSElementClear(Enter_Finish_Date);
        setElement(Enter_Finish_Date, Finish_Date);
        TimeUtil.shortTime();
        clickOnElement(Click_Business_Unit_Dropdown);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + Business_unit + "']")));
        TimeUtil.shortTime();
        JSElementClear(Enter_Remark);
        setElement(Enter_Remark, Remark);
        TimeUtil.shortTime();
        JSElementClear(Enter_DateEffective);
        setElement(Enter_DateEffective, Date_Effective);
        TimeUtil.shortTime();
        JSElementClear(Clear_ProjectCategory);
        TimeUtil.shortTime();
        clickOnElement(Click_ProjectCategory_Dropdown);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + Project_Category + "']")));
        TimeUtil.shortTime();
        clickOnElement(Clear_ProjectQuantity_Control);
        TimeUtil.shortTime();
        clickOnElement(Click_ProjectQuantity_Control_Dropdown);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("(//div[contains(text(),'" + ProjectQuantity_Control + "')])[1]")));
        TimeUtil.shortTime();

    }

    public void validate_BasicDetails(String Expected_ProjectNumber, String Expected_status,String Expected_Type,String Expected_Clerk) {
        TimeUtil.midTime();
        String actual_project_number = driver.findElement(By.xpath("//div[normalize-space()='Construction Project']//following::div[1]")).getText();
        System.out.println(actual_project_number);
        Assert.assertEquals(actual_project_number,Expected_ProjectNumber,"failed");
        TimeUtil.shortTime();
        String actual_status=driver.findElement(By.xpath("(//span[contains(text(),'Sales')])[3]")).getText();
        System.out.println(actual_status);
        Assert.assertEquals(actual_status,Expected_status,"failed");
        String actual_Type = driver.findElement(By.xpath("//div[normalize-space()='Construction Project']//following::div[3]")).getText();
        System.out.println(actual_Type);
        Assert.assertEquals(actual_Type,Expected_Type,"failed");
        String actual_Clerk = driver.findElement(By.xpath("//div[normalize-space()='Construction Project']//following::div[4]")).getText();
        System.out.println(actual_Clerk );
        Assert.assertEquals(actual_Clerk,Expected_Clerk,"failed");
       /* String actual_out = driver.findElement(By.xpath("//div[contains(text(),'" + Project_Name + "')]")).getText();
        Assert.assertEquals(actual_out, Project_Name);
        TimeUtil.shortTime();*/
    }
    //div[contains(text(),'iTWO Cloud Project')])[2]
    //Customer-Tab
    @FindBy(xpath = "//label[normalize-space()='Business Partner']/following::button[2]")
    WebElement Click_Business_Partner;
    @FindBy(xpath = "//input[@placeholder='Insert search Term']")
    WebElement Search_BP;
    @FindBy(xpath = "//button[@title='search']")
    WebElement Click_Search_Button;
    @FindBy(xpath = "//span[normalize-space()='Approved']")
    WebElement Select_BP_Approved;
    @FindBy(xpath = "//input[@name='prcStructureCheckBox']")
    WebElement Click_Checkbox_Procurement_Struc;
    @FindBy(xpath = "//div[@data-entity='$parent.$parent.prcstructure']//button[2]")
    WebElement Click_Procurement_Structure;
    @FindBy(xpath = "//button[normalize-space()='Refresh']")
    WebElement Refresh_Procurement_Structure;
    @FindBy(xpath = "//input[@name='locationsCheckBox']")
    WebElement Click_Checkbox_Location;
    @FindBy(xpath = "//input[@value='regional']")
    WebElement Click_Regional_RadioButton;
    @FindBy(xpath = "//input[@value='regional']/following::button[2]")
    WebElement Click_Regional_Dropdown;
    @FindBy(xpath = "//li[normalize-space()='Germany']")
    WebElement Select_Regional;
    @FindBy(xpath = "//input[@name='evaluationCheckBox']")
    WebElement Click_Checkbox_Evaluation_Mark;
    @FindBy(xpath = "//label[normalize-space()='Regional']/following::input[1]")
    WebElement Enter_Regional;
    @FindBy(xpath = "//label[normalize-space()='Evaluation Mark']/following::button[2]")
    WebElement Click_dropdown_Evaluation_Mark;
    @FindBy(xpath = "//input[@name='characteristicCheckBox']")
    WebElement Click_Checkbox_WithCharacteristic;
    @FindBy(xpath = "//input[@name='characteristicCheckBox']/following::button[2]")
    WebElement Click_Dropdown_WithCharacteristic;
    @FindBy(xpath = "//label[normalize-space()='Customer Group']/following::button[2]")
    WebElement Click_Customer_Group_Dropdown;
    @FindBy(xpath = "//label[normalize-space()='Contact']/following::button[2]")
    WebElement Click_Contact_Dropdown;

    public void customer_Details(String Business_Partner, String Procurement_Struct, String BP_Name, String Regional, String BP_MatchCode, String Evaluation_Work, String Characteristic, String Customer_Group, String contact) {
        TimeUtil.shortTime();
        clickOnElement(Click_Business_Partner);
        TimeUtil.shortTime();
        if (Search_BP != null) {
            Search_BP.clear();
        }
        setElement(Search_BP, Business_Partner);
        TimeUtil.shortTime();
        clickOnElement(Click_Search_Button);
        TimeUtil.shortTime();
        clickOnElement(Select_BP_Approved);
        TimeUtil.midTime();
        clickOnElement(Click_Ok);
        TimeUtil.shortTime();
        clickOnElement(Click_Business_Partner);
        if (Search_BP != null) {
            Search_BP.clear();
        }
        TimeUtil.shortTime();
        clickOnElement(Click_Checkbox_Procurement_Struc);
        TimeUtil.shortTime();
        clickOnElement(Click_Procurement_Structure);
        TimeUtil.shortTime();
        clickOnElement(Refresh_Procurement_Structure);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + Procurement_Struct + "']")));
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("(//button[@data-ng-disabled='okBtnDisabled()'])[1]")));
        TimeUtil.shortTime();
        clickOnElement(Click_Search_Button);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + BP_Name + "']")));
        TimeUtil.shortTime();
        JSElementClick(Click_Ok);
        TimeUtil.shortTime();
        clickOnElement(Click_Business_Partner);
        if (Search_BP != null) {
            Search_BP.clear();
        }
        clickOnElement(Click_Checkbox_Location);
        TimeUtil.shortTime();
        clickOnElement(Click_Regional_RadioButton);
        TimeUtil.shortTime();
        clickOnElement(Click_Regional_Dropdown);
        TimeUtil.shortTime();
        setElement(Enter_Regional, Regional);
        TimeUtil.midTime();
        clickOnElement(Select_Regional);
        TimeUtil.midTime();
        clickOnElement(Search_Button);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + BP_MatchCode + "']")));
        TimeUtil.shortTime();
        JSElementClick(Click_Ok_Button);
        TimeUtil.shortTime();
        clickOnElement(Click_Business_Partner);
        TimeUtil.shortTime();
        if (Search_BP != null) {
            Search_BP.clear();
            TimeUtil.shortTime();
        }
        clickOnElement(Click_Checkbox_Evaluation_Mark);
        TimeUtil.shortTime();
        clickOnElement(Click_dropdown_Evaluation_Mark);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + Evaluation_Work + "']")));
        TimeUtil.shortTime();
        clickOnElement(Search_Button);
        TimeUtil.shortTime();
        clickOnElement(Select_BP_Approved);
        TimeUtil.shortTime();
        clickOnElement(Click_Ok);
        TimeUtil.shortTime();
        /*clickOnElement(Click_Business_Partner);
        TimeUtil.shortTime();
        if (Search_BP != null) {
            Search_BP.clear();
            clickOnElement(Click_Checkbox_WithCharacteristic);
            TimeUtil.shortTime();
        } else {

            clickOnElement(Click_Checkbox_WithCharacteristic);
            TimeUtil.shortTime();
        }
        clickOnElement(Click_Dropdown_WithCharacteristic);
        TimeUtil.shortTime();
        JSElementClick(driver.findElement(By.xpath("//div[normalize-space()='" +Characteristic+ "']")));
        TimeUtil.shortTime();*/
        clickOnElement(Click_Customer_Group_Dropdown);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + Customer_Group + "']")));
        TimeUtil.shortTime();
        clickOnElement(Click_Contact_Dropdown);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + contact + "']")));
        TimeUtil.midTime();
    }

    @FindBy(xpath = "//label[normalize-space()='Country']/following::button[1]")
    WebElement Clear_CountryField;
    @FindBy(xpath = "//label[normalize-space()='Country']/following::button[2]")
    WebElement Click_Country_Dropdown;
    @FindBy(xpath = "//label[normalize-space()='Country']/following::input[1]")
    WebElement Enter_Country;
    @FindBy(xpath = "//div[normalize-space()='India']")
    WebElement Select_Country;
    @FindBy(xpath = "//label[normalize-space()='Address']/following::button[3]")
    WebElement Click_Address;
    @FindBy(xpath = "//textarea[@data-ng-model='entity.Street']")
    WebElement Street_Address;
    @FindBy(xpath = "//input[@data-ng-model='entity.ZipCode']")
    WebElement Zip;
    @FindBy(xpath = "//input[@data-ng-model='entity.City']")
    WebElement City_Field;
    @FindBy(xpath = "//input[@data-ng-model='entity.County']")
    WebElement County;
    @FindBy(xpath = "(//label[contains(text(),'Country')])[2]/following::input[1]")
    WebElement Country_Input;
    @FindBy(xpath = "//textarea[@data-ng-model='entity.Supplement']")
    WebElement Enter_Address_Supplement;
    @FindBy(xpath = "//button[normalize-space()='Map']")
    WebElement Click_Map;
    @FindBy(xpath = "//button[@title='Pick Location']")
    WebElement Pic_Location;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement CLICK_OK;
    @FindBy(xpath = "//label[normalize-space()='Region']/following::button[1]")
    WebElement Clear_Region;
    @FindBy(xpath = "//label[normalize-space()='Region']/following::button[2]")
    WebElement Click_Region_Dropdown;

    public void address_Details(String Country, String street, String zip, String city_field, String county, String country_2, String Address_Supplement, String regionn) {
        clickOnElement(Clear_CountryField);
        TimeUtil.shortTime();
        clickOnElement(Click_Country_Dropdown);
        TimeUtil.shortTime();
        setElement(Enter_Country, Country);
        TimeUtil.midTime();
        clickOnElement(Select_Country);
        TimeUtil.midTime();
        clickOnElement(Click_Address);
        TimeUtil.shortTime();
        setElement(Street_Address, street);
        TimeUtil.shortTime();
        setElement(Zip, zip);
        TimeUtil.shortTime();
        setElement(City_Field, city_field);
        TimeUtil.shortTime();
        setElement(County, county);
        TimeUtil.shortTime();
        JSElementClear(Country_Input);
        TimeUtil.midTime();
        setElement(Country_Input, country_2);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + country_2 + "']")));
        TimeUtil.shortTime();
        setElement(Enter_Address_Supplement, Address_Supplement);
        TimeUtil.shortTime();
        clickOnElement(Click_Map);
        TimeUtil.midTime();
        JSElementClick(Pic_Location);
        TimeUtil.shortTime();
        JSElementClick(CLICK_OK);
        TimeUtil.midTime();
        clickOnElement(Clear_Region);
        TimeUtil.midTime();
        clickOnElement(Click_Region_Dropdown);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + regionn + "']")));
        TimeUtil.midTime();
    }

    @FindBy(xpath = "//label[normalize-space()='Phone Number']/following::button[3]")
    WebElement Edit_PhoneNumber;
    @FindBy(xpath = "(//label[contains(text(),'Country')])[2]/following::input[1]")
    WebElement Edit_Country;
    @FindBy(xpath = "//input[@data-ng-model='entity.AreaCode']")
    WebElement Area_code;
    @FindBy(xpath = "//input[@data-ng-model='entity.PhoneNumber']")
    WebElement Phone_Number;
    @FindBy(xpath = "//input[@data-ng-model='entity.Extention']")
    WebElement Extention;
    @FindBy(xpath = "//textarea[@data-ng-model='entity.CommentText']")
    WebElement Comment;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement Phone_OK;
    public void add_Phone_Details(String country, String area_code, String phone_number, String exten, String comment) {
        clickOnElement(Edit_PhoneNumber);
        TimeUtil.midTime();
        JSElementClear(Edit_Country);
        TimeUtil.shortTime();
        setElement(Edit_Country, country);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + country + "']")));
        TimeUtil.shortTime();
        setElement(Area_code, area_code);
        TimeUtil.shortTime();
        setElement(Phone_Number, phone_number);
        TimeUtil.shortTime();
        setElement(Extention, exten);
        TimeUtil.shortTime();
        setElement(Comment, comment);
        TimeUtil.shortTime();
        clickOnElement(Phone_OK);
        TimeUtil.midTime();
    }

    /*Add TeleFax No*/
    @FindBy(xpath = "//label[normalize-space()='Fax']/following::button[3]")
    WebElement Telefax;
    @FindBy(xpath = "//input[@data-ng-model='entity.AreaCode']")
    WebElement Area_Code_Tel;
    @FindBy(xpath = "//input[@data-ng-model='entity.PhoneNumber']")
    WebElement Phone_Number_Tel;
    @FindBy(xpath = "//input[@data-ng-model='entity.Extention']")
    WebElement Extention_Tel;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement TeleFax_Ok;
    public void add_TeleFax(String country1, String area_code3, String phone_number3, String extent3, String comment) {

        JSElementClick(Telefax);
        TimeUtil.midTime();
        JSElementClear(Edit_Country);
        TimeUtil.shortTime();
        setElement(Edit_Country, country1);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + country1 + "']")));
        setElement(Area_Code_Tel, area_code3);
        TimeUtil.shortTime();
        setElement(Phone_Number_Tel, phone_number3);
        TimeUtil.shortTime();
        setElement(Extention_Tel, extent3);
        TimeUtil.shortTime();
        setElement(Comment, comment);
        TimeUtil.shortTime();
        clickOnElement(TeleFax_Ok);
        TimeUtil.midTime();
    }

    /*Add Mobile Number*/
    @FindBy(xpath = "//label[normalize-space()='Mobile']/following::button[3]")
    WebElement Click_Mobile;
    @FindBy(xpath = "//input[@data-ng-model='entity.AreaCode']")
    WebElement Area_Code_Mob;
    @FindBy(xpath = "//input[@data-ng-model='entity.PhoneNumber']")
    WebElement Phone_Mob;
    @FindBy(xpath = "//input[@data-ng-model='entity.Extention']")
    WebElement Extention_Mob;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement Mobile_Ok;
    @FindBy(xpath = "//label[normalize-space()='E-Mail']/following::input[1]")
    WebElement Enter_Email;
    public void add_Mobile(String country2, String area_code4, String phone_number4, String extent4, String comment, String Email) {
        JSElementClick(Click_Mobile);
        TimeUtil.shortTime();
        JSElementClear(Edit_Country);
        TimeUtil.shortTime();
        setElement(Edit_Country, country2);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + country2 + "']")));
        TimeUtil.midTime();
        setElement(Area_Code_Mob, area_code4);
        TimeUtil.shortTime();
        setElement(Phone_Mob, phone_number4);
        TimeUtil.shortTime();
        setElement(Extention_Mob, extent4);
        TimeUtil.shortTime();
        JSElementClear(Comment);
        setElement(Comment, comment);
        TimeUtil.shortTime();
        clickOnElement(Mobile_Ok);
        TimeUtil.midTime();
        setElement(Enter_Email, Email);
    }

    /*Contract Details*/
    @FindBy(xpath = "//label[normalize-space()='Contract Type']/following::button[1]")
    WebElement Clear_Contract_Type;
    @FindBy(xpath = "//label[normalize-space()='Contract Type']/following::button[2]")
    WebElement Click_Contract_Dropdown;
    @FindBy(xpath = "//label[normalize-space()='Contract No.']/following::input[1]")
    WebElement Enter_Contract_No;
    @FindBy(xpath = "//label[normalize-space()='Payment Term (PA)']/following::button[2]")
    WebElement Click_Dropdown_PA;
    @FindBy(xpath = "//label[normalize-space()='Payment Term (FI)']/following::button[2]")
    WebElement Click_Dropdown_FI;
    @FindBy(xpath = "//label[normalize-space()='Billing Schema']/following::input[1]")
    WebElement Billing_Schema_Input;
    @FindBy(xpath = "//label[normalize-space()='Billing Schema']/following::button[2]")
    WebElement Click_Dropdown_BillingSchema;
    @FindBy(xpath = "//label[normalize-space()='Cancellation No.']/following::input[1]")
    WebElement Enter_Cancellation_No;
    @FindBy(xpath = "//label[normalize-space()='Cancellation Date']/following::input[1]")
    WebElement Enter_Cancellation_Date;
    @FindBy(xpath = "//label[normalize-space()='Language']/following::button[2]")
    WebElement Click_Language_Dropdown;
    public void add_Contract(String Contract_Type, String contract_no, String PA, String FI, String Billing_Schema, String cancellation_no, String cancellation_date, String remark, String language) {
        TimeUtil.shortTime();
        JSElementClear(Clear_Contract_Type);
        TimeUtil.shortTime();
        clickOnElement(Click_Contract_Dropdown);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + Contract_Type + "']")));
        TimeUtil.midTime();
        if (Enter_Contract_No != null) {
            JSElementClear(Enter_Contract_No);
            TimeUtil.shortTime();
        }
        setElement(Enter_Contract_No, contract_no);
        TimeUtil.shortTime();
        clickOnElement(Click_Dropdown_PA);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + PA + "']")));
        TimeUtil.shortTime();
        clickOnElement(Click_Dropdown_FI);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + FI + "']")));
        TimeUtil.shortTime();
        if (Billing_Schema_Input != null) {
            clickOnElement(driver.findElement(By.xpath("//label[normalize-space()='Billing Schema']/following::button[1]")));
            TimeUtil.shortTime();
        }
        clickOnElement(Click_Dropdown_BillingSchema);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + Billing_Schema + "']")));
        TimeUtil.shortTime();
        setElement(Enter_Cancellation_No, cancellation_no);
        TimeUtil.midTime();
        setElement(Enter_Cancellation_Date, cancellation_date);
        TimeUtil.shortTime();
        setElement(Enter_Remark, remark);
        clickOnElement(Click_Language_Dropdown);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//li[normalize-space()='" + language + "']")));
        TimeUtil.midTime();

    }

 /*   *//*Submission Details*//*
    @FindBy(xpath = "//textarea[@data-ng-model='entity.TenderRemark']")
    WebElement Enter_BidRemark;

    public void add_Submission(String Bid_Remark) {
        List<WebElement> list = driver.findElements(By.xpath("(//div[@class='platform-form-group ng-scope'])[5]//following-sibling::input[@data-entity='entity']"));
        int rowSize = list.size();
        System.out.println(rowSize);
        for (int i = 1; i <= rowSize; i++) {
            String CheckRow = driver.findElement(By.xpath("((//div[@class='platform-form-group ng-scope'])[5]//following-sibling::input[@data-entity='entity']/preceding::label[1])[" + i + "]")).getText();
            System.out.println(CheckRow);
            if (!CheckRow.equalsIgnoreCase("Closing Location")) {
                setCurrentDate(driver.findElement(By.xpath("((//div[@class='platform-form-group ng-scope'])[5]//following-sibling::input[@data-entity='entity'])[" + i + "]")));
            } else {
                setElement(driver.findElement(By.xpath("((//div[@class='platform-form-group ng-scope'])[5]//following-sibling::input[@data-entity='entity'])[" + i + "]")), "Pune");
            }
        }
        TimeUtil.midTime();
        setElement(Enter_BidRemark, Bid_Remark);
    }

    @FindBy(xpath = "//textarea[@data-ng-model='entity.WarrentyRemark']")
    WebElement Enter_Warranty_Remark;

    public void add_Warranty_Details(String Warranty_Remark) {
        List<WebElement> list = driver.findElements(By.xpath("(//div[@class='platform-form-group ng-scope'])[6]//following-sibling::input[@data-entity='entity']"));
        int rowSize = list.size();
        System.out.println(rowSize);
        for (int i = 1; i <= rowSize; i++) {
            setCurrentDate(driver.findElement(By.xpath("((//div[@class='platform-form-group ng-scope'])[6]//following-sibling::input[@data-entity='entity'])[" + i + "]")));
            TimeUtil.shortTime();
        }
        setElement(Enter_Warranty_Remark, Warranty_Remark);
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//button[@title='Unsaved Data']")));
        TimeUtil.midTime();
        clickOnElement(driver.findElement(By.xpath("//h2[@title='Project Details']/following::button[1]")));
    }
*/
    /* Settings */
    @FindBy(xpath = "//label[normalize-space()='Calendar']/following::button[2]")
    WebElement Click_Calendar;
    @FindBy(xpath = "//label[normalize-space()='Calendar']/following::input[1]")
    WebElement Input_Calendar;
    @FindBy(xpath = "//input[@data-ng-model='searchValue']")
    WebElement Search_Calendar;
    @FindBy(xpath = "//input[@value='enterprise']")
    WebElement Select_CalendarType;
    @FindBy(xpath = "//label[normalize-space()='Asset Master']/following::button[2]")
    WebElement Click_AssetMaster;
    @FindBy(xpath = "//button[@title='search']")
    WebElement Search_AssetMaster;
    @FindBy(xpath = "//label[normalize-space()='Content Type']/following::div")
    WebElement Click_ContentType;
    @FindBy(xpath = "//input[@data-ng-model='entity.IsInterCompany']")
    WebElement Click_CheckboxPublish;
    @FindBy(xpath = "//label[normalize-space()='Rubric Category for Locations']/following::div[1]")
    WebElement RubricCategoryLocations;
    @FindBy(xpath = "//label[normalize-space()='Rubric Category for Locations']/following::button[1]")
    WebElement Clear_RubricCategoryLocations;
    @FindBy(xpath = "//label[normalize-space()='Rubric Category for Locations']/following::button[2]")
    WebElement Dropdown_RubricCategoryLocations;
    @FindBy(xpath = "//label[normalize-space()='Cost Group Configuration']/following::input[1]")
    WebElement Enter_CostGroupConfiguration;

    public void settings_Details(String calendar_code, String AssetMaster_Code) {
        if (Input_Calendar != null) {
            clickOnElement(driver.findElement(By.xpath("//label[normalize-space()='Calendar']/following::button[1]")));

        }
        TimeUtil.shortTime();
        clickOnElement(Click_Calendar);
        TimeUtil.shortTime();
        clickOnElement(Select_CalendarType);
        TimeUtil.shortTime();
        if (Search_Calendar != null) {
            Search_Calendar.clear();
        }
        clickOnElement(driver.findElement(By.xpath("//button[@title='search']")));
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + calendar_code + "']")));
        TimeUtil.midTime();
        clickOnElement(Click_Ok);
        TimeUtil.shortTime();
        clickOnElement(Click_AssetMaster);
        TimeUtil.shortTime();
        clickOnElement(Search_AssetMaster);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//div[normalize-space()='" + AssetMaster_Code + "']")));
        TimeUtil.shortTime();
        clickOnElement(Click_Ok);
        if (Click_ContentType != null) {
            clickOnElement(driver.findElement(By.xpath("//label[normalize-space()='Content Type']/following::button[1]")));
            TimeUtil.shortTime();
        }
        clickOnElement(driver.findElement(By.xpath("//label[normalize-space()='Content Type']/following::button[2]")));
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[@data-ng-repeat='item in canvasData']")));
        if (!Click_CheckboxPublish.isSelected()) {
            clickOnElement(driver.findElement(By.xpath("//input[@data-ng-model='entity.IsInterCompany']")));
        }
        if (RubricCategoryLocations != null) {
            clickOnElement(Clear_RubricCategoryLocations);
            TimeUtil.shortTime();
        }
        clickOnElement(Dropdown_RubricCategoryLocations);
        TimeUtil.shortTime();
        clickOnElement(driver.findElement(By.xpath("//li[@data-ng-repeat='item in canvasData']")));
        TimeUtil.shortTime();
        Enter_CostGroupConfiguration.clear();
        setElement(Enter_CostGroupConfiguration, "20006");
        TimeUtil.midTime();
    }




}

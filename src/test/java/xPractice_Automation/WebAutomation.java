//Static Drop down using select class
// Dropdown UI using loop
// Dynamic dropdown where value changes based on selection
// Dynamic dropdown with more than 1 xpath
// enclose xpath in and provide index "(xpath)[2]" or
// add scope of parent xpath space child xpath "ParentXpath ChildXpath"

package xPractice_Automation;

import iTWO_Factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class WebAutomation {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        // WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement Currencylist = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select staticDropDown = new Select(Currencylist);
        staticDropDown.selectByIndex(1);
        staticDropDown.selectByVisibleText("INR");
        staticDropDown.selectByValue("USD");
        System.out.println(staticDropDown.getFirstSelectedOption().getText());
        System.out.println(staticDropDown.getFirstSelectedOption().getTagName());

        WebElement DynamicList = driver.findElement(By.id("divpaxinfo"));
        DynamicList.click();
        Thread.sleep(4000);

        int i=1;
        while(i<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        String count= driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText();
        //Assert.assertTrue
        //Assert.assertFalse
        //Assert.assertEqual

        Assert.assertEquals(count,"5 Adult");

        WebElement Donebutton = driver.findElement(By.id("btnclosepaxoption"));
        Donebutton.click();
        // xpath for chennai (//a[@value="MAA"])[2] - When there are more than 1 instance of same xpath
        // xpath for //a[@value="BLR"]
        //xpath for From dropdow
        //xpath for chennai in form of (Parent xpath child xpth) //div[@id="ctl00_mainContent_ddl_originStation1_CTNR"] //a[@value='MAA']
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@value=\"BLR\"]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();

        //AutoSuggest drop down
        //To capture the xpath for auto suggest first add text and right click on dropdown to inspect element

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(4000);

        //Find all elements with matching criteria using a tag and it
        // returns list of web elements
        List <WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        // Using advanced for loop
        // For all options pick one option at a time and its data type is web element
        for (WebElement op :options)
        {
            if (op.getText().equalsIgnoreCase("India"))
            {
                op.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        boolean output = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
        Assert.assertTrue(output);
        //System.out.println(output);

        //Select all checkbox on page
        //Find common element and create common xpath to select all checkbox
         List <WebElement> Chk= driver.findElements(By.cssSelector("input[type='checkbox']"));
         System.out.println(Chk.size());


         //Find Active highlighted date on calendar control
         driver.findElement(By.cssSelector("input[id*='_rbtnl_Trip_1']")).click();
         //driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
         //If there is space in CSS selector then remove space and add "."
         //driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight ui-state-active']")).click();
            Thread.sleep(5000);

         driver.findElement(By.id("flightSearchContainer")).click();
         driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        // driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight ui-state-active']")).click();
         Thread.sleep(5000);
        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("its enabled");
            Assert.assertTrue(true);
        }
        else
        {

            Assert.assertTrue(false);
        }

         driver.close();

    }



}

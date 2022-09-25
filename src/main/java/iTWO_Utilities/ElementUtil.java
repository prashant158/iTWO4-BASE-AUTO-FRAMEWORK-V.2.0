package iTWO_Utilities;

import iTWO_Factory.DriverFactory;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil extends DriverFactory {

    public static JavascriptExecutor executor;
    public WebDriverWait wait;
    public Actions actions;
    public Action action;
    private WebDriver driver;
    public WebElement element1;

    public WebDriver getDriver() {
        return baseWebDriver;
    }

    public void setDriver(WebDriver d) {
        baseWebDriver = d;
    }

    public void flash(WebElement element) {
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 3; i++) {
            changeColor("rgb(0,200,0)", element);// 1
            changeColor(bgcolor, element);// 2
        }
    }

    private void changeColor(String color, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) baseWebDriver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }

    public void calculate_copyProject_LoadTime() {

    }

    public void clickOnElement(WebElement webElement) {
        flash(webElement);
        baseWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        //drawBorder(webElement);
        WebElement element = new WebDriverWait(baseWebDriver, Duration.ofSeconds(70)).until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
    }

    /*public void clickOnElement(WebElement webElement) {
        do {
            try {
                String element2 = baseWebDriver.findElement(By.xpath("//div[@class='ccsc_modalbg'] [@style = 'display: none;']")).getAttribute("style");
                String style = "display: none;";
                if (element2.equalsIgnoreCase(style)) {
                    flash(webElement);
                    drawBorder(webElement);
                    WebElement element = new WebDriverWait(baseWebDriver, Duration.ofSeconds(700)).until(ExpectedConditions.elementToBeClickable(webElement));
                    element.click();
                    break;
                } else {
                    System.out.println(element1 + ">>>" + "Waiting for Page Load");
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Error is==>>>" + e);
                break;
            } catch (NoSuchElementException ex) {
                System.out.println("Error is==>>>" + ex);
                break;
            }
        } while (true);

    }*/

    public void selectDropdown(WebElement webElement, String value) {
        ngWebDriver.waitForAngularRequestsToFinish();
        flash(webElement);
        //drawBorder(webElement);
        WebElement element = new WebDriverWait(baseWebDriver, Duration.ofSeconds(700)).until(ExpectedConditions.elementToBeClickable(webElement));
        Select dropdown = new Select(element);
        element.click();
        dropdown.selectByVisibleText(value);
    }

    public void selectDropdownByIndex(WebElement webElement, int index) {
        ngWebDriver.waitForAngularRequestsToFinish();
        flash(webElement);
        //drawBorder(webElement);
        WebElement element = new WebDriverWait(baseWebDriver, Duration.ofSeconds(700)).until(ExpectedConditions.elementToBeClickable(webElement));
        Select dropdown = new Select(element);
        element.click();
        dropdown.selectByIndex(index);
    }

    //public void uiDropdown(List<WebElement> , String text) {

   // }

    public WebElement setElement(WebElement webElement, String text) {
        ngWebDriver.waitForAngularRequestsToFinish();
        flash(webElement);
        //drawBorder(webElement);
        JSElementClear(webElement);
        WebElement element = new WebDriverWait(baseWebDriver, Duration.ofSeconds(100)).until(ExpectedConditions.elementToBeClickable(webElement));
        element.sendKeys(text);
        return element;
    }

    /*public void acceptAlert() {
        Alert alert = this.driver.switchTo().alert();
        alert.accept();
    }

    public void declineAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }*/

    public WebElement Setduplicate(WebElement webElement, String text) {
        ngWebDriver.waitForAngularRequestsToFinish();
        flash(webElement);
        WebElement element = new WebDriverWait(baseWebDriver, Duration.ofSeconds(100)).until(ExpectedConditions.elementToBeClickable(webElement));
        WebElement Duplicate = driver.findElement(By.xpath("//h2[contains(text(),'Duplicate')]"));
        if (Duplicate != null) {
            clickOnElement(driver.findElement(By.xpath("//button[normalize-space()='Ignore']")));
            element.sendKeys("condition");
        }

        element.sendKeys(text);
        return element;
    }

    public String waitForTitleIs(String expTitle, int timeOut) {
        if (new WebDriverWait(baseWebDriver, Duration.ofSeconds(100)).until(ExpectedConditions.titleIs(expTitle)))
            return baseWebDriver.getTitle();
        return null;
    }

    public void vefiyElementPresent(WebElement webElement) {
        try {
            if (webElement != null) {
                System.out.println("Element is present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WaitForPageLoad() {
        ngWebDriver.waitForAngularRequestsToFinish();
        baseWebDriver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
    }

    public String getText(WebElement webElement) {
        flash(webElement);
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(webElement));
        String value = element.getText();
        return value;
    }


    public static void JSElementClick(WebElement element) {
        executor = (JavascriptExecutor) baseWebDriver;
        executor.executeScript("arguments[0].click();", element);
    }


    public static String JSGetText(WebElement element) {
        //  String text = (String) executor.executeScript("return arguments[0].value", element);
        String text = (String) ((JavascriptExecutor) baseWebDriver).executeScript("return arguments[0].innerHTML;", element);
        return text;
    }

    public void elementActions(WebElement element) {
        actions = new Actions(baseWebDriver);
        flash(element);
        action = actions.moveToElement(element).build();
        action.perform();
    }

    public void elementTabs(Integer no_of_times) {
        actions = new Actions(baseWebDriver);
        TimeUtil.veryShortTime();
        for (int i = 1; i<= no_of_times; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

    }

    public void elementEnter() {
        actions = new Actions(baseWebDriver);
        TimeUtil.veryShortTime();
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void elementTyping(String text) {
        actions = new Actions(baseWebDriver);
        TimeUtil.veryShortTime();
        actions.sendKeys(text).perform();
    }

    public void elementActionsClick(WebElement element) {
        actions = new Actions(baseWebDriver);
        flash(element);
        action = actions.moveToElement(element).click().build();
        action.perform();
    }

    public void elementActionMoveFrom_TO(WebElement element, WebElement element2) {
        Actions builder = new Actions(baseWebDriver);
        Actions dragAndDrop = builder.clickAndHold(element);
        dragAndDrop.moveToElement(element2);
        dragAndDrop.release(element2);
        dragAndDrop.build().perform();
    }

    public static void moveElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }


    public static WebDriver SwitchToPopUp() throws Exception {
        Set<String> windows = baseWebDriver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String ModalWindow = iterator.next();
        baseWebDriver.switchTo().window(ModalWindow);
        return baseWebDriver;
    }

    public static void JSElementClear(WebElement element) {
        executor = (JavascriptExecutor) baseWebDriver;
        executor.executeScript("arguments[0].value = '';", element);
    }

    public static WebDriver SwitchToBack() {
        baseWebDriver.switchTo().defaultContent();
        return baseWebDriver;
    }

    public static void setClipboardData(String string) {
        //StringSelection is a class that can be used for copy and paste operations.
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public String sampleAttachment() {

        String filePathAttachment3 = System.getProperty("user.dir")+"\\src\\test\\resources\\Attachments\\UploadFile.exe";
        return filePathAttachment3;
    }


    public static void uploadFile(String fileLocation) {
        try {
            //Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static void Shift_Down() {
        try {
            Robot Key_event = new Robot();
            Key_event.keyPress(KeyEvent.VK_SHIFT);
            Key_event.keyPress(KeyEvent.VK_DOWN);
            Key_event.keyPress(KeyEvent.VK_DOWN);
            Key_event.keyPress(KeyEvent.VK_DOWN);
            Key_event.keyRelease(KeyEvent.VK_SHIFT);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static void Tab() {
        try {
            Robot Key_Event = new Robot();
            Key_Event.keyPress(KeyEvent.VK_TAB);
            Key_Event.keyRelease(KeyEvent.VK_TAB);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchTabs(WebDriver driver) {
        String mainWindow = driver.getWindowHandle();
        TimeUtil.midTime();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                driver.manage().getCookies();
            }
            /* driver.switchTo().window(mainWindow);*/
        }
    }

    public void JSScroll_Horizontal(WebElement element) {
        Actions act = new Actions(baseWebDriver);
        act.moveToElement(element).click().build().perform();
        JavascriptExecutor jse = (JavascriptExecutor) baseWebDriver;
        jse.executeScript("scroll(620, 620)");

    }


    public static WebDriver SwitchToWindow() throws Exception {
        Set<String> windows = baseWebDriver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String ModalWindow = iterator.next();
        baseWebDriver.switchTo().window(ModalWindow).getTitle();
        return baseWebDriver;
    }

    public static void Enter() {
        try {
            Robot Key_Event = new Robot();
            Key_Event.keyPress(KeyEvent.VK_ENTER);
            Key_Event.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollPageDown() {
        JavascriptExecutor js = (JavascriptExecutor) baseWebDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollPageDown(String height) {
        JavascriptExecutor js = (JavascriptExecutor) baseWebDriver;
        js.executeScript("window.scrollTo(0, '" + height + "')");
    }

    public static void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) baseWebDriver;
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) baseWebDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void drawBorder(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) baseWebDriver;
        js.executeScript("arguments[0].style.border='2px solid red'", element);
    }

    public String randomNumber(int bound) {
        Random random = new Random();
        int randomNumber = random.nextInt(bound);
        String StrRN = Integer.toString(randomNumber);
        return StrRN;
    }



}

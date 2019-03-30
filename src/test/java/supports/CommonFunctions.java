package supports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {
    private static WebDriver driver; //always private. Create getDriver to get
    private  static WebDriverWait wait;
    private static final long TIMEOUT_IN_SECOND = 60; //second


    public static WebDriver getDriver(){
        return driver;
    }
    public static void click(How how, String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(how.buildBy(locator)));
        getElement(how, locator).click();
    }

    public static void click (By locator){
        wait.until((ExpectedConditions.elementToBeClickable(locator))).click();
    }

    public static void fill(How how, String locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        getElement(how, locator).clear();
        getElement(how, locator).sendKeys(text);
    }

    public static void fill(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public static void visit(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void navigate(String url) {
        driver.navigate().to(url);
    }
    public static void back(){
        driver.navigate().back();
    }

    /**
     * This method use to get an element
     * @param how: String (name|id|css|xpath)
     * @param locator: (String)
     * @return: Webelement
     */
    public static WebElement getElement(How how, String locator) {
        return driver.findElement(how.buildBy(locator));
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> getElements(How how, String locator) {
        return driver.findElements(how.buildBy(locator));
    }

    public static void setupBrowser(Browsers browser) {
        switch (browser){
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case SAFARI:
                System.out.println("There is no safari browser on this machine");
                break;
            case FIREFOX_HEADLESS:
                WebDriverManager.firefoxdriver().setup();

                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);

                driver = new FirefoxDriver(firefoxOptions);
                break;
            case CHROME_HEADLESS:
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECOND);
    }
    public static String getText(How how, String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        return getElement(how, locator).getText();
    }
    public static String getText(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getElement(locator).getText();
    }

    //get screenshot
    public static void captureScreenshot (String name){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File image = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(image,new File("./" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isChecked(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getElement(locator).isSelected();
    }



    public static boolean isDisplayed(How how, String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        return getElement(how,locator).isDisplayed();
    }

    public static boolean isEnabled(How how, String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        return getElement(how,locator).isEnabled();
    }

    public static void select(How how, String locator,String selectValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
        Select dropdown = new Select(getElement(how, locator));
        dropdown.selectByVisibleText(selectValue);
    }

   /* public static void check(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (isChecked(locator)) {
            click(locator);
        }
    }*/

    public static void check(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (isChecked(locator)) {
            click(locator);
        }
    }

    public static void quit(){
        if (driver != null){
            driver.quit();
          //  driver.close(); //what is different between quit and close
        }
    }
    public static void waitForElementPresent(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

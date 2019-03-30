package support;

//import browsers.BrowsersMethodsTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CommonFunctions {
    private static WebDriver driver;


    public static void click(How how, String locator) {
        getElement(how, locator).click();
    }

    public static void fill(How how, String locator, String text) {

        getElement(how, locator).sendKeys(text);
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static void navigate(String url) {
        driver.navigate().to(url);
    }
    public static void back(){
        driver.navigate().back();
    }


    public static WebElement getElement(How how, String locator) {
        return driver.findElement(how.buildBy(locator));
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
    }


}

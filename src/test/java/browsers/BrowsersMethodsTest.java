package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class BrowsersMethodsTest {

    private static WebDriver driver;
    private enum Browsers {FIREFOX, CHROME, EDGE, IE, SAFARI,FIREFOX_HEADLESS,CHROME_HEADLESS}

    public static void main(String[] args) {
        setupBrowser(Browsers.IE);
        visit("https://the-internet.herokuapp.com/login");
        fill(How.ID,"username","tomsmith");
        fill(How.ID,"password","SuperSecretPassword!");
        click(How.TAG_NAME,"button");

    }

    private static void click(How how, String locator) {
        getElement(how, locator).click();
    }

    private static void fill(How how, String locator, String text) {

        getElement(how, locator).sendKeys(text);
    }

    private static void visit(String url) {
        driver.get(url);
    }

    private static WebElement getElement(How how, String locator) {
        return driver.findElement(how.buildBy(locator));
    }

    private static void setupBrowser(Browsers browser) {
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

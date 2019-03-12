package browsers;

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

public class BrowsersMethodsTest {

    public static WebDriver driver;

    public static void main(String[] args) {
        setupBrowser("firefox");
        visit("https://the-internet.herokuapp.com/login");
        fill(getElement("id","username"),"tomsmith");
        fill(getElement("id","password"),"SuperSecretPassword!");
        click(getElement("tagname","button"));
    }

    public static void click(WebElement element) {
        element.click();
    }

    public static void fill(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static WebElement getElement(String how, String locator) {
        WebElement element = null;
        if (how.equalsIgnoreCase("name")) {
            element = driver.findElement(By.name(locator));
        } else if (how.equalsIgnoreCase("id")) {
            element = driver.findElement(By.id(locator));
        } else if (how.equalsIgnoreCase("xpath")) {
            element = driver.findElement(By.xpath(locator));
        } else if (how.equalsIgnoreCase("css")) {
            element = driver.findElement(By.cssSelector(locator));
        } else if (how.equalsIgnoreCase("tagname")) {
            element = driver.findElement(By.tagName(locator));
        } else {
            System.err.println("Your input is invalid.");
        }
        return element;
    }

    /**
     * @param browser: firefox|chrome|edge|ie|safari|firefoxHeadless|chromeHeadless
     */
    private static void setupBrowser(String browser) {
        if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if ("safari".equalsIgnoreCase(browser)) {
            System.out.println("There is no safari browser on this machine");
        } else if ("firefoxHeadless".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();

            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);

            driver = new FirefoxDriver(firefoxOptions);
        } else if ("chromeHeadless".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            System.out.println("Sorry, your browser is not supported!");
        }
    }
}

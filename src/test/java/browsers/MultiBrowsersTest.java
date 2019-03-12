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


public class MultiBrowsersTest {


    public static WebDriver driver;

    public static void main(String[] args) {
        String[] browserName = {"firefox", "chrome", "edge", "ie"};

        openBrowser("firefox");

        /*for (String i : browserName) {
            openBrowser(i);
        }*/


    }

    private static void openBrowser(String browser){
        // improvement: upper case or lower case or enum for browser
       // WebDriver driver;
        if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("http://google.com");
            System.out.println("Opened Firefox browser!");
        } else if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("http://google.com");
            System.out.println("Opened Chrome browser!");
        } else if ("edge".equals(browser)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get("http://google.com");
            System.out.println("Opened Edge browser!");
        } else if ("ie".equals(browser)) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.get("http://google.com");
            System.out.println("Opened IE browser!");
        }else if ("safari".equals(browser)) {
            System.out.println("There is no safari browser on this machine");
        }else if ("firefoxHeadless".equals(browser)){
            WebDriverManager.firefoxdriver().setup();

            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);

            driver = new FirefoxDriver(firefoxOptions);
            driver.get("http://google.com");
            System.out.println("Opened firefox headless");
        }else if ("chromeHeadless".equals(browser)){
            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver =  new ChromeDriver(chromeOptions);
            driver.get("http://google.com");
            System.out.println("Opened chrome headless");
        }else {
            System.out.println("Sorry, your browser is not supported!");
        }
    }




}

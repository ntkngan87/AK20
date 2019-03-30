package modules.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxTest {
    public static void main(String[] args) {
        //System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
      /*  WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
       driver.get("http://google.com");*/

        WebDriverManager.firefoxdriver().setup();

        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);

        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("http://google.com");
        System.out.println("Successfully");


    }
}

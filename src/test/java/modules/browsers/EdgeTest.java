package modules.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTest {
    public static void main(String[] args) {
       // System.setProperty("webdriver.edge.driver", "Drivers/MicrosoftWebDriver.exe");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("hello");
    }

}

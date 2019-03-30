package modules.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IETest {
    public static void main(String[] args) {
        //System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("hello");

    }
}

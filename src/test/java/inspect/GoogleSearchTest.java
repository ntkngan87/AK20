package inspect;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("–lang= en-ca"); //en-ca
        ChromeDriver driver = new ChromeDriver(options);*/

        driver.get("https://google.com"); //        driver.navigate().to("https://google.com");
        Thread.sleep(10000);

       //driver.findElement(By.name("q")).sendKeys("hello\n");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello\n");

        //driver.findElement(By.xpath(("//input[@title='Tìm kiếm']"))).sendKeys("hello\n");
       //driver.findElement(By.xpath(("//input[@aria-label='Tìm kiếm']"))).sendKeys("hello\n");

        //driver.findElement(By.cssSelector(("input[title='Tìm kiếm']"))).sendKeys("hello\n");
       // driver.findElement(By.cssSelector(("input[aria-label='Tìm kiếm']"))).sendKeys("hello\n");

    }
}

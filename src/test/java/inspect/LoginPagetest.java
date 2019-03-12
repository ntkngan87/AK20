package inspect;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPagetest {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

       // driver.findElement(By.tagName("input")).sendKeys("tomsmith\n");
        //  driver.findElement(By.id("username")).sendKeys("tomsmith\n");
        driver.findElement(By.name("username")).sendKeys("tomsmith");

       // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith\n");
        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith\n");
        //driver.findElement(By.xpath("//input")).sendKeys("tomsmith\n");

        //driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("tomsmith\n"); //new way
        //driver.findElement(By.xpath("//*[contains(@name,'username')]")).sendKeys("tomsmith\n"); //new way

        //driver.findElement(By.cssSelector("input")).sendKeys("tomsmith\n");
        //  driver.findElement(By.cssSelector("input[id='username']")).sendKeys("tomsmith\n");
        //  driver.findElement(By.cssSelector("input[id='username']")).sendKeys("tomsmith\n");
         //driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith\n"); // new way


        //driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
       // driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
       // driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.tagName("button")).submit();

    }
}

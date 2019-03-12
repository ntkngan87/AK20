package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CocCocTest {
    public static void main(String[] args) {
        openCocCoc();
    }
    private static void openCocCoc(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\ntkngan\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://google.com");
        System.out.println("Opened Coc Coc browser.");
    }
}

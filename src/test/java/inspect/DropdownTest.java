package inspect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import support.Browsers;

import static support.CommonFunctions.*;

public class DropdownTest {
    public static void main(String[] args) throws InterruptedException {
        setupBrowser(Browsers.CHROME);
        navigate("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElement = getElement(How.ID,"dropdown");

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        //dropdown.selectByVisibleText("Option 2");
        dropdown.selectByIndex(2);



    }
}

package inspect;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import support.Browsers;
import static support.CommonFunctions.*;

import static support.CommonFunctions.navigate;
import static support.CommonFunctions.setupBrowser;

public class CheckboxTest {
    public static void main(String[] args) {
        setupBrowser(Browsers.CHROME);
        navigate("https://the-internet.herokuapp.com/checkboxes");

       // WebElement checkboxElement = getElement(How.ID,"checkboxes");

        WebElement checkbox1 = getElement(How.XPATH,"//form[@id='checkboxes']//input[1]");
        WebElement checkbox2 = getElement(How.XPATH,"//form[@id='checkboxes']//input[2]");

        select(checkbox1);
        select(checkbox2);

    }

    public static void select (WebElement e){
        if (!e.isSelected())
            e.click();
    }
    public static void unselect (WebElement e){
        if (e.isSelected())
            e.click();
    }
}

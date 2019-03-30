package modules.inspect;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import supports.Browsers;

import java.util.List;

import static supports.CommonFunctions.*;

public class PersonDue50Test {
    public static void main(String[] args) {
        setupBrowser(Browsers.FIREFOX);
        navigate("https://the-internet.herokuapp.com/tables");

        List<WebElement> rows = getElements(How.XPATH,"//table[@id='table1']//tbody/tr");
        List<WebElement> columns = getElements(How.XPATH, "//table[@id='table1']//thead/tr/th");

        System.out.println(rows.size() + "  " + columns.size());

       for (int i = 1; i <= rows.size(); i++){
           String due = getElement(How.XPATH,
                   String.format("//table[@id='table1']/tbody/tr[%d]/td[4]",i)).getText();
           if (due.equals("$50.00"))
               System.out.println("Last name of person who has Due = $50: " +
                       String.format(getElement(How.XPATH,String.format("//table[@id='table1']/tbody/tr[%d]/td[1]",i)).getText()));
        }

    }
}

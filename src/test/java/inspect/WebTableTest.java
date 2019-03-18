package inspect;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import support.Browsers;

import java.util.List;

import static support.CommonFunctions.*;

public class WebTableTest {
    public static void main(String[] args) {
        setupBrowser(Browsers.FIREFOX);
        navigate("https://the-internet.herokuapp.com/tables");

        List<WebElement> rows = getElements(How.XPATH,"//table[@id='table1']/tbody/tr");
        List<WebElement> columns = getElements(How.XPATH,"//table[@id='table1']/thead/tr/th");

        System.out.println(rows.size());
        System.out.println(columns.size());

        for (int i = 1; i <= rows.size(); i++){
            for (int j = 1; j <= columns.size(); j++){
                String value = getElement(How.XPATH,
                        String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]",i,j)).getText();
                System.out.println(value);

            }
        }

    }
}

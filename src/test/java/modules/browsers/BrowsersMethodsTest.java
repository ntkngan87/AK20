package modules.browsers;

import org.openqa.selenium.support.How;
import supports.Browsers;

import static supports.CommonFunctions.*;


public class BrowsersMethodsTest {



    public static void main(String[] args) {
        setupBrowser(Browsers.IE);
        visit("https://the-internet.herokuapp.com/login");
        fill(How.ID,"username","tomsmith");
        fill(How.ID,"password","SuperSecretPassword!");
        click(How.TAG_NAME,"button");

    }




}

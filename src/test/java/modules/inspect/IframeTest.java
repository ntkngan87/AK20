package modules.inspect;
import org.openqa.selenium.support.How;
import supports.Browsers;

import static supports.CommonFunctions.*;

public class IframeTest {
    public static void main(String[] args) {
        setupBrowser(Browsers.CHROME);
        visit("https://the-internet.herokuapp.com/iframe");
        //getDriver().switchTo().frame("mce_0_ifr"); //switch to frame id
        //getDriver().switchTo().frame(0);
        getDriver().switchTo().frame(getElement(How.TAG_NAME,"iframe"));
        getElement(How.XPATH,"//p[text()='Your content goes here.']").clear(); //or "html/body/p"
    }
}

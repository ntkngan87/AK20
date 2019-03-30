package modules.inspect;

import org.openqa.selenium.support.How;
import supports.Browsers;

import static supports.CommonFunctions.*;

public class NestframeTest {
    public static void main(String[] args) {
        setupBrowser(Browsers.CHROME);
        visit("https://the-internet.herokuapp.com/nested_frames");
        getDriver().switchTo().frame("frame-top"); //switch to frame id
        getDriver().switchTo().frame("frame-left");
        System.out.println(getText(How.XPATH,"//html/body"));
    }
}

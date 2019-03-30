package modules.inspect;
import org.openqa.selenium.support.How;
import supports.Browsers;

import static supports.CommonFunctions.*;

public class RedirectLinkTest {
    public static void main(String[] args) throws InterruptedException {
        setupBrowser(Browsers.FIREFOX);
        navigate("https://the-internet.herokuapp.com/redirector");
        //click(How.XPATH,"//a[@href,'redirect']");
        click(How.XPATH,"//a[text()='here']");
        click(How.XPATH,"//a[contains(text(),'200')]");
       // click(How.XPATH,"//a[@href='status_codes/200']");
        Thread.sleep(1000);
        back();

        click(How.XPATH,"//a[@href='status_codes/301']");
        Thread.sleep(1000);
        back();

        click(How.XPATH,"//a[@href='status_codes/404']");
        Thread.sleep(1000);
        back();

        click(How.XPATH,"//a[@href='status_codes/500']");
        Thread.sleep(1000);
        back();
    }


}

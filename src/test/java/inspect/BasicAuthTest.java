package inspect;

import support.Browsers;

import static support.CommonFunctions.setupBrowser;
import static support.CommonFunctions.visit;

public class BasicAuthTest {
    public static void main(String[] args) {
        setupBrowser(Browsers.CHROME);
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth"); //username:pass@weblink
        //visit("https://admin1:admin@the-internet.herokuapp.com/basic_auth");
    }
}

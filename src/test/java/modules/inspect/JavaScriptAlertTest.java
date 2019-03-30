package modules.inspect;

import supports.Browsers;

import static supports.CommonFunctions.*;

public class JavaScriptAlertTest {
    public static void main(String[] args) {
        setupBrowser(Browsers.CHROME);
        visit("https://the-internet.herokuapp.com/javascript_alerts");

        /*click(How.XPATH,"//button[.='Click for JS Alert']");
        getDriver().switchTo().alert().accept();*/

        /*click(How.XPATH,"//button[.='Click for JS Confirm']");
        //getDriver().switchTo().alert().accept();
        getDriver().switchTo().alert().dismiss();*/
/*
        click(How.XPATH,"//button[.='Click for JS Prompt']");
        getDriver().switchTo().alert().sendKeys("hello Ngan");
        getDriver().switchTo().alert().accept();*/
        captureScreenshot("mon");


    }
}

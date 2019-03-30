package modules.inspect;

import libraries.BmiFunctions;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browsers;
import supports.CommonFunctions;

import static supports.CommonFunctions.*;

public class BMITest {

    @BeforeMethod
    public void setUp(){
        setupBrowser(Browsers.CHROME);

    }
    @Test
    public void TestCase1() {
        BmiFunctions bmiPage = new BmiFunctions();
        bmiPage.load();
        bmiPage.isLoaded();
        bmiPage.clickMetricTab();
        bmiPage.fillBmiForm("32","female","158","100");
        bmiPage.getBimResult();
        Assert.assertEquals(bmiPage.getBimResult(),"BMI = 40.1 kg/m2");
    }

    @AfterMethod
    public void tearDown(){
        CommonFunctions.quit();
    }


}

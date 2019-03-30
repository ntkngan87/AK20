package libraries;

import objects.BmiObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import supports.CommonFunctions;
import supports.CommonFunctions.*;

import static supports.CommonFunctions.*;


public class BmiFunctions extends BmiObject {


   public BmiFunctions(){
        PageFactory.initElements(CommonFunctions.getDriver(),this);
    }


    public void load()    {
        CommonFunctions.visit("https://www.calculator.net/bmi-calculator.html");

    }


    public void isLoaded(){
        CommonFunctions.waitForElementPresent(By.xpath("//a[.='Metric Units']"));
    }

    public void clickMetricTab(){

        click(METRIC_TAB);
       // METRIC_TAB.click();;
    }
    public void fillBmiForm(String age, String gender, String height, String weight){
        fill(AGE_TEXT,age);
        if (gender.equalsIgnoreCase("female"))
            click(MALE_RAD);
        fill(HEIGHT_TXT,height);
        fill(WEIGHT_TXT,weight);

        click(CALCULATE_BTN);
        /*AGE_TEXT.sendKeys(age);
        if (gender.equalsIgnoreCase("female"))
            MALE_RAD.click();
        HEIGHT_TXT.sendKeys(height);
        WEIGHT_TXT.sendKeys(weight);*/

    }
    public String getBimResult(){
        String result = getText(BMI_RESULT_LBL);
        System.out.println(result);
        return result;
        //return BMI_RESULT_LBL.getText();
    }

}

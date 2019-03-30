package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * coding convention
 * variable naming
 * TXT --> TEXT BOX
 * TAB --> TAB
 * BTN --> BUTTON
 * LBL --> LABEL
 * RAD --> RADIO BUTTON
 * ...
 * function naming
 * parameter naming
 * class naming
 */
public class BmiObject {

   /* @FindBy(xpath = "//a[.='Metric Units']")
    protected WebElement METRIC_TAB;
    // --> return driver.findElement(By.xpath(xxx))

    @FindBy(xpath = "//input[@id='cage']")
    protected WebElement AGE_TEXT;

    @FindBy(xpath = "//label[@for='csex2']")
    protected WebElement MALE_RAD;

    @FindBy(xpath = "//input[@id='cheightmeter']")
    protected WebElement HEIGHT_TXT;

    @FindBy(xpath = "//input[@id='ckg']")
    protected WebElement WEIGHT_TXT;

    @FindBy(xpath = "//input[@value='Calculate']")
    protected WebElement CALCULATE_BTN;

    @FindBy(xpath = "//div/div/b")
    protected WebElement BMI_RESULT_LBL;*/

    protected final By METRIC_TAB = By.xpath("//a[.='Metric Units']");
    protected final By AGE_TEXT = By.xpath("//input[@id='cage']");
    protected final By MALE_RAD = By.xpath("//label[@for='csex2']");
    protected final By HEIGHT_TXT = By.xpath("//input[@id='cheightmeter']");
    protected final By WEIGHT_TXT = By.xpath("//input[@id='ckg']");
    protected final By CALCULATE_BTN = By.xpath("//input[@value='Calculate']");
    protected final By BMI_RESULT_LBL = By.xpath("//div/div/b");
}

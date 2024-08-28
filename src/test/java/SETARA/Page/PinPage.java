package SETARA.Page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PinPage {
    AndroidDriver driver;
    WebDriverWait wait;

    //By pinField = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.synrgyseveneight.bcarevamp:id/pinEditText\"]");
    By pin1 = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.synrgyseveneight.bcarevamp:id/btn1\"]");

    By pin2 = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.synrgyseveneight.bcarevamp:id/btn2\"]");
    By pin0 = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.synrgyseveneight.bcarevamp:id/btn0\"]");
    By pin9 = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.synrgyseveneight.bcarevamp:id/btn9\"]");
    By pin5 = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.synrgyseveneight.bcarevamp:id/btn5\"]");
    By ButtonSubmit = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.synrgyseveneight.bcarevamp:id/submitButton\"]");


    public PinPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //public void inputPin(String pin) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(pinField)).sendKeys(pin);

   // }
   public void click1() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(pin1)).click();
   }
    public void click2() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pin2)).click();
    }
    public void click0() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pin0)).click();
    }
    public void click9() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pin9)).click();
    }
    public void click5() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pin5)).click();
    }
    public void clicksubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonSubmit)).click();
    }

}

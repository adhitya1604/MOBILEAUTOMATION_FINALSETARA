package SETARA.Page;



import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    AndroidDriver driver;
    WebDriverWait wait;

    By usernameField = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.synrgyseveneight.bcarevamp:id/inputIdField\"]");
    By passwordField = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.synrgyseveneight.bcarevamp:id/inputPasswordField\"]");
    By ButtonSaldo = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tombol tampilkan saldo\"]");
    By loginButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.synrgyseveneight.bcarevamp:id/buttonLogin\"]");
    By errorText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/errorIdInput\"]");
    By errorText2 = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/errorPwInput\"]");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void inputUser(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);

    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);

    }

    public void clicksaldoButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonSaldo)).click();
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }

    public String getTextError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorText)).getText();
    }
    public String getTextError2() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorText2)).getText();
    }

    public String getUsernameFieldContentDescription() {
        return driver.findElement(usernameField).getAttribute("Masukkan user id anda");
    }

    public String getPasswordFieldContentDescription() {
        return driver.findElement(passwordField).getAttribute("Masukkan Password anda");
    }

    public String getLoginButtonContentDescription() {
        return driver.findElement(loginButton).getAttribute("LOGIN");
    }
}

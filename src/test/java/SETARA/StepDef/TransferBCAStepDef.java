package SETARA.StepDef;

import SETARA.Page.HomePage;
import SETARA.Page.LoginPage;
import SETARA.Page.TransferPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TransferBCAStepDef {

        private WebDriver driver;
        private LoginPage loginPage;
        private HomePage homePage;
   

    @Given("user logs in with {string} and {string}")
    public void userLogsInWithAnd(String username, String password) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "ukgyeyt8xkzpfmf6");
        capabilities.setCapability("app", "E:/Download/app-debug.apk");
        capabilities.setCapability("appPackage", "com.synrgyseveneight.bcarevamp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.synrgyseveneight.bcarevamp.MainActivity");

        driver = new AndroidDriver(capabilities);

        loginPage.inputUser(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("user sees the dashboard and checks saldo")
    public void userSeesTheDashboardAndChecksSaldo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement Saldo = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tombol tampilkan saldo\"]")));
        Saldo.click();
        WebElement norek = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/accountNumber\"]")));
        norek.click();
        WebElement saldoElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.synrgyseveneight.bcarevamp:id/saldoAmount']"));
        Assert.assertNotNull(saldoElement, "Elemen saldo tidak ditemukan");
        String saldo = saldoElement.getText();
        Assert.assertFalse(saldo.isEmpty(), "Saldo tidak ditemukan atau kosong");
    }
}

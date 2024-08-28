package SETARA.StepDef;

import SETARA.Page.HomePage;
import SETARA.Page.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginV2StepDef {
    protected static AndroidDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("user sudah pernah login dan user dihalaman login")
    public void userSudahPernahLoginDanUserDihalamanLogin() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "ukgyeyt8xkzpfmf6");
        capabilities.setCapability("app", "E:/Download/app-debug.apk");
        capabilities.setCapability("appPackage", "com.synrgyseveneight.bcarevamp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.synrgyseveneight.bcarevamp.MainActivity");

        driver = new AndroidDriver(capabilities);

        String validUsername = "ADTP604T";
        String validPassword = "andika12345";


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.synrgyseveneight.bcarevamp:id/inputIdField']")));
        usernameField.sendKeys(validUsername);
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.synrgyseveneight.bcarevamp:id/inputPasswordField']")));
        passwordField.sendKeys(validPassword);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"tombol untuk login\"]")));
        loginButton.click();
        WebElement LogoutButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tombol keluar\"]")));
        LogoutButton.click();
        WebElement LogoutValidButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.synrgyseveneight.bcarevamp:id/btnLogout\"]")));
        LogoutValidButton.click();

    }

    @When("the user enters a valid password and clicks the {string} button")
    public void theUserEntersAValidPasswordAndClicksTheButton(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String validPassword = "andika12345";
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.synrgyseveneight.bcarevamp:id/inputPasswordField']")));
        passwordField.sendKeys(validPassword);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"tombol untuk login\"]")));
        loginButton.click();
    }

    @Then("the user should see the dashboard with the text {string}")
    public void theUserShouldSeeTheDashboardWithTheText(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased wait time

        try {
            // Wait for the dashboard text element to be visible
            WebElement dashboardTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.TextView[@resource-id='com.synrgyseveneight.bcarevamp:id/greetings']")));

            // Verify the dashboard text
            String actualDashboardText = dashboardTextElement.getText();
            String expectedDashboardText = "Halo, Andhika Putra!";
            Assert.assertEquals(actualDashboardText, expectedDashboardText, "Teks dasbor tidak sesuai");

            // Verify that the icon is present
            WebElement iconElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.ImageView[@content-desc='Logo Aplikasi Setara']")));
            Assert.assertNotNull(iconElement, "Ikon tidak ditemukan");

        } catch (Exception e) {
            // Handle exception and print the stack trace
            e.printStackTrace();
            Assert.fail("Elemen tidak ditemukan atau terjadi kesalahan: " + e.getMessage());
        }
    }

    @When("the user enters an invalid password and clicks the {string} button")
    public void theUserEntersAnInvalidPasswordAndClicksTheButton(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String validPassword = "andika123456";
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.synrgyseveneight.bcarevamp:id/inputPasswordField']")));
        passwordField.sendKeys(validPassword);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"tombol untuk login\"]")));
        loginButton.click();
    }
}

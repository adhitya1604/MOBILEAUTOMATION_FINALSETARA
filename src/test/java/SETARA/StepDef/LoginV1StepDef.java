package SETARA.StepDef;

import SETARA.Page.HomePage;
import SETARA.Page.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginV1StepDef {
    protected static AndroidDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "ukgyeyt8xkzpfmf6");
        capabilities.setCapability("app", "E:/Download/app-debug.apk");
        capabilities.setCapability("appPackage", "com.synrgyseveneight.bcarevamp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.synrgyseveneight.bcarevamp.MainActivity");

        driver = new AndroidDriver(capabilities);
    }

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        String validUsername = "ADTP604T";
        String validPassword = "andika12345";


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.synrgyseveneight.bcarevamp:id/inputIdField']")));
        usernameField.sendKeys(validUsername);


        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.synrgyseveneight.bcarevamp:id/inputPasswordField']")));
        passwordField.sendKeys(validPassword);
    }
    @When("the user enters a valid username and an invalid password")
    public void theUserEntersAValidUsernameAndAnInvalidPassword() {
        String validUsername = "ADTP604T";
        String invalidPassword = "andika1234578";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Wait for the username field to be visible and enter the username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.EditText[@resource-id='com.synrgyseveneight.bcarevamp:id/inputIdField']")));
            System.out.println("Username field is visible, entering username.");
            usernameField.sendKeys(validUsername);

            // Wait for the password field to be visible and enter the invalid password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.EditText[@resource-id='com.synrgyseveneight.bcarevamp:id/inputPasswordField']")));
            System.out.println("Password field is visible, entering password.");
            passwordField.sendKeys(invalidPassword);

        } catch (Exception e) {
            System.err.println("An error occurred while interacting with elements: " + e.getMessage());
            throw e; // Rethrow to fail the step if necessary
        }
    }

    @And("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"tombol untuk login\"]")));
        loginButton.click();
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
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


    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Tunggu elemen pesan kesalahan terlihat
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/errorPwInput\"]")));

        // Ambil teks pesan kesalahan
        String actualErrorMessage = errorMessageElement.getText();

        // Verifikasi pesan kesalahan
        Object expectedErrorMessage = "Password yang dimasukkan salah";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Pesan kesalahan tidak sesuai");
    }
}

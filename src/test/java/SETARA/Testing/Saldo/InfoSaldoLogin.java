package SETARA.Testing.Saldo;

import SETARA.Page.HomePage;
import SETARA.Page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InfoSaldoLogin {
    protected static AndroidDriver driver;

    @BeforeTest
    public void setupDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName" , "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "ukgyeyt8xkzpfmf6");
        capabilities.setCapability("app", "E:/Download/app-debug.apk");
        capabilities.setCapability("appPackage", "com.synrgyseveneight.bcarevamp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.synrgyseveneight.bcarevamp.MainActivity");

        driver = new AndroidDriver(capabilities);
    }
    @Test
    public void InfoSaldoLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("JANE1234");
        loginPage.inputPassword("jane123");
        loginPage.clickLoginButton();

        // Navigate to HomePage
        HomePage homePage = new HomePage(driver);

        // Validate dashboard text
        Assert.assertEquals(homePage.getDashboardText(), "Halo, Jane Doe!");

        // Validate icon presence
        WebElement icon = homePage.getIcon();
        Assert.assertNotNull(icon, "Icon tidak ditemukan");

        // Click saldo button
        homePage.clickSaldoButton();

        // Validate account number (Norek)
        String norek = homePage.getNorek();
        Assert.assertNotNull(norek, "Nomor rekening tidak ditemukan");


        // Validate saldo
        String saldo = homePage.getSaldoText();
        Assert.assertNotNull(saldo, "Saldo tidak ditemukan");

        // Logout
        homePage.clickLogoutButton();
        homePage.clickLogoutButtonvalid();
    }

    @AfterTest
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

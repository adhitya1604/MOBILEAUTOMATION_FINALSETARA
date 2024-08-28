package SETARA.Testing.Mutasi;

import SETARA.Page.HomePage;
import SETARA.Page.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mutasi {
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
    public void Mutasi() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("JANE1234");
        loginPage.inputPassword("jane123");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);

        Assert.assertEquals(homePage.getDashboardText(), "Halo, Jane Doe!");

        WebElement icon = homePage.getIcon();
        Assert.assertNotNull(icon, "Icon tidak ditemukan");

        homePage.clickSaldoButton();

        String norek = homePage.getNorek();
        Assert.assertNotNull(norek, "Nomor rekening tidak ditemukan");

        String saldo = homePage.getSaldoText();
        Assert.assertNotNull(saldo, "Saldo tidak ditemukan");

        homePage.clickMutasiButton();


        WebElement titleTabElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.synrgyseveneight.bcarevamp:id/title_tab']"));


        Assert.assertNotNull(titleTabElement, "Elemen title tab tidak ditemukan");


        String titleTabText = titleTabElement.getText();

        Assert.assertFalse(titleTabText.isEmpty(), "Teks title tab tidak ditemukan atau kosong");

        String expectedTitle = "Mutasi";
        Assert.assertEquals(titleTabText, expectedTitle, "Teks title tab tidak sesuai!");

        WebElement downloadButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='tombol download laporan mutasi']"));

        Assert.assertNotNull(downloadButton, "Tombol download laporan mutasi tidak ditemukan");

        Assert.assertTrue(downloadButton.isEnabled(), "Tombol download laporan mutasi tidak dapat diklik");

        String buttonText = downloadButton.getText();
        String expectedButtonText = "Download Mutasi";
        Assert.assertEquals(buttonText, expectedButtonText, "Teks pada tombol download tidak sesuai!");


    }

    @AfterTest
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

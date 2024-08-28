package SETARA.Testing.Transfer;

import SETARA.Page.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TransferantarBCAgagal {
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
    public void TransferantarBCASuccess() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("ADTP604T");
        loginPage.inputPassword("andika12345");
        loginPage.clickLoginButton();

        // Navigate to HomePage
        HomePage homePage = new HomePage(driver);


        Assert.assertEquals(homePage.getDashboardText(), "Halo, Andhika Putra!");


        WebElement icon = homePage.getIcon();
        Assert.assertNotNull(icon, "Icon tidak ditemukan");


        homePage.clickSaldoButton();


        String norek = homePage.getNorek();
        Assert.assertNotNull(norek,"Nomor rekening tidak ditemukan");

        String saldo = homePage.getSaldoText();
        Assert.assertNotNull(saldo, "Saldo tidak ditemukan");

        homePage.clickTransferButton();

        TransferPage transferPage = new TransferPage(driver);
        transferPage.clickTransferButton();
        transferPage.clickTujuanButton();
        transferPage.inputrek("1122334455");
        transferPage.inputnominal("1000");
        transferPage.clickLanjutkanButton();

        KonfirmasiPage konfirmasiPage = new KonfirmasiPage(driver);
        String detail = konfirmasiPage.getdetailText();
        Assert.assertNotNull(detail, "Detail tidak ada");
        konfirmasiPage.clickTransferButton();

        PinPage pinPage = new PinPage(driver);
        pinPage.click1();
        pinPage.click2();
        pinPage.click0();
        pinPage.click9();
        pinPage.click5();
        pinPage.click1();


    }

    @AfterTest
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

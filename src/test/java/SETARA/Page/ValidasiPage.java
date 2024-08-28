package SETARA.Page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValidasiPage {


    private AndroidDriver driver;
    private WebDriverWait wait;

    private By icon = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Logo Aplikasi Setara\"]");
    private By textDashboard = AppiumBy.xpath("");
    public ValidasiPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void bagikan() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textDashboard)).click();
    }
    public WebElement getTransaksiTest() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textDashboard));
    }




}
//android.widget.TextView[@text="Transaksi Anda gagal kami proses karena beberapa masalah teknis. Mohon coba kembali dalam beberapa saat"]
//android.widget.Button[@resource-id="com.synrgyseveneight.bcarevamp:id/btnTopUp"]


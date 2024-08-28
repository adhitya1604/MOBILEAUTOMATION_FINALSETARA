package SETARA.Page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private By Transfer = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/transferOptions_recyclerview\"]/android.view.ViewGroup[1]");
    private By Tujuan = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Tombol transfer ke tujuan baru\"]");
    private By RekField = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Kolom input nomor rekening tujuan transfer\"]");
    private By nominall = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Kolom input nominal transfer\"]");
    private By lanjutkan = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Tombol Lanjutkan proses transfer\"]");
    public TransferPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickTransferButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Transfer)).click();
    }

    public void clickTujuanButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Tujuan)).click();
    }

    public void inputrek(String norek) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RekField)).sendKeys(norek);

    }

    public void inputnominal(String uang) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nominall)).sendKeys(uang);

    }

    public void clickLanjutkanButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lanjutkan)).click();
    }

    
}

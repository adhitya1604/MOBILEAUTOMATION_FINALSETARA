package SETARA.Page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KonfirmasiPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private By detail = AppiumBy.xpath("//android.widget.TextView[@text=\"Detail\"]");
    private By nominaltf = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/tvAmountDetails\"]");
    private By total = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Tombol Transfer\"]");
    private By TransferButton = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Tombol Transfer\"]");

    public KonfirmasiPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getdetailText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(detail)).getText();
    }

    public String getnominal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nominaltf)).getText();
    }

    public String gettotal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(total)).getText();
    }

    public void clickTransferButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TransferButton)).click();
    }
}

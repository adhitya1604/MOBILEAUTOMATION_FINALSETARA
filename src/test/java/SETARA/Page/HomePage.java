package SETARA.Page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private By icon = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Logo Aplikasi Setara\"]");
    private By textDashboard = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/greetings\"]");
    private By logout = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tombol keluar\"]");
   private By logoutvalid = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.synrgyseveneight.bcarevamp:id/btnLogout\"]");
    private By saldoButton = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tombol tampilkan saldo\"]");
    private By saldo = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/saldoAmount\"]");
    private By norek = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/accountNumber\"]");
    private By TransferButton = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Tombol menu transfer\"]");
    private By MutasiButton = AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.synrgyseveneight.bcarevamp:id/navigation_bar_item_icon_view\"])[2]");
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebElement getIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(icon));
    }

    public String getDashboardText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textDashboard)).getText();
    }

    public String getNorek() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(norek)).getText();
    }

    public String getSaldoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(saldo)).getText();
    }

    public void clickSaldoButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saldoButton)).click();
    }

    public void clickTransferButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TransferButton)).click();
    }
    public void clickMutasiButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MutasiButton)).click();
    }
    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout)).click();
    }
    public void clickLogoutButtonvalid() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutvalid)).click();
    }
}
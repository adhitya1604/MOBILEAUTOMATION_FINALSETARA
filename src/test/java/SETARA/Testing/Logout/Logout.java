package SETARA.Testing.Logout;

import SETARA.Page.HomePage;
import SETARA.Page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logout {
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
    public void LoginV1Fail() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("JANE1234");
        loginPage.inputPassword("jane123");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getDashboardText(), "Halo, Jane Doe!");


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

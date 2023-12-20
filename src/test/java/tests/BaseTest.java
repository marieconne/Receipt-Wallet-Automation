package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Helpers;
import utils.PlatformName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseTest {
    static AppiumDriver driver;
    static Helpers helpers;
    WebDriverWait wait;
    PlatformName platformName;


    @BeforeMethod
    @Parameters({"platform", "device", "osVersion"})

    public void configureAppium(@Optional("android") String platform, @Optional("Pixel_7_Pro_Api_33") String device, @Optional("13") String osVersion) throws MalformedURLException {

        URL url = new URL("http://127.0.0.1:4723");
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("newCommandTimeout", "3000");
        caps.setCapability("platformName", platform);
        caps.setCapability("deviceName", device);
        caps.setCapability("osVersion", osVersion);
        caps.setCapability("autoGrantPermissions", "true");

        if (platform.equalsIgnoreCase("android")) {
            platformName = PlatformName.ANDROID;
            caps.setCapability("automationName", "uiautomator2");
            caps.setCapability("appPackage", "com.example.receiptwallet");
            caps.setCapability("appActivity", "com.example.receiptwallet.MainActivity");
            caps.setCapability("appActivity", "com.example.receiptwallet.SplashScreenActivity");
            caps.setCapability("noReset", false);
            caps.setCapability("autoGrantPermissions", "true");


            driver = new AndroidDriver(url, caps);

        } else {
            platformName = PlatformName.IOS;
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("udid", "value for it");
            caps.setCapability("bundelID", "");
            driver = new IOSDriver(url, caps);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        helpers = new Helpers(wait, driver, platformName);
    }


}
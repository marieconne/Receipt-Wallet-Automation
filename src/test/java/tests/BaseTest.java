package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("newCommandTimeout", 300);
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Pixel_3");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("udid", "emulator-5554");
        //caps.setCapability("avd","Pixel_3");
        //caps.setCapability("avdLaunchTimeout",20000);

        caps.setCapability("appPackage", "Window{bcafa2 u0 com.example.receiptwallet");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        UiAutomator2Options options = new UiAutomator2Options().
                setDeviceName("Pixel_7_Pro_API_33").
                setAutomationName("UiAutomator2");
               // setApp();

       // URL url = new URL("http://127.0.0.1:4723/");

       // driver = new AndroidDriver(url, options);
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

}

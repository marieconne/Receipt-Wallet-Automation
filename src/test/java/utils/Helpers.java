package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Helpers {
    WebDriverWait wait;
    AppiumDriver driver;
    PlatformName platformName;

    public Helpers(WebDriverWait wait, AppiumDriver driver, PlatformName platformName) {
        this.wait = wait;
        this.driver = driver;
        this.platformName = platformName;
    }

    public WebElement waitForElementByAccessibilityId(String accessibilityId) {
        try {
            return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(new AppiumBy.ByAccessibilityId(accessibilityId)));
        } catch (Exception e) {
            return null;
        }
    }

    public WebElement waitForElementByXpath(String xPath) {
        try {
            return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(xPath) {
                @Override
                public List<WebElement> findElements(SearchContext context) {
                    return null;
                }
            }));
        } catch (Exception e) {
            return null;
        }

    }
}
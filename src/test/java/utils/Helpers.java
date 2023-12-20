package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import locators.HomeScreenLocators;
import locators.NewReceiptLocators;
import model.WarrantyCardsData;
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

    public WebElement waitForElementByID(String id) {
        try {
            return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ById(id)));
        } catch (Exception e) {
            return null;
        }
    }

    public void addWarrantyCards() {
        String[][] cardData = {
                {WarrantyCardsData.nameHonor, WarrantyCardsData.warrantyLength, WarrantyCardsData.cost1, WarrantyCardsData.date1, NewReceiptLocators.selectCategoryITComponent},
                {WarrantyCardsData.nameBed, WarrantyCardsData.warrantyLength1, WarrantyCardsData.cost2, WarrantyCardsData.date8, NewReceiptLocators.selectCategoryFurniture},
                {WarrantyCardsData.nameSamsung, WarrantyCardsData.warrantyLength3, WarrantyCardsData.cost3, WarrantyCardsData.date7,NewReceiptLocators.selectCategoryTv},
                {WarrantyCardsData.nameLenovo, WarrantyCardsData.warrantyLength2, WarrantyCardsData.cost4, WarrantyCardsData.date6,NewReceiptLocators.selectCategoryITComponent},
                {WarrantyCardsData.nameRealme, WarrantyCardsData.warrantyLength2, WarrantyCardsData.cost5, WarrantyCardsData.date5,NewReceiptLocators.selectCategoryITComponent},
                {WarrantyCardsData.nameSamsung, WarrantyCardsData.warrantyLength3, WarrantyCardsData.cost6, WarrantyCardsData.date4,NewReceiptLocators.selectCategoryITComponent},
                {WarrantyCardsData.nameHonor, WarrantyCardsData.warrantyLength2, WarrantyCardsData.cost7, WarrantyCardsData.date3,NewReceiptLocators.selectCategoryITComponent},
                {WarrantyCardsData.nameMakeUp, WarrantyCardsData.warrantyLength3, WarrantyCardsData.cost8, WarrantyCardsData.date2,NewReceiptLocators.selectCategoryOther},
                {WarrantyCardsData.nameTesla, WarrantyCardsData.warrantyLength2, WarrantyCardsData.cost9, WarrantyCardsData.date7,NewReceiptLocators.selectCategoryVehicle},
        };

        for (String[] card : cardData) {
            String name = card[0];
            String warrantyLength = card[1];
            String cost = card[2];
            String locatorDate = card[3];
            String locatorCat = card[4];

            addCard(name, warrantyLength, cost, locatorDate, locatorCat);
        }
    }

    private void addCard(String name, String warrantyLength, String cost, String locatorDate, String locatorCat) {
        waitForElementByAccessibilityId(HomeScreenLocators.addNewReceiptBtn).click();
        WebElement enterNameEt = waitForElementByAccessibilityId(NewReceiptLocators.enterNameEt);
        enterNameEt.click();
        enterNameEt.sendKeys(name);
        driver.navigate().back();

        waitForElementByAccessibilityId(NewReceiptLocators.enterDateEt).sendKeys(locatorDate);

        WebElement enterWarrantyLengthEt = waitForElementByAccessibilityId(NewReceiptLocators.enterWarrantyLengthEt);
        enterWarrantyLengthEt.click();
        enterWarrantyLengthEt.sendKeys(warrantyLength);
        driver.navigate().back();

        waitForElementByAccessibilityId(NewReceiptLocators.selectCategoryEt).click();

        waitForElementByXpath(locatorCat).click();

        WebElement enterCost = waitForElementByAccessibilityId(NewReceiptLocators.enterCostEt);
        enterCost.click();
        enterCost.sendKeys(cost);
        driver.navigate().back();

        waitForElementByAccessibilityId(NewReceiptLocators.rsdRB).click();
        waitForElementByAccessibilityId(NewReceiptLocators.euroRB).click();
        waitForElementByAccessibilityId(NewReceiptLocators.addImageBtn).click();
        waitForElementByAccessibilityId(NewReceiptLocators.openCameraBtn).click();
        waitForElementByID(NewReceiptLocators.takeAPhotoBtn).click();
        waitForElementByID(NewReceiptLocators.saveImageBtn).click();

        waitForElementByAccessibilityId(NewReceiptLocators.saveBtn).click();
        waitForElementByXpath(HomeScreenLocators.homeScreenTittle);
        //not used wait because he could not catch element
        driver.findElement(AppiumBy.xpath(NewReceiptLocators.toastMessageWA));
    }
}



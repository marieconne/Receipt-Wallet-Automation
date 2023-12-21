package tests;

import locators.HomeScreenLocators;
import locators.NewReceiptLocators;
import locators.WarrantyCardDetailsLocators;
import model.WarrantyCardDetailsPage;
import model.WarrantyCardsData;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddWarrantyCardsTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        helpers.addWarrantyCards();
    }

    @Test
    public void addWarrantyCardsTest() {
        helpers.scrollToRealme8();
        changeWarrantyLength();
    }

    private void changeWarrantyLength() {
        assertEquals(helpers.waitForElementByXpath(WarrantyCardDetailsLocators.titleRealme8).getText(), WarrantyCardsData.nameRealme, "Realme 8 text is not a match");
        WebElement warrantyLength = helpers.waitForElementByAccessibilityId(WarrantyCardDetailsLocators.warrantyLengthDetails);
        warrantyLength.click();
        driver.navigate().back();
        warrantyLength.sendKeys(WarrantyCardsData.warrantyLength4);
        helpers.waitForElementByAccessibilityId(WarrantyCardDetailsLocators.saveDetailsChange).click();
        assertEquals(helpers.waitForElementByAccessibilityId(WarrantyCardDetailsLocators.timeLeft).getText()
                ,WarrantyCardDetailsPage.expired, "Expired date text is not a match");
        searchAndDelete();
    }

    private void searchAndDelete() {
        helpers.waitForElementByAccessibilityId(HomeScreenLocators.searchBtn).click();
        WebElement searchElement = helpers.waitForElementByAccessibilityId(HomeScreenLocators.tfsearch);
        searchElement.sendKeys(WarrantyCardsData.nameHonor);
        WebElement honor90Card = helpers.waitForElementByXpath(WarrantyCardDetailsLocators.titleHonor90);
        assertEquals(honor90Card.getText(), WarrantyCardsData.nameHonor90, "Honor 90 text is not a match");
        honor90Card.click();
        helpers.waitForElementByAccessibilityId(WarrantyCardDetailsLocators.deleteButton).click();
        WebElement deleteYes = helpers.waitForElementByAccessibilityId(WarrantyCardDetailsLocators.deleteYes);
        assertEquals(deleteYes.getText(), WarrantyCardDetailsPage.deleteYesTxt, "Yes txt is not a match");
        deleteYes.click();
        helpers.waitForElementByAccessibilityId(HomeScreenLocators.searchBtn).click();
        searchElement = helpers.waitForElementByAccessibilityId(HomeScreenLocators.tfsearch);
        searchElement.sendKeys(WarrantyCardsData.nameHonor);
    }
}

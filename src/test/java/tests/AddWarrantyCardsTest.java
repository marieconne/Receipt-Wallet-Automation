package tests;

import locators.WarrantyCardDetailsLocators;
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
        System.out.println("Added cards and run TEST method in AddWarrantyCardsTest class");
    }

    private void changeWarrantyLength() {
        WebElement clickWarrantyCard = helpers.waitForElementByXpath(WarrantyCardDetailsLocators.cardClick);
        clickWarrantyCard.click();
        WebElement warrantyLengthTitle = helpers.waitForElementByXpath(WarrantyCardDetailsLocators.titleDetailsCard);
        helpers.waitForElementByAccessibilityId(WarrantyCardDetailsLocators.deleteButton).click();
    }
}

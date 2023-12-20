package tests;

import locators.HomeScreenLocators;
import locators.NewReceiptLocators;
import model.NewReceiptPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NewReceiptTest extends BaseTest {

    @Test
    public void verifyTextElements() {
        helpers.waitForElementByAccessibilityId(HomeScreenLocators.addNewReceiptBtn).click();

        assertEquals(helpers.waitForElementByXpath(NewReceiptLocators.newReceiptScreen).getText()
                ,NewReceiptPage.newReceiptTxt, "New Receipt text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.nameLabel).getText()
                ,NewReceiptPage.nameTxt, "Name text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.purchaseDateLabel).getText()
                ,NewReceiptPage.purchaseDateTxt, "Purchase date text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.warrantyLengthLabel).getText()
                ,NewReceiptPage.warrantyLengthTxt, "Warranty length text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.categoryLabel).getText()
                ,NewReceiptPage.categoryTxt, "Category text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.costLabel).getText(),
                NewReceiptPage.costTxt, "Cost text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.enterNameEt).getText()
                ,NewReceiptPage.enterNameTxt, "Enter name text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.enterDateEt).getText()
                ,NewReceiptPage.enterPurchaseDateTxt, "Enter date is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.enterWarrantyLengthEt).getText()
                ,NewReceiptPage.enterWarrantyLengthTxt, "Enter warranty Length btn text is not a match");

        WebElement selectCategoryEt = helpers.waitForElementByAccessibilityId(NewReceiptLocators.selectCategoryEt);
        assertEquals(selectCategoryEt.getText(),NewReceiptPage.selectCategoryTxt, "Select category text is not a match");
        selectCategoryEt.click();

        WebElement selectCategoryITComponent = helpers.waitForElementByXpath(NewReceiptLocators.selectCategoryITComponent);
        assertEquals(selectCategoryITComponent.getText(),NewReceiptPage.ITComponentTxt, "IT Component text is not a match");
        selectCategoryITComponent.click();

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.enterCostEt).getText()
                ,NewReceiptPage.enterCostTxt, "Enter cost text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.rsdRB).getText()
                ,NewReceiptPage.rsdTxt, "Enter rsd text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.euroRB).getText()
                ,NewReceiptPage.euroTxt, "Enter euro text is not a match");

        helpers.waitForElementByAccessibilityId(NewReceiptLocators.addImageBtn).click();

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.openCameraBtn).getText()
                ,NewReceiptPage.openCameraTxt, "Open Camera text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.uploadPictureBtn).getText()
                ,NewReceiptPage.uploadPictureTxt, "Upload Picture text is not a match");

        helpers.waitForElementByAccessibilityId(NewReceiptLocators.closePopUpCameraBtn).click();

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.saveBtn).getText()
                ,NewReceiptPage.saveTxt, "Save text is not a match");

        assertEquals(helpers.waitForElementByAccessibilityId(NewReceiptLocators.cancelBtn).getText()
                ,NewReceiptPage.cancelTxt, "Cancel text is not a match");
    }
}

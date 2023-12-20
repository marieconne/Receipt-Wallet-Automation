package tests;


import locators.HomeScreenLocators;
import model.HomeScreen;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class HomeScreenTest extends BaseTest {

    @Test
    public void verifyBottomNavigationButtons() {

        assertEquals(helpers.waitForElementByXpath(HomeScreenLocators.homeScreenTittle).getText(), HomeScreen.homeScreenTitleText,
                "The home screen title text does not match!");

        WebElement expenseBtn = helpers.waitForElementByAccessibilityId(HomeScreenLocators.expenseBtn);
        expenseBtn.click();
        assertTrue(expenseBtn.isSelected(), "Expense button is not selected!");
        assertEquals(helpers.waitForElementByXpath(HomeScreenLocators.expenseText).getText(),
                HomeScreen.expenseBtnText, "The expense button text does not match!");
        assertTrue(helpers.waitForElementByXpath(HomeScreenLocators.expenseIcon).isDisplayed(), "Expense icon is not displayed");

        WebElement homeBtn = helpers.waitForElementByAccessibilityId(HomeScreenLocators.homeBtn);
        homeBtn.click();
        assertTrue(homeBtn.isSelected(), "Home button is not selected!");
        assertEquals(helpers.waitForElementByXpath(HomeScreenLocators.homeText).getText(),
                HomeScreen.homeBtnText, "The expense button text does not match!");
        assertTrue(helpers.waitForElementByXpath(HomeScreenLocators.homeIcon).isDisplayed(), "Home icon is not displayed!");

    }
}


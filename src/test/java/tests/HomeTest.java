package tests;

import locators.HomePageLocators;
import model.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class HomeTest extends BaseTest {

    HomePageLocators homePageLocators;
    HomePage homePage;

    @Test
    public void verifyBottomNavigationButtons() {

        homePageLocators = new HomePageLocators();
        homePage = new HomePage();

        WebElement homeScreenTittle = helpers.waitForElementByXpath(homePageLocators.getHomeScreenTittle());
        assertEquals(homeScreenTittle.getText(), homePage.getHomeScreenTitleText(), "The home screen title text does not match!");

        WebElement expenseBtn = helpers.waitForElementByAccessibilityId(homePageLocators.getExpenseBtn());
        expenseBtn.click();
        assertTrue(expenseBtn.isSelected(), "Expense button is not selected!");

        WebElement expenseText = helpers.waitForElementByXpath(homePageLocators.getExpenseText());
        assertEquals(expenseText.getText(), homePage.getExpenseBtnText(), "The expense button text does not match!");

        WebElement expenseIcon = helpers.waitForElementByXpath(homePageLocators.getExpenseIcon());
        assertTrue(expenseIcon.isDisplayed(), "Expense icon is not displayed");


        WebElement homeBtn = helpers.waitForElementByAccessibilityId(homePageLocators.getHomeBtn());
        homeBtn.click();
        assertTrue(homeBtn.isSelected(), "Home button is not selected!");

        WebElement homeText = helpers.waitForElementByXpath(homePageLocators.getHomeText());
        assertEquals(homeText.getText(), homePage.getHomeBtnText(), "The expense button text does not match!");

        WebElement homeIcon = helpers.waitForElementByXpath(homePageLocators.getHomeIcon());
        assertTrue(homeIcon.isDisplayed(), "Home icon is not displayed!");

    }

}

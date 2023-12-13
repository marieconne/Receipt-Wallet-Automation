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

        WebElement expenseBtn = helpers.waitForElementByAccessibilityId(homePageLocators.getExpenseBtn());
        assertNotNull(expenseBtn,"Expense button is null!");
        expenseBtn.click();
        assertTrue(expenseBtn.isSelected(),"Expense button is not selected!");

        WebElement expenseText = helpers.waitForElementByXpath(homePageLocators.getExpenseText());
        assertNotNull(expenseText,"Expense Text is null!");
        assertEquals(expenseText.getText(), homePage.getExpenseBtnText());

        WebElement expenseIcon = helpers.waitForElementByXpath(homePageLocators.getExpenseIcon());
        assertNotNull(expenseIcon,"Expense icon is null!");
        assertTrue(expenseIcon.isDisplayed(),"Expense icon is not displayed");


        WebElement homeBtn = helpers.waitForElementByAccessibilityId(homePageLocators.getHomeBtn());
        assertNotNull(homeBtn,"Home button is null!");
        homeBtn.click();
        assertTrue(homeBtn.isSelected(),"Home button is not selected!");

        WebElement homeTab = helpers.waitForElementByXpath(homePageLocators.getHomeText());
        assertNotNull(homeTab,"Home Text is null!");
        assertEquals(homeTab.getText(), homePage.getHomeBtnText());

        WebElement homeIcon = helpers.waitForElementByXpath(homePageLocators.getExpenseIcon());
        assertNotNull(homeIcon,"Home icon is null!");
        assertTrue(homeIcon.isDisplayed(),"Home icon is not displayed!");

    }

}

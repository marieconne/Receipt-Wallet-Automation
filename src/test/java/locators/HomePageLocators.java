package locators;

import tests.BaseTest;


public class HomePageLocators extends BaseTest {

    String homeScreenTittle = "//android.widget.TextView[@text='Receipt Wallet']";
    String homeBtn = "home";
    String homeText = "//android.widget.TextView[@text='home']";
    String homeIcon = "(//android.widget.ImageView[@resource-id='com.example.receiptwallet:id/navigation_bar_item_icon_view'])[2]";
    String expenseBtn = "expense";
    String expenseText = "//android.widget.TextView[@text='expense']";
    String expenseIcon = "(//android.widget.ImageView[@resource-id='com.example.receiptwallet:id/navigation_bar_item_icon_view'])[1]";


    public String getHomeScreenTittle() {
        return homeScreenTittle;
    }

    public String getHomeBtn() {
        return homeBtn;
    }

    public String getHomeText() {
        return homeText;
    }

    public String getExpenseBtn() {
        return expenseBtn;
    }

    public String getExpenseText() {
        return expenseText;
    }

    public String getHomeIcon() {
        return homeIcon;
    }

    public String getExpenseIcon() {
        return expenseIcon;

    }
}



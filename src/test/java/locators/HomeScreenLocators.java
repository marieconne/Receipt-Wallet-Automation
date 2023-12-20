package locators;

import tests.BaseTest;


public class HomeScreenLocators extends BaseTest {

    public static final String homeScreenTittle = "//android.widget.TextView[@text='Receipt Wallet']";
    public static final String homeBtn = "home";
    public static final String homeText = "//android.widget.TextView[@text='home']";
    public static final String homeIcon = "(//android.widget.ImageView[@resource-id='com.example.receiptwallet:id/navigation_bar_item_icon_view'])[2]";
    public static final String expenseBtn = "expense";
    public static final String expenseText = "//android.widget.TextView[@text='expense']";
    public static final String expenseIcon = "(//android.widget.ImageView[@resource-id='com.example.receiptwallet:id/navigation_bar_item_icon_view'])[1]";
    public static final String addNewReceiptBtn = "addNewReceiptBtn";
    public static final String searchBtn = "searchBtn";
    public static final String tfsearch = "tfsearch";
    public static final String toastMessageWA = "//android.widget.Toast[@text='Warranty added']";
    public static final String toastMessageEdit = "//android.widget.Toast[@text='Warranty updated']";
}
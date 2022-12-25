package AppTests;

import Pages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.ParseException;
import java.util.List;

public class PurchaseTestPage extends BaseTestSetUp{

    LoginPage loginPage= new LoginPage(driver);
    ProductsPage productsPage= new ProductsPage(driver);
    BackpackPage backpackPage= new BackpackPage(driver);
    ShoppingCartPage shoppingCartPage= new ShoppingCartPage(driver);
    CheckoutBuyersInfoPage checkoutBuyersInfoPage= new CheckoutBuyersInfoPage(driver);
    CheckoutOverviewPage checkoutOverviewPage= new CheckoutOverviewPage(driver);
    CheckoutCompleteOrderPage checkoutCompleteOrderPage= new CheckoutCompleteOrderPage(driver);

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

//  Test of successful purchase one item that has been added in cart from its specific page
    @Test
    public void SingleItemPurchase() throws InterruptedException {
       productsPage.takeAlookAtBackpack();
            Thread.sleep(5000);
       String expectedURLforBackpack= "https://www.saucedemo.com/inventory-item.html?id=4";
       String actualURLforBackpack= driver.getCurrentUrl();
            System.out.println(actualURLforBackpack);
       Assert.assertTrue("We are not at backpack preview page", expectedURLforBackpack.equals(actualURLforBackpack));
       productsPage.addBackpackToShoppingCart();
       Thread.sleep(5000);
       String expectedRemoveText= "REMOVE";
       String actualRemoveText= backpackPage.getTextRemoveButton();
            System.out.println(actualRemoveText);
       Assert.assertTrue("There is no Remove inscription on that button",expectedRemoveText.equals(actualRemoveText));
       String expectedNumber1onCart= "1";
       String actualNumerationOnCart= backpackPage.getTextNumber1onCartLogo();
            System.out.println(actualNumerationOnCart);
       Assert.assertTrue("There is no Number 1 on Cart logo",expectedNumber1onCart.equals(actualNumerationOnCart));
       productsPage.goToShoppingCart();
            Thread.sleep(5000);
       String expectedTextOnShoppingCartPage= "DESCRIPTION";
       String actualTextOnShoppingCartPage= shoppingCartPage.getTextForAssertation();
       String URLofShoppingCart= driver.getCurrentUrl();
            System.out.println(URLofShoppingCart);
       Assert.assertTrue("Desired inscription on web page is not there",expectedTextOnShoppingCartPage.equals(actualTextOnShoppingCartPage));
       shoppingCartPage.goToCheckoutPage();
            Thread.sleep(5000);
       String URLofCheckoutPage= driver.getCurrentUrl();
            System.out.println(URLofCheckoutPage);
       checkoutBuyersInfoPage.enterFirstName("Standard");
       checkoutBuyersInfoPage.enterLastName("User");
       checkoutBuyersInfoPage.enterPostalCode("26000");
       checkoutBuyersInfoPage.goToCheckoutOverviewPage();
            Thread.sleep(5000);
       String URLofCheckoutOverviewPage= driver.getCurrentUrl();
            System.out.println(URLofCheckoutOverviewPage);
       String expectedTextOnCheckoutPage="Sauce Labs Backpack";
       String actualTextOnCheckoutPage=checkoutOverviewPage.getTextForSauceLabsBackpackCart();
       Assert.assertTrue("We are not at Checkout overview page",expectedTextOnCheckoutPage.equals(actualTextOnCheckoutPage));
       String expectedTextFreePony= "FREE PONY EXPRESS DELIVERY!";
       String actualTextFreePony= checkoutOverviewPage.getTextFreePony();
            System.out.println(actualTextFreePony);
       Assert.assertTrue("The Name of Shipping company isn't visible, that means we're not on Checkout overview page",expectedTextFreePony.equals(actualTextFreePony));
       checkoutOverviewPage.finishTheOrder();
            Thread.sleep(5000);
       String expectedURLcheckoutComplete= "https://www.saucedemo.com/checkout-complete.html";
       String actualURLweGet= driver.getCurrentUrl();
            System.out.println(actualURLweGet);
       String expectedInscriptionForCompleteOrder= "THANK YOU FOR YOUR ORDER";
       String actualInscriptionWeGet= checkoutCompleteOrderPage.getThankYouInscriptionText();
            System.out.println(actualInscriptionWeGet);
       Assert.assertTrue("Purchase is not successful",expectedURLcheckoutComplete.equals(actualURLweGet));
       Assert.assertTrue("There is no 'Thank you for your order' inscription on this page",expectedInscriptionForCompleteOrder.equals(actualInscriptionWeGet));
            Thread.sleep(5000);
    }

//  Testing successful adding items to shopping cart on products page
    @Test
    public void AddingItemsToShoppingCart() throws InterruptedException {

        productsPage.addBikeLightToShoppingCart();
        productsPage.addFleeceJacketToShoppingCart();
        productsPage.addBoltTshirtToShoppingCart();
        productsPage.goToShoppingCart();
            Thread.sleep(5000);
        String expectedBikeLightInShoppingCart= "Sauce Labs Bike Light";
        String actualTextBikeLightInShoppingCart= shoppingCartPage.getTextForSauceLabsBikeLightCart();
            System.out.println(actualTextBikeLightInShoppingCart);
        Assert.assertTrue("There is no Bike light in shopping cart",expectedBikeLightInShoppingCart.equals(actualTextBikeLightInShoppingCart));
        String expectedTextBoltTshirtInShoppingCart= "Sauce Labs Bolt T-Shirt";
        String actualTextBoltTshirtInShoppingCart= shoppingCartPage.getTextForSauceLabsBoltTshirtCart();
            System.out.println(actualTextBoltTshirtInShoppingCart);
        Assert.assertTrue("There is no Bolt T-shirt in shopping cart",expectedTextBoltTshirtInShoppingCart.equals(actualTextBoltTshirtInShoppingCart));
        String expectedTextFleeceJacketInShoppingCart= "Sauce Labs Fleece Jacket";
        String actualTextFleeceJacketInShoppingCart= shoppingCartPage.getTextForSauceLabsFleeceJacketCart();
            System.out.println(actualTextFleeceJacketInShoppingCart);
        Assert.assertTrue("There is no Fleece Jacket in shopping cart",expectedTextFleeceJacketInShoppingCart.equals(actualTextFleeceJacketInShoppingCart));

    }

//  Testing removing item(s) from shopping cart
    @Test
    public void RemoveItemsFromShoppingCart() throws InterruptedException {
        productsPage.addBikeLightToShoppingCart();
        productsPage.addFleeceJacketToShoppingCart();
        productsPage.addBoltTshirtToShoppingCart();
        productsPage.goToShoppingCart();
            Thread.sleep(5000);
        List<WebElement> listOfItemsInCartBeforeItemRemoval= driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
        System.out.println("Number of items in shopping cart:" + listOfItemsInCartBeforeItemRemoval.size());
        for (int i=0; i<listOfItemsInCartBeforeItemRemoval.size(); i++){
            System.out.println(listOfItemsInCartBeforeItemRemoval.get(i).getText());
        }
        productsPage.removeBoltTshirtFromShoppingCart();
            Thread.sleep(5000);
        List<WebElement> listOfItemsInCart= driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
            System.out.println("Number of items in shopping cart:" + listOfItemsInCart.size());
        for (int i=0; i<listOfItemsInCart.size(); i++){
            System.out.println(listOfItemsInCart.get(i).getText());
            if (listOfItemsInCart.get(i).getText().contains("Sauce Labs Bolt T-Shirt")){
                System.out.println("Alert! Bug detected! Sauce Labs Bolt T-Shirt shouldn't have been on this list!");
                break;
            }
        }
    }
//    Notice: Don't be alarm if you see this test fail if all the tests from this class are run at once.
//    If you see such a message, run just this test a lone and everything is going to be fine!


//  Testing price summing while purchasing 2 items
    @Test
    public void PriceSummaryTest() throws InterruptedException, ParseException {
        productsPage.addOnesieToShoppingCart();
        productsPage.addRedTshirtTallTTtoShoppingCart();
        productsPage.goToShoppingCart();
            Thread.sleep(5000);
        shoppingCartPage.goToCheckoutPage();
            Thread.sleep(5000);
        checkoutBuyersInfoPage.enterFirstName("Standard");
        checkoutBuyersInfoPage.enterLastName("User");
        checkoutBuyersInfoPage.enterPostalCode("26000");
        checkoutBuyersInfoPage.goToCheckoutOverviewPage();
            Thread.sleep(5000);
        String expectedItemTotalTextPriceDollar= checkoutOverviewPage.getTextForItemsTotalPrice();
            System.out.println(expectedItemTotalTextPriceDollar);
        String expectedItemTotalTextPrice= expectedItemTotalTextPriceDollar.replaceAll("[Item total: $]","");
            System.out.println(expectedItemTotalTextPrice);
        float expectedItemTotalFloat= Float.parseFloat(expectedItemTotalTextPrice); //Float value of String data!
            System.out.println(expectedItemTotalFloat);
        String textValueForOnasiePriceDollar= checkoutOverviewPage.getTextValueForOnesiePrice();
            System.out.println(textValueForOnasiePriceDollar);
        String textValueForOnasie=textValueForOnasiePriceDollar.replaceAll("[$]","");
            System.out.println(textValueForOnasie);
        float valueForOnasieFloat= Float.parseFloat(textValueForOnasie);
            System.out.println(valueForOnasieFloat);
        String textValueForTallTTRedTshirtDollar= checkoutOverviewPage.getTextValueForTallTTRedTshirtPrice();
            System.out.println(textValueForTallTTRedTshirtDollar);
        String textValueForTallTTRedTshirt= textValueForTallTTRedTshirtDollar.replaceAll("[$]","");
            System.out.println(textValueForTallTTRedTshirt);
        float valueForTallTTRedTshirtFloat= Float.parseFloat(textValueForTallTTRedTshirt);
            System.out.println(valueForTallTTRedTshirtFloat);
        float actualItemTotal= valueForOnasieFloat + valueForTallTTRedTshirtFloat;
            System.out.println("Summary price of two items in shopping cart is: " + actualItemTotal + "$");
        Assert.assertTrue("Price summary is not correct",expectedItemTotalFloat==actualItemTotal);

    }
}

//The last test on this page was a quite a challenge for me. I needed to use a lot of "sout" just to see what
//I'm getting after every node. I'll say it again, System.out.println was crucial for writing this code.
//Now, when I know what expect from every node, I could delete some "sout" for cleaner look, but I decided to leave it nevertheless!
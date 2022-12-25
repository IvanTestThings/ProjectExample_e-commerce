package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends ProductsPage{

    public static WebDriver driver;

    public By continueShopping= By.id("continue-shopping");
    public By checkoutButton= By.id("checkout");

    public By descriptionText= By.xpath("//*[text()='DESCRIPTION']");

    public By sauceLabsBoltTshirtCart= By.xpath("//*[text()='Sauce Labs Bolt T-Shirt']");
    public By sauceLabsBikeLightCart= By.xpath("//*[text()='Sauce Labs Bike Light']");
    public By sauceLabsBackpackCart= By.xpath("//*[text()='Sauce Labs Backpack']");
    public By sauceLabsFleeceJacketCart= By.xpath("//*[text()='Sauce Labs Fleece Jacket']");
    public By sauceLabsOnesieCart= By.xpath("//*[text()='Sauce Labs Onesie']");
    public By testAllTheThingsTshirtRedCart= By.xpath("//*[text()='Test.allTheThings() T-Shirt (Red)']");

    public ShoppingCartPage(WebDriver driver){
        this.driver=driver;
    }

    public ShoppingCartPage(){

    }

    public void backToProductsPage(){
        driver.findElement(continueShopping).click();
    }

    public void goToCheckoutPage(){
        driver.findElement(checkoutButton).click();
    }

    public String getTextForAssertation(){
        return driver.findElement(descriptionText).getText();
    }

    public String getTextForSauceLabsBoltTshirtCart(){
        return driver.findElement(sauceLabsBoltTshirtCart).getText();
    }

    public String getTextForSauceLabsBikeLightCart(){
        return driver.findElement(sauceLabsBikeLightCart).getText();
    }

    public String getTextForSauceLabsBackpackCart(){
        return driver.findElement(sauceLabsBackpackCart).getText();
    }

    public String getTextForSauceLabsFleeceJacketCart(){
        return driver.findElement(sauceLabsFleeceJacketCart).getText();
    }

    public String getTextForSauceLabsOnesieCart(){
        return driver.findElement(sauceLabsOnesieCart).getText();
    }

    public String getTextForTestAllTheThingsTshirtRedCart(){
        return driver.findElement(testAllTheThingsTshirtRedCart).getText();
    }

}


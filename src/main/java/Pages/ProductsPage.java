package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    public static WebDriver driver;

    public By backpack= By.id("item_4_title_link");
    public By backpackAddRemoveButton= By.xpath("//*[contains(@id,'-sauce-labs-backpack')]");
    public By boltTShirt = By.id("item_1_title_link");
    public By boltTshirtAddRemoveButton = By.xpath("//*[contains(@id,'-sauce-labs-bolt-t-shirt')]");
    public By onesie= By.id("item_2_title_link");
    public By onesieAddRemoveButton= By.xpath("//*[contains(@id,'-sauce-labs-onesie')]");
    public By bikeLight= By.id("item_0_title_link");
    public By bikeLightAddRemoveButton= By.xpath("//*[contains(@id,'-sauce-labs-bike-light')]");
    public By fleeceJacket= By.id("item_5_title_link");
    public By fleeceJacketAddRemoveButton= By.xpath("//*[contains(@id,'-sauce-labs-fleece-jacket')]");
    public By redTshirtTallTT= By.id("item_3_title_link");
    public By redTshirtTallTTaddRemoveButton= By.xpath("//*[contains(@id,'-test.allthethings()-t-shirt-(red)')]");
    public By shoppingCartIcon= By.id("shopping_cart_container");
    public By twitterLogo= By.cssSelector("a[href=\"https://twitter.com/saucelabs\"]");
    public By facebookLogo= By.cssSelector("a[href=\"https://www.facebook.com/saucelabs\"]");
    public By linkedinLogo= By.cssSelector("a[href=\"https://www.linkedin.com/company/sauce-labs/\"]");

    public ProductsPage(){
    }

    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }

    public void addBackpackToShoppingCart(){
        driver.findElement(backpackAddRemoveButton).click();
    }

    public void addBoltTshirtToShoppingCart(){
        driver.findElement(boltTshirtAddRemoveButton).click();
    }

    public void addOnesieToShoppingCart(){
        driver.findElement(onesieAddRemoveButton).click();
    }

    public void addBikeLightToShoppingCart(){
        driver.findElement(bikeLightAddRemoveButton).click();
    }

    public void addFleeceJacketToShoppingCart(){
        driver.findElement(fleeceJacketAddRemoveButton).click();
    }

    public void addRedTshirtTallTTtoShoppingCart(){
        driver.findElement(redTshirtTallTTaddRemoveButton).click();
    }

    public void removeBackpackFromShoppingCart(){
        driver.findElement(backpackAddRemoveButton).click();
    }

    public void removeBikeLightFromShoppingCart(){
        driver.findElement(bikeLightAddRemoveButton).click();
    }

    public void removeBoltTshirtFromShoppingCart(){
        driver.findElement(boltTshirtAddRemoveButton).click();
    }
    public void removeFleeceJacketFromShoppingCart(){
        driver.findElement(fleeceJacketAddRemoveButton).click();
    }

    public void removeOnesieFromShoppingCart(){
        driver.findElement(onesieAddRemoveButton).click();
    }

    public void removeRedTshirtTallTTFromShoppingCart(){
        driver.findElement(redTshirtTallTTaddRemoveButton).click();
    }

    public void goToShoppingCart(){
        driver.findElement(shoppingCartIcon).click();
    }

    public void takeAlookAtBackpack(){
        driver.findElement(backpack).click();
    }

    public void clickOnTwitterLogo(){
        driver.findElement(twitterLogo).click();
    }

    public void clickOnFacebookLogo(){
        driver.findElement(facebookLogo).click();
    }

    public void clickOnLinkedinLogo(){
        driver.findElement(linkedinLogo).click();
    }



}

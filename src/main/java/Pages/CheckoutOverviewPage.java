package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends ShoppingCartPage{

    public static WebDriver driver;

    public By finishButton= By.id("finish");
    public By cancelButton= By.id("cancel");

    public By priceForOnesie= By.xpath("//*[text()='7.99']");
    public By priceForTallTTRedTshirt= By.xpath("//*[text()='15.99']");
    public By itemsTotalPrice= By.xpath("//*[text()='23.98']");
    public By textFreePony= By.xpath("//*[text()='FREE PONY EXPRESS DELIVERY!']");

    public CheckoutOverviewPage(){

    }

    public CheckoutOverviewPage(WebDriver driver){
        this.driver=driver;
    }

    public void finishTheOrder(){
        driver.findElement(finishButton).click();
    }

    public void backToProductsPage(){
        driver.findElement(cancelButton).click();
    }

    public String getTextValueForOnesiePrice(){
        return driver.findElement(priceForOnesie).getText();
    }

    public String getTextValueForTallTTRedTshirtPrice(){
        return driver.findElement(priceForTallTTRedTshirt).getText();
    }

    public String getTextForItemsTotalPrice(){
        return driver.findElement(itemsTotalPrice).getText();
    }

    public String getTextFreePony(){
        return driver.findElement(textFreePony).getText();
    }

}

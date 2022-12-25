package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompleteOrderPage extends ProductsPage{

    public static WebDriver driver;

    public By backHomeButton= By.id("back-to-products");
    public By thankYouInscription= By.xpath("//*[text()='THANK YOU FOR YOUR ORDER']");

    public CheckoutCompleteOrderPage(WebDriver driver){
        this.driver=driver;
    }

    public CheckoutCompleteOrderPage(){

    }

    public void goToProductsPage(){
        driver.findElement(backHomeButton).click();
    }

    public String getThankYouInscriptionText(){
        return driver.findElement(thankYouInscription).getText();
    }

}



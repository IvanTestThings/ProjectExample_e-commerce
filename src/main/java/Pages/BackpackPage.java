package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackpackPage extends ProductsPage{

    public static WebDriver driver;

    public By backToProducts= By.id("back-to-products");
    public By textRemove= By.xpath("//*[text()='Remove']");
    public By number1onCartLogo= By.xpath("//*[text()='1']");

    public BackpackPage(WebDriver driver){
        this.driver= driver;
    }

    public BackpackPage(){
    }

    public void goBackToTheProducts(){
        driver.findElement(backToProducts).click();
    }

    public String getTextRemoveButton(){
        return driver.findElement(textRemove).getText();
    }

    public String getTextNumber1onCartLogo(){
        return driver.findElement(number1onCartLogo).getText();
    }

}

// All locators and methods has been written down on ProductsPage.
// All I've done is "extends" on every page concerning those web elements.
// It can be done like that because locators for add and remove specific item are the same on every page of this application.
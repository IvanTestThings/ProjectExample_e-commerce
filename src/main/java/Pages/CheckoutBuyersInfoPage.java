package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutBuyersInfoPage {

    public static WebDriver driver;

    public By dataFirstNameField = By.name("firstName");
    public By dataLastNameField = By.name("lastName");
    public By postalCodeField= By.name("postalCode");
    public By cancelButton= By.name("cancel");
    public By continueButton= By.name("continue");

    public CheckoutBuyersInfoPage(WebDriver driver){
        this.driver=driver;
    }

    public CheckoutBuyersInfoPage(){

    }

    public void enterFirstName(String usersFirstName){
        driver.findElement(dataFirstNameField).sendKeys(usersFirstName);
    }

    public void enterLastName(String usersLastName){
        driver.findElement(dataLastNameField).sendKeys(usersLastName);
    }

    public void enterPostalCode(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void getBackToShoppingCart(){
        driver.findElement(cancelButton).click();
    }

    public void goToCheckoutOverviewPage(){
        driver.findElement(continueButton).click();
    }
























}

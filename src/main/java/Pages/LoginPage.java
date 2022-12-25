package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public static WebDriver driver;

    public By usernameInputField= By.id("user-name");
    public By passwordInputField= By.name("password");
    public By loginButton= By.id("login-button");
    public By errorMessage= By.xpath("//*[contains(text(),'Epic sadface:')]");

    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    public void enterUsername(String textForUsername){
        driver.findElement(usernameInputField).sendKeys(textForUsername);
    }

    public void enterPassword(String textForPassword){
        driver.findElement(passwordInputField).sendKeys(textForPassword);
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String getErrorMsgText(){
        return driver.findElement(errorMessage).getText();
    }

}

package AppTests;

import Pages.LoginPage;
import Pages.ProductsPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;

public class FooterTests extends BaseTestSetUp{

    LoginPage loginPage= new LoginPage(driver);
    ProductsPage productsPage= new ProductsPage(driver);

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(5000);
    }

    @Test
    public void twitterRedirection() {
        String oldTab = driver.getWindowHandle();
        productsPage.clickOnTwitterLogo();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        String expectedURL= "https://twitter.com/saucelabs";
        String actualURL= driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue("We haven't been redirected to Twitter",expectedURL.equals(actualURL));
    }

    @Test
    public void facebookRedirection() {
        String oldTab = driver.getWindowHandle();
        productsPage.clickOnFacebookLogo();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        String expectedURL= "https://www.facebook.com/saucelabs";
        String actualURL= driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue("We haven't been redirected to Facebook",expectedURL.equals(actualURL));
    }

    @Test
    public void linkedinRedirection() throws InterruptedException {
        String oldTab = driver.getWindowHandle();
        productsPage.clickOnLinkedinLogo();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        Thread.sleep(3000);
        driver.switchTo().window(newTab.get(0));
        Thread.sleep(5000);
        String expectedURL= "https://www.linkedin.com/company/sauce-labs/";
        String actualURL= driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue("We haven't been redirected to Linkedin",expectedURL.equals(actualURL));
    }
}

//Assertion test for LinkedIn Redirection failed because it requires to be logged in
//with valid LinkedIn profile to see Sauce Labs page on LinkedIn.
//That's not the case with other social platforms like FB and Twitter!
//Therefore, test appears to be a failure, but actually it's not!
//I even tried with this loop:
//        if (actualURL.equals(expectedURL) || actualURL.equals(alternativeURL)){
//            System.out.println("LinkedIn redirection works just fine!");
//        }else System.out.println("LinkedIn redirection doesn't work properly for some reason!");
//Where I predefine alternativeURL as URL we get when LinkedIn redirect us on login page
//and that doesn't work because, I guess, code for switching to second TAB breaks for unexpected result on new tab
//and first tab can't be closed to complete the code! That is my guessing, not a fact.
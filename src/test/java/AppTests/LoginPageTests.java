package AppTests;

import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;

public class LoginPageTests extends BaseTestSetUp{

    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
    }

    @Test
    public void testLoginWithoutAnyCredentials() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage= "Epic sadface: Username is required";
        String actualErrorMessage= loginPage.getErrorMsgText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue("Error message is not adequate for login without credentials",expectedErrorMessage.equals(actualErrorMessage));

    }

    @Test
    public void testLoginWithoutUsernameAndCorrectPassword() {
        loginPage.enterUsername("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage= "Epic sadface: Username is required";
        String actualErrorMessage= loginPage.getErrorMsgText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue("Error message is not adequate for login without username and correct Password",expectedErrorMessage.equals(actualErrorMessage));
    }

    @Test
    public void testLoginWithoutUsernameAndFalsePassword() {
        loginPage.enterUsername("");
        loginPage.enterPassword("abcdefg");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage= "Epic sadface: Username is required";
        String actualErrorMessage= loginPage.getErrorMsgText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue("Error message is not adequate for login without username and false password",expectedErrorMessage.equals(actualErrorMessage));
    }

    @Test
    public void testLoginWithFasleUsernameAndWithoutPassword() {
        loginPage.enterUsername("edfjgknbedgk;d");
        loginPage.enterPassword("");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage= "Epic sadface: Password is required";
        String actualErrorMessage= loginPage.getErrorMsgText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue("Error message is not adequate for login with false username and no password",expectedErrorMessage.equals(actualErrorMessage));
    }

    @Test
    public void testLoginWithCorrectUsernameAndWithoutPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage= "Epic sadface: Password is required";
        String actualErrorMessage= loginPage.getErrorMsgText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue("Error message is not adequate for login with correct username and no password",expectedErrorMessage.equals(actualErrorMessage));
    }

    @Test
    public void testLoginWithCorrectUsernameAndFalsePassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("abcdefg");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage= "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage= loginPage.getErrorMsgText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue("Error message is not adequate for login with correct username and false password",expectedErrorMessage.equals(actualErrorMessage));
    }

    @Test
    public void testLoginWithFalseUsernameAndCorrectPassword() {
        loginPage.enterUsername("standarduser");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage= "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage= loginPage.getErrorMsgText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue("Error message is not adequate for login with false username and correct password",expectedErrorMessage.equals(actualErrorMessage));
    }

    @Test
    public void testLoginWithCorrectCredentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedURLafterLogin= "https://www.saucedemo.com/inventory.html";
        String actualURLafterLogin= driver.getCurrentUrl();
        System.out.println(actualURLafterLogin);
        Assert.assertTrue("Login attempt is not successfull", expectedURLafterLogin.equals(actualURLafterLogin));
    }
}

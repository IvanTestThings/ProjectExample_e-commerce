package AppTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTestSetUp {

    public static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();
    }
}


//Notice: I have written everything what it needs to be written for log out option and decided not to implement it because I haven't had any reason to do so!
// My thought was to place locator and method for logout option in productsPage and Select constructor in test page where's needed!

//    public By dropdownBox= By.id("react-burger-menu-btn");
//    Select dropdownMenu= new Select(driver.findElement(dropdownBox));

//    public void logoutFromApp(){
//        dropdownMenu.selectByVisibleText("Logout");
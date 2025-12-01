package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.loginPage;

public class initiateDriver {

    public WebDriver driver;
    public loginPage login;

    @BeforeMethod
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        login = new loginPage(driver);
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

}

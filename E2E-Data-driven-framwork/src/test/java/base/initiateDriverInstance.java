package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.utility;

public class initiateDriverInstance {
    
    public WebDriver driver;

    @BeforeMethod
    public void startBrowser(){
        
        if (utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome") ){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(utility.fetchPropertyValue("url").toString());

    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
    
}

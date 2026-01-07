package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.propertieReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class initiateDriver {

    public WebDriver driver;

    @BeforeMethod
    public void startBrowser() throws IOException {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();

        // Typical Windows path:
        options.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
        driver = new ChromeDriver(options);
        driver.get(propertieReader.appConfigReader("App_url"));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}

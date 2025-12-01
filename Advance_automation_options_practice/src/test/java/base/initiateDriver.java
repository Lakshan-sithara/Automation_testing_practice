package base;

import listener.driverUpdate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class initiateDriver {

    public WebDriver driver;

    @BeforeMethod
    public void startBrowser(){
        WebDriver originalDriver = new ChromeDriver();

        driverUpdate listner = new driverUpdate();
        driver = new EventFiringDecorator<>(listner).decorate(originalDriver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}

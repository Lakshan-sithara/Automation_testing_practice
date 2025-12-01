package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class TC_001 {
    public void tc_001(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        EventFiringDecorator eventDriver = new EventFiringDecorator((WebDriverListener) driver);
        DriverUpdate listner = new DriverUpdate;
    }
}

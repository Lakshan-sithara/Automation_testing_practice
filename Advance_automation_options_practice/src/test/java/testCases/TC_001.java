package testCases;

import base.initiateDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.Test;

public class TC_001 extends initiateDriver {

    @Test
    public void tc_001(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }
}

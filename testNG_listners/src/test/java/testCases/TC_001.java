package testCases;

import base.initializeBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TC_001 extends initializeBrowser {

    @Test
    public void tc_001(){
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    @Test
    public void tc_002(){
        List<WebElement> link = driver.findElements(By.xpath("//a"));
        System.out.println("Total number of links are: " + link.size());
    }
}

package testCases;

import base.initializeBrowser;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_001 extends initializeBrowser {

    @Test
    public void tc_001(){
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }
}

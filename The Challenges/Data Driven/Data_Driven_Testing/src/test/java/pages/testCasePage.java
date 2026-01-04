package pages;

import org.openqa.selenium.WebDriver;
import verify.compair;

public class testCasePage {

    WebDriver driver;

    public testCasePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyTestCasesPage(){
        compair.verifyTestCasesPage(driver,"https://automationexercise.com/test_cases");
    }
}

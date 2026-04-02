package pages;

import org.openqa.selenium.WebDriver;
import verify.Compair;

public class testCasePage {

    WebDriver driver;

    public testCasePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyTestCasesPage(){
        Compair.verifyTestCasesPage(driver,"https://automationexercise.com/test_cases");
    }
}

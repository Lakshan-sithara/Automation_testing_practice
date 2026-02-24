package testcases;

import base.InitiateDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.HomePage;

import java.io.IOException;

public class TC_26 extends InitiateDriver {
    @Test
    public void verifySchrollUpWithoutArrowButtonAndSchollDownFunctionality() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.validateSubscriptionText();
        js.executeScript("window.scrollTo(0, 0);");
        homePage.verifyPageIsScrolledUp();
        homePage.verifyFullFledgedPracticeWebsiteForAutomationEngineersText();
    }
}

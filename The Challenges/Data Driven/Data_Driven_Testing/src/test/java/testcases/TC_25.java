package testcases;

import base.InitiateDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.HomePage;

import java.io.IOException;

public class TC_25 extends InitiateDriver {

    @Test
    public void verifySchrollUpUsingArrowButtonAndSchollDownFunctionality() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.validateSubscriptionText();
        homePage.clickOnArrowAtBottomRightSide();
        homePage.verifyPageIsScrolledUp();
        homePage.verifyFullFledgedPracticeWebsiteForAutomationEngineersText();
    }

}

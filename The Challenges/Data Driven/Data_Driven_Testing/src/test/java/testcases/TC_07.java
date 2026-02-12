package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.testCasePage;

import java.io.IOException;

public class TC_07 extends InitiateDriver {

    @Test
    public void verifyTestCasePage() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickTestCaseButton();

        testCasePage testCasePage = new testCasePage(driver);
        testCasePage.verifyTestCasesPage();

    }

}

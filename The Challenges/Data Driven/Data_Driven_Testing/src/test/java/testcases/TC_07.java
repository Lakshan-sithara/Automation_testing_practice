package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.homePage;
import pages.testCasePage;

import java.io.IOException;

public class TC_07 extends initiateDriver {

    @Test
    public void verifyTestCasePage() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();
        homePage.clickTestCaseButton();

        testCasePage testCasePage = new testCasePage(driver);
        testCasePage.verifyTestCasesPage();

    }

}

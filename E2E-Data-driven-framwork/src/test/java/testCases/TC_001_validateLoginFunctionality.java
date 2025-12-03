package testCases;

import assertions.compair;
import base.initiateDriverInstance;
import org.testng.annotations.Test;
import pages.loginPage;

public class TC_001_validateLoginFunctionality extends initiateDriverInstance {

    @Test
    public void tc_001(){

        compair.compairtitle(driver,"https://practicetestautomation.com/practice-test-login/");
        compair.compairUrl(driver,"Test Login | Practice Test Automation");

        loginPage login = new loginPage(driver);
        login.enterUsername();
        login.enterPassword();
        login.clickSubmitButton();


    }

}

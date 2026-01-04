package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.homePage;

import java.io.IOException;

public class TC_05 extends initiateDriver {

    @Test
    public void registerUserWithExistingEmail() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();
        homePage.clickLoginSigninButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyNewUserSignupVisibility();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickSignUpButton();
        loginPage.verifyEmailAlreadyExistMessage();
    }

}

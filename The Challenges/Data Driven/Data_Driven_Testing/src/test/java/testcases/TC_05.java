package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

import java.io.IOException;

public class TC_05 extends initiateDriver {

    @Test
    public void registerUserWithExistingEmail() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickLoginSigninButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyNewUserSignupVisibility();
        loginPage.enterUsernameOnSignUp();
        loginPage.enterEmailOnSignUp();
        loginPage.clickSignUpButton();
        loginPage.verifyEmailAlreadyExistMessage();
    }

}

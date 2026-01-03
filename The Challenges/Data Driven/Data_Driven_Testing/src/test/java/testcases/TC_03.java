package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.homePage;

import java.io.IOException;

public class TC_03 extends initiateDriver {

    @Test
    public void loginUserWithInCorrectcredintials() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();
        homePage.clickLoginSigninButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();

        loginPage.enterEmailOnlogin();
        loginPage.enterPasswordOnlogin();
        loginPage.clickLoginButton();

        loginPage.verifyEmailOrPasswordIncorrectMessage();
    }

}

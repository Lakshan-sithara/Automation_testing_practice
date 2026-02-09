package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.loggedInHomePage;

import java.io.IOException;


public class TC_02 extends initiateDriver {

    @Test
    public void loginUserWithCorrectcredintials() throws IOException {

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickLoginSigninButton();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.enterEmailOnlogin();
        loginPage.enterPasswordOnlogin();
        loginPage.clickLoginButton();

        loggedInHomePage loggedInHomePage = new loggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();
        loggedInHomePage.clickDeleteButton();
        loggedInHomePage.accountDeletedPage();
    }

}

package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.loggedInHomePage;

import java.io.IOException;

public class TC_04 extends initiateDriver {

    @Test
    public void logOutUser() throws IOException {
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
        loggedInHomePage.clickLogoutButton();

        loginPage.verifyLoginPage();



    }

}

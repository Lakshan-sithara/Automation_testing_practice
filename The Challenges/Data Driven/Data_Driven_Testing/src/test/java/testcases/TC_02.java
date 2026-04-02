package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.LoggedInHomePage;

import java.io.IOException;


public class TC_02 extends InitiateDriver {

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

        LoggedInHomePage loggedInHomePage = new LoggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();
        loggedInHomePage.clickDeleteButton();
        loggedInHomePage.accountDeletedPage();
    }

}

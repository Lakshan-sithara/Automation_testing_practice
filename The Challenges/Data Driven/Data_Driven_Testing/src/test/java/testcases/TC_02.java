package testcases;

import base.initiateDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.homePage;
import pages.loggedInHomePage;


public class TC_02 extends initiateDriver {

    @Test
    public void loginUserWithCorrectcredintials(){

        homePage homePage = new homePage(driver);
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

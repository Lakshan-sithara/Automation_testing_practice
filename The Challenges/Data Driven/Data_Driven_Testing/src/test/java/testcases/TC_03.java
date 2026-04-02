package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

import java.io.IOException;

public class TC_03 extends InitiateDriver {

    @Test
    public void loginUserWithInCorrectcredintials() throws IOException {
        HomePage homePage = new HomePage(driver);
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

package testcases;


import base.initiateDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AccountInformationFormPage;
import pages.HomePage;
import pages.LoggedInHomePage;

import java.io.IOException;

public class TC_01 extends initiateDriver {



    @Test
    public void testUserCanLogin() throws IOException {

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickLoginSigninButton();


        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsernameOnSignUp();
        loginPage.enterEmailOnSignUp();
        loginPage.clickSignUpButton();
        //Assert.assertTrue(homePage.isHomePageDisplayed());

        AccountInformationFormPage AIFPage = new AccountInformationFormPage(driver);
        AIFPage.verifyTitleVisibility();
        AIFPage.fillRegistrationForm();
        AIFPage.verifyAccountCreatedAndClickContinueButton();

        LoggedInHomePage loggedInHomePage = new LoggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();
        /*loggedInHomePage.clickDeleteButton();
        loggedInHomePage.accountDeletedPage();*/

    }

}

package testcases;


import base.initiateDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.accountInformationFormPage;
import pages.HomePage;
import pages.loggedInHomePage;

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

        accountInformationFormPage AIFPage = new accountInformationFormPage(driver);
        AIFPage.verifyTitleVisibility();
        AIFPage.fillRegistrationForm();
        AIFPage.verifyAccountCreatedAndClickContinueButton();

        loggedInHomePage loggedInHomePage = new loggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();
        /*loggedInHomePage.clickDeleteButton();
        loggedInHomePage.accountDeletedPage();*/

    }

}

package testcases;


import base.initiateDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.accountInformationFormPage;
import pages.homePage;
import pages.loggedInHomePage;

import java.io.IOException;

public class TC_01 extends initiateDriver {



    @Test
    public void testUserCanLogin() throws IOException {

        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();
        homePage.clickLoginSigninButton();


        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickSignUpButton();
        //Assert.assertTrue(homePage.isHomePageDisplayed());

        accountInformationFormPage AIFPage = new accountInformationFormPage(driver);
        AIFPage.verifyTitleVisibility();
        AIFPage.fillRegistrationForm();
        AIFPage.continueButton();

        loggedInHomePage loggedInHomePage = new loggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();
        /*loggedInHomePage.clickDeleteButton();
        loggedInHomePage.accountDeletedPage();*/

    }

}

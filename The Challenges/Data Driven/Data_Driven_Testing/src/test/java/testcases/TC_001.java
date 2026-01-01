package testcases;


import base.initiateDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.accountInformationFormPage;
import pages.homePage;
import pages.loggedInHomePage;
import verify.compair;

public class TC_001 extends initiateDriver {

    boolean homePageUrl;

    @Test
    public void testUserCanLogin(){

        homePageUrl = compair.verifyHomePageVisibility(driver,"https://automationexercise.com/");
        Assert.assertTrue(homePageUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.isHomePageDisplayed());

        accountInformationFormPage AIFPage = new accountInformationFormPage(driver);
        AIFPage.verifyTitleVisibility();
        AIFPage.fillRegistrationForm();
        AIFPage.continueButton();

        loggedInHomePage loggedInHomePage = new loggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();
        loggedInHomePage.clickDeleteButton();
        loggedInHomePage.accountDeletedPage();

    }

}

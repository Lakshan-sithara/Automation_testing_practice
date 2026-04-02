package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.contactUsPage;
import pages.HomePage;

import java.io.IOException;

public class TC_06 extends InitiateDriver {

    @Test
    public void contactUsForm() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickContactUsButton();

        contactUsPage contactUsPage = new contactUsPage(driver);
        contactUsPage.enterName();
        contactUsPage.enterEmail();
        contactUsPage.enterSubject();
        contactUsPage.enterMessage();
        contactUsPage.uploadDocument();
        contactUsPage.clickSubmitButton();
        contactUsPage.clickOkInPopUp();
        contactUsPage.verifySuccessMessage();
        contactUsPage.clickHomeButton();

        homePage.verifyHomePage();

    }

}

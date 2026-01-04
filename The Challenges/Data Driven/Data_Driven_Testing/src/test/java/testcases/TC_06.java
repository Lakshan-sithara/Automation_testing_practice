package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.contactUsPage;
import pages.homePage;

import java.io.IOException;

public class TC_06 extends initiateDriver {

    @Test
    public void contactUsForm() throws IOException {
        homePage homePage = new homePage(driver);
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

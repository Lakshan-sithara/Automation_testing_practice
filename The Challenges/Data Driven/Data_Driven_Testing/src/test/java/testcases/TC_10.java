package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.homePage;

import java.io.IOException;

public class TC_10 extends initiateDriver {

    @Test
    public void verifySubscriptionInHomePage() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.scrollToBottom();
        allProductPage.validateSubscriptionText();
        allProductPage.enterEmailOnSubscription();
        allProductPage.clickOnSubscribeArrowButton();
        allProductPage.verifySubscribeSuccessText();
    }

}

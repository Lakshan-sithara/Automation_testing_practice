package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.homePage;

import java.io.IOException;

public class TC_11 extends initiateDriver {

    @Test
    public void verifySubscriptionInCartPage() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();
        homePage.clickCartButton();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.scrollToBottom();
        allProductPage.validateSubscriptionText();
        allProductPage.enterEmailOnSubscription();
        allProductPage.clickOnSubscribeArrowButton();
        allProductPage.verifySubscribeSuccessText();

    }

}

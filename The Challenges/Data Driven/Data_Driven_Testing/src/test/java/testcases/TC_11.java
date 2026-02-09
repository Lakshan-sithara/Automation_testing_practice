package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.HomePage;

import java.io.IOException;

public class TC_11 extends initiateDriver {

    @Test
    public void verifySubscriptionInCartPage() throws IOException {
        HomePage homePage = new HomePage(driver);
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

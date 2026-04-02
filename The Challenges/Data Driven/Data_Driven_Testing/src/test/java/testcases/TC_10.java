package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.HomePage;

import java.io.IOException;

public class TC_10 extends InitiateDriver {

    @Test
    public void verifySubscriptionInHomePage() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.scrollToBottom();
        allProductPage.validateSubscriptionText();
        allProductPage.enterEmailOnSubscription();
        allProductPage.clickOnSubscribeArrowButton();
        allProductPage.verifySubscribeSuccessText();
    }

}

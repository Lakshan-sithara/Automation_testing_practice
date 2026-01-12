package testcases;

import base.initiateDriver;
import library.jsonDataReader;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC_16 extends initiateDriver {

    @Test
    public void placeOrderLoginBeforeCheckout() throws IOException {

        // load all data from JSON
        Map<String,Object> allData = jsonDataReader.getTestData();

        // extract specific hashMap
        HashMap<String,String> addressDetails = (HashMap<String, String>) allData.get("addressDetails");
        HashMap<String,String> paymentDetails = (HashMap<String, String>) allData.get("paymentDetails");

        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();
        homePage.clickLoginSigninButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOnlogin();
        loginPage.enterPasswordOnlogin();
        loginPage.clickLoginButton();

        loggedInHomePage loggedInHomePage= new loggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.hoverOverItemAndAddToCart("Blue Top");

        homePage.clickCartButton();

        cartPage cartPage= new cartPage(driver);
        cartPage.verifyCartPage();
        cartPage.clickCheckoutButton();

        checkOutPage checkOutPage = new checkOutPage(driver);
        checkOutPage.verifyAddressDetailsAndReviewOrder(addressDetails);

        checkOutPage.enterDiscriptionOnTextArea();
        checkOutPage.clickPlaceOrderButton();

        paymentPage paymentPage = new paymentPage(driver);
        paymentPage.enterPaymentDetails(paymentDetails);
        paymentPage.clickPayAndConfirmOrderButton();
        paymentPage.verifySucessMessage();
        paymentPage.clickDeleteAccountButton();
        paymentPage.verifyDeleteAccountMessage();




    }

}

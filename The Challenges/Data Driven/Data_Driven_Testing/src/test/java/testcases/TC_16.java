package testcases;

import base.InitiateDriver;
import library.jsonDataReader;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC_16 extends InitiateDriver {

    @Test
    public void placeOrderLoginBeforeCheckout() throws IOException {

        // load all data from JSON
        Map<String,Object> allData = jsonDataReader.getTestData();

        // extract specific hashMap
        HashMap<String,String> addressDetails = (HashMap<String, String>) allData.get("addressDetails");
        HashMap<String,String> paymentDetails = (HashMap<String, String>) allData.get("paymentDetails");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickLoginSigninButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOnlogin();
        loginPage.enterPasswordOnlogin();
        loginPage.clickLoginButton();

        LoggedInHomePage loggedInHomePage= new LoggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.hoverOverItemAndAddToCart("Blue Top");

        homePage.clickCartButton();

        CartPage cartPage= new CartPage(driver);
        cartPage.verifyCartPage();
        cartPage.clickCheckoutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.verifyDelivaryAddressDetailsAndReviewOrder(addressDetails);

        checkOutPage.enterDiscriptionOnTextArea();
        checkOutPage.clickPlaceOrderButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterPaymentDetails(paymentDetails);
        paymentPage.clickPayAndConfirmOrderButton();
        paymentPage.verifySucessMessage();
        paymentPage.clickDeleteAccountButton();
        paymentPage.verifyDeleteAccountMessage();




    }

}

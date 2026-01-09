package testcases;

import base.initiateDriver;
import library.jsonDataReader;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC_14 extends initiateDriver {

    @Test
    public void placeOrder_RegisterWhileCheckout() throws IOException, InterruptedException {

        Map<String,Object> allData = jsonDataReader.getTestData();

        HashMap<String,String> addressDetails = (HashMap<String, String>) allData.get("addressDetails");
        HashMap<String,String> paymentDetails = (HashMap<String, String>) allData.get("paymentDetails");

        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.hoverOverItemAndAddToCart("Blue Top");
        Thread.sleep(2000);

        allProductPage.clickViewCartButton();

        cartPage cartPage = new cartPage(driver);
        cartPage.verifyCartPage();
        cartPage.clickCheckoutButton();
        cartPage.clickRegisterAndLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameOnSignUp();
        loginPage.enterEmailOnSignUp();
        loginPage.clickSignUpButton();

        accountInformationFormPage accountInformationFormPage = new accountInformationFormPage(driver);
        accountInformationFormPage.fillRegistrationForm();
        accountInformationFormPage.verifyAccountCreatedAndClickContinueButton();

        loggedInHomePage loggedInHomePage = new loggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();

        homePage.clickCartButton();
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
        paymentPage.clickContinueButtonInAccountDelete();

    }

}

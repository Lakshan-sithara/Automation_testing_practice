package testcases;

import base.InitiateDriver;
import library.jsonDataReader;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC_14 extends InitiateDriver {

    @Test
    public void placeOrder_RegisterWhileCheckout() throws IOException, InterruptedException {

        Map<String,Object> allData = jsonDataReader.getTestData();

        HashMap<String,String> addressDetails = (HashMap<String, String>) allData.get("addressDetails");
        HashMap<String,String> paymentDetails = (HashMap<String, String>) allData.get("paymentDetails");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.hoverOverItemAndAddToCart("Blue Top");
        Thread.sleep(2000);

        allProductPage.clickViewCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyCartPage();
        cartPage.clickCheckoutButton();
        cartPage.clickRegisterAndLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameOnSignUp();
        loginPage.enterEmailOnSignUp();
        loginPage.clickSignUpButton();

        AccountInformationFormPage accountInformationFormPage = new AccountInformationFormPage(driver);
        accountInformationFormPage.fillRegistrationFormAndContinue();
        accountInformationFormPage.verifyAccountCreatedAndClickContinueButton();

        LoggedInHomePage loggedInHomePage = new LoggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();

        homePage.clickCartButton();
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
        paymentPage.clickContinueButton();

    }

}

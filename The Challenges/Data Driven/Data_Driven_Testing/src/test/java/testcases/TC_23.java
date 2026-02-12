package testcases;

import base.initiateDriver;
import library.jsonDataReader;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC_23 extends initiateDriver {

    @Test
    public void verifyAddressDetailsInCheckoutPage() throws IOException {

        // load all data from JSON
        Map<String,Object> allData = jsonDataReader.getTestData();
        // extract specific hashMap
        HashMap<String,String> addressDetails = (HashMap<String, String>) allData.get("addressDetails");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickLoginSigninButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameOnSignUp();
        loginPage.enterEmailOnSignUp();
        loginPage.clickSignUpButton();

        AccountInformationFormPage accountInformationFormPage = new AccountInformationFormPage(driver);
        accountInformationFormPage.fillRegistrationForm();
        accountInformationFormPage.verifyAccountCreatedAndClickContinueButton();

        LoggedInHomePage loggedInHomePage = new LoggedInHomePage(driver);
        loggedInHomePage.verifyUsernameIsVisible();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.hoverOverItemAndAddToCart("Blue Top");
        allProductPage.clickViewCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyCartPage();
        cartPage.clickCheckoutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.verifyDelivaryAddressDetailsAndReviewOrder(addressDetails);

        loggedInHomePage.clickDeleteButton();
        loggedInHomePage.accountDeletedPage();

    }

}

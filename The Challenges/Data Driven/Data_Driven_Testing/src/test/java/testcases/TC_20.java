package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.LoginPage;
import pages.homePage;

import java.io.IOException;

public class TC_20 extends initiateDriver {

    @Test
    public void searchProductAndVerifyCartAfterLogin() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.clickProductButton();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.verifyAllProductPage();
        allProductPage.enterDataOnSearchBar("tshirt");
        allProductPage.clickSearchButton();
        allProductPage.verifySearchedItemsAreVisible();
        allProductPage.addAllSearchedProductsToCart();

        homePage.clickCartButton();
        allProductPage.verifySearchedItemsAreVisible();

        homePage.clickLoginSigninButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOnlogin();
        loginPage.enterPasswordOnlogin();
        loginPage.clickLoginButton();

        homePage.clickCartButton();
        allProductPage.verifySearchedItemsAreVisible();
    }

}

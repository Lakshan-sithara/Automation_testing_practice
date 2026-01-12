package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.cartPage;
import pages.homePage;

import java.io.IOException;

public class TC_17 extends initiateDriver {

    @Test
    public void removeProductFromCart() throws IOException {

        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.hoverOverItemAndAddToCart("Blue Top");
        allProductPage.clickContinueShippingButton();
        allProductPage.hoverOverItemAndAddToCart("Men Tshirt");
        allProductPage.clickViewCartButton();

        cartPage cartPage = new cartPage(driver);
        cartPage.verifyCartPage();
        cartPage.removeProductAndVerify("Blue Top");


    }

}

package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.CartPage;
import pages.HomePage;

import java.io.IOException;

public class TC_17 extends InitiateDriver {

    @Test
    public void removeProductFromCart() throws IOException {

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.hoverOverItemAndAddToCart("Blue Top");
        allProductPage.clickContinueShoppingButton();
        allProductPage.hoverOverItemAndAddToCart("Men Tshirt");
        allProductPage.clickViewCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyCartPage();
        cartPage.removeProductAndVerify("Blue Top");


    }

}

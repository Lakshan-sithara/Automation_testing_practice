package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;

import java.io.IOException;

public class TC_13 extends InitiateDriver {

    @Test
    public void verifyProductQuntityInCart() throws IOException {

        String productName = "Blue Top";
        int productQuantity = 4;

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickViewProductOnItem(productName);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.verifyProductDetailsPage(productName);
        productDetailsPage.setQuantity(productQuantity);
        productDetailsPage.clickAddToCartButton();
        productDetailsPage.clickViewCartButton();
        productDetailsPage.validateProductQuantity(String.valueOf(productQuantity));


    }

}

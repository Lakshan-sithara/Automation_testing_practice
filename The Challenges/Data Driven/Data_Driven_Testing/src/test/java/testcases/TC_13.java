package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.homePage;
import pages.ProductDetailsPage;

import java.io.IOException;

public class TC_13 extends initiateDriver {

    @Test
    public void verifyProductQuntityInCart() throws IOException {

        String productName = "Blue Top";
        int productQuantity = 4;

        homePage homePage = new homePage(driver);
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

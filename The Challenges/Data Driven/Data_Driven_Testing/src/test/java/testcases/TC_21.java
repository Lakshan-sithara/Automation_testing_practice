package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.ProductDetailsPage;
import pages.homePage;

import java.io.IOException;

public class TC_21 extends initiateDriver {

    @Test
    public void addReviewOnProduct() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.clickProductButton();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.verifyAllProductPage();
        allProductPage.clickViewProductButton("Blue Top");

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.verifyWriteYourReviewText();
        productDetailsPage.enterNameOnReview("lakshan");
        productDetailsPage.enterEmailOnReview("aa@aa.mm");
        productDetailsPage.enterDetailsOnReviewSection("this is good product !");
        productDetailsPage.clickReviewSubmitButton();
        productDetailsPage.verifyReviewSuccessMessage();

    }

}

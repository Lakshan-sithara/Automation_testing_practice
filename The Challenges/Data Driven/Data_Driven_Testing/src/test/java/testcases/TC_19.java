package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.homePage;

import java.io.IOException;

public class TC_19 extends initiateDriver {

    @Test
    public void viewAndCartBrandProducts() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.clickProductButton();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.verifyBrandText();
        allProductPage.clickBrand("polo");
        allProductPage.verifyBrandTitleTextAndBrandProductsAreDisplayed();
        allProductPage.clickBrand("Allen Solly Junior");
    }

}

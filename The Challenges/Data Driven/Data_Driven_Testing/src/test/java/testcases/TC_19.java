package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.HomePage;

import java.io.IOException;

public class TC_19 extends InitiateDriver {

    @Test
    public void viewAndCartBrandProducts() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.clickProductButton();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.verifyBrandText();
        allProductPage.clickBrand("polo");
        allProductPage.verifyBrandTitleTextAndBrandProductsAreDisplayed();
        allProductPage.clickBrand("Allen Solly Junior");
    }

}

package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.HomePage;

import java.io.IOException;

public class TC_09 extends InitiateDriver {

    @Test
    public void searchProduct() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickProductButton();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.verifyAllProductPage();
        allProductPage.enterDataOnSearchBar("tshirt");
        allProductPage.clickSearchButton();
        allProductPage.verifySearchedItemsAreVisible();
    }

}

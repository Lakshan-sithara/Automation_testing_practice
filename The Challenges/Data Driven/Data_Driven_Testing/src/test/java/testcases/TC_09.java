package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.homePage;

import java.io.IOException;

public class TC_09 extends initiateDriver {

    @Test
    public void searchProduct() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();
        homePage.clickProductButton();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.verifyAllProductPage();
        allProductPage.enterDataOnSearchBar("tshirt");
        allProductPage.clickSearchButton();
        allProductPage.verifySearchedItemsAreVisible();
    }

}

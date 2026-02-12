package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.HomePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC_08 extends InitiateDriver {

    @Test
    public void verifyAllProductsAndProductDetailPage() throws IOException {

        // 1. Initialize the Map with expected data for "Blue Top"
        Map<String, String> expectedData = new HashMap<>();
        expectedData.put("name", "Blue Top");
        expectedData.put("category", "Women > Tops");
        expectedData.put("price", "Rs. 500");
        expectedData.put("availability", "In Stock");
        expectedData.put("condition", "New");
        expectedData.put("brand", "Polo");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickProductButton();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.verifyAllProductPage();
        allProductPage.clickOnFirstProductButton();
        allProductPage.validateProductPageDetails(expectedData);
    }

}

package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.CartPage;
import pages.HomePage;

import java.io.IOException;
import java.util.HashMap;

public class TC_22 extends InitiateDriver {



    @Test
    public void addToCartFromRecommendedItem() throws IOException {

        HashMap<String,String> itemsDetails = new HashMap<>();
        itemsDetails.put("Item1Name","Blue Top");

        HomePage homePage = new HomePage(driver);
        homePage.verifyRecommendedItemText();
        homePage.addRecommendedItemToCart();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.clickViewCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyItemAddedToCart(itemsDetails);
    }

}

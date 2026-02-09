package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.AllProductPage;
import pages.CartPage;
import pages.HomePage;

import java.io.IOException;
import java.util.HashMap;

public class TC_12 extends initiateDriver {

    @Test
    public void addProductInCart() throws IOException {

        int item1_price = 500;
        int item1_quantity = 1;
        int item2_price = 400;
        int item2_quantity = 1;

        HashMap<String,String> itemsDetails = new HashMap<>();
        itemsDetails.put("Item1Name","Blue Top");
        itemsDetails.put("Item2Name","Men Tshirt");
        itemsDetails.put("Item1price","Rs. "+item1_price);
        itemsDetails.put("Item1quantity",String.valueOf(item1_quantity));
        itemsDetails.put("Item1total_price","Rs. "+(item1_price*item1_quantity));
        itemsDetails.put("Item2price","Rs. "+item2_price);
        itemsDetails.put("Item2quantity",String.valueOf(item2_quantity));
        itemsDetails.put("Item2total_price","Rs. "+item2_price*item2_quantity);

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.clickProductButton();

        AllProductPage allProductPage = new AllProductPage(driver);
        allProductPage.hoverOverItemAndAddToCart(itemsDetails.get("Item1Name"));
        allProductPage.clickContinueShoppingButton();
        allProductPage.hoverOverItemAndAddToCart(itemsDetails.get("Item2Name"));
        allProductPage.clickViewCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyItemAddedToCart(itemsDetails);
        //validate first item details
        cartPage.validateProductDetails(itemsDetails.get("Item1price"),itemsDetails.get("Item1quantity"),
                itemsDetails.get("Item1Name"),itemsDetails.get("Item1total_price"));

        //validate second item details
        cartPage.validateProductDetails(itemsDetails.get("Item2price"),itemsDetails.get("Item2quantity"),
                itemsDetails.get("Item2Name"),itemsDetails.get("Item2total_price"));

    }

}

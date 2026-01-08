package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import verify.compair;

import java.util.HashMap;

public class cartPage {

    WebDriver driver;

    By item1ElementPriceXpath = By.xpath("");

    public cartPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyItemAddedToCart(HashMap <String,String> ItemName){
        compair.verifyAddedCartItems(driver,ItemName.get("Item1Name"));
        compair.verifyAddedCartItems(driver, ItemName.get("Item2Name"));
    }

    public void validateProductDetails(String price,String quantity,String itemName,String total_price){
        compair compair = new compair();

        compair.validateCartItemDetails(driver.findElement(By.xpath("//p[text()='"+price+"']")),price,"price");
        compair.validateCartItemDetails(driver.findElement(By.xpath("//a[text()='"+itemName+"']/parent::h4/parent::td/following-sibling::td/button[text()='"+quantity+"']")),
                quantity,"quantity" );
        compair.validateProductDetails(driver.findElement(By.xpath("//a[text()='"+itemName+"']/parent::h4/parent::td/following-sibling::td/p[@class='cart_total_price']")),
                total_price,"total price");

        compair.assertcartDetails();
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import verify.compair;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;


    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifyCartPage(){
        compair.verifyCartPage(driver);
    }

    public void verifyItemAddedToCart(HashMap <String,String> ItemName){
        for (Map.Entry<String, String> entry : ItemName.entrySet()) {
            String item = entry.getValue();
            if (item != null) {
                compair.verifyAddedCartItems(driver, item);
            }
        }
    }

    public void validateProductDetails(String price,String quantity,String itemName,String total_price){
        compair compair = new compair();

        compair.compairDetails(driver.findElement(By.xpath("//p[text()='"+price+"']")),price,"price");
        compair.compairDetails(driver.findElement(By.xpath("//a[text()='"+itemName+"']/parent::h4/parent::td/following-sibling::td/button[text()='"+quantity+"']")),
                quantity,"quantity" );
        compair.validateProductDetails(driver.findElement(By.xpath("//a[text()='"+itemName+"']/parent::h4/parent::td/following-sibling::td/p[@class='cart_total_price']")),
                total_price,"total price");

        compair.assertcartDetails();
    }

    public void clickCheckoutButton(){
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
    }

    public void clickRegisterAndLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//u[text()='Register / Login']")))).click();
    }

    public void removeProductAndVerify(String productName){
        driver.findElement(By.xpath("//a[text()='"+productName+"']/parent::h4/parent::td/following-sibling::td/a[@class='cart_quantity_delete']")).click();
        compair.verifyRemovedProduct(driver,productName);
    }


}

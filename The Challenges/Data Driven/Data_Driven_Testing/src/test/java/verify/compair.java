package verify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class compair {

    SoftAssert softAssert = new SoftAssert();

    public static boolean verifyHomePageVisibility(WebDriver driver,String url){

        boolean result = false;
        if (driver.getCurrentUrl().equalsIgnoreCase(url)){
            result = true;
        }

        return result;
    }

    public static boolean verifyNewUserSignupVisible(WebDriver driver, String actualValue){

        boolean result = false;

        if (driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText().equalsIgnoreCase(actualValue)){
            result = true;
        }

        return result;

    }

    public static boolean verifyLoginToYourAccountText(WebDriver driver){
        boolean result = false;
        if (driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed()){
            result = true;
        }
        return result;
    }

    public static boolean verifyEnterAccountInformationTextVisible(WebDriver driver){

        boolean result = driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();

        return result;

    }

    public static boolean verifyAccountCreatedText(WebDriver driver){

        boolean result = driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();

        return result;

    }

    public static boolean isUserLoggedInAs(WebDriver driver, String username) {
        try {
            // This looks for the anchor tag that contains BOTH the label and the bold username
            String xpathExpression = "//a[contains(., 'Logged in as') and .//b[text()='" + username + "']]";
            return driver.findElement(By.xpath(xpathExpression)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verifyAccountDeletedText(WebDriver driver){

        boolean result = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
        return result;

    }

    public static boolean verifyEmailOrPasswordIncorrectErrorText(WebDriver driver){
        boolean result = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).isDisplayed();
        return result;
    }

    public static boolean verifyEmailAlreadyExistMessage(WebDriver driver){
        return driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed();
    }

    public static boolean verifySucsessMessageInContactUs(WebDriver driver){
        boolean result = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed();
        return result;
    }

    public static boolean verifyTestCasesPage(WebDriver driver, String url){
        boolean result = false;
        if (driver.getCurrentUrl().equalsIgnoreCase(url)){
            result = true;
        }
        return result;
    }

    public static boolean verifyAllProductPage(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement allProductText = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"))));
        return allProductText.isDisplayed();
    }

    public void validateProductDetails(WebElement element,String expectedValue,String fieldName){
        String actualValue = element.getText().trim();
        softAssert.assertEquals(actualValue,expectedValue,fieldName + "mismatch!");
    }

    public void assertAllDetails(){
        softAssert.assertAll();
    }

    public void verifySearchItems(WebDriver driver,String productName){

        String lowerCaseName = productName.toLowerCase();

        List<WebElement> searchItems = driver.findElements(By.xpath("//p[contains(translate(.," +
                " 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"+lowerCaseName+"')]"));

        if (searchItems.isEmpty()){
            System.out.println("No product found matching: " + productName);
        } else {
            System.out.println("Found " + searchItems.size() + " items.");
        }
    }

    public static boolean verifySubscriptionText(WebDriver driver){
        boolean result = driver.findElement(By.xpath("//h2[contains(.,'Subscription')]")).isDisplayed();
        return result;
    }

    public static boolean verifySubscribeSuccessfullMessage(WebDriver driver){
        return driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']")).isDisplayed();
    }

    public static boolean verifyAddedCartItems(WebDriver driver,String itemName){
        boolean result = false;


            if (driver.findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed()){
                System.out.println(itemName+" is in the cart! ");
                result = true;
            }
            else {
                System.out.println(itemName+" is not in the cart! ");
            }



        return result;
    }

    public void validateCartItemDetails(WebElement element,String expectedValue,String fieldName){
        String actualValue = element.getText().trim();
        softAssert.assertEquals(actualValue,expectedValue,fieldName + "mismatch!");
    }
    public void assertcartDetails(){
        softAssert.assertAll();
    }

    public static boolean verifyProductDetailsPage(WebDriver driver,String itemName){
        boolean result = driver.findElement(By.xpath("//h2[text()='"+itemName+"']")).isDisplayed();
        return result;
    }

}

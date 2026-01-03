package verify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class compair {

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

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import verify.compair;

import java.time.Duration;

public class loggedInHomePage {

    WebDriver driver;
    WebDriverWait wait;
    boolean verifyUsernameResult;
    boolean accountDeletedResult;

    //Refactored selecters
    By deleteaccount_text_xpath = By.xpath("//a[@href='/delete_account']");
    By continue_button_xpath = By.xpath("//a[text()='Continue']");

    public loggedInHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifyUsernameIsVisible(){
        verifyUsernameResult=compair.isUserLoggedInAs(driver,"abc");
        Assert.assertTrue(verifyUsernameResult);
    }

    public void clickDeleteButton(){

        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(deleteaccount_text_xpath)));
        deleteButton.click();
    }

    public void accountDeletedPage(){
         accountDeletedResult = compair.verifyAccountDeletedText(driver);
         Assert.assertTrue(accountDeletedResult);

         driver.findElement(continue_button_xpath).click();
    }

}

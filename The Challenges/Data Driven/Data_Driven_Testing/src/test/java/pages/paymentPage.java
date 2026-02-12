package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import verify.Compair;

import java.time.Duration;
import java.util.HashMap;

public class paymentPage {
    WebDriver driver;
    WebDriverWait wait;

    public paymentPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterPaymentDetails(HashMap<String,String> paymentDetails){
        driver.findElement(By.name("name_on_card")).sendKeys(paymentDetails.get("nameOnCard"));
        driver.findElement(By.name("card_number")).sendKeys(paymentDetails.get("cardNumber"));
        driver.findElement(By.name("cvc")).sendKeys(paymentDetails.get("CVC"));
        driver.findElement(By.name("expiry_month")).sendKeys(paymentDetails.get("Emonth"));
        driver.findElement(By.name("expiry_year")).sendKeys(paymentDetails.get("Eyear"));
    }

    public void clickPayAndConfirmOrderButton(){
        driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']")).click();
    }

    public void verifySucessMessage(){
        Assert.assertTrue(Compair.verifyOrderPlaceSuccessMessage(driver));
    }

    public void clickDeleteAccountButton(){
        WebElement deleteAcountBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/delete_account']"))));
        deleteAcountBtn.click();
    }

    public void verifyDeleteAccountMessage(){
        Compair.verifyAccountDeletedText(driver);
    }

    public void clickContinueButtonInAccountDelete(){
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }

}

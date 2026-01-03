package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import verify.compair;

import java.time.Duration;

public class homePage {

    WebDriver driver;
    boolean homePageUrl;
    WebDriverWait wait;
    By loginButton = By.xpath("//a[@href='/login']");

    public homePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickLoginSigninButton() {
        WebElement loginlink = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginlink.click();
    }

    public void verifyHomePage() {
        homePageUrl = compair.verifyHomePageVisibility(driver,"https://automationexercise.com/");
        Assert.assertTrue(homePageUrl);
    }


}

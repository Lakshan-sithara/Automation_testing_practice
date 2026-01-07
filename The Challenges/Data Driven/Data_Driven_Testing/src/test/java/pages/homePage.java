package pages;

import library.propertieReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import verify.compair;

import java.io.IOException;
import java.time.Duration;

public class homePage {

    WebDriver driver;
    boolean homePageUrl;
    WebDriverWait wait;
    By loginButton = By.xpath(propertieReader.appConfigReader("loginButton_xpath"));
    By contactUsButton = By.xpath(propertieReader.appConfigReader("contactUs_button_xpath"));
    By testCasesButton = By.xpath(propertieReader.appConfigReader("testCasesButton_xpath"));
    By productButton = By.xpath(propertieReader.appConfigReader("productButton_xpath"));
    By cartButton = By.xpath(propertieReader.appConfigReader("cartButton_xpath"));


    public homePage(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickLoginSigninButton() {
        WebElement loginlink = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginlink.click();
    }

    public void verifyHomePage() throws IOException {
        homePageUrl = compair.verifyHomePageVisibility(driver,propertieReader.appConfigReader("App_url"));
        Assert.assertTrue(homePageUrl);
    }

    public void clickContactUsButton(){
        WebElement contactUsBtn = wait.until(ExpectedConditions.elementToBeClickable(contactUsButton));
        contactUsBtn.click();
    }

    public void clickTestCaseButton(){
        driver.findElement(testCasesButton).click();
    }

    public void clickProductButton(){
        WebElement productBtn = wait.until(ExpectedConditions.elementToBeClickable(productButton));
        productBtn.click();
    }

    public void clickCartButton(){
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartBtn.click();
    }


}

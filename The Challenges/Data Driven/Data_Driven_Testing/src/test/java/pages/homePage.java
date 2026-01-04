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
    By testCasesButton = By.xpath(propertieReader.appConfigReader("testCasesButton"));

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


}

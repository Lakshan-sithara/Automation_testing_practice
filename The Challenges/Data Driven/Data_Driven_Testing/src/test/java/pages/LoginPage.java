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

public class LoginPage {

    public WebDriver driver;
    WebDriverWait wait;
    boolean visibleText;

    //Refactored selecters

    By username_textbox_xpath = By.xpath(propertieReader.appConfigReader("username_textbox_xpath"));
    By password_textbox_xpath = By.xpath(propertieReader.appConfigReader("password_textbox_xpath"));
    By signup_button_xpath = By.xpath(propertieReader.appConfigReader("signup_button_xpath"));
    By login_username_textbox_xpath = By.xpath(propertieReader.appConfigReader("login_username_textbox_xpath"));
    By login_password_textbox_xpath = By.xpath(propertieReader.appConfigReader("login_password_textbox_xpath"));
    By login_button_xpath = By.xpath(propertieReader.appConfigReader("login_button_xpath"));


    public LoginPage(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void checkNewUserSignupVisibility(){
        visibleText = compair.verifyNewUserSignupVisible(driver,"New User Signup!");
        Assert.assertTrue(visibleText);
    }

    public void verifyLoginPage(){
        boolean result = compair.verifyLoginToYourAccountText(driver);
        Assert.assertTrue(result);
    }

    public void verifyEmailOrPasswordIncorrectMessage(){
        boolean result = compair.verifyEmailOrPasswordIncorrectErrorText(driver);
        Assert.assertTrue(result);
    }

    public void enterUsername() throws IOException {
        driver.findElement(username_textbox_xpath).sendKeys(propertieReader.appConfigReader("signInUsername"));
    }

    public void enterPassword() throws IOException {
        driver.findElement(password_textbox_xpath).sendKeys(propertieReader.appConfigReader("signInPassword"));
    }

    public void clickSignUpButton(){
        driver.findElement(signup_button_xpath).click();
    }

    public void enterEmailOnlogin() throws IOException {
        driver.findElement(login_username_textbox_xpath).sendKeys(propertieReader.appConfigReader("loginEmail"));
    }

    public void enterPasswordOnlogin() throws IOException {
        driver.findElement(login_password_textbox_xpath).sendKeys(propertieReader.appConfigReader("loginPassword"));
    }

    public void clickLoginButton(){
        driver.findElement(login_button_xpath).click();
    }




}

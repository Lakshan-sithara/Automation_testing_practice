package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import verify.compair;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    WebDriverWait wait;
    boolean visibleText;

    //Refactored selecters

    By username_textbox_xpath = By.xpath("//input[@type='text']");
    By password_textbox_xpath = By.xpath("//input[@data-qa='signup-email']");
    By signup_button_xpath = By.xpath("//button[text()='Signup']");
    By login_username_textbox_xpath = By.xpath("//input[@data-qa='login-email']");
    By login_password_textbox_xpath = By.xpath("//input[@data-qa='login-password']");
    By login_button_xpath = By.xpath("//button[@data-qa='login-button']");


    public LoginPage(WebDriver driver) {
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

    public void enterUsername(){
        driver.findElement(username_textbox_xpath).sendKeys("abc");
    }

    public void enterPassword(){
        driver.findElement(password_textbox_xpath).sendKeys("aa@aa.mm");
    }

    public void clickSignUpButton(){
        driver.findElement(signup_button_xpath).click();
    }

    public void enterEmailOnlogin(){
        driver.findElement(login_username_textbox_xpath).sendKeys("aa@aa.mm");
    }

    public void enterPasswordOnlogin(){
        driver.findElement(login_password_textbox_xpath).sendKeys("123");
    }

    public void clickLoginButton(){
        driver.findElement(login_button_xpath).click();
    }




}

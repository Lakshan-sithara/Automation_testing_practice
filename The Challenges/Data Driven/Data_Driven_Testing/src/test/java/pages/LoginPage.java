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
    By loginButton = By.xpath("//a[@href='/login']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void login(String standardUser, String secretSauce) {


        WebElement loginlink = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginlink.click();

        // assertion
        visibleText = compair.verifyNewUserSignupVisible(driver,"New User Signup!");
        Assert.assertTrue(visibleText);

        //sign up
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aa@aa.mm");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

        //check 'Enter Account Information' isVisible


    }



}

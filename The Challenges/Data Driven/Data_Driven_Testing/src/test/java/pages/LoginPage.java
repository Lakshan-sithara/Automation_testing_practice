package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    WebDriverWait wait;

    //Refactored selecters
    By loginButton = By.xpath("//a[@href='/login']");
    By email = By.name("email");
    By password = By.name("password");
    By submitButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void login(String standardUser, String secretSauce) {


        WebElement loginlink = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginlink.click();


        driver.findElement(email).sendKeys("hiiii");
        driver.findElement(password).sendKeys("1234");
        driver.findElement(submitButton).click();

    }



}

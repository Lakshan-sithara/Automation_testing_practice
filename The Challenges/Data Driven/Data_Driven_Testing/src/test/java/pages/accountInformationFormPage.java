package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import verify.compair;

import javax.swing.*;

public class accountInformationFormPage {

    WebDriver driver;
    boolean actualTitle;
    boolean accountCreatedVisibleResult;

    public accountInformationFormPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyTitleVisibility(){
        actualTitle = compair.verifyEnterAccountInformationTextVisible(driver);
        //Assert.assertEquals(actualTitle,"Enter Account Information");
        Assert.assertTrue(actualTitle);
    }

    public void fillRegistrationForm(){

        driver.findElement(By.xpath("//input[@name='title' and @value='Mr']")).click();

        driver.findElement(By.id("password")).sendKeys("123");

        Select DOB_day_dropdown = new Select(driver.findElement(By.id("days")));
        DOB_day_dropdown.selectByVisibleText("1");

        Select DOB_month_dropdown = new Select(driver.findElement(By.id("months")));
        DOB_month_dropdown.selectByVisibleText("April");

        Select DOB_years_dropdown = new Select(driver.findElement(By.id("years")));
        DOB_years_dropdown.selectByVisibleText("2021");

        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("optin")).click();

        //address information
        driver.findElement(By.id("first_name")).sendKeys("aaaaaa");
        driver.findElement(By.id("last_name")).sendKeys("bbbbb");
        driver.findElement(By.id("company")).sendKeys("ABC");
        driver.findElement(By.id("address1")).sendKeys("nochchikulama");

        Select country_dropdown= new Select(driver.findElement(By.id("country")));
        country_dropdown.selectByValue("Canada");

        driver.findElement(By.id("state")).sendKeys("cccc");
        driver.findElement(By.name("city")).sendKeys("DDDDD");
        driver.findElement(By.name("zipcode")).sendKeys("123333");
        driver.findElement(By.name("mobile_number")).sendKeys("123654789");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();


    }

    public void continueButton(){
        accountCreatedVisibleResult=compair.verifyAccountCreatedText(driver);
        Assert.assertTrue(accountCreatedVisibleResult);

        driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }

}

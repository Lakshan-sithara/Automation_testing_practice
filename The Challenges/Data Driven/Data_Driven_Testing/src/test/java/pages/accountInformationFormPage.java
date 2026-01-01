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

    //Refactored selecters
    By title_RadioButton_xpath = By.xpath("//input[@name='title' and @value='Mr']");
    By password_textbox_id = By.id("password");
    By DOB_dropdown_days_id = By.id("days");
    By DOB_dropdown_months_id = By.id("months");
    By DOB_dropdown_years_id = By.id("years");
    By newsletter_checkbox_name = By.name("newsletter");
    By option_checkbox_name = By.name("optin");
    By firstname_textbox_id = By.id("first_name");
    By lastname_textbox_id = By.id("last_name");
    By company_textbox_id = By.id("company");
    By address1_textbox_id = By.id("address1");
    By country_dropdown_id = By.id("country");
    By state_textbox_id = By.id("state");
    By city_textbox_name = By.name("city");
    By zipcode_textbox_name = By.name("zipcode");
    By mnumber_textbox_name = By.name("mobile_number");
    By submit_button_xpath = By.xpath("//button[text()='Create Account']");
    By continue_button_xpath = By.xpath("//a[text()='Continue']");


    public accountInformationFormPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyTitleVisibility(){
        actualTitle = compair.verifyEnterAccountInformationTextVisible(driver);
        //Assert.assertEquals(actualTitle,"Enter Account Information");
        Assert.assertTrue(actualTitle);
    }

    public void fillRegistrationForm(){

        driver.findElement(title_RadioButton_xpath).click();

        driver.findElement(password_textbox_id).sendKeys("123");

        Select DOB_day_dropdown = new Select(driver.findElement(DOB_dropdown_days_id));
        DOB_day_dropdown.selectByVisibleText("1");

        Select DOB_month_dropdown = new Select(driver.findElement(DOB_dropdown_months_id));
        DOB_month_dropdown.selectByVisibleText("April");

        Select DOB_years_dropdown = new Select(driver.findElement(DOB_dropdown_years_id));
        DOB_years_dropdown.selectByVisibleText("2021");

        driver.findElement(newsletter_checkbox_name).click();
        driver.findElement(option_checkbox_name).click();

        //address information
        driver.findElement(firstname_textbox_id).sendKeys("aaaaaa");
        driver.findElement(lastname_textbox_id).sendKeys("bbbbb");
        driver.findElement(company_textbox_id).sendKeys("ABC");
        driver.findElement(address1_textbox_id).sendKeys("nochchikulama");

        Select country_dropdown= new Select(driver.findElement(country_dropdown_id));
        country_dropdown.selectByValue("Canada");

        driver.findElement(state_textbox_id).sendKeys("cccc");
        driver.findElement(city_textbox_name).sendKeys("DDDDD");
        driver.findElement(zipcode_textbox_name).sendKeys("123333");
        driver.findElement(mnumber_textbox_name).sendKeys("123654789");
        driver.findElement(submit_button_xpath).click();


    }

    public void continueButton(){
        accountCreatedVisibleResult=compair.verifyAccountCreatedText(driver);
        Assert.assertTrue(accountCreatedVisibleResult);

        driver.findElement(continue_button_xpath).click();
    }

}

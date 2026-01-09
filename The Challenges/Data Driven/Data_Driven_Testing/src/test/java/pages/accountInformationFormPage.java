package pages;

import library.propertieReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import verify.compair;

import java.io.IOException;

public class accountInformationFormPage {

    WebDriver driver;
    boolean actualTitle;
    boolean accountCreatedVisibleResult;

    //Refactored selecters
    By title_RadioButton_xpath = By.xpath(propertieReader.appConfigReader("title_RadioButton_xpath"));
    By password_textbox_id = By.id(propertieReader.appConfigReader("password_textbox_id"));
    By DOB_dropdown_days_id = By.id(propertieReader.appConfigReader("DOB_dropdown_days_id"));
    By DOB_dropdown_months_id = By.id(propertieReader.appConfigReader("DOB_dropdown_months_id"));
    By DOB_dropdown_years_id = By.id(propertieReader.appConfigReader("DOB_dropdown_years_id"));
    By newsletter_checkbox_name = By.name(propertieReader.appConfigReader("newsletter_checkbox_name"));
    By option_checkbox_name = By.name(propertieReader.appConfigReader("option_checkbox_name"));
    By firstname_textbox_id = By.id(propertieReader.appConfigReader("firstname_textbox_id"));
    By lastname_textbox_id = By.id(propertieReader.appConfigReader("lastname_textbox_id"));
    By company_textbox_id = By.id(propertieReader.appConfigReader("company_textbox_id"));
    By address1_textbox_id = By.id(propertieReader.appConfigReader("address1_textbox_id"));
    By country_dropdown_id = By.id(propertieReader.appConfigReader("country_dropdown_id"));
    By state_textbox_id = By.id(propertieReader.appConfigReader("state_textbox_id"));
    By city_textbox_name = By.name(propertieReader.appConfigReader("city_textbox_name"));
    By zipcode_textbox_name = By.name(propertieReader.appConfigReader("zipcode_textbox_name"));
    By mnumber_textbox_name = By.name(propertieReader.appConfigReader("mnumber_textbox_name"));
    By submit_button_xpath = By.xpath(propertieReader.appConfigReader("submit_button_xpath"));
    By continue_button_xpath = By.xpath(propertieReader.appConfigReader("continue_button_xpath"));


    public accountInformationFormPage(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public void verifyTitleVisibility(){
        actualTitle = compair.verifyEnterAccountInformationTextVisible(driver);
        //Assert.assertEquals(actualTitle,"Enter Account Information");
        Assert.assertTrue(actualTitle);
    }

    public void fillRegistrationForm() throws IOException {

        driver.findElement(title_RadioButton_xpath).click();

        driver.findElement(password_textbox_id).sendKeys(propertieReader.appConfigReader("password"));

        Select DOB_day_dropdown = new Select(driver.findElement(DOB_dropdown_days_id));
        DOB_day_dropdown.selectByVisibleText(propertieReader.appConfigReader("DOB_day_dropdown_value"));

        Select DOB_month_dropdown = new Select(driver.findElement(DOB_dropdown_months_id));
        DOB_month_dropdown.selectByVisibleText(propertieReader.appConfigReader("DOB_month_dropdown_value"));

        Select DOB_years_dropdown = new Select(driver.findElement(DOB_dropdown_years_id));
        DOB_years_dropdown.selectByVisibleText(propertieReader.appConfigReader("DOB_year_dropdown_value"));

        driver.findElement(newsletter_checkbox_name).click();
        driver.findElement(option_checkbox_name).click();

        //address information
        driver.findElement(firstname_textbox_id).sendKeys(propertieReader.appConfigReader("firstname_textbox_value"));
        driver.findElement(lastname_textbox_id).sendKeys(propertieReader.appConfigReader("lastname_textbox_value"));
        driver.findElement(company_textbox_id).sendKeys(propertieReader.appConfigReader("company_textbox_value"));
        driver.findElement(address1_textbox_id).sendKeys(propertieReader.appConfigReader("address1_textbox_value"));

        Select country_dropdown= new Select(driver.findElement(country_dropdown_id));
        country_dropdown.selectByValue("Canada");

        driver.findElement(state_textbox_id).sendKeys(propertieReader.appConfigReader("state_textbox_value"));
        driver.findElement(city_textbox_name).sendKeys(propertieReader.appConfigReader("city_textbox_value"));
        driver.findElement(zipcode_textbox_name).sendKeys(propertieReader.appConfigReader("zipcode_textbox_value"));
        driver.findElement(mnumber_textbox_name).sendKeys(propertieReader.appConfigReader("mnumber_textbox_value"));
        driver.findElement(submit_button_xpath).click();


    }

    public void verifyAccountCreatedAndClickContinueButton(){
        accountCreatedVisibleResult=compair.verifyAccountCreatedText(driver);
        Assert.assertTrue(accountCreatedVisibleResult);

        driver.findElement(continue_button_xpath).click();
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import utilities.utility;

public class loginPage {

    WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String uname){
        driver.findElement(By.id(utility.fetchPropertyValue("login_page_username_textbox_id").toString())).sendKeys(uname);
    }

    public void enterPassword(String pword){
        driver.findElement(By.id(utility.fetchPropertyValue("login_page_password_textbox_id").toString())).sendKeys(pword);
    }

    public void clickSubmitButton(){
        driver.findElement(By.id(utility.fetchPropertyValue("login_page_submit_button_id").toString())).click();
    }

}

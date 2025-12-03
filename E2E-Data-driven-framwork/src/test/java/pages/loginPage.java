package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class loginPage {

    WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(){
        driver.findElement(By.id(utility.fetchPropertyValue("login_page_username_textbox_id").toString())).sendKeys("abc");
    }

    public void enterPassword(){
        driver.findElement(By.id(utility.fetchPropertyValue("login_page_password_textbox_id").toString())).sendKeys("123");
    }

    public void clickSubmitButton(){
        driver.findElement(By.id(utility.fetchPropertyValue("login_page_submit_button_id").toString())).click();
    }

}

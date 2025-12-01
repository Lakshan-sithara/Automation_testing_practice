package pages;

import libraries.propertieReader;
import utilities.pageAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    WebDriver driver = null;
    pageAction action;

    public loginPage(WebDriver driver){
        this.driver = driver;
        action = new pageAction(driver);
    }

    public void enterUsername(String username){
        action.enterDataIntoTextBox(driver.findElement(By.id(propertieReader.getElements("login_page_username_text_box_id"))),username);
    }

    public void enterPassword(String password){
        action.enterDataIntoTextBox(driver.findElement(By.xpath(propertieReader.getElements("login_page_password_text_box_xpath"))),password);
    }

    public void clickSubmit(){
        action.clickButton(driver.findElement(By.id(propertieReader.getElements("login_page_submit_button_id"))));
    }

}

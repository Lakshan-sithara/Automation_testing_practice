package pages;

import base.initiateDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class loginPage extends initiateDriver {

    @FindBy (id = "username")
    @CacheLookup
    WebElement usernameTextBox;
    @FindBy (xpath = "//input[@type='password']")
    @CacheLookup WebElement passwordTextBox;
    @FindBy (id = "submit")
    @CacheLookup WebElement submitButton;

    public void enterUsername(){
        usernameTextBox.sendKeys("student");
    }

    public void enterPassword(){
        passwordTextBox.sendKeys("Password123");
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

}

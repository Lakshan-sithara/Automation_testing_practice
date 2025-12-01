package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import verify.compair;

import java.time.Duration;

public class pageAction {

    WebDriver driver;
    WebDriverWait wait;

    public pageAction(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterDataIntoTextBox(WebElement login, String text){
        wait.until(ExpectedConditions.visibilityOf(login));
        boolean resultOfTextBox = compair.validateTextFieldEnable(login);
        Assert.assertTrue(resultOfTextBox);
        login.sendKeys(text);
    }

    public void clickButton(WebElement login){
        wait.until(ExpectedConditions.elementToBeClickable(login));
        boolean resultOfButton = compair.validateSubmitButtonEnable(login);
        Assert.assertTrue(resultOfButton);
        login.click();
    }
}

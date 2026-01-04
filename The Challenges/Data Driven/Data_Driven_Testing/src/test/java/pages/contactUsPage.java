package pages;

import library.propertieReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import verify.compair;

import java.io.IOException;
import java.time.Duration;

public class contactUsPage {

    WebDriver driver;

    By nameTextBoxName = By.name("name");
    By emailTextBoxName = By.name("email");
    By enterSubjectName = By.name("subject");
    By enterMessageName = By.name("message");
    By fileUploadXpath = By.xpath("//input[@type='file']");
    By submitButtonXpath = By.xpath("//input[@type='submit']");
    By homeButtonXpath = By.xpath("//a[@class='btn btn-success']");


    public contactUsPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterName(){
        driver.findElement(nameTextBoxName).sendKeys("abc");
    }

    public void enterEmail() throws IOException {
        driver.findElement(emailTextBoxName).sendKeys(propertieReader.appConfigReader("loginEmail"));
    }

    public void enterSubject(){
        driver.findElement(enterSubjectName).sendKeys("abc");
    }

    public void enterMessage(){
        driver.findElement(enterMessageName).sendKeys("aaaaa");
    }

    public void uploadDocument(){
        WebElement uploadElement = driver.findElement(fileUploadXpath);
        String filePath = "C:/Users/DELL/Desktop/QA/test.pdf";
        uploadElement.sendKeys(filePath);
    }

    public void clickSubmitButton(){
        driver.findElement(submitButtonXpath).click();
    }

    public void clickOkInPopUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void verifySuccessMessage(){
        boolean result = compair.verifySucsessMessageInContactUs(driver);
        Assert.assertTrue(result);
    }

    public void clickHomeButton(){
        driver.findElement(homeButtonXpath).click();
    }

}

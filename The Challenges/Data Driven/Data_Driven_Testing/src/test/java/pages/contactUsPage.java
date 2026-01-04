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

    By nameTextBoxName = By.name(propertieReader.appConfigReader("nameTextBox_Name"));
    By emailTextBoxName = By.name(propertieReader.appConfigReader("emailTextBox_Name"));
    By enterSubjectName = By.name(propertieReader.appConfigReader("enterSubject_Name"));
    By enterMessageName = By.name(propertieReader.appConfigReader("enterMessage_Name"));
    By fileUploadXpath = By.xpath(propertieReader.appConfigReader("fileUpload_Xpath"));
    By submitButtonXpath = By.xpath(propertieReader.appConfigReader("submitButton_Xpath"));
    By homeButtonXpath = By.xpath(propertieReader.appConfigReader("homeButton_Xpath"));


    public contactUsPage(WebDriver driver) throws IOException {
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

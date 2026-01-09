package pages;

import library.propertieReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import verify.compair;

import java.io.IOException;
import java.time.Duration;

public class productDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    By setQuantityTextFieldElement = By.xpath(propertieReader.appConfigReader("setQuantity_Textbox_xpath"));
    By addToCartButtonElement = By.xpath(propertieReader.appConfigReader("addToCart_Button_xpath"));
    By viewCartButtonElement = By.xpath(propertieReader.appConfigReader("viewCartButton_xpath"));


    public productDetailsPage(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifyProductDetailsPage(String productName){
        compair.verifyProductDetailsPage(driver,productName);
    }

    public void setQuantity(int quantity){
        WebElement quantityCount = driver.findElement(setQuantityTextFieldElement);
        quantityCount.clear();
        quantityCount.sendKeys(String.valueOf(quantity));
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButtonElement).click();
    }

    public void clickViewCartButton(){
        WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable
                (driver.findElement(viewCartButtonElement)));
        viewCartButton.click();
    }

    public void validateProductQuantity(String quantity){
        compair compair = new compair();
        compair.compairDetails(driver.findElement(By.xpath("//button[text()='"+quantity+"']")),quantity,"quantity" );

        compair.assertAllDetails();
    }

}

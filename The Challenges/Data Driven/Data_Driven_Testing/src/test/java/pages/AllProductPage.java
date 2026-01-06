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
import java.util.Map;

public class AllProductPage {

    WebDriver driver;
    WebDriverWait wait;

    By firstProduct_Button_xpath = By.xpath(propertieReader.appConfigReader("firstProduct_Button_xpath"));
    By productNameElement = By.xpath(propertieReader.appConfigReader("productName_xpath"));
    By categaryElement = By.xpath(propertieReader.appConfigReader("chategary_xpath"));
    By priceElement = By.xpath(propertieReader.appConfigReader("price_xpath"));
    By availabilityElement = By.xpath(propertieReader.appConfigReader("availibility_xpath"));
    By conditionElement = By.xpath(propertieReader.appConfigReader("consition_xpath"));
    By brandElement = By.xpath(propertieReader.appConfigReader("brand_xpath"));


    public AllProductPage(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifyAllProductPage(){
        boolean result = compair.verifyAllProductPage(driver);
        Assert.assertTrue(result);
    }

    public void clickOnFirstProductButton(){
        WebElement FirstProductButton = wait.until(ExpectedConditions.elementToBeClickable(firstProduct_Button_xpath));
        FirstProductButton.click();
    }

    public void validateProductPageDetails(Map<String,String>expectedDetails){
        compair compair = new compair();
        compair.validateProductDetails(driver.findElement(productNameElement),expectedDetails.get("name"),"Product Name");
        compair.validateProductDetails(driver.findElement(categaryElement), expectedDetails.get("category"),"Category" );
        compair.validateProductDetails(driver.findElement(priceElement), expectedDetails.get("price"),"Price" );
        compair.validateProductDetails(driver.findElement(availabilityElement), expectedDetails.get("availability"),"Availability" );
        compair.validateProductDetails(driver.findElement(conditionElement), expectedDetails.get("condition"),"Condition" );
        compair.validateProductDetails(driver.findElement(brandElement), expectedDetails.get("brand"),"Brand" );
    }

}

package pages;

import library.propertieReader;
import library.stringCapitalize;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    compair compair;

    String productName;
    String fixedBrandName;

    By firstProduct_Button_xpath = By.xpath(propertieReader.appConfigReader("firstProduct_Button_xpath"));
    By productNameElement = By.xpath(propertieReader.appConfigReader("productName_xpath"));
    By categaryElement = By.xpath(propertieReader.appConfigReader("chategary_xpath"));
    By priceElement = By.xpath(propertieReader.appConfigReader("price_xpath"));
    By availabilityElement = By.xpath(propertieReader.appConfigReader("availibility_xpath"));
    By conditionElement = By.xpath(propertieReader.appConfigReader("consition_xpath"));
    By brandElement = By.xpath(propertieReader.appConfigReader("brand_xpath"));
    By searchBarElement = By.xpath(propertieReader.appConfigReader("searchBar_xpath"));
    By searchButtonElement = By.id(propertieReader.appConfigReader("searchButton_id"));
    By emailTextBoxElement = By.id(propertieReader.appConfigReader("emailTextBox_id"));
    By subscribeArrowButtonElement = By.id(propertieReader.appConfigReader("subscribeArrowButton_id"));
    By continueShipingButtonElement = By.xpath(propertieReader.appConfigReader("continueShipingButton_xpath"));
    By viewCartButtonElement = By.xpath(propertieReader.appConfigReader("viewCartButton_xpath"));


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

    public void enterDataOnSearchBar(String productName){
        this.productName = productName;
        WebElement searchBar =wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchBarElement) ));
        searchBar.clear();
        searchBar.sendKeys(productName);
    }

    public void clickSearchButton(){
        driver.findElement(searchButtonElement).click();
    }

    public void verifySearchedItemsAreVisible(){
        compair.verifySearchItems(driver,productName);
    }

    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void validateSubscriptionText(){
        boolean result = compair.verifySubscriptionText(driver);
        Assert.assertTrue(result);
    }

    public void enterEmailOnSubscription(){
        driver.findElement(emailTextBoxElement).sendKeys("aa@aa.mm");
    }

    public void clickOnSubscribeArrowButton(){
        driver.findElement(subscribeArrowButtonElement).click();
    }

    public void verifySubscribeSuccessText(){
        Assert.assertTrue(compair.verifySubscribeSuccessfullMessage(driver));
    }

    public void hoverOverItemAndAddToCart(String itemName){

        By locator = By.xpath("//p[text()='"+itemName+"']/following-sibling::a[text()='Add to cart']");

        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(locator));

        Actions act = new Actions(driver);
        act.moveToElement(item).perform();

        item.click();

    }

    public void clickContinueShippingButton(){
        WebElement continueShipingButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(continueShipingButtonElement)));
        continueShipingButton.click();
    }

    public void clickViewCartButton(){
        WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(viewCartButtonElement)));
        viewCartButton.click();
    }

    public void verifyBrandText(){
        boolean result = verify.compair.verifyBrandTitleText(driver);
        Assert.assertTrue(result);
    }

    public void clickBrand(String brandName){
        fixedBrandName = stringCapitalize.capitalize(brandName);

        driver.findElement(By.xpath("//a[text()='"+fixedBrandName+"']")).click();
    }

    public void verifyBrandTitleTextAndBrandProductsAreDisplayed(){
        compair.verifyBrandBannerText(driver,fixedBrandName);

    }



}

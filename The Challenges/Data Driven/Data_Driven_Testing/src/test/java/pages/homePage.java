package pages;

import library.propertieReader;
import library.stringCapitalize;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import verify.Compair;

import java.io.IOException;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    boolean homePageUrl;
    WebDriverWait wait;
    By loginButton = By.xpath(propertieReader.appConfigReader("loginButton_xpath"));
    By contactUsButton = By.xpath(propertieReader.appConfigReader("contactUs_button_xpath"));
    By testCasesButton = By.xpath(propertieReader.appConfigReader("testCasesButton_xpath"));
    By productButton = By.xpath(propertieReader.appConfigReader("productButton_xpath"));
    By cartButton = By.xpath(propertieReader.appConfigReader("cartButton_xpath"));


    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickLoginSigninButton() {
        WebElement loginlink = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginlink.click();
    }

    public void verifyHomePage() throws IOException {
        homePageUrl = Compair.verifyHomePageVisibility(driver,propertieReader.appConfigReader("App_url"));
        Assert.assertTrue(homePageUrl);
    }

    public void clickContactUsButton(){
        WebElement contactUsBtn = wait.until(ExpectedConditions.elementToBeClickable(contactUsButton));
        contactUsBtn.click();
    }

    public void clickTestCaseButton(){
        driver.findElement(testCasesButton).click();
    }

    public void clickProductButton(){
        WebElement productBtn = wait.until(ExpectedConditions.elementToBeClickable(productButton));
        productBtn.click();
    }

    public void clickCartButton(){
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartBtn.click();
    }

    public void clickViewProductOnItem(String itemName){
        WebElement viewProductItemButton = wait.until(ExpectedConditions.
                elementToBeClickable(driver.findElement(By.xpath("//p[text()='"+itemName+"']" +
                        "/parent::div/parent::div/parent::div/following-sibling::div/ul/li/a[text()='View Product']"))));
        viewProductItemButton.click();
    }

    public void verifyCategoryVisibility(){
        boolean result = Compair.verifyCategoryVisibility(driver);
        Assert.assertTrue(result);
    }

    public void clickMainCategory(String categoryName) {

        String fixedMainCategory = stringCapitalize.capitalize(categoryName);
        String xpath = "//a[@href='#"+fixedMainCategory+"']";

        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickSubCategoryAndConfirmText(String subCategoryName,String mainCategoryName){

        String lowerSubCategory = subCategoryName.toLowerCase();

        String catXpath = "//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"+lowerSubCategory+"')]";

        driver.findElement(By.xpath(catXpath)).click();

        boolean result = Compair.verifyCategoryText(driver,wait,mainCategoryName,lowerSubCategory);
        Assert.assertTrue(result);

    }

    public void verifyRecommendedItemText(){
        Assert.assertTrue(Compair.vertifyRecommendedItemText(driver));
    }

    public void scrollToRecommendedItemsCarousel() {
        // Find the carousel element
        WebElement recommendedCarousel = driver.findElement(By.id("recommended-item-carousel"));

        // Scroll it into the center of the viewport
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
                recommendedCarousel
        );

        // Small pause so the carousel items fully render (important on this site)
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void addRecommendedItemToCart() {
        scrollToRecommendedItemsCarousel();

        // This bypasses the hover/visibility issue completely
        WebElement addToCart = driver.findElement(
                By.xpath("//div[@class='recommended_items']//a[contains(@class, 'add-to-cart')][1]")
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
    }



}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import verify.Compair;

import java.util.HashMap;

public class CheckOutPage {

    WebDriver driver;


    public CheckOutPage(WebDriver driver){
        this.driver = driver;

    }

    public void verifyDelivaryAddressDetailsAndReviewOrder(HashMap<String,String> expectedResult){
        Compair compair = new Compair();
        compair.compairDetails(driver.findElement(By.xpath("//li[@class='address_firstname address_lastname']"))
                , expectedResult.get("fname")+" "+expectedResult.get("lname"),"address");
        compair.compairDetails(driver.findElement(By.xpath("//li[text()='ABC']"))
                ,expectedResult.get("address1"),"address1" );
        compair.compairDetails(driver.findElement(By.xpath("//li[text()='nochchikulama']"))
                ,expectedResult.get("address2"),"address2");
        compair.compairDetails(driver.findElement(By.xpath("//li[@class='address_city address_state_name address_postcode']"))
                ,expectedResult.get("city")+" "+expectedResult.get("state_name")+" "+expectedResult.get("post_code"),"city,state name,post code" );
        compair.compairDetails(driver.findElement(By.xpath("//li[@class='address_country_name']"))
                ,expectedResult.get("country_name"),"country" );
        compair.compairDetails(driver.findElement(By.xpath("//li[@class='address_phone']"))
                ,expectedResult.get("phone_numer"),"phone number" );
    }


    public void enterDiscriptionOnTextArea(){
        driver.findElement(By.tagName("textarea")).sendKeys("test");
    }

    public void clickPlaceOrderButton(){
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();
    }



}

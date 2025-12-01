package verify;

import libraries.propertieReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class compair {

    public static boolean validateTextFieldEnable(WebElement login){
        boolean result=false;

        if (login.isDisplayed()){
            result = true;
        }

        return result;

    }

    public static boolean validateSubmitButtonEnable(WebElement login){
        boolean result = false;

        if (login.isEnabled()){
            result = true;
        }
        return result;
    }

}

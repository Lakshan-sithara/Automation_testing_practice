package assertions;

import org.openqa.selenium.WebDriver;
import utilities.utility;

public class compair {

    public static boolean compairUrl(WebDriver driver, String url){
        boolean urlResult = false;

        if (driver.getCurrentUrl().equalsIgnoreCase(url)){
            urlResult = true;
        }

        return urlResult;
    }

    public static boolean compairtitle(WebDriver driver,String title){
        boolean titleResult = false;

        if (driver.getTitle().equalsIgnoreCase(title)){
            titleResult = true;
        }

        return titleResult;
    }

}

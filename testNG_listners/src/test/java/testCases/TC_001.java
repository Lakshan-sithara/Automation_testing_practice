package testCases;

import base.initializeBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.LinkUtils;

import java.util.List;

public class TC_001 extends initializeBrowser {

    @Test
    public void checkBrockenLinks(){
        int count = 0;
        List<WebElement> links = driver.findElements(By.xpath("//a"));

        for (WebElement ele : links){

            if (ele.getAttribute("href") != null || !ele.getAttribute("href").contains("javascript")){

                boolean result = LinkUtils.checkLink(ele.getAttribute("href"));

                if (result == false){
                    count = count + 1;
                }
            }
        }
        System.out.println(count);
    }

}

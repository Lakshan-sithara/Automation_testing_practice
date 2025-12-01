package listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class driverUpdate implements WebDriverListener {

    @Override
    public void afterGet(WebDriver driver , String url) {
        System.out.println("Navigated to: " + url);
    }

    // Run this automatically BEFORE clicking any element
    @Override
    public void beforeClick(WebElement element) {
        System.out.println("[LOG] About to click on element: " + element.toString());
    }

    // Run this automatically AFTER clicking
    @Override
    public void afterClick(WebElement element) {
        System.out.println("[LOG] Clicked successfully!");
    }
}

package listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

public class driverUpdate implements WebDriverListener {


    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to: " + url);
    }
}

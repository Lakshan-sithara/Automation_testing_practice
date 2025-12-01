package testCases;

import base.initiateDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.loginPage;

public class TC_001 extends initiateDriver {

    @Test
    public void tc001(){
        loginPage login = PageFactory.initElements(driver, loginPage.class);
        login.enterUsername();
        login.enterPassword();
        login.clickSubmitButton();
    }

}

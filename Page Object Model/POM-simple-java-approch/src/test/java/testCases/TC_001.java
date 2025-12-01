package testCases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.loginPage;

public class TC_001 extends initiateDriver {

    @Test
    public void tc_001(){
        login.enterUsername("student");
        login.enterPassword("Password123");
        login.clickSubmit();

    }

}

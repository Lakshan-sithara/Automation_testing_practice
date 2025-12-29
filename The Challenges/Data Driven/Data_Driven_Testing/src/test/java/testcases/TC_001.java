package testcases;


import base.initiateDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.homePage;

public class TC_001 extends initiateDriver {

    @Test
    public void testUserCanLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

}

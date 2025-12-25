package testCases;
import utilities.testDataGenerator;
import assertions.compair;
import base.initiateDriverInstance;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.loginPage;

public class TC_001_validateLoginFunctionality extends initiateDriverInstance {

    @Test(dataProvider = "excel" , dataProviderClass = testDataGenerator.class)
    public void tc_001(String uname,String pwd){

        compair.compairtitle(driver,"https://practicetestautomation.com/practice-test-login/");
        compair.compairUrl(driver,"Test Login | Practice Test Automation");

        loginPage login = new loginPage(driver);
        login.enterUsername(uname);
        login.enterPassword(pwd);
        login.clickSubmitButton();


    }



}

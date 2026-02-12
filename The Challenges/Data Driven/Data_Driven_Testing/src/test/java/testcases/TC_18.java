package testcases;

import base.InitiateDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class TC_18 extends InitiateDriver {

    @Test
    public void viewCategoryProducts() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();
        homePage.verifyCategoryVisibility();
        homePage.clickMainCategory("women");
        homePage.clickSubCategoryAndConfirmText("dress","women");
        homePage.clickMainCategory("men");
        homePage.clickSubCategoryAndConfirmText("Jeans","men");
    }

}

package testcases;

import base.initiateDriver;
import org.testng.annotations.Test;
import pages.homePage;

import java.io.IOException;

public class TC_18 extends initiateDriver {

    @Test
    public void viewCategoryProducts() throws IOException {
        homePage homePage = new homePage(driver);
        homePage.verifyHomePage();
        homePage.verifyCategoryVisibility();
        homePage.clickMainCategory("women");
        homePage.clickSubCategoryAndConfirmText("dress","women");
        homePage.clickMainCategory("men");
        homePage.clickSubCategoryAndConfirmText("Jeans","men");
    }

}

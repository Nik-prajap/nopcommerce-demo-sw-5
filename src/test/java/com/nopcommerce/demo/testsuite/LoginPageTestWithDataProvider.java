package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class LoginPageTestWithDataProvider extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @Test(dataProvider = "data set" , dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYourOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("PrimePizza@gmail.com");
        loginPage.enterPassword("Prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }
}

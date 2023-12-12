package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }


    /**
     * Click on Register Link
     * Verify "Register" Text
     */
    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    /**
     * Click on Register Link
     * Click on "REGISTER" button
     * Verify the error message "First name is required."
     * Verify the error message "Last name is required."
     * Verify the error message "Email is required."
     * Verify the error message "Password is required."
     * Verify the error message "Password is required."
     */
    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLAstNamePasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("primePizza@gmail.com");
        loginPage.enterPassword("prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }



    /**
     * Click on Register Link
     * Select gender "Female"
     * Enter firstname
     * Enter lastname
     * Select day
     * Select month
     * Select year
     * Enter email
     * Enter password
     * Enter Confirm Password
     * Click on "REGISTER" button
     */
    @Test(groups= {"regression" })
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("primePizza@gmail.com");
        loginPage.enterPassword("prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }
}

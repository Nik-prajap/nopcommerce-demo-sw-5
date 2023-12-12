package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    HomePage homePage;
    ComputerPage computerPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    /**
     * Click on login link
     * verify that "Welcome, Please Sign In!" message display
     */
    @Test(groups= {"sanity" ,"smoke" , "regression" })
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    /**
     * Click on login link
     * Enter EmailId
     * Enter Password
     * Click on Login Button
     * Verify that the Error message
     */
    @Test(groups= {"smoke" , "regression" })
    public void verifyTheErrorMessageWithValidCredentials() {

        homePage.clickOnLoginLink();
        loginPage.enterEmailId("PrimePizza@gmail.com");
        loginPage.enterPassword("Prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");

    }

    /**
     * Click on login link
     * Enter EmailId
     * Enter Password
     * Click on Login Button
     * Verify that LogOut link is display
     */
    @Test(groups= {"regression" })
    public void verifyThatUserShouldLoginSuccessfullyWithValidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("PrimePizza@gmail.com");
        loginPage.enterPassword("Prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }


    /**
     * Click on login link
     * Enter EmailId
     * Enter Password
     * Click on Login Button
     * Click on LogOut Link
     * Verify that LogIn Link Display
     */
    @Test(groups= {"regression" })
    public void verifyThatUserShouldLogOutSuccessfully() {
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

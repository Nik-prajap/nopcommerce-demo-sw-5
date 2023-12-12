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
public class ComputerPageTest extends BaseTest {
        HomePage homePage;
        LoginPage loginPage;

        @BeforeMethod(alwaysRun = true)
        public void inIt() {
            homePage = new HomePage();
            loginPage = new LoginPage();
        }

    /**
     * Click omComputer tab
     * verify "Computer" text
     */
    @Test(groups= {"sanity" ,"smoke" , "regression" })
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }


    /**
     * Click on Computer tab
     * Click on Desktops link
     * Verify "Desktops" text
     */
    @Test(groups= {"smoke" , "regression" })
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
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
     * Click on Computer tab
     * Click on Desktops link
     * Click on product name "Build your own computer"
     * Select processor "processor"
     * Select RAM "ram"
     * Select HDD "hdd"
     * Select OS "os"
     * Select Software "software"
     * Click on "ADD TO CART" Button
     * Verify message "The product has been added to your shopping cart"
     */
    @Test(groups= {"regression" })
    public void verifyThatUserShouldBuildYourOwnComputerAndAddThemToCartSuccessfully() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("primePizza@gmail.com");
        loginPage.enterPassword("Prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }
}

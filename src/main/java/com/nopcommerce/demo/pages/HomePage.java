package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilites.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    //    By loginLink = By.linkText("Log in");
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    //    By registerLink = By.linkText("Register");
    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;


    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink() {
     clickOnElement(registerLink);
    }
}

package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Utility {
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement singIn;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordField;
    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement singButton;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailAdd;
    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAcc;
    @FindBy(xpath = "//span[@class='navigation_page']")
    WebElement authentication;
    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    WebElement errorMessage;
    //verify signout
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOut;

    public void clickSignIn() {
        clickOnElement(singIn);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailAddress, email);
    }

    public void enterPassword(String pass) {
        sendTextToElement(passwordField, pass);
    }

    public void clickSign() {
        clickOnElement(singButton);
    }

    public void enterEmailAdd(String emai) {
        sendTextToElement(emailAdd, emai);
    }

    public void clickCreateAcc() {
        clickOnElement(createAcc);
    }

    public String verifyAuthentication() {
        return getTextFromElement(authentication);
    }

    public boolean verifySignOut() {
        return signOut.isDisplayed();
    }

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }

    public void clickSignOut() {
        clickOnElement(signOut);
    }

    public boolean verifySignIn() {
        return singIn.isDisplayed();
    }
}
/*
Email address, Password, Sign In Button, Create an account button and
"AUTHENTICATION" text, "CREATE AN ACCOUNT" text Locators
and create appropriate methods for it.

 */
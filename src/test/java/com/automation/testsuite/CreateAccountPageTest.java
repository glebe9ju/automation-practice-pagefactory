package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductPage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountPageTest extends TestBase {
    CreateAccountPage createAccountPage;
    SignInPage signInPage;


    @BeforeMethod
    public void inIt() {
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
    }

    @Test
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        //Click on Sign in Link
        signInPage.clickSignIn();
        //Enter email address
        signInPage.enterEmailAdd("xyz789@yahoo.com");
//Click on "Create an account" button
        signInPage.clickCreateAcc();
                //Fill all mandetory fields
        String expected = "YOUR PERSONAL INFORMATION";
        String actual = createAccountPage.verifyPersonalInfo();
        createAccountPage.selectGender("Mrs");
        createAccountPage.enterFirstName("Rebecca");
        createAccountPage.enterLastName("Mori");
//        createAccountPage.enterEmail("xyz123@yahoo.com");
        createAccountPage.enterPassWord("xyz123");
        createAccountPage.enterSecondName("Rebecca");
        createAccountPage.enterSecondLast("Mori");
        createAccountPage.enterAddress("89,RedFord");
        createAccountPage.enterCity("Manchester");
        createAccountPage.enterState("Alaska");
        createAccountPage.enterZipCode("12345");
        createAccountPage.enterCountry("UnitedStates");
        createAccountPage.enterMobile("91234556789");
        createAccountPage.enterAssignAdd("89,RedFord");
        //Click on "Register" button
        createAccountPage.clickRegister();
        String expectedResult = "MY ACCOUNT";
        String actualResult = createAccountPage.verifyMyAcc();
        Assert.assertEquals(actualResult,expectedResult,"not displayed");

    }
}

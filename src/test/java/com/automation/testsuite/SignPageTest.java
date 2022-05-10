package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class SignPageTest extends TestBase {
    SignInPage signInPage;

    @BeforeMethod
    public void inIt() {
        signInPage = new SignInPage();
    }

    @Test
    public void userShouldNavigateToSignInPageSuccessFully() {
        //Click on Sign In link
        signInPage.clickSignIn();

//verify that "AUTHENTICATION" message is displayed
        String expected = "Authentication";
        String actual = signInPage.verifyAuthentication();
        Assert.assertEquals(actual, expected, "not displayed");

    }

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void verifyTheErrorMessageWithInValidCredentials(String username, String password,
                                                            String message) {
        signInPage.clickSignIn();
        signInPage.enterEmail(username);
        signInPage.enterPassword(password);
        signInPage.clickSign();
        String expected = message;
        String actual = signInPage.getErrorMessage();
        Assert.assertEquals(actual, expected, "error in message");
    }

    @Test
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        //Click on sign link
        signInPage.clickSignIn();

        //Enter EmailId
        signInPage.enterEmail("abc23@yahoo.com");

        //Enter Password
        signInPage.enterPassword("rebecca123");

        //Click on Sign Button
        signInPage.clickSign();

        //Verify that Sign out link is displayed
        Assert.assertTrue(signInPage.verifySignOut(), "not displayed");
    }

    @Test
    public void verifyThatUserShouldLogOutSuccessFully() {
        //Click on sign link
        signInPage.clickSignIn();

        //Enter EmailId
//        signInPage.enterEmail("xyz123@yahoo.com");

        //Enter Password
        signInPage.enterPassword("xyz123");

        //Click on Sign Button
        signInPage.clickSign();
        signInPage.clickSignOut();
//Verify that Sign In Link displayed
        Assert.assertTrue(signInPage.verifySignIn(), "not displayed");

    }
}
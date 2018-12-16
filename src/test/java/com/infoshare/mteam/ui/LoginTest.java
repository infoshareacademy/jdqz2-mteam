package com.infoshare.mteam.ui;

import com.infoshare.mteam.pages.HomePage;
import com.infoshare.mteam.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest extends BaseTest{

    private HomePage homePage;
    private LoginPage loginPage;
    private String userEmail = "kulfon@kulfon.pl";
    private String userPassword = "kulfon123";
    private String expectedTextAfterLogin = "My Account";
    private String expectedErrorMsg = "Login Failed. Username or Password is incorrect.";


    @Before
    public void goToLoginPage(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.clickSignIn();
    }

    @Test
    public void negativeIncorrectEmail(){
    loginPage.loginToMyAccout("non_existing_email", userPassword);
        assertThat(loginPage.getErrorText())
                .isEqualTo(expectedErrorMsg);
    }

    @Test
    public void negativeIncorrectPassword(){
        loginPage.loginToMyAccout(userEmail, "non_existing_pass");
        assertThat(loginPage.getErrorText())
                .isEqualTo(expectedErrorMsg);
    }

    @Test
    public void positiveLogIn(){
        loginPage.loginToMyAccout(userEmail, userPassword);
        assertThat(loginPage.getTextAfterLogin())
                .isEqualTo(expectedTextAfterLogin);
    }
}

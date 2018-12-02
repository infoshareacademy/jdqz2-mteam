package com.infoshare.mteam.ui;

import com.infoshare.mteam.pages.HomePage;
import com.infoshare.mteam.pages.RegistrationForm;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterAccountTest extends BaseTest {

    private HomePage homePage;
    private RegistrationForm registrationForm;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        registrationForm = new RegistrationForm(driver);
        homePage.goToRegisterNewUserPage();

    }

    @Test
    public void registerNewAccount() {
        registrationForm.fillAllInputs();
        registrationForm.clickRegisterButton();
        assertThat(registrationForm.isUserLoggedIn()).isEqualTo(true);
    }

    @Test
    public void negativeRegisterWithoutName() {
        registrationForm.fillInputWithoutName();
        registrationForm.clickRegisterButton();
        assertThat(registrationForm.isUserLoggedIn()).isEqualTo(true);
    }
}

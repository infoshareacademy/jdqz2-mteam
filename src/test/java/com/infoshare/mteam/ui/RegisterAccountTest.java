package com.infoshare.mteam.ui;

import com.infoshare.mteam.pages.BasePage;
import com.infoshare.mteam.pages.HomePage;
import com.infoshare.mteam.pages.RegistrationForm;
import com.infoshare.mteam.utils.driver.WebDriverCreators;
import com.infoshare.mteam.utils.driver.WebDriverProvider;
import com.infoshare.mteam.utils.waits.Waits;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterAccountTest extends BaseTest {

    private HomePage homePage;
    private RegistrationForm registrationForm;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        registrationForm = new RegistrationForm(driver);

    }

    @Test
    public void registerNewAccount() {
        homePage.goToRegisterNewUserPage();
        registrationForm.fillAllInputs();
        registrationForm.clickRegisterButton();
        assertThat(registrationForm.isUserLoggedIn()).isEqualTo(true);
    }

    @Test
    public void negativeRegisterWithoutName() {

    }
}

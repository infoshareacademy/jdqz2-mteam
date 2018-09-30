package com.infoshare.mteam.ui;

import com.infoshare.mteam.pages.HomePage;
import com.infoshare.mteam.pages.RegistrationForm;
import com.infoshare.mteam.utils.driver.WebDriverCreators;
import com.infoshare.mteam.utils.driver.WebDriverProvider;
import com.infoshare.mteam.utils.waits.Waits;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterAccountTest {
    private static final String PAGE_URL = "http://demo.shopizer.com:8080/";

    private WebDriver driver;
    private HomePage homePage;
    private RegistrationForm registrationForm;
    private Waits waits;

    @Before
    public void setUp() {

        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        registrationForm = new RegistrationForm(driver);
        driver.get(PAGE_URL);
    }

    @Test
    public void registerNewAccount() {
        homePage.goToRegisterNewUserPage();
        registrationForm.fillAllInputs();
    }
}

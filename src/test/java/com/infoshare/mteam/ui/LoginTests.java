package com.infoshare.mteam.ui;

import com.infoshare.mteam.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTests {

    private WebDriver driver;
    private String urlRemote = "http://mteam.jdqz2.is-academy.pl/shop/customer/customLogon.html";
    private LoginPage loginPage;
    private String userEmail = "kulfon@kulfon.pl";
    private String userPassword = "kulfon123";
    private String expectedTextAfterLogin = "My Account";
    private String expectedErrorMsg = "Login Failed. Username or Password is incorrect.";
    @Before
    public void setUpAndRegister(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_Linux64");
        driver = new ChromeDriver();
        driver.get(urlRemote);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
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

    @After
    public void closeBrowser(){
        driver.close();
    }

}

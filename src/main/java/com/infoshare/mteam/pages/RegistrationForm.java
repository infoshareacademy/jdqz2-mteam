package com.infoshare.mteam.pages;

import com.infoshare.mteam.generator.userData.User;
import com.infoshare.mteam.generator.userGenerator.UserGenerator;
import com.infoshare.mteam.utils.waits.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationForm {
    private WebDriver driver;
    UserGenerator generator= new UserGenerator();

    public RegistrationForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "registration_country")
    private WebElement country;

    @FindBy(id = "hidden_zones")
    private WebElement stateProvince;

    @FindBy(id = "emailAddress")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "passwordAgain")
    private WebElement repeatPassword;

    @FindBy(xpath = "//button[@class='btn btn-default login-btn']")
    private WebElement registerButton;

    @FindBy(xpath = "//li[@class='click_menu']/a")
    private WebElement welcomeNewUser;


    public void fillAllInputs() {
        User[] user1 = generator.generateRandomUsers(1, generator.generateRandomNumbers(1));
        firstName.sendKeys(user1[0].getName().getFirstName());
        lastName.sendKeys(user1[0].getName().getLastName());
        country.sendKeys(user1[0].getAddress().getCountry());
        stateProvince.sendKeys(user1[0].getAddress().getStateProvince());
        email.sendKeys(user1[0].getEmail());
        password.sendKeys(user1[0].getPassword());
        repeatPassword.sendKeys(user1[0].getPassword());
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean isUserLoggedIn() {
        return welcomeNewUser.isDisplayed();
    }
}

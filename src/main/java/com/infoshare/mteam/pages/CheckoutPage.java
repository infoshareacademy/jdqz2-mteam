package com.infoshare.mteam.pages;

import com.infoshare.mteam.generator.userData.User;
import com.infoshare.mteam.generator.userGenerator.UserGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;
    UserGenerator generator= new UserGenerator();

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.billing.company")
    private WebElement billingComapny;

    @FindBy(id = "customer.billing.address")
    private WebElement billingAddress;

    @FindBy(id = "customer.billing.city")
    private WebElement city;

    @FindBy(id = "customer.billing.country")
    private WebElement country;

    @FindBy(id = "billingStateProvince")
    private WebElement stateProvince;

    @FindBy(id = "customer.emailAddress")
    private WebElement email;

    @FindBy(id = "customer.billing.phone")
    private WebElement phoneNumber;

    @FindBy(id = "submitOrder")
    private WebElement submitOrder;


    public void fillAllInputs(User user) {

        firstName.sendKeys(user.getName().getFirstName());
        lastName.sendKeys(user.getName().getLastName());
        billingComapny.sendKeys(user.getCompany());
        billingAddress.sendKeys(user.getAddress().getStreet());
        country.sendKeys(user.getAddress().getCountry());
        stateProvince.sendKeys(user.getAddress().getStateProvince());
        email.sendKeys(user.getEmail());
        phoneNumber.sendKeys(user.getPhone());

    }

//    public void clickRegisterButton() {
//        registerButton.click();
//    }
//
//    public boolean isUserLoggedIn() {
//        Waits wait1 = new Waits(driver);
//        wait1.waitForElementToBeVisible(welcomeNewUser);
//        return welcomeNewUser.isDisplayed();
//    }

}

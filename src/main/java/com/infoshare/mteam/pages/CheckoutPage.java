package com.infoshare.mteam.pages;

import com.infoshare.mteam.generator.userData.User;
import com.infoshare.mteam.generator.userGenerator.UserGenerator;
import com.infoshare.mteam.utils.waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    UserGenerator generator= new UserGenerator();
    private Waits waits;

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

    @FindBy(id = "billingPostalCode")
    private WebElement postalCode;

    @FindBy(id = "customer.billing.country")
    private WebElement country;

    @FindBy(id = "billingStateList")
    private WebElement stateProvince;

    @FindBy(id = "customer.emailAddress")
    private WebElement email;

    @FindBy(id = "customer.billing.phone")
    private WebElement phoneNumber;

    @FindBy(id = "submitOrder")
    private WebElement submitOrderButton;

    @FindBy(id = "customerAgreed")
    private WebElement agreeTermsAndConditionsCheckbox;


    public void fillAllInputs(User user) {

        WebDriverWait wait = new WebDriverWait(driver, 60);

        firstName.sendKeys(user.getName().getFirstName());
        lastName.sendKeys(user.getName().getLastName());
        billingComapny.sendKeys(user.getCompany());
        billingAddress.sendKeys(user.getAddress().getStreet());
        city.sendKeys(user.getAddress().getCity());
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loadingoverlay")));
        postalCode.sendKeys(user.getAddress().getPostalCode());
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loadingoverlay")));
        country.sendKeys(user.getAddress().getCountry());
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loadingoverlay")));
        stateProvince.sendKeys(user.getAddress().getStateProvince());
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loadingoverlay")));
        email.sendKeys(user.getEmail());
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loadingoverlay")));
        phoneNumber.sendKeys(user.getPhone());
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loadingoverlay")));

    }

    public void clickAgreeTermsAndConditionsCheckbox () {

        Waits waits = new Waits(driver);

//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loadingoverlay")));
        waits.wiatForElementToBeClickable(agreeTermsAndConditionsCheckbox);
        agreeTermsAndConditionsCheckbox.click();
    }

    public void submitOrder() {
        submitOrderButton.click();
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

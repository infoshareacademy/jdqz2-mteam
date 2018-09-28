package com.infoshare.mteam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {

    @FindBy(css = "#genericLogin-button")
    private WebElement buttonSignIn;

    @FindBy(css = "#signin_userName")
    private WebElement fieldCustomerEmailAdrees;

    @FindBy(css = "#signin_password")
    private WebElement fieldPassword;

//    @FindBy(css = "#customerAccount")
//    private WebElement textLoggedInAs;

    @FindBy(css = ".p-title")
    List<WebElement>  myAccountMenu;

    @FindBy(css = "#loginError")
    private WebElement errorText;

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void loginToMyAccout(String userEmail, String password){
        fieldCustomerEmailAdrees.sendKeys(userEmail);
        fieldPassword.sendKeys(password);
        buttonSignIn.click();
    }

    public String getTextAfterLogin(){

        wait.until(ExpectedConditions.visibilityOfAllElements(myAccountMenu));
        return myAccountMenu.get(0).getText();
    }

    public String getErrorText(){
        wait.until(ExpectedConditions.visibilityOf(errorText));
        return errorText.getText();
    }

}

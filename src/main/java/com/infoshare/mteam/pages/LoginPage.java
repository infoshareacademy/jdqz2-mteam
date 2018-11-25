package com.infoshare.mteam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage{

    @FindBy(css = "#genericLogin-button")
    private WebElement buttonSignIn;

    @FindBy(css = "#signin_userName")
    private WebElement fieldCustomerEmailAdrees;

    @FindBy(css = "#signin_password")
    private WebElement fieldPassword;

    @FindBy(css = ".p-title")
    private List<WebElement>  myAccountMenu;

    @FindBy(css = "#loginError")
    private WebElement errorText;

    public LoginPage(WebDriver driver){
        super(driver);
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

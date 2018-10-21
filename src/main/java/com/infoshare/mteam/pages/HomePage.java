package com.infoshare.mteam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(id = "customerAccount")
    private WebElement menuMyAccount;

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement linkSignIn;

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn(){
        menuMyAccount.click();
        wait.until(ExpectedConditions.visibilityOf(linkSignIn));
        linkSignIn.click();
    }
}

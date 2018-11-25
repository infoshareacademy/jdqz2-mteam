package com.infoshare.mteam.pages;

import com.infoshare.mteam.utils.waits.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    @FindBy(css = "#miniCartSummary > a")
    private WebElement shoppingCartIcon;

    @FindBy(xpath = "//li[@class='click_menu']")
    public WebElement myAccount;

    @FindBy(id = "registerLink")
    private WebElement registerLink;

    @FindBy(id = "customerAccount")
    private WebElement menuMyAccount;

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement linkSignIn;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnShoppingCart () {

        Waits wait = new Waits(driver);
        wait.waitForElementToBeVisible(shoppingCartIcon);
        shoppingCartIcon.click();
    }

    public void goToRegisterNewUserPage() {

        Waits wait = new Waits(driver);
        wait.waitForElementToBeVisible(myAccount);
        myAccount.click();
        registerLink.click();
    }

    public void clickSignIn(){
        menuMyAccount.click();
        wait.until(ExpectedConditions.visibilityOf(linkSignIn));
        linkSignIn.click();
    }

}

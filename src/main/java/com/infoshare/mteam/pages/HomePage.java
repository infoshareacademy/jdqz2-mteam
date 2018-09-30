package com.infoshare.mteam.pages;

import com.infoshare.mteam.utils.waits.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#miniCartSummary > a")
    private WebElement shoppingCartIcon;

    @FindBy(xpath = "//li[@class='click_menu']")
    public WebElement myAccount;

    @FindBy(id = "registerLink")
    private WebElement registerLink;

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
}

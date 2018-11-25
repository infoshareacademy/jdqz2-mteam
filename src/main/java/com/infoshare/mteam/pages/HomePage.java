package com.infoshare.mteam.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(id = "customerAccount")
    private WebElement menuMyAccount;

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement linkSignIn;

    @FindBy(id = "searchField")
    private WebElement inputSearchField;

    @FindBy(xpath = "//button[text()='Search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//span[@class='tt-suggestions']")
    private WebElement suggestions;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickSignIn(){
        menuMyAccount.click();
        wait.until(ExpectedConditions.visibilityOf(linkSignIn));
        linkSignIn.click();
    }

    public void searchBagsByName(String searchText){
        inputSearchField.sendKeys(searchText);
    }

    public String getDisplayedSuggestions(){
        try {
            wait.until(ExpectedConditions.visibilityOf(suggestions));
            return suggestions.getText();
        } catch (TimeoutException e) {
            return null; }
    }

    public void clickSearchButton(){
        buttonSearch.click();
    }
}

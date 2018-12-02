package com.infoshare.mteam.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id = "customerAccount")
    private WebElement menuMyAccount;

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement linkSignIn;

    @FindBy(id = "searchField")
    private WebElement inputSearchField;

    @FindBy(xpath = "//button[text()='Search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@class='tt-suggestion']")
    private List<WebElement> suggestionsList;

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

    public List<String> getDisplayedSuggestions(){
        List<String> suggestionTextList = new ArrayList<>();
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(suggestionsList));
            for (WebElement e: suggestionsList) {
                suggestionTextList.add(e.getText());
            }
        } catch (TimeoutException e) {

        } finally {
            return suggestionTextList;
        }
    }

    public void clickSearchButton(){
        buttonSearch.click();
    }
}

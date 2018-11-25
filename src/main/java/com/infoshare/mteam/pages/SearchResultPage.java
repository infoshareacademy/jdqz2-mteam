package com.infoshare.mteam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(id = "products-qty")
    private WebElement textItemsFound;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public String returnSearchResultText(){
        return textItemsFound.getText();
    }

}

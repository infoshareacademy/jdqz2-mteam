package com.infoshare.mteam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(id = "products-qty")
    private WebElement textItemsFound;

    @FindBy(xpath = "//div[@id = 'productsContainer']/div")
    List<WebElement> productsList;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public String returnSearchResultText(){
        return textItemsFound.getText();
    }

    public List<String> returnResultBagNames(){
        wait.until(ExpectedConditions.visibilityOfAllElements(productsList));

        List<String> itemNames = null;

        for (WebElement e: productsList) {
            itemNames.add(e.getAttribute("item-name"));

        }

        return itemNames;
    }

}

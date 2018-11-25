package com.infoshare.mteam.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'productsContainer']/div")
    List<WebElement> productsList;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public List<String> returnBagNamesResultList(){
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(productsList));
            List<String> itemNames = new ArrayList<>();

            for (WebElement e : productsList) {
                itemNames.add(e.getAttribute("item-name"));
            }
            return itemNames;
        }catch (TimeoutException e){
            return null;
        }
    }
}

package com.infoshare.mteam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "#miniCartSummary > a")
    private WebElement shoppingCartIcon;

    public void clickOnShoppingCart () {


        shoppingCartIcon.click();
    }
}

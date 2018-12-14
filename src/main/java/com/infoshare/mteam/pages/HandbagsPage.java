package com.infoshare.mteam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandbagsPage extends BasePage{

    public HandbagsPage(WebDriver driver){
        super(driver);
    }

    public void addToCart () {

        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loadingoverlay")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"productsContainer\"]/div[1]/div[1]"))).click();

        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-10 > div > button"))).click();
    }
}

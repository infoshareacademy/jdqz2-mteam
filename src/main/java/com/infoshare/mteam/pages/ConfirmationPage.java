package com.infoshare.mteam.pages;

import com.infoshare.mteam.utils.waits.Waits;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    private WebDriver driver;
    private Waits waits;

    public ConfirmationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "main-content")
    private WebElement orderCompletedMessage;

    public void assertOrderCompleted () {

        waits = new Waits(driver);
//        waits.waitForElementToBeVisible(orderCompletedMessage);
        waits.wiatForElementToBeClickable(orderCompletedMessage);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://mteam.jdqz2.is-academy.pl/shop/order/confirmation.html");
    }
}

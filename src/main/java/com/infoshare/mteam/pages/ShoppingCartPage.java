package com.infoshare.mteam.pages;

import com.infoshare.mteam.utils.waits.Waits;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(css = "body > div.cart-main-area.ptb-40 > div > div > div > div > div > div.row > div.col-lg-4.col-md-4.col-sm-5.col-xs-12 > div.wc-proceed-to-checkout > a")
    private WebElement proceedToCheckoutButton;


    public ShoppingCartPage (WebDriver driver){
        super(driver);
    }

    public CheckoutPage goToCheckout() {

        Waits waits = new Waits(driver);
        waits.wiatForElementToBeClickable(proceedToCheckoutButton);


        Actions action = new Actions(driver);
        action.pause(2000).moveToElement(proceedToCheckoutButton).pause(2000).click(proceedToCheckoutButton).build().perform();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "http://mteam.jdqz2.is-academy.pl/shop/order/checkout.html");
//        Assert.assertEquals(currentUrl, "http://demo.shopizer.com:8080/shop/order/checkout.html");

        return new CheckoutPage(driver);
    }
}

//package com.infoshare.mteam.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class HomePage extends BasePage{
//
//    @FindBy(id = "customerAccount")
//    private WebElement menuMyAccount;
//
//    @FindBy(xpath = "//a[text()='Sign in']")
//    private WebElement linkSignIn;
//
//    public HomePage(WebDriver driver){
//        super(driver);
//    }
//
//    public void clickSignIn(){
//        menuMyAccount.click();
//        wait.until(ExpectedConditions.visibilityOf(linkSignIn));
//        linkSignIn.click();
//    }
//}


package com.infoshare.mteam.pages;

import com.infoshare.mteam.generator.userData.User;
import com.infoshare.mteam.generator.userGenerator.UserGenerator;
import com.infoshare.mteam.utils.driver.WebDriverCreators;
import com.infoshare.mteam.utils.driver.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.infoshare.mteam.utils.waits.Waits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id = "customerAccount")
    private WebElement menuMyAccount;

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement linkSignIn;

    @FindBy(xpath = "//*[@id=\"productsContainer\"]/div[1]/div[2]/div/div/a")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"productsContainer\"]/div[1]/div[2]/div/div/a")
    private WebElement bagItem;

    @FindBy(css = "#miniCartSummary > a > font > strong")
    private WebElement numberOfItemsInCart;

    @FindBy(css = "#miniCartDetails > h4")
    private WebElement cartDetailsForEmptyCart;

    @FindBy(tagName = "h4 > a")
    private List <WebElement> cartDetailsForFullCart;

    @FindBy(xpath = "//div[@class=\"cart-content\"]")
    private List<WebElement> productsInCart;

    @FindBy(css = "#miniCartDetails > li.checkout-bg > a")
    private WebElement checkoutButton;

    @FindBy(css = "body > div.cart-main-area.ptb-40 > div > div > div > div > div > div.row > div.col-lg-4.col-md-4.col-sm-5.col-xs-12 > div.wc-proceed-to-checkout > a")
    private WebElement proceedToCheckoutButton;

    /////////////////////////////////////////////////////////////////////


    @FindBy(css = "#miniCartSummary > a > span")
    private WebElement shoppingCartIcon;

    @FindBy(id = "featuredItemsContainer")
    private List<WebElement> productList;

    @FindBy(xpath = "//*[@id=\"main_h\"]/div/div/div/div")
    private List<WebElement> mainMenuTabs;

    @FindBy(id = "productsContainer")
    private WebElement productsContainer;

    @FindBy(xpath = "//*[@id=\"featuredItemsContainer\"]/div[1]/div[2]/div/div/a")
    private WebElement foo;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickSignIn(){
        menuMyAccount.click();
        wait.until(ExpectedConditions.visibilityOf(linkSignIn));
        linkSignIn.click();
    }

    public void selectOneCategoryMenu (int menuItemIndex, String title) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("nav")));


        List<WebElement> menuItemsList = driver.findElements(By.tagName("nav"));


        menuItemsList.get(menuItemIndex);

        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main_h\"]/div/div/div/div/nav/ul/li[1]/a"))).click();

        Assert.assertTrue(driver.getTitle().equals(title));
    }
//to zabieram do HabagsPage:
//    public void addToCart () {
//
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//
////        wait.until(ExpectedConditions.invisibilityOf(By.cssSelector(".loadingoverlay")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loadingoverlay")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"productsContainer\"]/div[1]/div[1]"))).click();
//
//        wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-10 > div > button"))).click();
//    }

    public void goToShoppingCart () {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#miniCartSummary > a > span")));

        Actions action = new Actions(driver);
        action.moveToElement(shoppingCartIcon).pause(2000).moveToElement(checkoutButton).click(checkoutButton).build().perform();

        String currentUrl = driver.getCurrentUrl();

//        Assert.assertEquals(currentUrl, "http://mteam.jdqz2.is-academy.pl/shop/cart/shoppingCart.html");
        Assert.assertEquals(currentUrl, "http://demo.shopizer.com:8080/shop/cart/shoppingCart.html");
    }

    public CheckoutPage goToCheckout() {

        Waits waits = new Waits(driver);
        waits.wiatForElementToBeClickable(proceedToCheckoutButton);


        Actions action = new Actions(driver);
        action.pause(2000).moveToElement(proceedToCheckoutButton).pause(2000).click(proceedToCheckoutButton).build().perform();

        String currentUrl = driver.getCurrentUrl();

//        Assert.assertEquals(currentUrl, "http://mteam.jdqz2.is-academy.pl/shop/order/checkout.html");
        Assert.assertEquals(currentUrl, "http://demo.shopizer.com:8080/shop/order/checkout.html");

        return new CheckoutPage(driver);
    }


    public void checkItemsInShoppingCart (String numberOfItems) {

        WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute
        String numberOfItemsInCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#miniCartSummary > a > font > strong"))).getText();
        Assert.assertEquals(numberOfItems, numberOfItemsInCart);
    }

}
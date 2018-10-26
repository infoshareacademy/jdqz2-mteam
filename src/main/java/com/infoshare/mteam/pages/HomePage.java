package com.infoshare.mteam.pages;

import com.infoshare.mteam.utils.waits.Waits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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


    public void selectOneCategoryMenu (int menuItemIndex, String title) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("nav")));


        List<WebElement> menuItemsList = driver.findElements(By.tagName("nav"));


        menuItemsList.get(menuItemIndex);

        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main_h\"]/div/div/div/div/nav/ul/li[1]/a"))).click();

        Assert.assertTrue(driver.getTitle().equals(title));
    }

    public void addToCart () {

        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"productsContainer\"]/div[1]/div[1]"))).click();

        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-10 > div > button"))).click();
    }

    public void goToShoppingCart () {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#miniCartSummary > a > span")));

        Actions action = new Actions(driver);
        action.moveToElement(shoppingCartIcon).pause(2000).moveToElement(checkoutButton).click(checkoutButton).build().perform();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "http://mteam.jdqz2.is-academy.pl/shop/cart/shoppingCart.html");
    }

    public void goToCheckout() {

        Waits waits = new Waits(driver);
        waits.wiatForElementToBeClickable(proceedToCheckoutButton);


        Actions action = new Actions(driver);
        action.pause(2000).moveToElement(proceedToCheckoutButton).pause(2000).click(proceedToCheckoutButton).build().perform();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "http://mteam.jdqz2.is-academy.pl/shop/order/checkout.html");
    }


    public void checkItemsInShoppingCart (String numberOfItems) {

        WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute
        String numberOfItemsInCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#miniCartSummary > a > font > strong"))).getText();
        Assert.assertEquals(numberOfItems, numberOfItemsInCart);
    }

}

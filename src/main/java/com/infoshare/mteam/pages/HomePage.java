package com.infoshare.mteam.pages;

import com.infoshare.mteam.utils.waits.Waits;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"featuredItemsContainer\"]/div[1]/div[2]/div/div/a")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"featuredItemsContainer\"]/div[1]/div[1]/a")
    private WebElement bagItem;


    /////////////////////////////////////////////////////////////////////


    @FindBy(css = "#miniCartSummary > a")
    private WebElement shoppingCartIcon;

    @FindBy(id = "featuredItemsContainer")
    private List<WebElement> productList;

    @FindBy(partialLinkText = "Checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"main_h\"]/div/div/div/div")
    private List<WebElement> mainMenuTabs;

    @FindBy(id = "productsContainer")
    private WebElement productsContainer;

    @FindBy(xpath = "//*[@id=\"featuredItemsContainer\"]/div[1]/div[2]/div/div/a")
    private WebElement foo;


    public void scrollDown () throws Exception {

        Actions a = new Actions(driver);
        a.moveToElement(bagItem);
    }

    public void clickOnParticularItem () {

        bagItem.click();

        Waits wait = new Waits(driver);
        wait.waitForElementToBeVisible(addToCartButton);

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://demo.shopizer.com:8080/shop/product/vintage-courier-bag.html");

    }

    public void addToCart () {

        addToCartButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }







    public void clickOnShoppingCart () {

        Waits wait = new Waits(driver);
        wait.waitForElementToBeVisible(shoppingCartIcon);
        shoppingCartIcon.click();
    }

    public void getProductListSize () {

        int productListSize = productList.size();
        System.out.println("***************************************product list size: " + productListSize);
    }



//    public void clickBagsTab () {
//        mainMenuTabs.get(3).click();
//        Waits waits = new Waits(driver);
//        waits.waitForElementToBeVisible(productsContainer);
//        assertTrue("product is not visible", productsContainer.isDisplayed());
//    }





//    public void clickAddToCart (int productIndex) {
//
////        Waits waits = new Waits(driver);
////        waits.waitForElementToBeVisible(productList.get(productIndex));
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        this.scrollDown();
//        foo.click();
////        productList.get(productIndex).click();
//    }




//    public void clickAddToCartOnAllProductsFromList (int productIndex) {
//
//        for (WebElement product : productList) {
//            productList.get(productIndex).click();
//        }
//    }

//    public void scrollDown () {
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0, 500);");
//    }

    public void checkIfCheckoutButtonVisible () {
        Waits wait = new Waits(driver);
        wait.waitForElementToBeVisible(checkoutButton);
        boolean checkoutButtonDisplayed = checkoutButton.isDisplayed();
        System.out.println("checkoutButtonDisplayed" + checkoutButtonDisplayed);
    }

}

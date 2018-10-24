package com.infoshare.mteam.ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.infoshare.mteam.pages.HomePage;
import com.infoshare.mteam.utils.waits.Waits;

import com.infoshare.mteam.utils.driver.WebDriverCreators;
import com.infoshare.mteam.utils.driver.WebDriverProvider;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class CartTest {

    private static final String PAGE_URL = "http://demo.shopizer.com:8080/";

    private static WebDriver driver;

    private HomePage homePage;

    private Waits waits;

    @Before
    public void setUp() {

        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);

        driver.get(PAGE_URL);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testAddToCart () {

        homePage.selectOneCategoryMenu(0,"Vintage handbags");
        homePage.addToCart();
        homePage.checkItemsInShoppingCart();
        homePage.hoverOnTheShoppingCart();
//        homePage.expectShoppingCartIsEmpty();
        homePage.goToShoppingCart();
    }














//    @Test
//    public void clickCartIconAndcheckIfEmpty() {
//
////        homePage.clickOnShoppingCart();
////        homePage.getProductListSize();
////        homePage.clickBagsTab();
////        homePage.clickAddToCart(0);
//        homePage.getProductListSize();
////        homePage.clickAddToCart(0);
////        homePage.clickOnShoppingCart();
////        homePage.checkIfCheckoutButtonVisible();
//    }
//
//    @Test
//    public void clickAnItemAndAddToCart () throws Exception {
//
//        WebElement bagItem = driver.findElement(By.cssSelector("#featuredItemsContainer > div:nth-child(1) > div.thumbnail.product-img > a"));
//
//        homePage.scrollDown();
//        homePage.clickOnParticularItem();
//        homePage.addToCart();
//    }
//
////    @Test
////    public void singleProductAddToCart () {
////
////    }
////
////    @Test
////    public void multipleProductsAddToCart () {
////
////    }
////
////    @Test
////    public void clearCart () {
////
////    }
////
////    @Test
////    public void editQuantityValidationCart () {
////
////    }
////
////    @Test
////    public void editQuantityCartBoundryValue () {
////
////    }
////
////    @Test
////    public void singleProductRemoveFromCart () {
////
////    }
////
////    @Test
////    public void multipleProductsRemoveFromCart () {
////
////    }
////
////    @Test
////    public void continueShopping () {
////
////    }


}

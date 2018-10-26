package com.infoshare.mteam.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.infoshare.mteam.pages.HomePage;
import com.infoshare.mteam.utils.waits.Waits;
import com.infoshare.mteam.utils.driver.WebDriverCreators;
import com.infoshare.mteam.utils.driver.WebDriverProvider;


public class CartTest {

    private static final String PAGE_URL = "http://mteam.jdqz2.is-academy.pl/";

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
    public void singleProductAddToCart () {

        homePage.selectOneCategoryMenu(0,"Vintage handbags");
        homePage.addToCart();
        homePage.checkItemsInShoppingCart("(1)");
        homePage.goToShoppingCart();
        homePage.goToCheckout();
    }



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

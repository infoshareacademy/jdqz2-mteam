package com.infoshare.mteam.ui;

import com.infoshare.mteam.generator.userData.User;
import com.infoshare.mteam.generator.userGenerator.UserGenerator;
import com.infoshare.mteam.pages.CheckoutPage;
import com.infoshare.mteam.pages.HandbagsPage;
import com.infoshare.mteam.pages.HomePage;
import com.infoshare.mteam.utils.driver.WebDriverCreators;
import com.infoshare.mteam.utils.driver.WebDriverProvider;
import com.infoshare.mteam.utils.waits.Waits;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CartTest {

    //    private static final String PAGE_URL = "http://mteam.jdqz2.is-academy.pl/";
    private static final String PAGE_URL = "http://demo.shopizer.com:8080/shop";

    private static WebDriver driver;

    private HomePage homePage;

    private HandbagsPage handbagsPage;

    private CheckoutPage checkoutRegistration;

    private Waits waits;

    @Before
    public void setUp() {

        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        checkoutRegistration = new CheckoutPage(driver);
        homePage = new HomePage(driver);
        handbagsPage = new HandbagsPage(driver);

        driver.get(PAGE_URL);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void singleProductAddToCart () {

        UserGenerator generator= new UserGenerator();

        Integer randomNumber = generator.generateRandomNumbers(1).iterator().next() * generator.generateRandomNumbers(1).iterator().next();
        User[] user = generator.generateRandomUsers(1, generator.generateRandomNumbers(1));

        homePage.selectOneCategoryMenu(0,"Vintage handbags");
//        homePage.addToCart();
        handbagsPage.addToCart();
        homePage.checkItemsInShoppingCart("(1)");
        homePage.goToShoppingCart();
        homePage.goToCheckout();

        User user1 = generator.generateRandomUsers(1, generator.generateRandomNumbers(1))[0];

        checkoutRegistration.fillAllInputs(user1);

//        registrationForm.fillAllInputs();
//        registrationForm.clickRegisterButton();
//        registrationForm.isUserLoggedIn();
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

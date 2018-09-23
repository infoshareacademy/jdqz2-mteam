package com.infoshare.mteam.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.infoshare.mteam.pages.HomePage;
import com.infoshare.mteam.utils.waits.Waits;

import com.infoshare.mteam.utils.driver.WebDriverCreators;
import com.infoshare.mteam.utils.driver.WebDriverProvider;

import static org.junit.Assert.*;


public class CartTest {

    private static final String PAGE_URL = "http://demo.shopizer.com:8080/";

    private WebDriver driver;

    private HomePage homePage;

    private Waits waits;

    @Before
    public void setUp() {

        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        homePage = PageFactory.initElements(driver, HomePage.class);

        driver.get(PAGE_URL);
    }

    @Test
    public void clickChartIconAndcheckIfEmpty() {
        waits.waitForElementToBeVisible();
        homePage.clickOnShoppingCart();
    }
}

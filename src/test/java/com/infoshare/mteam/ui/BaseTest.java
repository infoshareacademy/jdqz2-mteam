package com.infoshare.mteam.ui;

import com.infoshare.mteam.utils.driver.WebDriverCreators;
import com.infoshare.mteam.utils.driver.WebDriverProvider;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    private static final String baseUrl = "http://demo.shopizer.com:8080/shop";

    @Before
    public void setUpDriver() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser(){
        driver.close();
    }
}
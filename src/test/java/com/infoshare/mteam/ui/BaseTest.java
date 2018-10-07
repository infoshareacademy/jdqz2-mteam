package com.infoshare.mteam.ui;

import com.infoshare.mteam.utils.driver.WebDriverCreators;
import com.infoshare.mteam.utils.driver.WebDriverProvider;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    private static final String baseUrl = "http://mteam.jdqz2.is-academy.pl/shop";

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
}
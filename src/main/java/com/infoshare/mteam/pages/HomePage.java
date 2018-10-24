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

//    @FindBy(css = "#productsContainer > div:nth-child(1) > div.product-content.text-center > div > div")
    @FindBy(xpath = "//*[@id=\"productsContainer\"]/div[1]/div[2]/div/div/a")
//    @FindBy(css = "#productsContainer > div:nth-child(1) > div.product-content.text-center > div > div > a")
    private WebElement addToCartButton;

//    @FindBy(xpath = "//*[@id=\"featuredItemsContainer\"]/div[1]/div[1]/a")
    @FindBy(xpath = "//*[@id=\"productsContainer\"]/div[1]/div[2]/div/div/a")
    private WebElement bagItem;

    @FindBy(css = "#miniCartSummary > a > font > strong")
    private WebElement numberOfItemsInCart;

//    @FindBy(css = "#miniCartSummary > a > span")
//    @FindBy(css = "#miniCartSummary")
    @FindBy(css = "#miniCartDetails > h4")
    private WebElement cartDetailsForEmptyCart;

    @FindBy(tagName = "h4 > a")
    private List <WebElement> cartDetailsForFullCart;


    /////////////////////////////////////////////////////////////////////


    @FindBy(css = "#miniCartSummary > a > span")
    private WebElement shoppingCartIcon;

    @FindBy(id = "featuredItemsContainer")
    private List<WebElement> productList;

//    @FindBy(partialLinkText = "Checkout")
//    @FindBy(css = "#miniCartDetails > li.checkout-bg > a")
    @FindBy(xpath = "//div[@id=\"miniCartDetails\"]//a")
    private List <WebElement> checkoutButton;

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

//        bagItem.click();

        Waits wait = new Waits(driver);
        wait.waitForElementToBeVisible(addToCartButton);

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://demo.shopizer.com:8080/shop/product/vintage-courier-bag.html");

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

    public void addToCart () {

        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"productsContainer\"]/div[1]/div[1]"))).click();

        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-10 > div > button"))).click();
    }

    public void hoverOnTheShoppingCart () {

        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By) shoppingCartIcon));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#miniCartSummary > a > span")));

        Actions action = new Actions(driver);
        action.moveToElement(shoppingCartIcon).build().perform();

    }

    public void goToShoppingCart () {

        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));

        //div[@id="miniCartDetails"]//a[text()="Checkout"]


        Actions action = new Actions(driver);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& : " + checkoutButton.get(0).getText());

//        action.click(checkoutButton).perform();

//        wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.titleIs("Place your order"));
//        Assert.assertTrue(driver.getTitle().equals("Place your order"));
    }

    public void expectShoppingCartIsEmpty () {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("##miniCartDetails > h4")));

//        cartDetailsForEmptyCart.getText();
        Assert.assertEquals(cartDetailsForEmptyCart.getText(), "No items in your shopping cart");
    }



    public void checkItemsInShoppingCart () {

        WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute
        String numberOfItemsInCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#miniCartSummary > a > font > strong"))).getText();
        Assert.assertEquals("(1)", numberOfItemsInCart);
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


}

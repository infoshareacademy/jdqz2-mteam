package com.infoshare.mteam.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage{

    @FindBy(id = "customerAccount")
    private WebElement menuMyAccount;

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement linkSignIn;

    @FindBy(id = "searchField")
    private WebElement inputSearchField;

    @FindBy(xpath = "//button[text()='Search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@class='tt-suggestion']")
    private List<WebElement> suggestionsList;

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

    public void searchBagsByName(String searchText){
        inputSearchField.sendKeys(searchText);
    }

    public List<String> getDisplayedSuggestions(){
        List<String> suggestionTextList = new ArrayList<>();
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(suggestionsList));
            for (WebElement e: suggestionsList) {
                suggestionTextList.add(e.getText());
            }
        } catch (TimeoutException e) {

        } finally {
            return suggestionTextList;
        }
    }

    public void clickSearchButton(){
        buttonSearch.click();
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

    public void goToShoppingCart () {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#miniCartSummary > a > span")));

        Actions action = new Actions(driver);
        action.moveToElement(shoppingCartIcon).pause(2000).moveToElement(checkoutButton).click(checkoutButton).build().perform();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "http://mteam.jdqz2.is-academy.pl/shop/cart/shoppingCart.html");
//        Assert.assertEquals(currentUrl, "http://demo.shopizer.com:8080/shop/cart/shoppingCart.html");
    }

    public void checkItemsInShoppingCart (String numberOfItems) {

        WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute
        String numberOfItemsInCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#miniCartSummary > a > font > strong"))).getText();
        Assert.assertEquals(numberOfItems, numberOfItemsInCart);
    }

}
package com.infoshare.mteam.ui;

import com.infoshare.mteam.pages.HomePage;
import com.infoshare.mteam.pages.SearchResultPage;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private String existingBagName = "bag";
    private String nonExistingBagName = "olaboga";
    private Integer expectedSuggestionsSize = 2;
    private Integer expectedResultSize = 8;

    @Before
    public void setup(){
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void searchDisplaysSuggestionsIncludingBagName(){
        homePage.searchBagsByName(existingBagName);
        assertThat(homePage.getDisplayedSuggestions())
                .hasSize(expectedSuggestionsSize)
                .allSatisfy(suggestionName -> assertThat(suggestionName.contains(existingBagName)));
    }

    @Test
    public void searchReturnsProperBagResults(){
        homePage.searchBagsByName(existingBagName);
        homePage.clickSearchButton();

        assertThat(searchResultPage.returnBagNamesResultList())
                .hasSize(expectedResultSize)
                .allSatisfy(bagName -> assertThat(bagName).contains(existingBagName));
    }

    @Test
    public void searchDoesNotShowSuggestionsForNonExistingBag(){
        homePage.searchBagsByName(nonExistingBagName);
        assertThat(homePage.getDisplayedSuggestions())
                .isNull();
    }

    @Test
    public void searchReturnsZeroResultsForNonExistingBag(){
        homePage.searchBagsByName(nonExistingBagName);
        homePage.clickSearchButton();
        assertThat(searchResultPage.returnBagNamesResultList())
                .isNull();
    }
}

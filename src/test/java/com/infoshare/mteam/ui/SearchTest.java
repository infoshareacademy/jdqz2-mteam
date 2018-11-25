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
    private String expectedSearchResult = "item(s) found";

    @Before
    public void setup(){
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void searchShouldDisplaySuggestionsIncludingBagName(){
        homePage.searchBagsByName(existingBagName);
        assertThat(homePage.getDisplayedSuggestions())
                .containsIgnoringCase(existingBagName);
    }

    @Test
    public void searchDoesNotShowSuggestions(){
        homePage.searchBagsByName(nonExistingBagName);
        assertThat(homePage.getDisplayedSuggestions())
                .isNull();
    }

    @Test
    public void searchReturnsOneBagResult(){
        homePage.searchBagsByName(existingBagName);
        homePage.clickSearchButton();

//        assertThat(searchResultPage.returnSearchResultText())
//                .isEqualTo(String.format("%s "+ expectedSearchResult, 1));

        assertThat(searchResultPage.returnResultBagNames())
                .contains(existingBagName);
    }

    @Test
    public void searchReturnsZeroResults(){
        homePage.searchBagsByName(nonExistingBagName);
        homePage.clickSearchButton();
        assertThat(searchResultPage.returnSearchResultText())
                .isEqualTo(String.format("%s "+ expectedSearchResult, 0));
    }
}

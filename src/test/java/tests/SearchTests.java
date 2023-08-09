package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchTests extends AppiumConfig {

    String city = "Tel Aviv";
    int dateFrom = 3;
    int dateTo = 10;

        @Test
    public void testSearchFormPositive() {
            SearchPage searchPage = new SearchPage(driver);
            searchPage.fillSearchForm(city, dateFrom, dateTo);
            SearchResultPage searchResultPage = new SearchResultPage(driver);
            Assert.assertTrue(searchResultPage.validateTitle());
        }
}

package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchTests extends BaseTest {

    String city = "Tel Aviv";
    int dateFrom = 3;
    int dateTo = 10;

        @Test
    public void testSearchFormPositive() {
            searchResultPage = searchPage.fillSearchForm(city, dateFrom, dateTo);
            Assert.assertTrue(searchResultPage.validateTitle());
        }
}

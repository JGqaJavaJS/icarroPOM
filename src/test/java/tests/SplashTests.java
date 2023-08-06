package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

public class SplashTests extends AppiumConfig {

    String title2 = "The Ultimate Car Rental Service".toUpperCase();

    @Test
    public void title2Test() {
        SplashPage splashPage = new SplashPage(driver);
        Assert.assertEquals(splashPage.getTextTitle2(), title2);
    }
}

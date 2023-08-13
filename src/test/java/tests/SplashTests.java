package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

public class SplashTests extends BaseTest {

    String title2 = "The Ultimate Car Rental Service".toUpperCase();

    @Test
    public void title2Test() {
        Assert.assertEquals(splashPage.getTextTitle2(), title2);
    }
}

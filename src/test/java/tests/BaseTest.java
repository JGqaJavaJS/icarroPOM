package tests;

import pages.*;
import utils.RandomUtils;

public class BaseTest {

    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    SearchPage searchPage = new SearchPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    SplashPage splashPage = new SplashPage();
    RandomUtils randomUtils = new RandomUtils();
}

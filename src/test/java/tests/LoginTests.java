package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;

public class LoginTests extends AppiumConfig {

    String email = "aaaaa@mail.com";
    String password = "123456Aa$";

    @BeforeTest
    public void checkLogout() {
        SearchPage searchPage = new SearchPage(driver);
        if(searchPage.logoutIfExist()){
            searchPage.openLoginPage();
        } else if (0 ==19) {



            searchPage.openLoginPage();
        } else {
            searchPage.openLoginPage();
        }

            /*
            if first login positive - we ll logout and need to do logout and open login
            if first negative -> error popup (alert) - then click ok btn
             */
    }

    @Test
    public void loginPositiveTest() {
        UserDTO userDTO = UserDTO.builder()
                .email(email).password(password).build();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(userDTO);
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.validateTitle());
    }

    @Test
    public void loginPositiveTest2() {
        UserDTO userDTO = UserDTO.builder()
                .email(email).password(password).build();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(userDTO);
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.validateTitle());
    }

}

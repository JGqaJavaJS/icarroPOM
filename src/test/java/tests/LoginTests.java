package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;

public class LoginTests extends BaseTest {

    String email = "aaaaa@mail.com";
    String password = "123456Aa$";

    @BeforeMethod
    public void checkLogout() {

        boolean b =      searchPage.logoutIfExist();
        System.out.println("---------------- " + b);

        if (b) {
            loginPage = searchPage.clickOpenMenu(15).openLoginPage();
        } else if (loginPage.isPopUpErrorOpen()) {
           loginPage.clickOkPopUp();
// to check po0p up after negative login
        } else {
//            searchPage.clickBackBTNPhone();
//            loginPage = searchPage.clickOpenMenu(15).openLoginPage();
            
                loginPage = searchPage.openLoginPage();

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
        searchPage = loginPage.fillLoginForm(userDTO);
        Assert.assertTrue(searchPage.validateTitle());
    }

    @Test
    public void loginPositiveTest2() {
        UserDTO userDTO = UserDTO.builder()
                .email(email).password(password).build();
        searchPage = loginPage.fillLoginForm(userDTO);
        Assert.assertTrue(searchPage.validateTitle());
    }

    @Test
    public void loginNegativeTest() {
        UserDTO userDTO = UserDTO.builder()
                .email("abdsjh@bb").password(password).build();
        loginPage.fillLoginForm(userDTO);
        Assert.assertTrue(loginPage.validatePopUpErrorMessage());
    }

}